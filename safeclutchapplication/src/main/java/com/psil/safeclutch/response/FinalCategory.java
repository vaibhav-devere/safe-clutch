package com.psil.safeclutch.response;

/**
 * 
 * @author vpottumu
 *
 */
public class FinalCategory {

	private Long categoryId;
	private String categoryName;
	private Long finalLimit;

	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getFinalLimit() {
		return finalLimit;
	}

	public void setFinalLimit(Long finalLimit) {
		this.finalLimit = finalLimit;
	}

}
