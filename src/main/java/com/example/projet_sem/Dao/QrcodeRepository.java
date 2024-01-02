package com.example.projet_sem.Dao;

import com.example.projet_sem.Entity.Document;
import com.example.projet_sem.Entity.Qrcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QrcodeRepository extends JpaRepository <Qrcode , Long> {
    public Qrcode findQrcodeByHash(String hash);
}
