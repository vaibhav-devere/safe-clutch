package com.psil.safeclutch.response;

import java.util.List;

/**
 * 
 * @author vpottumu
 *
 */
public class DashboardResponse {

	private List<UserFiles> userFiles;
	private List<FinalCategory> resulantantCategories;

	public List<UserFiles> getUserFiles() {
		return userFiles;
	}

	public void setUserFiles(List<UserFiles> userFiles) {
		this.userFiles = userFiles;
	}

	public List<FinalCategory> getResulantantCategories() {
		return resulantantCategories;
	}

	public void setResulantantCategories(List<FinalCategory> resulantantCategories) {
		this.resulantantCategories = resulantantCategories;
	}

	
}
