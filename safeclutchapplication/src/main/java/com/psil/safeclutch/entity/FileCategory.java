package com.psil.safeclutch.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author vdevere
 *
 */
/**
 * 
 * @author vpottumu
 *
 */
@Entity
public class FileCategory {
	@Id
	private Long id;
	private String fileCategory;
	private Long documentLimit;

	public FileCategory() {
		super();
	}

	public FileCategory(String fileName, Long documentLimit) {
		super();
		this.fileCategory = fileName;
		this.documentLimit = documentLimit;
	}

	public String getFileCategory() {
		return fileCategory;
	}

	public void setFileCategory(String fileCategory) {
		this.fileCategory = fileCategory;
	}

	public Long getDocumentLimit() {
		return documentLimit;
	}

	public void setDocumentLimit(Long documentLimit) {
		this.documentLimit = documentLimit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
