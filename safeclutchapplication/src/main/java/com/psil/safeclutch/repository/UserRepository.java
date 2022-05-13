package com.psil.safeclutch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psil.safeclutch.entity.User;

/**
 * 
 * @author vdevere
 * 
 *
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	User findByPhoneNumber(Long phoneNumber);

}
