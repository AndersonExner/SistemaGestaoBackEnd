package com.example.ProjetoGestaoBackEnd.Models;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ResponseModel {
    
    private Boolean success;
    private String message;

}
