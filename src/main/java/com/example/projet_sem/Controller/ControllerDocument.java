package com.example.projet_sem.Controller;

import com.example.projet_sem.service.ServiceDocument;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ControllerDocument {


    @GetMapping("/index")
    public String getAllDocuments(Model m)
    {
        return "index";
    }


}
