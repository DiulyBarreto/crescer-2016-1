

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
    
    @Test
    public void dwarfNasceVivo(){
        Dwarf dwarf = new Dwarf("Balin");
        assertEquals(Status.VIVO, dwarf.getStatus());
    }
    
    @Test
    public void dwarfMorreSemVidaNegativa(){
        // Arrange
        Dwarf dwarf = new Dwarf("sem nome");
        int esperado = 0;
        
        // Act
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        dwarf.perdeVida();
        
        // Assert
        assertEquals(esperado, dwarf.getVida());
        
    }
    
    @Test
    public void adicionarItemAoInventarioDwarf(){
        
        //Arrange
        Dwarf dwarf = new Dwarf("sem nome");
        Item espada = new Item(1, "espada afiada");
        boolean esperado = true;
        
        //Act
        dwarf.adicionarItem(espada);
        
        //Assert
        boolean obtido = dwarf.getInventario().getLista().contains(espada);
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void removerItemDoInventarioDwarf(){
        //Arrange
        Dwarf dwarf = new Dwarf("sem nome");
        Item espada = new Item(1, "espada afiada");
        dwarf.adicionarItem(espada);
        boolean esperado = false;
        
        //Act
        dwarf.perderItem(espada);
        
        //Assert
        boolean obtido = dwarf.getInventario().getLista().contains(espada);
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void criarDwarfComDataNascimento(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(5, 4, 3024);
        
        Dwarf dwarf = new Dwarf("nome legal", dataNascimento);
        
        assertEquals(dataNascimento, dwarf.getDataNascimento());
    }
}