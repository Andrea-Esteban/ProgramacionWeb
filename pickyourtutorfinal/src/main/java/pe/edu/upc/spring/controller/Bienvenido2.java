package pe.edu.upc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Bienvenido2 {

    @GetMapping("/bienvenidoalapag")
    public String bienvenido2() {
        return "bienvenidoalapag";
    }

}