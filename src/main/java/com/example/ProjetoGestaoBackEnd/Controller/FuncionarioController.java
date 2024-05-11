package com.example.ProjetoGestaoBackEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjetoGestaoBackEnd.Models.FuncionarioModel;
import com.example.ProjetoGestaoBackEnd.Models.ResponseModel;
import com.example.ProjetoGestaoBackEnd.Service.FuncionarioService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/Api")
public class FuncionarioController {
    
    @Autowired
    private final FuncionarioService funcionarioService;

    private final PasswordEncoder encoder;

    private final ResponseModel response;

    public FuncionarioController (FuncionarioService funcionarioService, PasswordEncoder encoder, ResponseModel response) {
        this.funcionarioService = funcionarioService;
        this.encoder = encoder;
        this.response = response;
    }

    @GetMapping("/Funcionario")
    public Iterable<FuncionarioModel> buscartodos(){
        return funcionarioService.bucarTodos();
    }

    @PostMapping("/Funcionario")
    public ResponseEntity<ResponseModel> cadastrar(@RequestBody FuncionarioModel funcionario){

        if (funcionario.getNome().isEmpty()) {
            response.setSuccess(false);
            response.setMessage("Nome Obrigatório");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        }

        if (funcionario.getEmail().isEmpty()) {
            response.setSuccess(false);
            response.setMessage("Email Obrigatório");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        }
        
        if (funcionario.getSenha().isEmpty()) {
            response.setSuccess(false);
            response.setMessage("Senha Obrigatório");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        }
        if (funcionario.getTelefone().isEmpty()) {
            response.setSuccess(false);
            response.setMessage("Telefone Obrigatório");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        }
        
        if (funcionario.getCargo().isEmpty()) {
            response.setSuccess(false);
            response.setMessage("Cargo Obrigatório");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        }

        if (funcionario.getSalario().isEmpty()) {
            response.setSuccess(false);
            response.setMessage("Salário Obrigatório");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        }

        if (funcionario.getCpf().isEmpty()) {
            response.setSuccess(false);
            response.setMessage("CPF Obrigatório");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        }

        if (funcionario.getEndereco().isEmpty()) {
            response.setSuccess(false);
            response.setMessage("Endereço Obrigatório");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        }

        funcionario.setSenha(encoder.encode(funcionario.getSenha()));
        
        return funcionarioService.cadastrar(funcionario);
    }

    @DeleteMapping("/Funcionario/{codigo}")
    public ResponseEntity<ResponseModel> remover(@PathVariable Long codigo){
        return funcionarioService.remover(codigo);
    }
}
