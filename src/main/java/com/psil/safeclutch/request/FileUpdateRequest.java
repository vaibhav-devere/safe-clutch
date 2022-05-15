/**
 * 
 */
package com.psil.safeclutch.request;

/**
 * @author vdevere
 *
 */
public class FileUpdateRequest {
	private String fileId;
	private String selfAssested;
	private String description;
	
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getSelfAssested() {
		return selfAssested;
	}
	public void setSelfAssested(String selfAssested) {
		this.selfAssested = selfAssested;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}