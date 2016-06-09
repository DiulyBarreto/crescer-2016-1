/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        } catch (NullPointerException e) {
            System.out.println("Erro");
        }
    }
    
    public void delete(String nome) {
        File file = new File(nome);
        if(file.isDirectory())
            System.out.println("Arquivo inválido");
        else
            file.delete();
    }
    
    public void getPath(String nome) {
        File file = new File(nome);
        String[] lista = null;
        
        if(file.isDirectory())
            lista = file.list();
        else {
            lista = new String[1];
            lista[0] = file.getAbsolutePath();
        }
        
        for (String cont : lista) {
            System.out.println(cont);
        }
    }
    
    public void moveFile(String nome, String novoNome) {
        File file = new File(nome);
        File dest = new File(novoNome);
        if(file.isDirectory()) {
            System.out.println("Arquivo inválido");
        } else {
            try {
                // TODO - ver maneira de mover, sem precisar passar o caminho completo.
                // http://stackoverflow.com/questions/1000183/reliable-file-renameto-alternative-on-windows
                Files.move(file.toPath(), dest.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            
            } catch (IOException e) {
                System.out.println("Erro ao acessar arquivo");
            }
            
        }
    }
    
    public static void main(String[] args) {
        String op = null;
        MeuFileUtils utils = new MeuFileUtils();
        do {
            System.out.println("C:\\Users\\Name>");
            Scanner scanner = new Scanner(System.in);
            op = scanner.nextLine();
            String nome = scanner.nextLine();
            
            if (op.equalsIgnoreCase("mk")) 
                utils.create(nome);
            else if (op.equalsIgnoreCase("rm")) 
                utils.delete(nome);
            else if (op.equalsIgnoreCase("ls")) 
                utils.getPath(nome);
            else if (op.equalsIgnoreCase("mv")) {
                String novoNome = scanner.nextLine();
                utils.moveFile(nome, novoNome);
            }
        } while (!op.equalsIgnoreCase("tchau"));
    }
    
}
