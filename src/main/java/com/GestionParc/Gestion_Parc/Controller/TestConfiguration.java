package com.GestionParc.Gestion_Parc.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConfiguration {


    @GetMapping("/hello")
    public String hello(){
        return "helo world";
    }
}
