package com.example.ProjetoGestaoBackEnd.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ProjetoGestaoBackEnd.Models.FuncionarioModel;
import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<FuncionarioModel, Long > {
    
    List<FuncionarioModel> findByCpf(String cpf);
}
