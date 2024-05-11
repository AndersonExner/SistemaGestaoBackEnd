package com.example.ProjetoGestaoBackEnd.Service;

import java.util.List;

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

    public ResponseEntity<ResponseModel> cadastrar(FuncionarioModel funcionario){
        try {

            if (!validarCPF(funcionario.getCpf())) {
                response.setSuccess(false);
                response.setMessage("CPF já cadastrado");
                return new ResponseEntity<ResponseModel>(response, HttpStatus.BAD_REQUEST);
            }

            FuncionarioModel novoFuncionario = funcionarioRepository.save(funcionario);

            if(novoFuncionario != null){
                response.setSuccess(true);
                response.setMessage("Cadastrado com Sucesso");
            }else{
                response.setSuccess(false);
                response.setMessage("Ocorreu um Erro");
            }

        } catch (Exception error) {
            response.setSuccess(false);
            response.setMessage(error.toString());
        }


        return new ResponseEntity<ResponseModel>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseModel> remover(Long id){
        funcionarioRepository.deleteById(id);
        response.setSuccess(true);
        response.setMessage("Usuário Removido Com Sucesso");

        return new ResponseEntity<ResponseModel>(response, HttpStatus.OK);
    }

    private boolean validarCPF(String cpf) {
        List<FuncionarioModel> list = funcionarioRepository.findByCpf(cpf); 

        if(!list.isEmpty()) {
            return false;
        }

        return true;
    }

}
