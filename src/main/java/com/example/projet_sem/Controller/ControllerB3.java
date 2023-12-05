package com.example.projet_sem.Controller;

import com.example.projet_sem.Entity.B3;
import com.example.projet_sem.Entity.Document;
import com.example.projet_sem.service.ServiceB3;
import com.example.projet_sem.service.ServiceDocument;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
