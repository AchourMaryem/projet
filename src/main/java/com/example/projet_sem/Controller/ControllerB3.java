package com.example.projet_sem.Controller;

import com.example.projet_sem.Entity.B3;
import com.example.projet_sem.service.ServiceB3;
import com.example.projet_sem.service.ServiceDocument;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
