/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diuly.barreto
 */
public class TestPessoa {
    public static void main(String[] args) {
        ConnectionPessoa connection = new ConnectionPessoa();
        List<Pessoa> lista = connection.findNames("João");
        
        for(Pessoa p : lista) {
            System.out.println(p.getNome());
        }
    }
}
