package com.srinivas.document.persistence.repo;

import com.srinivas.document.persistence.entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author <a href="mailto:sthallapalli@outlook.com">sthallapalli</a>
 */


public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {

}
