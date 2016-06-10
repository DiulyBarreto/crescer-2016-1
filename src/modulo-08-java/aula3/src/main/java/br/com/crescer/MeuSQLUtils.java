/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diuly.barreto
 */
public class MeuSQLUtils {
    // TODO - REFATORAR READERUTILS PARA UTILIZAR AQUI
    public void executaComandosDeArquivo(String path) {
        if(ehArquivoSQL(path)) {
            try {
                Reader reader = new FileReader(path);
                BufferedReader bufferReader = new BufferedReader(reader);
                String line;
                do {
                    line = bufferReader.readLine();
                    System.out.println(line);
                    if(line != null)
                        executaComando(line);
                } while (line != null);

            } catch (IOException e) {
                System.out.println("Arquivo não encontrado.");
            }
        }
    }
    
    public void executaComando(String comando) {
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                statement.executeUpdate(comando);
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            } 
            
        }catch (SQLException e) {
                System.err.format("SQLException: %s", e);
        }
    }
    
    public boolean ehArquivoSQL(String path) {
        return path.endsWith(".sql");
    }
    
    public boolean ehArquivoCSV(String path) {
        return path.endsWith(".csv");
    }
    
    public List<String> executaQuery(String query) {
        List<String> lista = new ArrayList<>();
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                lista.add(rsmd.getColumnName(1) + " " + rsmd.getColumnName(2));
                while (rs.next()) {
                    lista.add(rs.getLong("ID_PESSOA") + " " + rs.getString("NM_PESSOA"));
                }
                rs.close();
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            } 
            
        }catch (SQLException e) {
                System.err.format("SQLException: %s", e);
        }
        
        return lista;
    }
    
    public void importarDeArquivoCSV(String path) {
        if(ehArquivoCSV(path)) {
            MeuReaderUtils reader = new MeuReaderUtils();
            List<String> list = reader.readFile(path);
            
            for(int i = 0; i < list.size(); i++) {
                String[] lista = list.get(i).split(";");
                inserirEmTabela(Long.parseLong(lista[0]), lista[1]);
            }
            
        }
    }
    
    private void inserirEmTabela(Long id, String nome) {
        final String INSERT = "INSERT INTO PESSOA("
                    + "ID_PESSOA, NM_PESSOA ) "
                    + "VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA), ?)";
        
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
                    preparedStatement.setLong(1, id);
                    preparedStatement.setString(2, nome);
                    preparedStatement.executeUpdate();
        } catch (final SQLException e) {
                e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        MeuSQLUtils utils = new MeuSQLUtils();
        //utils.executaComandosDeArquivo("C:\\Users\\diuly.barreto\\Documents\\crescer-2016-1\\src\\modulo-08-java\\aula3\\comando.sql");
//        List<String> lista = new ArrayList();
//        lista = utils.executaQuery("select * from Pessoa");
//        for(int i = 0 ; i < lista.size(); i++) {
//            System.out.println(lista.get(i));
//        }
        utils.importarDeArquivoCSV("C:\\Users\\diuly.barreto\\Documents\\crescer-2016-1\\src\\modulo-08-java\\aula3\\arquivo.csv");
    }

    
}
