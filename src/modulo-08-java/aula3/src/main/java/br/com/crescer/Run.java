/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author diuly.barreto
 */
public class Run {

    public static void main(String[] args) {
        final String insert = "INSERT INTO PESSOA("
                    + "ID_PESSOA, NM_PESSOA ) "
                    + "VALUES (?, ?)";
        
        final String ddl = "CREATE TABLE PESSOA ("
                + " ID_PESSOA NUMBER(19,0) NOT NULL, "
                + " NM_PESSOA VARCHAR2(50) NOT NULL, "
                + " PRIMARY KEY (ID_PESSOA) "
                + ")";
        
        final String dml = "INSERT INTO PESSOA (ID_PESSOA, NM_PESSOA)" + "VALUES (1, 'Diuly')";
        
        final String query = "Select * from Pessoa";
        
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                // criar tabela
                //statement.executeUpdate(ddl);
                
                // inserir
                //statement.executeUpdate(dml);
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    System.out.println(rs.getString("NM_PESSOA"));
                }
                rs.close();
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            } 
            
        }catch (SQLException e) {
                System.err.format("SQLException: %s", e);
        }
    }
}
