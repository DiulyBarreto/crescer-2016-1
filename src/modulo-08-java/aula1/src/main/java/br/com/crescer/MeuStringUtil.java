package br.com.crescer;

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
}
