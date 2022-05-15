package com.psil.safeclutch.request;

/**
 * 
 * @author vpottumu
 *
 */
public class AddFileRequest {

	private Long fileCategoryId;
	private String description;
	private String selfAssested;
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFileCategoryId() {
		return fileCategoryId;
	}

	public void setFileCategoryId(Long fileCategoryId) {
		this.fileCategoryId = fileCategoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSelfAssested() {
		return selfAssested;
	}

	public void setSelfAssested(String selfAssested) {
		this.selfAssested = selfAssested;
	}

}
