/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author diuly.barreto
 */
public class Chat {
    public static BufferedReader getReader(String fila) throws FileNotFoundException, IOException{
       File file = new File(fila);
       file.createNewFile();
       
       return new BufferedReader(new FileReader(file));
    }
    
    public static BufferedWriter getWriter(String fila) throws IOException{
       
       return new BufferedWriter(new FileWriter(fila,true));
    }
    
    public static void main(String[] args) {
        System.out.println("Informe seu nickname: ");
        Scanner scanner = new Scanner(System.in);
        String nick = scanner.nextLine();
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader bufferReader = null;
                
                try {
                    bufferReader = Chat.getReader("//10.0.100.102/cwitmp/carloshenrique/crescer.txt");
                    while(true) {
                        String readLine = bufferReader.readLine();
                        if(!new MeuStringUtil().isEmpty(readLine)) {
                            System.out.println(readLine);
                        }
                        Thread.sleep(1000l);
                    }
                } catch (Exception e) {
                    //...
                } finally {
                    try {
                        if (bufferReader != null) {
                            bufferReader.close();
                        }
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            
        }).start();
        
        while (true) {
            System.out.println("Informe um valor: ");
            String nextLine = scanner.nextLine();
            if(":q!".equals(nextLine)) {
                break;
            }
            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = getWriter("//10.0.100.102/cwitmp/carloshenrique/crescer.txt");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date data = new Date();
                String cont = dateFormat.format(data) + "\n" + nick + " says: " + nextLine;
                bufferedWriter.write(cont);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (Exception e) {
                // ...
            } finally {
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (Exception e) {
                    
                }
            }
        }
        System.exit(0);
    } 
}
