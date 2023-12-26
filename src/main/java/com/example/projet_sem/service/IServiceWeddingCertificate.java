package com.example.projet_sem.service;

import com.example.projet_sem.Entity.B3;
import com.example.projet_sem.Entity.WeddingCertificate;

import java.util.List;

public interface IServiceWeddingCertificate {
    public List<WeddingCertificate> getAllWedd();
    public void saveWed(WeddingCertificate weddingCertificate);
    public WeddingCertificate getWedding(Long id);
    void updateWedding(Long id, WeddingCertificate updatedWedding);
    void deleteWedding(Long id);
    byte[] generatePDF(Long id);

}

