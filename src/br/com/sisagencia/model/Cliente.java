/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sisagencia.model;

import java.sql.Date;

/**
 *
 * @author Jhonatan Nobre
 */
public class Cliente {
    private int idcliente;
    private String cpf;
    private String email;
    private String sexo;
    private String nome;

    public Cliente() {
    
    }

    public Cliente(int idcliente, String cpf, String email, String sexo, String nome) {
        this.idcliente = idcliente;
        this.cpf = cpf;
        this.email = email;
        this.sexo = sexo;
        this.nome = nome;
        //this.usuario_idusuario = usuario_idusuario;
    }

    public Cliente(String cpf, String email, String sexo, String nome) {
        this.cpf = cpf;
        this.email = email;
        this.sexo = sexo;
        this.nome = nome;
        //this.usuario_idusuario = usuario_idusuario;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getCpf() {
        return cpf;
    }

    public   void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
