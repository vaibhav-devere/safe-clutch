/**
 * 
 */
package com.psil.safeclutch.entity;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "filestorage")
public class FileProp {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String fileName;
	private String fileType;
	private String fileCategory;
	private String description;
	private String selfAssested;

	@Lob
	//@Type(type = "org.hibernate.type.File")
	private byte[] data;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class)
	@JoinColumn(name = "userId")
	private User user;

	public FileProp(String fileName, String fileType, String fileCategory, String description, String selfAssested,
			byte[] data, User user) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileCategory = fileCategory;
		this.description = description;
		this.selfAssested = selfAssested;
		this.data = data;
		this.user = user;
	}

	public String getFileCategory() {
		return fileCategory;
	}

	public void setFileCategory(String fileCategory) {
		this.fileCategory = fileCategory;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "FileProp [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", data="
				+ Arrays.toString(data) + "]";
	}

	public FileProp() {
		super();
	}

}
