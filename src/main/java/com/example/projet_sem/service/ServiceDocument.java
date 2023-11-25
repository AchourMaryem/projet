package com.example.projet_sem.service;

import com.example.projet_sem.Dao.DocumentRepository;
import com.example.projet_sem.Entity.Document;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceDocument implements IServiceDocument{
    DocumentRepository documentRepository;
    @Override
    public List<Document> getAllDocuments() {

        return documentRepository.findAll();
    }


}
