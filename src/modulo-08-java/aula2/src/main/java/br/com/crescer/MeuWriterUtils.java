/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diuly
 */
public class MeuWriterUtils {
    
    public void writeFile(String path, List<String> content) {
        if(path.endsWith(".txt")) {
            try {
                Writer writer = new FileWriter(path);
                BufferedWriter bufferReader = new BufferedWriter(writer);
                
                for(String text : content) {
                    bufferReader.write(text);
                    bufferReader.newLine();
                    bufferReader.flush();
                }
                
            } catch (IOException e) {
                System.out.println("Arquivo não encontrado.");
            }
        } else {
            System.out.println("O arquivo solicitado é incompatível.");
        }
    }
    
    public static void main(String[] args) {
        MeuWriterUtils writer = new MeuWriterUtils();
        List<String> lista = new ArrayList<>();
        lista.add("Diuly");
        lista.add("Barreto");
        writer.writeFile("teste.txt", lista);
    }
}
