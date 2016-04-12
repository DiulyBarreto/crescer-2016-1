import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
    @Test
    public void ganharDobroDeExperienciaComparadoAoElfoNormal(){
        ElfoVerde elfoVerde = new ElfoVerde("Elfo Verde");
        Dwarf d = new Dwarf("Dwarf");
        int esperado = 4;
        
        elfoVerde.atirarFlechaDwarf(d);
        elfoVerde.atirarFlechaDwarf(d);
        
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
    public void adicionarItensComDescricaoDiferenteDaPermitida(){
        ElfoVerde elfoVerde = new ElfoVerde("Elfo Verde");
        Item item = new Item(1, "Espada de aço velho");
        int tamanhoEsperado = 0;
        
        elfoVerde.adicionarItem(item);
         
        assertEquals(tamanhoEsperado, elfoVerde.getInventario().getLista().size()); 
    }
    
    @Test
    public void adicionarItemComDescricaoVazia(){
        ElfoVerde elfoVerde = new ElfoVerde("Elfo Verde");
        Item item = new Item(1, "");
        elfoVerde.adicionarItem(item);
        int tamanhoEsperado = 0;
         
        assertEquals(tamanhoEsperado, elfoVerde.getInventario().getLista().size());
    }
    
    @Test
    public void adicionarItemComDescricaoNula(){
        ElfoVerde elfoVerde = new ElfoVerde("Elfo Verde");
        Item item = new Item(1, null);
        elfoVerde.adicionarItem(item);
        int tamanhoEsperado = 0;
         
        assertEquals(tamanhoEsperado, elfoVerde.getInventario().getLista().size());
    }
    
    @Test
    public void adicionarItemComDescricaoIgnorandoLetrasMaiusculas(){
        ElfoVerde elfoVerde = new ElfoVerde("Elfo Verde");
        Item item = new Item(1, "Espada De Aço Valiriano");
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
