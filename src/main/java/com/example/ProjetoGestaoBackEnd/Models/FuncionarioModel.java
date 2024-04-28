package com.example.ProjetoGestaoBackEnd.Models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "funcionarios")
@Getter
@Setter

public class FuncionarioModel {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int telefone;
    private String cargo;
    private float salario;
    private int cpf;
    private int rg;
    private String endereco;

    @CreationTimestamp
    private Date data_registro;

    @UpdateTimestamp
    private Date data_update;
}
