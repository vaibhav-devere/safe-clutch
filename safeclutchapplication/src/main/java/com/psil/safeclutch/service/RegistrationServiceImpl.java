package com.psil.safeclutch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.psil.safeclutch.entity.SecurityQuestion;
import com.psil.safeclutch.entity.User;
import com.psil.safeclutch.exceptions.EmailAlreadyExistException;
import com.psil.safeclutch.exceptions.PhoneNumberAlreadyExistException;
import com.psil.safeclutch.exceptions.QuestionNotFoundException;
import com.psil.safeclutch.repository.SecurityQuestionRepository;
import com.psil.safeclutch.repository.UserRepository;
import com.psil.safeclutch.request.UserRequest;
import com.psil.safeclutch.util.DateConverter;

/**
 * 
 * @author vdevere
 *
 *
 */
@Service("registration")
public class RegistrationServiceImpl implements IRegistrationService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private DateConverter dateConverter;
	@Autowired
	private SecurityQuestionRepository securityQuestionRepository;

	@Override
	public String userSignUp(UserRequest user) {

		User emailAlreadyExists = userRepository.findByEmail(user.getEmail());
		if (emailAlreadyExists != null) {
			throw new EmailAlreadyExistException(user.getEmail() + "  Email Already exists");
		}
		User phoneNumberExists = userRepository.findByPhoneNumber(user.getPhoneNumber());
		if (phoneNumberExists != null) {
			throw new PhoneNumberAlreadyExistException(user.getPhoneNumber() + "  Phone-Number Already exists");
		}

		User user1 = new User();
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		user1.setEmail(user.getEmail());
		user1.setPassword(encoder.encode(user.getPassword()));
		user1.setDob(dateConverter.toDate(user.getDob()));
		user1.setPhoneNumber(user.getPhoneNumber());

		SecurityQuestion securityQuestion = securityQuestionRepository.findById(user.getQuestionId()).orElse(null);
		if (securityQuestion == null) {
			throw new QuestionNotFoundException("Question Not Found" + user.getQuestionId());

		}
		user1.setSecurityQuestion(securityQuestion);
		user1.setAnswer(user.getAnswer());
		userRepository.save(user1);
		return "User successfully registered with the EmailID = " + user.getEmail();

	}
}
