package com.psil.safeclutch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psil.safeclutch.entity.SecurityQuestion;

/**
 * @author pkurdeka
 */
@Repository
public interface SecurityQuestionRepository extends JpaRepository<SecurityQuestion, Long> {

}
