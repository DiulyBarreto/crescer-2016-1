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
    
    public static void main(String[] args) {
        MeuSQLUtils utils = new MeuSQLUtils();
        utils.executaComandosDeArquivo("C:\\Users\\diuly.barreto\\Documents\\crescer-2016-1\\src\\modulo-08-java\\aula3\\comando.sql");
//        List<String> lista = new ArrayList();
//        lista = utils.executaQuery("select * from Pessoa");
//        for(int i = 0 ; i < lista.size(); i++) {
//            System.out.println(lista.get(i));
//        }
    }
}
