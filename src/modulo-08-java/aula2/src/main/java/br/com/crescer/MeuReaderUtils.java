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

/**
 *
 * @author Diuly
 */
public class MeuReaderUtils {

    public void readFile(String path) {
        if (path.endsWith(".txt")) {
            try {
                Reader reader = new FileReader(path);
                BufferedReader bufferReader = new BufferedReader(reader);
                String line;
                do {
                    line = bufferReader.readLine();
                    if (!new MeuStringUtil().isEmpty(line)) {
                        System.out.println(line);
                    }
                } while (line != null);

            } catch (IOException e) {
                System.out.println("Arquivo não encontrado.");
            }
        } else {
            System.out.println("O arquivo solicitado é incompatível!");
        }
    }
    
    public static void main(String[] args) {
        MeuReaderUtils reader = new MeuReaderUtils();
        reader.readFile("teste.txt");
    }
}
