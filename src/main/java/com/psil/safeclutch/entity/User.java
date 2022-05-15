package com.psil.safeclutch.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author vdevere
 *
 */
@Entity
@Valid
@Table(name = "USERS_TABLE", uniqueConstraints = { @javax.persistence.UniqueConstraint(columnNames = "email"),
		@javax.persistence.UniqueConstraint(columnNames = "phoneNumber") })
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
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
	@Column(name = "Date_of_Birth", nullable = false)
	private LocalDate dob;

	@OneToOne(cascade = CascadeType.ALL, targetEntity = SecurityQuestion.class)
	@JoinColumn(name = "id")
	private SecurityQuestion securityQuestion;

	private String answer;

	public User() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public SecurityQuestion getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(SecurityQuestion securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}