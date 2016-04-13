import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest{
    @Test
    public void criarElfoComNome(){
        Elfo e1 = new Elfo("Legolas");
        String esperado = "Legolas";
        String obtido = e1.getNome();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void testaExperienciaElfo(){
        Elfo e1 = new Elfo("Legolas");
        int obtido = e1.getExperiencia();
        assertEquals(0, obtido);
    }
    
    @Test
    public void testaQuantidadeFlechasElfo(){
        Elfo e1 = new Elfo("Legolas");
        int esperado = 42;
        int obtido = e1.getFlechas();
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void testarMetodoAtirarFlecha(){
        Elfo e1 = new Elfo("Legolas");
        e1.atirarFlecha();
        
        // testa experiencia
        assertEquals(1, e1.getExperiencia());
        
        // testa flechas
        assertEquals(41, e1.getFlechas());
    }
    
    @Test
    public void testarMetodoAtirarFlechaDwarf(){
        Dwarf d1 = new Dwarf("Diuly");
        Elfo e1 = new Elfo("Legolas");
        e1.atirarFlechaDwarf(d1);
        
        // Comparando experiencia Elfo
        int esperado = 1;
        assertEquals(esperado, e1.getExperiencia());
        
        // Comparando Flechas Elfo
        esperado = 41;
        assertEquals(esperado, e1.getFlechas());
        
        // Comparando Método Perde Vida Dwarf
        esperado = 100;
        assertEquals(esperado, d1.getVida());
    }
    
    @Test
    public void testarMetodoToString(){
         Elfo e1 = new Elfo("Legolas");
         // aumenta o nivel de esperiencia e diminui as flechas;
         e1.atirarFlecha();
         String esperado = "Legolas possui 41 flechas e 1 niveis de experiência.";
         String obtido = e1.toString();
         assertEquals(esperado, obtido);
    }
    
    @Test
    public void testarConstrutorComFlechas(){
        Elfo e1 = new Elfo("Legolas", 102);
        int esperado = 102;
        
        //Compração flechas
        assertEquals(esperado, e1.getFlechas());
        
        // Compração nome
        assertEquals("Legolas", e1.getNome());
    }
    
    @Test
    public void elfoComInventario(){
        Elfo elfo = new Elfo("nomeElfo");
        Item escudo = new Item(1, "escudo");
        
        elfo.adicionarItem(escudo);
        
        assertEquals(escudo, elfo.getInventario().getLista().get(0));
    }
    
    @Test
    public void contarMais3Elfos(){
        int totalElfos = Elfo.getContadorElfos();
        
        Elfo e1 = new Elfo("E1");
        Elfo e2 = new Elfo("E2");
        Elfo e3 = new Elfo("E3");
        
        totalElfos = Elfo.getContadorElfos() - totalElfos;
        
        assertEquals(3, totalElfos);
    }
    
    @Test
    public void contar5Elfos() {
        
        int totalElfos = Elfo.getContadorElfos();
        
        Elfo e1 = new Elfo("E1");
        Elfo e2 = new Elfo("E2");
        Elfo e3 = new Elfo("E3");
        Elfo e4 = new Elfo("E4");
        Elfo e5 = new Elfo("E5");
        
        totalElfos = Elfo.getContadorElfos() - totalElfos;
        
        assertEquals(5, totalElfos);
    }
    
}