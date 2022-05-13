package com.psil.safeclutch.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.psil.safeclutch.entity.FileProp;
import com.psil.safeclutch.response.UserFiles;

/**
 * 
 * @author vpottumu
 *
 */
@Component
public class FileUtil {

	public UserFiles toUserFiles(FileProp file) {
		UserFiles userFile = new UserFiles();
		userFile.setFileId(file.getId());
		userFile.setDescription(file.getDescription());
		userFile.setFileCategory(file.getFileCategory());
		userFile.setSelfAssested(file.getSelfAssested());
		return userFile;
	}

	public List<UserFiles> toListUserFiles(Collection<FileProp> listOfFiles) {
		return listOfFiles.stream().map(file -> toUserFiles(file)).collect(Collectors.toList());
	}

}
