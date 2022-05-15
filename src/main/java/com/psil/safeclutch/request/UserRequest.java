package com.psil.safeclutch.request;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author vpottumu
 *
 */
@Valid
public class UserRequest {

	@NotEmpty(message = "FirstName cannot not be empty")
	@Size(max = 20)
	private String firstName;
	@NotNull(message = "Cannot be null")
	@NotEmpty(message = "LastName cannot not be empty")
	@Size(max = 20)
	private String lastName;
	@Size(min = 5, max = 120)
	private String password;
	@NotEmpty(message = "This field cannot be empty")
	@Size(max = 50)
	@Email(message = "*Please provide a valid Email")
	private String email;
	private Long phoneNumber;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private String dob;
	@NotEmpty(message = "This field cannot be empty")
	private Long questionId;
	@NotEmpty(message = "This field cannot be empty")
	private String answer;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}