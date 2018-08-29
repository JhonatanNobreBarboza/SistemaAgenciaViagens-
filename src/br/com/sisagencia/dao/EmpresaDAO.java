/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sisagencia.dao;

import br.com.sisagencia.dao.ConnectionFactory;
import br.com.sisagencia.model.Empresa;
import br.com.sisagencia.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonatan Nobre
 */
public class EmpresaDAO {
    
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public EmpresaDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getIntance().getConnection();
        return conn;
    }

    public boolean add(Empresa empresa) throws Exception {
        try {
            String queryString = "INSERT INTO empresa(cnpj, razaoSocial, statusSituacao, ramoAtividade, descrServico) VALUES(?,?,?,?,?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, empresa.getCnpj());
            ptmt.setString(2, empresa.getRazaoSocial());
            ptmt.setString(3, empresa.getStatusSituacao());
            ptmt.setString(4, empresa.getRamoAtividade());
            ptmt.setString(5, empresa.getDescrServico());
            ptmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection(connection, ptmt, resultSet);
        }
    }

    public boolean update(Empresa empresa) throws Exception {
        try {
            String queryString = "UPDATE empresa SET cnpj=? WHERE idempresa=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, empresa.getCnpj());
            ptmt.setInt(2, empresa.getIdempresa());
            ptmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection(connection, ptmt, resultSet);
        }
    }

    public int delete(int idempresa) throws Exception {
        try {
            String queryString = "DELETE FROM empresa WHERE idempresa=?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, idempresa);
            int val = ptmt.executeUpdate();

            return val;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            closeConnection(connection, ptmt, resultSet);
        }
    }

    public List<Empresa> findAll() throws Exception {
        List<Empresa> empresas = new ArrayList<>();
        try {
            String queryString = "SELECT * FROM empresa";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                empresas.add(new Empresa(resultSet.getInt("idempresa"),
                        resultSet.getString("cnpj"),
                        resultSet.getString("razaoSocial"),
                        resultSet.getString("statusSituacao"),
                        resultSet.getString("ramoAtividade"),
                        resultSet.getString("descrServico")));
            }
            return empresas;
        } catch (SQLException e) {
            e.printStackTrace();
            return empresas;
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

    private List<Empresa> findEmpresaEntities(boolean b, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
