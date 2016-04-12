import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
    @Test
    public void ganharDobroDeExperienciaComparadoAoElfoNormal(){
        ElfoVerde elfoVerde = new ElfoVerde("Elfo Verde");
        int esperado = 2;
        
        elfoVerde.atirarFlecha();
        
        assertEquals(esperado, elfoVerde.getExperiencia());
    }
    
    @Test
    public void adicionarItem(){
         ElfoVerde elfoVerde = new ElfoVerde("Elfo Verde");
         Item item = new Item(1, "Espada de aço valiriano");
         elfoVerde.adicionarItem(item);
         
         assertEquals(item, elfoVerde.getInventario().getLista().get(0));
    }
    
    @Test
    public void atirarFlechaDwarf(){
         ElfoVerde elfoVerde = new ElfoVerde("Elfo Verde");
         IrishDwarf dwarf = new IrishDwarf("Dwarf");
         elfoVerde.atirarFlechaDwarf(dwarf);
         
         assertEquals(2, elfoVerde.getExperiencia());
    }
}
