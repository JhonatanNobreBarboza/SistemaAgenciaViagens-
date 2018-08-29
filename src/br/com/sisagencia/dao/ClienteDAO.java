/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sisagencia.dao;

import br.com.sisagencia.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonatan Nobre
 */
public class ClienteDAO {

    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public ClienteDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getIntance().getConnection();
        return conn;
    }
    
    public boolean add(Cliente cliente) throws Exception {
        try {
            String queryString = "INSERT INTO cliente(cpf, email, sexo, nome) VALUES(?,?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
            ptmt.setString(1, cliente.getCpf());
            ptmt.setString(2, cliente.getEmail());
            ptmt.setString(3, cliente.getSexo());
            ptmt.setString(4, cliente.getNome());
            ptmt.executeUpdate();
            
          //  ResultSet resultSet = ptmt.getGeneratedKeys();
          //  while(resultSet.next()){
          //  cliente.setIdcliente(resultSet.getInt("usuario_idusuario"));
          //  }
           
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection(connection, ptmt, resultSet);
        }
    }

    public boolean update(Cliente cliente) throws Exception {
        try {
            String queryString = "UPDATE cliente SET cpf=? WHERE idcliente=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, cliente.getCpf());
            ptmt.setInt(2, cliente.getIdcliente());
            ptmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection(connection, ptmt, resultSet);
        }
    }

    public int delete(int idcliente) throws Exception {
        try {
            String queryString = "DELETE FROM cliente WHERE idcliente=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, idcliente);
            int val = ptmt.executeUpdate();

            return val;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            closeConnection(connection, ptmt, resultSet);
        }
    }

    public List<Cliente> findAll() throws Exception {
        List<Cliente> clientes = new ArrayList<>();
        try {
            String queryString = "SELECT * FROM cliente";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                clientes.add(new Cliente(resultSet.getInt("idcliente"),
                        resultSet.getString("cpf"),
                        resultSet.getString("email"),
                        resultSet.getString("sexo"),
                        resultSet.getString("nome")));
            }
            return clientes;
        } catch (SQLException e) {
            e.printStackTrace();
            return clientes;
        } finally {
            closeConnection(connection, ptmt, resultSet);
        }
    }

    public void closeConnection(Connection conn, Statement st, ResultSet rs) throws Exception {
        close(conn, st, rs);
    }

    public void closeConnection(Connection conn, Statement st) throws Exception {
        close(conn, st, null);
    }

    public void closeConnection(Connection conn) throws Exception {
        close(conn, null, null);
    }

    public void close(Connection conn, Statement st, ResultSet rs) throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
