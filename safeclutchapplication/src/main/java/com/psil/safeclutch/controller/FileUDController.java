/**
 * 
 */
package com.psil.safeclutch.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.psil.safeclutch.entity.FileProp;
import com.psil.safeclutch.exceptions.FileCategoryLimitException;
import com.psil.safeclutch.repository.FileStorageRepository;
import com.psil.safeclutch.request.AddFileRequest;
import com.psil.safeclutch.request.FileUpdateRequest;
import com.psil.safeclutch.response.DashboardResponse;
import com.psil.safeclutch.response.FileResponse;
import com.psil.safeclutch.service.FileService;

/**
 * 
 * @author vpottumu
 * @author vdevere
 *
 */


@RestController
@RequestMapping("/api")
public class FileUDController {

	@Autowired
	private FileService fileStorageService;
	
	
	@Autowired
	private FileStorageRepository fileRepository;
	
	/**
	 * Api to upload the file
	 * @throws IOException 
	 * @throws FileCategoryLimitException 
	 */
	@PostMapping(path = "/uploadFile", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public FileResponse uploadFile(@RequestParam(name = "attachments") MultipartFile file, @RequestParam(name = "request") String request) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		AddFileRequest request1 = mapper.readValue(request, AddFileRequest.class);
		FileProp fileName = fileStorageService.storeFile(file,request1);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/download/")
				.path(fileName.getFileName())
				.toUriString();

		return new FileResponse(fileName.getFileName(), fileDownloadUri,
				file.getContentType(), file.getSize());
	}

	
	/**
	 * Get all the files by userId
	 * @param userId
	 * @return
	 */
	@GetMapping("/allfiles/{userId}")
	public DashboardResponse getAllFilesByUserId(@PathVariable("userId") Long userId){
		return fileStorageService.getAllFilesByUserId(userId);
		
	}
	@GetMapping("/byid/{id}")
	public FileProp getById(@PathVariable("id") String id) {
		
		return fileRepository.findById(id).get();
	}
	

	/**
	 * @param fileUpdate
	 * @return
	 */
	@PutMapping("/updatefile")
	public ResponseEntity<FileProp> updateById(@RequestBody FileUpdateRequest fileUpdate) {
		return fileStorageService.updateFile(fileUpdate);	
		
	}
}


