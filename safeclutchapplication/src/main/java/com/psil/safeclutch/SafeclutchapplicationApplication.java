package com.psil.safeclutch;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.psil.safeclutch.entity.FileCategory;
import com.psil.safeclutch.entity.SecurityQuestion;
import com.psil.safeclutch.entity.User;
import com.psil.safeclutch.repository.FileCategoryRepository;
import com.psil.safeclutch.repository.SecurityQuestionRepository;
import com.psil.safeclutch.repository.UserRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

/**
 * @author vdevere
 *
 */
/**
 * 
 * @author vpottumu
 *
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "SafeClutch-API", version = "2.0", description = "Web app to store government verified documents"))
@SecurityScheme(name = "login-registration", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class SafeclutchapplicationApplication {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SecurityQuestionRepository questionRepository;
	
	@Autowired
	private FileCategoryRepository fileCategoryRepository;

	@Autowired
	private PasswordEncoder encoder;

	/*
	 * pre populate data in the data base Added user to the data base
	 */
	@PostConstruct
	public void initUsers() {

		userRepository.deleteAll();
		questionRepository.deleteAll();
		fileCategoryRepository.deleteAll();
		
		//Adding Security Questions 
		List<SecurityQuestion> questions = new ArrayList<>();

		SecurityQuestion question1 = new SecurityQuestion();
		question1.setId(101L);
		question1.setQuestion("What is your old phone number? ");
		questions.add(question1);

		SecurityQuestion question2 = new SecurityQuestion();
		question2.setId(102L);
		question2.setQuestion("What is your maiden name? ");
		questions.add(question2);

		SecurityQuestion question3 = new SecurityQuestion();
		question3.setId(103L);
		question3.setQuestion("What is your pet name? ");
		questions.add(question3);

		questionRepository.saveAll(questions);
		
		//Adding DummyUser into the database
		User dummyUser = new User();
		dummyUser.setUserId(1L);
		dummyUser.setFirstName("Vaibhav");
		dummyUser.setLastName("Devere");
		dummyUser.setPassword(encoder.encode("admin123"));
		dummyUser.setEmail("vaibhav@safeclutch.com");
		dummyUser.setPhoneNumber(9809897650L);
		dummyUser.setDob(LocalDate.now());

		dummyUser.setSecurityQuestion(questionRepository.findById(101L).get());
		dummyUser.setAnswer("1234567890");
		userRepository.save(dummyUser);
		
		
		//Adding the categories of files and their limits
		List<FileCategory> categories = new ArrayList<>();
		
		FileCategory category1 = new FileCategory();
		category1.setId(201L);
		category1.setFileCategory("Passport");
		category1.setDocumentLimit(1L);
		categories.add(category1);
		
		FileCategory category2 = new FileCategory();
		category2.setId(202L);
		category2.setFileCategory("Driving License");
		category2.setDocumentLimit(1L);
		categories.add(category2);
		
		FileCategory category3 = new FileCategory();
		category3.setId(203L);
		category3.setFileCategory("Biometric Residence Card");
		category3.setDocumentLimit(1L);
		categories.add(category3);
		
		FileCategory category4 = new FileCategory();
		category4.setId(204L);
		category4.setFileCategory("National Identity Card");
		category4.setDocumentLimit(1L);
		categories.add(category4);
		
		FileCategory category5 = new FileCategory();
		category5.setId(205L);
		category5.setFileCategory("Travel Document");
		category5.setDocumentLimit(1L);
		categories.add(category5);
		
		FileCategory category6 = new FileCategory();
		category6.setId(206L);
		category6.setFileCategory("Vaccine Certificate");
		category6.setDocumentLimit(6L);
		categories.add(category6);
		
		FileCategory category7 = new FileCategory();
		category7.setId(207L);
		category7.setFileCategory("Birth Certificate");
		category7.setDocumentLimit(1L);
		categories.add(category7);
		
		FileCategory category8 = new FileCategory();
		category8.setId(208L);
		category8.setFileCategory("Education Certificates");
		category8.setDocumentLimit(10L);
		categories.add(category8);
		
		FileCategory category9 = new FileCategory();
		category9.setId(209L);
		category9.setFileCategory("Marriage Certificate");
		category9.setDocumentLimit(1L);
		categories.add(category9);
		
		FileCategory category10 = new FileCategory();
		category10.setId(210L);
		category10.setFileCategory("Decree Absolute");
		category10.setDocumentLimit(1L);
		categories.add(category10);
		
		fileCategoryRepository.saveAll(categories);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(SafeclutchapplicationApplication.class, args);
	}

}