package com.psil.safeclutch.response;

/**
 * @author vpottumu
 *
 */
public class UserFiles {
	
	private String fileId;
	private String fileCategory;
	private String Description;
	private String selfAssested;

	
	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileCategory() {
		return fileCategory;
	}

	public void setFileCategory(String fileCategory) {
		this.fileCategory = fileCategory;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getSelfAssested() {
		return selfAssested;
	}

	public void setSelfAssested(String selfAssested) {
		this.selfAssested = selfAssested;
	}

	

}
