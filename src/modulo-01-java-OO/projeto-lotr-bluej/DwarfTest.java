

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
        
        //Act
        dwarf.perderItem(espada);
        
        //Assert
        boolean obtido = dwarf.getInventario().getLista().contains(espada);
        assertFalse(obtido);
    }
    
    @Test
    public void criarDwarfComDataNascimento(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(5, 4, 3024);
        
        Dwarf dwarf = new Dwarf("nome legal", dataNascimento);
        
        assertEquals(dataNascimento, dwarf.getDataNascimento());
    }
    
    @Test
    public void criarDwarfComDataNascimentoPadrao(){
        int diaEsperado = 1;
        int mesEsperado = 1;
        int anoEsperado = 1;
        
        Dwarf dwarf = new Dwarf("nome legal");
        
        assertEquals(diaEsperado, dwarf.getDataNascimento().getDia());
        assertEquals(mesEsperado, dwarf.getDataNascimento().getMes());
        assertEquals(anoEsperado, dwarf.getDataNascimento().getAno());
    }
    
    @Test
    public void retornarNumeroDaSorteAnoBissexto(){
        DataTerceiraEra data = new DataTerceiraEra(7, 8, 2016);
        Dwarf dwarf = new Dwarf("nome legal", data);
        dwarf.perdeVida();
        dwarf.perdeVida();
        int esperado = -3333;
        
        int obtido = (int)dwarf.getNumeroSorte();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void retornarNumeroDaSorteAnoNAOBissexto(){
        Dwarf dwarf = new Dwarf("Meireles");
        int esperado = 33;
        
        int obtido = (int)dwarf.getNumeroSorte();
        
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void receberFlechaDwarfComSorte(){
        DataTerceiraEra data = new DataTerceiraEra(7, 8, 2016);
        Dwarf dwarf = new Dwarf("nome legal", data);
        Elfo elfo = new Elfo("sem nome");
        dwarf.perdeVida();
        dwarf.perdeVida();
        int vidaEsperada = 90;
        int experienciaEsperada = 2;
        
        elfo.atirarFlechaDwarf(dwarf);
        
        assertEquals(vidaEsperada, dwarf.getVida());
        assertEquals(experienciaEsperada, dwarf.getExperiencia());
    }
    
    @Test
    public void receberFlechaDwarfSEMSorte(){
         Dwarf dwarf = new Dwarf("nao é Meireles");
         Elfo elfo = new Elfo("sem nome");
         int vidaEsperada = 100;
         int experienciaEsperada = 0;
         
         
         elfo.atirarFlechaDwarf(dwarf);
         
         assertEquals(vidaEsperada, dwarf.getVida());
         assertEquals(experienciaEsperada, dwarf.getExperiencia());
    }
    
    @Test
    public void dwarfLeprechaunComSorteAumenta1000Itens(){
        DataTerceiraEra nasc = new DataTerceiraEra(1, 1, 2016);
        Dwarf dwarf = new Dwarf("nome", nasc);
        for(int i = 0; i < 3; i++){
           dwarf.perdeVida();
        }
        Item espada = new Item(2, "espada");
        dwarf.adicionarItem(espada);
        int esperado = 1002;
        
        dwarf.tentarSorte();
        
         int obtido = dwarf.getInventario().getLista().get(0).getQuantidade();
        assertEquals(esperado, obtido);
    }
}