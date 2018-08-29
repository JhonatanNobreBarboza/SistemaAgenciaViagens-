/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sisagencia.dao;

import br.com.sisagencia.model.Pacoteviajem;
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
public class PacoteviajemDAO {

    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public PacoteviajemDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getIntance().getConnection();
        return conn;
    }
    
    public boolean add(Pacoteviajem pacoteviajem) throws Exception {
        try {
            String queryString = "INSERT INTO pacoteviajem(roteiroViajem, tipoPacote, tipoPagamento, valorPagamento, dataIda, dataVolta) VALUES(?,?,?,?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
            ptmt.setString(1, pacoteviajem.getRoteiroViajem());
            ptmt.setString(2, pacoteviajem.getTipoPacote());
            ptmt.setString(3, pacoteviajem.getTipoPagamento());
            ptmt.setDouble(4, pacoteviajem.getValorPagamento());
            ptmt.setDate(5, pacoteviajem.getDataIda());
            ptmt.setDate(6, pacoteviajem.getDataVolta());
            ptmt.executeUpdate();
                       
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection(connection, ptmt, resultSet);
        }
    }

    public boolean update(Pacoteviajem pacoteviajem) throws Exception {
        try {
            String queryString = "UPDATE pacoteviajem SET tipoPacote=? WHERE idvendaPacoteViajem=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, pacoteviajem.getTipoPacote());
            ptmt.setInt(2, pacoteviajem.getIdvendaPacoteViajem());
            ptmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection(connection, ptmt, resultSet);
        }
    }

    public int delete(int idpacoteviajem) throws Exception {
        try {
            String queryString = "DELETE FROM pacoteviajem WHERE idvendaPacoteViajem=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, idpacoteviajem);
            int val = ptmt.executeUpdate();

            return val;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            closeConnection(connection, ptmt, resultSet);
        }
    }

    public List<Pacoteviajem> findAll() throws Exception {
        List<Pacoteviajem> pacoteviajens = new ArrayList<>();
        try {
            String queryString = "SELECT * FROM pacoteviajem";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                pacoteviajens.add(new Pacoteviajem(resultSet.getInt("idvendaPacoteViajem"),
                        resultSet.getString("roteiroViajem"),
                        resultSet.getString("tipoPacote"),
                        resultSet.getString("tipoPagamento"),
                        resultSet.getDouble("valorPagamento"),
                        resultSet.getDate("dataIda"),
                        resultSet.getDate("dataVolta")));
            }
            return pacoteviajens;
        } catch (SQLException e) {
            e.printStackTrace();
            return pacoteviajens;
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
