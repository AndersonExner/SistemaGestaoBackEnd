package com.example.ProjetoGestaoBackEnd.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class ApiController {

    @GetMapping("/")
    public String rota(){
        return "API running";
    }
}
