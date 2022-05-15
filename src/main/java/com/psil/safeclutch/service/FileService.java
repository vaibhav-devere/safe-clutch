/**
 * 
 */
package com.psil.safeclutch.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.psil.safeclutch.entity.FileCategory;
import com.psil.safeclutch.entity.FileProp;
import com.psil.safeclutch.entity.User;
import com.psil.safeclutch.exceptions.FileCategoryLimitException;
import com.psil.safeclutch.exceptions.FileStorageException;
import com.psil.safeclutch.exceptions.UserNotFoundException;
import com.psil.safeclutch.repository.FileCategoryRepository;
import com.psil.safeclutch.repository.FileStorageRepository;
import com.psil.safeclutch.repository.UserRepository;
import com.psil.safeclutch.request.AddFileRequest;
import com.psil.safeclutch.request.FileUpdateRequest;
import com.psil.safeclutch.response.DashboardResponse;
import com.psil.safeclutch.response.FinalCategory;
import com.psil.safeclutch.response.UserFiles;
import com.psil.safeclutch.util.FileUtil;

/**
 * @author vdevere
 *
 */
/**
 * 
 * @author vpottumu
 *
 */
@Transactional
@Service
public class FileService implements IFileService {

	@Autowired
	private FileStorageRepository fileStorageRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FileCategoryRepository categoryRepository;

	@Autowired
	private FileUtil fileUtil;

	/**
	 * Method to store the file and other fields into the database.
	 * @throws FileCategoryLimitException 
	 * @throws IOException 
	 */
	@Override
	public FileProp storeFile(MultipartFile file, AddFileRequest request) throws IOException{
		// Normalize file name
		String fileName = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		User user = userRepository.findById(request.getUserId())
				.orElseThrow(() -> new UserNotFoundException("User Not Found with userId" + request.getUserId()));
		FileCategory fileCategory = categoryRepository.findById(request.getFileCategoryId()).get(); 

		if (fileName.contains("..")) {
			throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
		}
		if(file.getSize() > 5000000)
		{
			throw new FileStorageException("File Size Exceeds 5MB");
		}


		FileProp dbFile = new FileProp(fileName, file.getContentType(), fileCategory.getFileCategory(),
				request.getDescription(), request.getSelfAssested(), file.getBytes(), user);

		return fileStorageRepository.save(dbFile);

	}



	/**
	 * Get all files by userId and also the resultant Categories
	 */
	@Override
	public DashboardResponse getAllFilesByUserId(Long userId) {
		DashboardResponse response = new DashboardResponse();

		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found "+userId));
		List<FileProp> listOfFiles = fileStorageRepository.findByUser(user);
		System.out.println(listOfFiles);
		List<UserFiles> userFiles = fileUtil.toListUserFiles(listOfFiles);



		//avaibale categories
		List<FileCategory> availableCategories = categoryRepository.findAll();

		//result categories
		List<FinalCategory> resultCategories = new ArrayList<>();

		//mapping against the category
		Map<String,List<FileProp>> mapByCategory = listOfFiles.stream().collect(Collectors.groupingBy(o -> o.getFileCategory()));

		for(FileCategory c : availableCategories) {
			FinalCategory result = new FinalCategory();
			if(mapByCategory.containsKey(c.getFileCategory())) {
				if(c.getDocumentLimit() - mapByCategory.get(c.getFileCategory()).size()!=0) {

					Long count = c.getDocumentLimit() - mapByCategory.get(c.getFileCategory()).size();
					result.setCategoryId(c.getId());
					result.setCategoryName(c.getFileCategory());
					result.setFinalLimit(count);

					resultCategories.add(result);

				}
				else {
					continue;
				}
			}
			else {
				result.setCategoryId(c.getId());
				result.setCategoryName(c.getFileCategory());
				result.setFinalLimit(c.getDocumentLimit());

				resultCategories.add(result);

			}
		}

		response.setUserFiles(userFiles);
		response.setResulantantCategories(resultCategories);

		return response;
	}



	@Override
	public ResponseEntity<FileProp> updateFile(FileUpdateRequest fileUpdate) {
		FileProp file = fileStorageRepository.getById(fileUpdate.getFileId());

		file.setDescription(fileUpdate.getDescription());
		file.setSelfAssested(fileUpdate.getSelfAssested());
		FileProp updatedFile = fileStorageRepository.save(file);
		return ResponseEntity.ok(updatedFile);
	}
}
