/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisagencia.controller;

import br.com.sisagencia.dao.ClienteDAO;
import br.com.sisagencia.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhonatan Nobre
 */
public class ClienteController {
    private Cliente cliente;
    private List<Cliente> clientes;
    private ClienteDAO dao;

    public ClienteController() {
        dao = new ClienteDAO();
        cliente = new Cliente();
        try {
            clientes = dao.findAll();
        } catch (Exception ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean inserirCliente() throws Exception{
        return dao.add(cliente);
    }
    
    public boolean atualizarCliente() throws Exception{
        return dao.update(cliente);
    }
    
    public int removerCliente(int id) throws Exception{
        return dao.delete(id);
    }
    
    public void listarClientes() throws Exception{
        clientes = dao.findAll();
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    private void novo(){
        cliente = new Cliente();
        clientes = new ArrayList<>();
    }
    
    public List<Cliente> getClientes(){
        return clientes;
    }

    public ClienteDAO getDao() {
        return dao;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setDao(ClienteDAO dao) {
        this.dao = dao;
    }
    
    
}
