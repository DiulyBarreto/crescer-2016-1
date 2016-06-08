package br.com.crescer;

import java.util.Scanner;

/**
 *
 * @author Diuly
 */
public class MeuStringUtil {
    
    public boolean isEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }
    
    public int contaVogais(String s) {
        int cont = 0;
        
        if(!isEmpty(s)) {
            String vogais = "aeiou";
            s = s.toLowerCase();
            
            for (int i = 0; i < s.length(); i++) 
                if(vogais.indexOf(s.charAt(i)) >= 0)
                    cont++;
        }
        
        return cont;
    }
    
    public String invertString(String s) {
        String invertida = "";
        
        if(!isEmpty(s)) {
            for (int i = s.length() - 1 ; i >= 0; i--)
                invertida += s.charAt(i);
        }
        
        return invertida;
    }
    
    public boolean identificaPalindromo(String s) {
        return s.toUpperCase().equals(invertString(s.toUpperCase()));
    }
    
    public static void main(String[] args) {
        MeuStringUtil util = new MeuStringUtil();
        Scanner teclado = new Scanner(System.in);
        
        try {
            System.out.println("Recursos disponíveis: ");
            System.out.println("Método que verifica se string é vazia.\nInforme uma string:  ");
            System.out.println("Resultado: " + util.isEmpty(teclado.nextLine()));
            
            System.out.println("Método que conta as vogais de uma string.\nInforme uma string: ");
            System.out.println("Resultado: " + util.contaVogais(teclado.nextLine()));
            
            System.out.println("Método que inverte uma string.\nInforme uma string: ");
            System.out.println("Resultado: " + util.invertString(teclado.nextLine()));
            
            System.out.println("Método que verifica se uma string é palindromo.\nInforme uma string: ");
            System.out.println("Resultado: " + util.identificaPalindromo(teclado.nextLine()));
        } catch (Exception e) {
            System.out.println("ERRO");
        } finally {
            teclado.close();
        }
        
    }
}
