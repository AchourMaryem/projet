package com.example.projet_sem.Controller;

import com.example.projet_sem.Entity.B3;
import com.example.projet_sem.Entity.WeddingCertificate;
import com.example.projet_sem.service.ServiceDocument;
import com.example.projet_sem.service.ServiceWeddingCertificate;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/wedding")

public class ControllerWeddingCertificate {
    ServiceWeddingCertificate serviceWeddingCertificate;
    ServiceDocument serviceDocument;
    @GetMapping("/")
    public String getAllWedd(Model m){
        List<WeddingCertificate> b=serviceWeddingCertificate.getAllWedd();
        m.addAttribute("weddingCertificate",b);
        return "/WeddingCertificate/ShowAll";
    }
    @GetMapping("/add")
    public String redirection(Model m){
        m.addAttribute("weddingCertificate", new WeddingCertificate());
        return "/WeddingCertificate/Ad";
    }

    @PostMapping("/save")
    public String saveWed(@ModelAttribute WeddingCertificate weddingCertificate, Model m){

        serviceWeddingCertificate.saveWed(weddingCertificate);
        return "redirect:/wedding/";
    }

    @GetMapping("/show/{id}")
    public String showWedding(@PathVariable("id") Long id, Model m) {
        WeddingCertificate weddingCertificate = serviceWeddingCertificate.getWedding(id);
        m.addAttribute("weddingCertificate", weddingCertificate);
        return "/WeddingCertificate/Show";
    }
    @GetMapping("/edit/{id}")
    public String editWedding(@PathVariable Long id, Model m){
        WeddingCertificate weddingCertificate = serviceWeddingCertificate.getWedding(id);
        m.addAttribute("weddingCertificate", weddingCertificate);
        return "/WeddingCertificate/Edit";
    }
    @PostMapping("/update/{id}")
    public String updateWedding(@PathVariable Long id, @ModelAttribute WeddingCertificate updatedWedding){
        serviceWeddingCertificate.updateWedding(id,updatedWedding);
        return "redirect:/wedding/";
    }
    @PostMapping("/delete/{id}")
    public String deleteWedding(@PathVariable Long id){
        serviceWeddingCertificate.deleteWedding(id);
        return "redirect:/wedding/";
    }
    @GetMapping("/print-pdf/{id}")
    public ResponseEntity<byte[]> printPDF(@PathVariable Long id) {
        byte[] pdfContent = serviceWeddingCertificate.generatePDF(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", "weddingCertificate.pdf");

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }


}

