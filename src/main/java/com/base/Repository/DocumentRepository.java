package com.base.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.base.Model.Document;
 
@Transactional
public interface DocumentRepository extends JpaRepository<Document, Long>
{	

	
}


