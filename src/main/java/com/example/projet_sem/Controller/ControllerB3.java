package com.example.projet_sem.Controller;

import com.example.projet_sem.Entity.B3;
import com.example.projet_sem.Entity.Document;
import com.example.projet_sem.service.ServiceB3;
import com.example.projet_sem.service.ServiceDocument;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.projet_sem.service.ServiceQrcode;
import java.io.IOException;
import java.util.List;
//pdf
import org.springframework.http.HttpStatus;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Binding;

@Controller
@AllArgsConstructor
@RequestMapping("/papier3")

public class ControllerB3 {
    ServiceB3 serviceB3;
    ServiceDocument serviceDocument;
    ServiceQrcode qrservice;
    @GetMapping("/")
    public String getAllB3(Model m)
    { List<B3> b=serviceB3.getAllB3();
        m.addAttribute("b3",b);
        return "/B3/ShowAll";
    }

  /**  public String getAllB3(Model m,
                           @RequestParam(name = "mc",defaultValue = "")String mc,
                           @RequestParam(name = "mc",defaultValue = "")String mc1,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "10") int size
    )



    {

        Page<B3> b=serviceB3.getB3ByMc(mc, mc1,PageRequest.of(page, size));
        m.addAttribute("mc",mc);
        m.addAttribute("mc1",mc1);
        m.addAttribute("b3", b.getContent());
        m.addAttribute("pages", new int[b.getTotalPages()]);
        m.addAttribute("currentpage", b.getNumber());

        return "/B3/ShowAll";
    }*/






    @PostMapping("/save")
    public String saveB3(@Valid B3 b3, BindingResult bindingResult ,Model m,
                         @RequestParam ("image") MultipartFile mf) throws IOException {
        if (bindingResult.hasErrors()){
            return "/B3/Ad";
        }

      //  System.out.println(b3);
        serviceB3.saveB3(b3,mf);
       qrservice.generateQrcode(b3);

        return "redirect:/papier3/";
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
        return "redirect:/papier3/";
    }
@PostMapping("/delete/{id}")
    public String deleteB3(@PathVariable Long id){
        serviceB3.deleteB3(id);
        return "redirect:/papier3/";
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
