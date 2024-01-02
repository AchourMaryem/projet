package com.example.projet_sem.Controller;

import com.example.projet_sem.Dao.DocumentRepository;
import com.example.projet_sem.Dao.QrcodeRepository;
import com.example.projet_sem.Entity.Document;
import com.example.projet_sem.Entity.Qrcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QrController {
    @Autowired
    QrcodeRepository qrcodeRepository;
    @GetMapping("/verify/{hash}")
    public Document getDoc(@PathVariable String hash){
        Qrcode qr = qrcodeRepository.findQrcodeByHash(hash);
        return qr.getDocument();

    }
}

