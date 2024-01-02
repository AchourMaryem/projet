package com.example.projet_sem.Controller;


import com.example.projet_sem.Dao.BirthCertificateRepository;
import com.example.projet_sem.Entity.BirthCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControllerBirthCertificate {
    @Autowired
    BirthCertificateRepository birthCertificateRepository;


    @PostMapping("/bc")
    public BirthCertificate addbc(@RequestBody BirthCertificate birth){
        birthCertificateRepository.save(birth);
        return birth;

    }
}
