import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
    @Test
    public void compararUmItemComOutro(){
        Item item1 = new Item(1, "Escudo");
        Item item2 = new Item(1, "Escudo");
        
        assertEquals(item1, item2);
    }
    
    @Test
    public void itemDiferenteDeOutroItem(){
        Item item1 = new Item(1, "Escudo");
        Item item2 = new Item(3, "Escudo");
        
        assertTrue(!item1.equals(item2));
    }
}
