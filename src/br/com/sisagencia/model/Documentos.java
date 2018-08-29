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
public class Documentos {
    private int iddocumentos;
    private String certidaoFGTS;
    private String certidaoUniao;
    private String certidaoTrabalhista;
    private String certidaoinscricaoEstadual;
    private int empresa_idempresa;

    public Documentos(int iddocumentos, String certidaoFGTS, String certidaoUniao, String certidaoTrabalhista, String certidaoinscricaoEstadual, int empresa_idempresa) {
        this.iddocumentos = iddocumentos;
        this.certidaoFGTS = certidaoFGTS;
        this.certidaoUniao = certidaoUniao;
        this.certidaoTrabalhista = certidaoTrabalhista;
        this.certidaoinscricaoEstadual = certidaoinscricaoEstadual;
        this.empresa_idempresa = empresa_idempresa;
    }

    public Documentos(String certidaoFGTS, String certidaoUniao, String certidaoTrabalhista, String certidaoinscricaoEstadual, int empresa_idempresa) {
        this.certidaoFGTS = certidaoFGTS;
        this.certidaoUniao = certidaoUniao;
        this.certidaoTrabalhista = certidaoTrabalhista;
        this.certidaoinscricaoEstadual = certidaoinscricaoEstadual;
        this.empresa_idempresa = empresa_idempresa;
    }

    public int getIddocumentos() {
        return iddocumentos;
    }

    public void setIddocumentos(int iddocumentos) {
        this.iddocumentos = iddocumentos;
    }

    public String getCertidaoFGTS() {
        return certidaoFGTS;
    }

    public void setCertidaoFGTS(String certidaoFGTS) {
        this.certidaoFGTS = certidaoFGTS;
    }

    public String getCertidaoUniao() {
        return certidaoUniao;
    }

    public void setCertidaoUniao(String certidaoUniao) {
        this.certidaoUniao = certidaoUniao;
    }

    public String getCertidaoTrabalhista() {
        return certidaoTrabalhista;
    }

    public void setCertidaoTrabalhista(String certidaoTrabalhista) {
        this.certidaoTrabalhista = certidaoTrabalhista;
    }

    public String getCertidaoinscricaoEstadual() {
        return certidaoinscricaoEstadual;
    }

    public void setCertidaoinscricaoEstadual(String certidaoinscricaoEstadual) {
        this.certidaoinscricaoEstadual = certidaoinscricaoEstadual;
    }

    public int getEmpresa_idempresa() {
        return empresa_idempresa;
    }

    public void setEmpresa_idempresa(int empresa_idempresa) {
        this.empresa_idempresa = empresa_idempresa;
    }
    
        
}