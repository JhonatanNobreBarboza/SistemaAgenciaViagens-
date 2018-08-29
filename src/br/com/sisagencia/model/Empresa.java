/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisagencia.model;
/**
 *
 * @author Jhonatan Nobre
 */
public class Empresa {
    private int idempresa;
    private String cnpj;
    private String razaoSocial;
    private String statusSituacao;
    private String ramoAtividade;
    private String descrServico;

    public Empresa() {
    
    }

    public Empresa(int idempresa, String cnpj, String razaoSocial, String statusSituacao, String ramoAtividade, String descrServico) {
        this.idempresa = idempresa;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.statusSituacao = statusSituacao;
        this.ramoAtividade = ramoAtividade;
        this.descrServico = descrServico;
    }

    public Empresa(String cnpj, String razaoSocial, String statusSituacao, String ramoAtividade, String descrServico) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.statusSituacao = statusSituacao;
        this.ramoAtividade = ramoAtividade;
        this.descrServico = descrServico;
    }

      
    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getStatusSituacao() {
        return statusSituacao;
    }

    public void setStatusSituacao(String statusSituacao) {
        this.statusSituacao = statusSituacao;
    }

    public String getRamoAtividade() {
        return ramoAtividade;
    }

    public void setRamoAtividade(String ramoAtividade) {
        this.ramoAtividade = ramoAtividade;
    }

    public String getDescrServico() {
        return descrServico;
    }

    public void setDescrServico(String descrServico) {
        this.descrServico = descrServico;
    }
    
    
}