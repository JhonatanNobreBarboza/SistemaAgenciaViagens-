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
public class EmpresaHospedagem {
    private int idempresaHospedagem;
    private String adicionais;
    private int diasHospedados;
    private String tipoQuarto;
    private Double valorDiaria;
    private int empresa_idempresa;
    private int empresa_documentos_iddocumentos;
    private int empresa_endereco_idendereco;

    public EmpresaHospedagem(int idempresaHospedagem, String adicionais, int diasHospedados, String tipoQuarto, Double valorDiaria, int empresa_idempresa, int empresa_documentos_iddocumentos, int empresa_endereco_idendereco) {
        this.idempresaHospedagem = idempresaHospedagem;
        this.adicionais = adicionais;
        this.diasHospedados = diasHospedados;
        this.tipoQuarto = tipoQuarto;
        this.valorDiaria = valorDiaria;
        this.empresa_idempresa = empresa_idempresa;
        this.empresa_documentos_iddocumentos = empresa_documentos_iddocumentos;
        this.empresa_endereco_idendereco = empresa_endereco_idendereco;
    }

    public EmpresaHospedagem(String adicionais, int diasHospedados, String tipoQuarto, Double valorDiaria, int empresa_idempresa, int empresa_documentos_iddocumentos, int empresa_endereco_idendereco) {
        this.adicionais = adicionais;
        this.diasHospedados = diasHospedados;
        this.tipoQuarto = tipoQuarto;
        this.valorDiaria = valorDiaria;
        this.empresa_idempresa = empresa_idempresa;
        this.empresa_documentos_iddocumentos = empresa_documentos_iddocumentos;
        this.empresa_endereco_idendereco = empresa_endereco_idendereco;
    }

    public int getIdempresaHospedagem() {
        return idempresaHospedagem;
    }

    public void setIdempresaHospedagem(int idempresaHospedagem) {
        this.idempresaHospedagem = idempresaHospedagem;
    }

    public String getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(String adicionais) {
        this.adicionais = adicionais;
    }

    public int getDiasHospedados() {
        return diasHospedados;
    }

    public void setDiasHospedados(int diasHospedados) {
        this.diasHospedados = diasHospedados;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public int getEmpresa_idempresa() {
        return empresa_idempresa;
    }

    public void setEmpresa_idempresa(int empresa_idempresa) {
        this.empresa_idempresa = empresa_idempresa;
    }

    public int getEmpresa_documentos_iddocumentos() {
        return empresa_documentos_iddocumentos;
    }

    public void setEmpresa_documentos_iddocumentos(int empresa_documentos_iddocumentos) {
        this.empresa_documentos_iddocumentos = empresa_documentos_iddocumentos;
    }

    public int getEmpresa_endereco_idendereco() {
        return empresa_endereco_idendereco;
    }

    public void setEmpresa_endereco_idendereco(int empresa_endereco_idendereco) {
        this.empresa_endereco_idendereco = empresa_endereco_idendereco;
    }

    
}