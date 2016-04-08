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
}
