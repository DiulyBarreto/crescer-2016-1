import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;


public class InventarioTest
{
    @Test
    public void adicionarItemNoArrayList(){
        
        //Arrange
        Inventario inventario = new Inventario();
        Item flecha = new Item(2, "Flecha para matar todo mundo.");
        boolean esperado = true;
        
        //Act
        inventario.adicionarItem(flecha);
        
        //Assert
        boolean obtido = inventario.getLista().contains(flecha);
        assertEquals(esperado, obtido);
   }
   
   @Test
   public void removerItemDoArrayist(){
       
       // Arrange
       Inventario inventario = new Inventario();
       Item flecha = new Item(2, "Flecha para matar todo mundo.");
       inventario.adicionarItem(flecha);
       boolean esperado = false;
       
       //Act
       inventario.removerItem(flecha);
       
       //Assert
       boolean obtido = inventario.getLista().contains(flecha);
       assertEquals(esperado, obtido);
   }
   
   @Test
   public void getDescricoesCom4Itens(){
       
       Item escudo = new Item(1, "Escudo");
       Item espada = new Item(1, "Espada");
       Item faca = new Item(1, "Faca");
       Item colher = new Item(1, "Colher");
       Inventario i = new Inventario();
       i.adicionarItem(escudo);
       i.adicionarItem(espada);
       i.adicionarItem(faca);
       i.adicionarItem(colher);
       String esperado = "Escudo, Espada, Faca, Colher";
       
       assertEquals(esperado, i.getDescricoesItens());
   }
   
   @Test
   public void itemComMaiorQuantidadeTem100Unidades(){
       Item escudo = new Item(12, "escudo");
       Item espada = new Item(0, "espada");
       Item roupa = new Item(100, "roupa");
       Item sapato = new Item(76, "sapato");
       Inventario inventario = new Inventario();
       inventario.adicionarItem(escudo);
       inventario.adicionarItem(espada);
       inventario.adicionarItem(roupa);
       inventario.adicionarItem(sapato);
       Item esperado = roupa;
       
       Item obtido = inventario.getItemComMaiorQuantidade();
       
       assertEquals(esperado, obtido);
   }
   
   @Test
   public void ordenarItensInventario(){
       Item escudo = new Item(12, "escudo");
       Item espada = new Item(0, "espada");
       Item roupa = new Item(100, "roupa");
       Item sapato = new Item(76, "sapato");
       Inventario inventario = new Inventario();
       inventario.adicionarItem(roupa);
       inventario.adicionarItem(sapato);
       inventario.adicionarItem(espada);
       inventario.adicionarItem(escudo);
       
       inventario.ordenarItens();
       
       // verificar se a quantidade de itens da posição i é igual ao int informado no objeto Item específico
       assertEquals(0, inventario.getLista().get(0).getQuantidade());
       assertEquals(12, inventario.getLista().get(1).getQuantidade());
       assertEquals(76, inventario.getLista().get(2).getQuantidade());
       assertEquals(100, inventario.getLista().get(3).getQuantidade());
   }
}
