/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisagencia.controller;

import br.com.sisagencia.dao.PacoteviajemDAO;
import br.com.sisagencia.model.Pacoteviajem;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhonatan Nobre
 */
public class PacoteviajemController {
    private Pacoteviajem pacoteviajem;
    private List<Pacoteviajem> pacotesviajens;
    private PacoteviajemDAO dao;

    public PacoteviajemController() {
        dao = new PacoteviajemDAO();
        pacoteviajem = new Pacoteviajem();
        try {
            pacotesviajens = dao.findAll();
        } catch (Exception ex) {
            Logger.getLogger(PacoteviajemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean inserirPacoteviajem() throws Exception{
        return dao.add(pacoteviajem);
    }
    
    public boolean atualizarPacoteviajem() throws Exception{
        return dao.update(pacoteviajem);
    }
    
    public int removerPacoteviajem(int id) throws Exception{
        return dao.delete(id);
    }
    
    public void listarPacoteviajens() throws Exception{
        pacotesviajens = dao.findAll();
    }
        
    private void novo(){
        pacoteviajem = new Pacoteviajem();
        pacotesviajens = new ArrayList<>();
    }

    public Pacoteviajem getPacoteviajem() {
        return pacoteviajem;
    }

    public void setPacoteviajem(Pacoteviajem pacoteviajem) {
        this.pacoteviajem = pacoteviajem;
    }

    public List<Pacoteviajem> getPacotesviajens() {
        return pacotesviajens;
    }

    public void setPacotesviajens(List<Pacoteviajem> pacotesviajens) {
        this.pacotesviajens = pacotesviajens;
    }

    public PacoteviajemDAO getDao() {
        return dao;
    }

    public void setDao(PacoteviajemDAO dao) {
        this.dao = dao;
    }
    
    
    
    
}
