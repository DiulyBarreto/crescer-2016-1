import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void criarIrishDwarfComSorte(){
        DataTerceiraEra nasc = new DataTerceiraEra(7, 7, 2000);
        IrishDwarf dwarf = new IrishDwarf("IrishDwarfLouco", nasc);
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        Item escudo = new Item(3, "escudo");
        Item espada = new Item(5, "espada");
        dwarf.getInventario().adicionarItem(escudo);
        dwarf.getInventario().adicionarItem(espada);
        
        dwarf.tentarSorte();
        
        assertEquals(6003, dwarf.getInventario().getLista().get(0).getQuantidade());
        assertEquals(15005, dwarf.getInventario().getLista().get(1).getQuantidade());
    }
}
