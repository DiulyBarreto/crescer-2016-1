import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HobbitContadorTest
{
   @Test
    public void calcularDiferencaEntreProdutosEMenorMultiploComum(){
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(15, 18)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(4, 5)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(12, 60)));

        HobbitContador contador = new HobbitContador();
        int diferenca = contador.calcularDiferenca(arrayDePares);
        int esperado = 840;
        
        assertEquals(esperado, diferenca);
    }
  
   @Test
   public void maiorMultiploDe3Ate56(){
       HobbitContador bolsomito = new HobbitContador();
       
       int maiorMulti = bolsomito.obterMaiorMultiploDeTresAte(56);
       
       assertEquals(54, maiorMulti);
   }
   
   @Test
   public void maiorMultiploDe3Ate0(){
       HobbitContador bolsomito = new HobbitContador();
       
       int maiorMulti = bolsomito.obterMaiorMultiploDeTresAte(0);
       
       assertEquals(0, maiorMulti);
   }
   
   @Test
   public void obterListaDeMultiplosDe3Ate10(){
        HobbitContador bolsomito = new HobbitContador();
       
        ArrayList<Integer> multiplos = bolsomito.obterMultiplosDeTresAte(10);
        
        assertEquals(0, multiplos.get(0).intValue());
        assertEquals(3, multiplos.get(1).intValue());
        assertEquals(6, multiplos.get(2).intValue());
        assertEquals(9, multiplos.get(3).intValue());
   }
   
   @Test
   public void obterListaDeMultiplosDe3Ate0(){
       HobbitContador bolsomito = new HobbitContador();
       
       ArrayList<Integer> multiplos = bolsomito.obterMultiplosDeTresAte(0);
        
       assertEquals(0, multiplos.get(0).intValue());
   }
}
