package com.example.projet_sem.service;

import com.example.projet_sem.Dao.QrcodeRepository;
import com.example.projet_sem.Entity.Document;
import com.example.projet_sem.Entity.Qrcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class ServiceQrcode implements IServiceQrcode {

    @Autowired
    QrcodeRepository qrcodeRepository;

    @Override
    public void generateQrcode(Document document) {
        String Document =document.getId() + document.getCin() + document.getNom() + document.getPrenom();
        String hash = hashString(Document);
        Qrcode qrcode = new Qrcode();
        qrcode.setDocument(document);
        qrcode.setHash(hash);
        qrcodeRepository.save(qrcode);

    }
    private String hashString(String input){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodehash = digest.digest(input.getBytes());
            return bytesToHex(encodehash);

        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
    }
    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
