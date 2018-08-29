/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisagencia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jhonatan Nobre
 */
public class ConnectionFactory {
    String driverClassName = "com.mysql.jdbc.Driver";
    String connectionURL = "jdbc:mysql://localhost:3306/agenciaviajemdb";
    String dbUser = "root";
    String dbPwd = "";
    
    private static ConnectionFactory connectionFactory = null;
    
    private ConnectionFactory(){
        try{
            Class.forName(driverClassName);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection()throws SQLException{
        Connection conn = null;
        conn = DriverManager.getConnection(connectionURL, dbUser, dbPwd);
        return conn;
    }
    
    public static ConnectionFactory getIntance(){
        if(connectionFactory == null){
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}
