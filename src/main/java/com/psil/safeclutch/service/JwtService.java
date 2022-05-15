package com.psil.safeclutch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.psil.safeclutch.entity.User;
import com.psil.safeclutch.exceptions.InvalidCredentialsException;
import com.psil.safeclutch.repository.UserRepository;
import com.psil.safeclutch.request.JwtRequest;
import com.psil.safeclutch.response.JwtResponse;
import com.psil.safeclutch.util.JwtUtil;

/**
 * 
 * @author vpottumu
 *
 */
@Service("jwtService")
public class JwtService implements UserDetailsService {

	private static final String USEREMAIL_NOT_FOUND = "User not found with useremail :";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(userEmail);
		if (user != null) {
			
			return new CustomUserDetails(user);
		} else {
			throw new UsernameNotFoundException("User not found with useremail: " + userEmail);
		}
	}

	public JwtResponse generateToken(JwtRequest jwtRequest) throws InvalidCredentialsException {

		User user = userRepository.findByEmail(jwtRequest.getUserEmail());
		if (user == null) {
			throw new InvalidCredentialsException(USEREMAIL_NOT_FOUND + " " + jwtRequest.getUserEmail());
		}
		if (!encoder.matches(jwtRequest.getPassword(), user.getPassword())) {
			throw new InvalidCredentialsException("Invalid Password for username = " + jwtRequest.getUserEmail());
		}
		if (encoder.matches(jwtRequest.getPassword(), user.getPassword())
				&& user.getEmail().equals(jwtRequest.getUserEmail())) {

			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUserEmail(), jwtRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtil.generateJwtToken(authentication);
			CustomUserDetails user1 = (CustomUserDetails) authentication.getPrincipal();

			return new JwtResponse(user1.getUser().getUserId(),user1.getUser().getFirstName(), user1.getUser().getLastName(),
					user1.getUser().getPhoneNumber(), jwt);

		} else {
			throw new InvalidCredentialsException(USEREMAIL_NOT_FOUND + " " + jwtRequest.getUserEmail());
		}

	}

}