package com.example.ProjetoGestaoBackEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetoGestaoBackEnd.Models.FuncionarioModel;
import com.example.ProjetoGestaoBackEnd.Models.ResponseModel;
import com.example.ProjetoGestaoBackEnd.Service.FuncionarioService;

@RestController
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionario")
    public Iterable<FuncionarioModel> buscartodos(){
        return funcionarioService.bucarTodos();
    }

    @PostMapping("/funcionario")
    public ResponseEntity<ResponseModel> cadastrar(@RequestBody FuncionarioModel model){
        return funcionarioService.cadastrar(model);
    }

    @DeleteMapping("/funcionario/{codigo}")
    public ResponseEntity<ResponseModel> remover(@PathVariable Long codigo){
        return funcionarioService.remover(codigo);
    }
}
