package com.psil.safeclutch.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psil.safeclutch.entity.SecurityQuestion;
import com.psil.safeclutch.repository.SecurityQuestionRepository;
import com.psil.safeclutch.request.JwtRequest;
import com.psil.safeclutch.request.UserRequest;
import com.psil.safeclutch.response.JwtResponse;
import com.psil.safeclutch.service.IRegistrationService;
import com.psil.safeclutch.service.JwtService;

/**
 * @author vdevere
 *
 */
/**
 * 
 * @author vpottumu
 *
 */
@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	private IRegistrationService registration;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private SecurityQuestionRepository questionRepository;

	@GetMapping(name = "/", produces = "application/json") // check for authorization
	public String home(@RequestHeader("Authorization") String auth) {
		return "Welcome, you are authenticated";
	}

	/*
	 * Registration for all users based on their roles
	 */
	@PostMapping("/signup")
	public String userSignup(@RequestBody UserRequest user) {
		return registration.userSignUp(user);
	}

	@PostMapping("/signin")
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) {

		return jwtService.generateToken(jwtRequest);

	}

	@GetMapping("/allquestions")
	public List<SecurityQuestion> fetchQuestions() {
		return questionRepository.findAll();
	}

}