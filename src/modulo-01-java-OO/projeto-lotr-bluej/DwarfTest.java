

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest{
    @Test
    public void criarDwarfNome(){
        Dwarf d1 = new Dwarf("Diuly");
        String esperado = "Diuly";
        String obtido = d1.getNome();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void criarDwarfCom110Vidas(){
        Dwarf d1 = new Dwarf("Diuly");
        int esperado = 110;
        int obtido = d1.getVida();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void testarPerdeVida(){
        Dwarf d1 = new Dwarf("Diuly");
        d1.perdeVida();
        int esperado = 100;
        int obtido = d1.getVida();
        assertEquals(esperado, obtido);
    }
    
    
}