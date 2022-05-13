package com.psil.safeclutch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psil.safeclutch.entity.FileCategory;

@Repository
public interface FileCategoryRepository extends JpaRepository<FileCategory, Long> {
        Long findByDocumentLimit(Long id);

}
