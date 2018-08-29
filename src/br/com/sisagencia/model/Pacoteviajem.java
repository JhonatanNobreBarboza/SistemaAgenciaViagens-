/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisagencia.model;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Jhonatan Nobre
 */
public class Pacoteviajem {
    private int idvendaPacoteViajem;
    private String roteiroViajem;
    private String tipoPacote;
    private String tipoPagamento;
    private Double valorPagamento;
    private Date dataIda;
    private Date dataVolta;

    public Pacoteviajem(int idvendaPacoteViajem, String roteiroViajem, String tipoPacote, String tipoPagamento, Double valorPagamento, Date dataIda, Date dataVolta) {
        this.idvendaPacoteViajem = idvendaPacoteViajem;
        this.roteiroViajem = roteiroViajem;
        this.tipoPacote = tipoPacote;
        this.tipoPagamento = tipoPagamento;
        this.valorPagamento = valorPagamento;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
    }

    public Pacoteviajem(String roteiroViajem, String tipoPacote, String tipoPagamento, Double valorPagamento, Date dataIda, Date dataVolta) {
        this.roteiroViajem = roteiroViajem;
        this.tipoPacote = tipoPacote;
        this.tipoPagamento = tipoPagamento;
        this.valorPagamento = valorPagamento;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
    }

    public Pacoteviajem() {
        }

    public int getIdvendaPacoteViajem() {
        return idvendaPacoteViajem;
    }

    public void setIdvendaPacoteViajem(int idvendaPacoteViajem) {
        this.idvendaPacoteViajem = idvendaPacoteViajem;
    }

    public String getRoteiroViajem() {
        return roteiroViajem;
    }

    public void setRoteiroViajem(String roteiroViajem) {
        this.roteiroViajem = roteiroViajem;
    }

    public String getTipoPacote() {
        return tipoPacote;
    }

    public void setTipoPacote(String tipoPacote) {
        this.tipoPacote = tipoPacote;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Date getDataIda() {
        return dataIda;
    }

    public void setDataIda(Date dataIda) {
        this.dataIda = dataIda;
    }

    public Date getDataVolta() {
        return dataVolta;
    }

    public void setDataVolta(Date dataVolta) {
        this.dataVolta = dataVolta;
    }
    
    
}