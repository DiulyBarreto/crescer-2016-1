import java.util.*;

public class HobbitContador{
    
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares){
        
       ArrayList<Integer> produtos = new ArrayList<>();
       ArrayList<Integer> mmc = new ArrayList<>();
       int somaDiferenca = 0;
       
       for(int i = 0; i < arrayDePares.size(); i++){
           int prod = 1;
           int menorMult = 1;
          
           for(int j = 0; j < arrayDePares.get(i).size(); j++){
               prod *= arrayDePares.get(i).get(j);
               menorMult *= arrayDePares.get(i).get(j);
           }
           
           // fórmula de mmc: a x b / mdc(a, b)
           menorMult = menorMult/mdc(arrayDePares.get(i).get(0), arrayDePares.get(i).get(1)); 
           produtos.add(prod);
           mmc.add(menorMult);
           somaDiferenca += produtos.get(i) - mmc.get(i);
       }
       
       return somaDiferenca;
    }
    
    // Algoritmo de Euclides
    private int mdc(int a, int b) {
        
        if(a == 0 || b == 0)
            return 0;
            
        while (b != 0){
            if(a > b)
                a = a - b;
            else
                b = b - a;
        }
        
        return a;
    }
     
}