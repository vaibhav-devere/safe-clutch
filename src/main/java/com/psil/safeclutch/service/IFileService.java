package com.psil.safeclutch.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.psil.safeclutch.entity.FileProp;
import com.psil.safeclutch.exceptions.FileCategoryLimitException;
import com.psil.safeclutch.request.AddFileRequest;
import com.psil.safeclutch.request.FileUpdateRequest;
import com.psil.safeclutch.response.DashboardResponse;

/**
 * 
 * @author vpottumu
 *
 */
public interface IFileService {

	FileProp storeFile(MultipartFile file, AddFileRequest request) throws FileCategoryLimitException, IOException;
	DashboardResponse getAllFilesByUserId(Long userId);
	ResponseEntity<FileProp> updateFile(FileUpdateRequest fileUpdate);
	
}
