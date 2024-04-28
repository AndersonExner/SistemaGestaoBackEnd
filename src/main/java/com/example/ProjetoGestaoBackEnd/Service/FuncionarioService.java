package com.example.ProjetoGestaoBackEnd.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ProjetoGestaoBackEnd.Models.ResponseModel;
import com.example.ProjetoGestaoBackEnd.Models.FuncionarioModel;
import com.example.ProjetoGestaoBackEnd.Repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ResponseModel response;

    public Iterable<FuncionarioModel> bucarTodos(){
        return funcionarioRepository.findAll();
    }

    public ResponseEntity<ResponseModel> cadastrar(FuncionarioModel model){

        if(model.getNome().equals("")){
            response.setMessage("Nome Obrigatório");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        }

        if(model.getCargo().equals("")){
            response.setMessage("Cargo Obrigatório");
            return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
        }

        FuncionarioModel novoFuncionario = funcionarioRepository.save(model);

        if(novoFuncionario != null){
            response.setMessage("Cadastrado com Sucesso");
        }else{
            response.setMessage("Ocorreu um Erro");
        }

        return new ResponseEntity<ResponseModel>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseModel> remover(Long id){
        funcionarioRepository.deleteById(id);

        response.setMessage("Usuário Removido Com Sucesso");

        return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
    }
}
