/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author diuly.barreto
 */
public class Run2 {
    private static final Logger LOGGER = Logger.getLogger(Run.class.getName());
    
    public static void main(String[] args) {
        final String INSERT = "INSERT INTO PESSOA("
                    + "ID_PESSOA, NM_PESSOA ) "
                    + "VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA), ?)";
        
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
                    preparedStatement.setString(1, "Pedro");
                    preparedStatement.executeUpdate();
        } catch (final SQLException e) {
                LOGGER.severe(e.getMessage());
        }
    }
}
