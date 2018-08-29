package br.com.sisagencia.controller;

import br.com.sisagencia.dao.UsuarioDAO;
import br.com.sisagencia.model.Usuario;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rgarcia
 */
public class UsuarioController {
    private UsuarioDAO dao;
    private Usuario usuario;
    private List<Usuario> usuarios;

    public UsuarioController() {
        usuario = new Usuario();
        dao = new UsuarioDAO();
        usuarios = dao.findUsuarioEntities();
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }   
    
    public void salvar() throws NoSuchAlgorithmException{
        encriptografarSenha();
        dao.create(usuario);
    }
    
    public void removerUsuario(int id) throws Exception{
        dao.destroy(id);
    }
    
    public boolean efetuarLogin() throws NoSuchAlgorithmException{
        encriptografarSenha();
        if(dao.efetuarLogin(usuario) != null)
            return true;
        else return false;
    }
    
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public UsuarioDAO getDao() {
        return dao;
    }

    public void setDao(UsuarioDAO dao) {
        this.dao = dao;
    }
    
    private void encriptografarSenha() throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(usuario.getSenha().getBytes());
        
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        /*StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
     
        System.out.println("Hex format : " + sb.toString());*/
        
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	usuario.setSenha(hexString.toString());
    }
        
    
}
