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
    
    
    // o tipo de retorno do método estava errado, o método deveria retornar int e estava tentando retornar ArrayList
    //a variável limite não havia sido declarada.
    public int obterMaiorMultiploDeTresAte(int numero) {
        int maiorMult = 0;
        
        for (int i = 1; i <= numero; i++) {
            if (i % 3 == 0) 
                maiorMult = i;
        }

        return maiorMult;
    }
     
    // variável limite não declarada
    // break no if antes de atribuir o multiplo ao ArrayList
    public ArrayList<Integer> obterMultiplosDeTresAte(int numero) {
        ArrayList<Integer> multiplos = new ArrayList<>(Arrays.asList(0));

        for (int i = 1; i <= numero; i++) {
            if (i % 3 == 0) 
                multiplos.add(i);
        }

        return multiplos;
    }
}