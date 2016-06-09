/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Diuly
 */
public class MeuFileUtils {
    
    public void create(String nome) {
        try {
            File file = new File(nome);
            file.getParentFile().mkdirs();
            file.createNewFile();
            
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
    
    public void delete(String nome) {
        File file = new File(nome);
        if(file.isDirectory())
            System.out.println("Arquivo inválido");
        else
            file.delete();
    }
    
    public static void main(String[] args) {
        MeuFileUtils file = new MeuFileUtils();
        file.create("aula3\\aula.txt");
        file.delete("aula3\\aula.txt");
    }
    
}
