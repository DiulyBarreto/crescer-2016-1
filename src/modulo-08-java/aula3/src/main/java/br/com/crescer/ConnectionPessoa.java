/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import static java.awt.Event.INSERT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diuly.barreto
 */
public class ConnectionPessoa implements IPessoa {

    @Override
    public void insert(Pessoa pessoa) {
        String INSERT = "INSERT INTO PESSOA("
                    + "ID_PESSOA, NM_PESSOA ) "
                    + "VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA), ?)";
        
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
                    preparedStatement.setString(1, pessoa.getNome());
                    preparedStatement.executeUpdate();
        } catch (final SQLException e) {
                e.printStackTrace();
        }
    }

    @Override
    public void update(Pessoa pessoa) {
        String UPDATE = "UPDATE PESSOA SET NM_PESSOA = ? WHERE ID_PESSOA = ?";
        
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
                    preparedStatement.setString(1, pessoa.getNome());
                    preparedStatement.setLong(2, pessoa.getIdPessoa());
                    preparedStatement.executeUpdate();
        } catch (final SQLException e) {
                e.printStackTrace();
        }
    }

    @Override
    public void delete(Pessoa pessoa) {
        String DELETE = "DELETE FROM PESSOA WHERE ID_PESSOA = ?";
        
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
                    preparedStatement.setLong(1, pessoa.getIdPessoa());
                    preparedStatement.executeUpdate();
        } catch (final SQLException e) {
                e.printStackTrace();
        }
    }

    @Override
    public List<Pessoa> listAll() {
        String query = "SELECT * FROM PESSOA";
        List<Pessoa> lista = new ArrayList<>();
        try (final Connection connection = ConnectionUtils.getConnection();
                final Statement statement = connection.createStatement()) {
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        lista.add(new Pessoa(resultSet.getLong("ID_PESSOA"), resultSet.getString("NM_PESSOA")));
                    }
        } catch (final SQLException e) {
                e.printStackTrace();
        }
        
        return lista;
    }

    @Override
    public List<Pessoa> findNames(String nome) {
        String query = "SELECT * FROM PESSOA WHERE NM_PESSOA LIKE ?";
        List<Pessoa> lista = new ArrayList<>();
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, "%"+nome+"%");
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        lista.add(new Pessoa(resultSet.getLong("ID_PESSOA"), resultSet.getString("NM_PESSOA")));
                    }
        } catch (final SQLException e) {
                e.printStackTrace();
        }
        
        return lista;
    }
}
