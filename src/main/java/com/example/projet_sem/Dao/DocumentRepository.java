package com.example.projet_sem.Dao;

import com.example.projet_sem.Entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository <Document,Long> {
    public Document findDocumentById(Long id);
}
