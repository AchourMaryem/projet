package com.example.projet_sem.Controller;

import com.example.projet_sem.Entity.B3;
import com.example.projet_sem.Entity.Document;
import com.example.projet_sem.service.ServiceB3;
import com.example.projet_sem.service.ServiceDocument;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Controller
@AllArgsConstructor
public class ControllerB3 {
    ServiceB3 serviceB3;
    ServiceDocument serviceDocument;
    @GetMapping("/B3")
    public String getAllB3(Model m)
    { List<B3> b=serviceB3.getAllB3();
        m.addAttribute("b3",b);
        return "/B3/ShowAll";
    }


    @PostMapping("/save")
    public String saveB3(@ModelAttribute B3 b3, Model m){

        System.out.println(b3);
        serviceB3.saveB3(b3);
        return "redirect:/B3";
    }

@GetMapping("/Ad")
    public String redirection(Model m){
        m.addAttribute("b3",new B3());
        return "/B3/Ad";
}
@GetMapping("/show/{id}")
    public String showB3(@PathVariable("id") Long id, Model m) {
        B3 b3 = serviceB3.getB3(id);
        m.addAttribute("b3", b3);
        return "/B3/Show";
    }
    @GetMapping("/edit/{id}")
    public String editB3(@PathVariable Long id, Model m){
        B3 b3 = serviceB3.getB3(id);
        m.addAttribute("b3", b3);
        return "/B3/Edit";
    }
    @PostMapping("/update/{id}")
    public String updateB3(@PathVariable Long id, @ModelAttribute B3 updatedB3){
        serviceB3.updateB3(id,updatedB3);
        return "redirect:/B3";
    }
@PostMapping("/delete/{id}")
    public String deleteB3(@PathVariable Long id){
        serviceB3.deleteB3(id);
        return "redirect:/B3";
}
    @GetMapping("/print-pdf/{id}")
    public ResponseEntity<byte[]> printPDF(@PathVariable Long id) {
        byte[] pdfContent = serviceB3.generatePDF(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", "b3.pdf");

        return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);
    }
}
