/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisagencia.controller;

import br.com.sisagencia.dao.EmpresaDAO;
import br.com.sisagencia.model.Empresa;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhonatan Nobre
 */
public class EmpresaController {
    private Empresa empresa;
    private List<Empresa> empresas;
    private EmpresaDAO dao;

    public EmpresaController() {
        dao = new EmpresaDAO();
        empresa = new Empresa();
        try {
            empresas = dao.findAll();
        } catch (Exception ex) {
            Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean inserirEmpresa() throws Exception{
        return dao.add(empresa);
    }
    
    public boolean atualizarEmpresa() throws Exception{
        return dao.update(empresa);
    }
    
    public int removerEmpresa(int id) throws Exception{
        return dao.delete(id);
    }
    
    public void listarEmpresas() throws Exception{
        empresas = dao.findAll();
    }
    
    public Empresa getEmpresa(){
        return empresa;
    }
    
    public void setEmpresa(Empresa empresa){
        this.empresa = empresa;
    }
    
    public List<Empresa> getEmpresas(){
        return empresas;
    }

    public EmpresaDAO getDao() {
        return dao;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public void setDao(EmpresaDAO dao) {
        this.dao = dao;
    }
    
    
}
