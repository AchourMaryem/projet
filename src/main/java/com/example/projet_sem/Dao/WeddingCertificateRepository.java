package com.example.projet_sem.Dao;

import com.example.projet_sem.Entity.B3;
import com.example.projet_sem.Entity.WeddingCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeddingCertificateRepository extends JpaRepository<WeddingCertificate,Long> {
    List<WeddingCertificate> findByCin(String cin);



}
