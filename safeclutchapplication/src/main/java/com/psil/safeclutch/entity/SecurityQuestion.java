package com.psil.safeclutch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author vdevere
 * 
 */
@Entity
public class SecurityQuestion {

	@Id
	@Column(name="id")
	private Long id;
	private String question;

	public SecurityQuestion() {
		super();
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SecurityQuestion [questionId=" + id + ", question=" + question + "  ]";
	}

}