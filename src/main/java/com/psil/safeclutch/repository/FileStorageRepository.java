/**
 * 
 */
package com.psil.safeclutch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psil.safeclutch.entity.FileProp;
import com.psil.safeclutch.entity.User;

/**
 * @author vdevere
 *
 */
@Repository
public interface FileStorageRepository extends JpaRepository<FileProp,String> {
	List<FileProp> findByUser(User user);
}
