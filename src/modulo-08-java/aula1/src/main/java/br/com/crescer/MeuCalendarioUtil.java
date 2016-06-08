/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Diuly
 */
public class MeuCalendarioUtil {
    
    public String diaDaSemana(String data) {
        String dia = null;

        if (data != null && !data.isEmpty()) {
            try {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date date = formato.parse(data);
                dia = new SimpleDateFormat("EEEE").format(date);
            } catch (ParseException e) {
                System.out.println("ERRO: ");
                e.printStackTrace();
            }
        }

        return dia;
    }
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        MeuCalendarioUtil calendario = new MeuCalendarioUtil();
        try {
            System.out.println("Recursos disponíveis: ");
            System.out.println("Método que informa o dia da semana de uma determinada data.\nInforme a data: ");
            System.out.println("Resultado: " + calendario.diaDaSemana(teclado.nextLine()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            teclado.close();
        }
        
        
    }
    
}
