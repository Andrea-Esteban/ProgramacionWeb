package pe.edu.upc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Bienvenido4 {

    @GetMapping("/bienvenido4")
    public String bienvenido4() {
        return "bienvenido4";
    }

}