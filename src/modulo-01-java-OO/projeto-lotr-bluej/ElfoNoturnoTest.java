import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest {
    
    @Test
    public void atirarFlechaGanhar9DeExperiencia(){
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo Noturno");
        Dwarf dwarf= new Dwarf("Dwarf");
        
        elfoNoturno.atirarFlechaDwarf(dwarf);
        elfoNoturno.atirarFlechaDwarf(dwarf);
        elfoNoturno.atirarFlechaDwarf(dwarf);
        
        assertEquals(9, elfoNoturno.getExperiencia());
    }
    
    @Test
    public void perderCincoPorCentoDeVida(){
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo Noturno");
        Dwarf dwarf= new Dwarf("Dwarf");
        double esperado = 95.0;
        
        elfoNoturno.atirarFlechaDwarf(dwarf);
        
        assertEquals(esperado, elfoNoturno.getVidaElfoNoturno(), 0.001);
    }
    
    @Test
    public void perderVidaTresVezes(){
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo Noturno");
        Dwarf dwarf= new Dwarf("Dwarf");
        double esperado = 95.0;
        
        for(int i = 0; i < 3; i++)
            elfoNoturno.atirarFlechaDwarf(dwarf);
            
        assertEquals(85.7375, elfoNoturno.getVidaElfoNoturno(), 0.001);
    }
    
    @Test
    public void perderVida10vezes(){
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo Noturno");
        Dwarf dwarf= new Dwarf("Dwarf");
        double esperado = 95.0;
        
        for(int i = 0; i < 10; i++)
            elfoNoturno.atirarFlechaDwarf(dwarf);
            
        assertEquals(59.8736939, elfoNoturno.getVidaElfoNoturno(), 0.001);
    }
    
    @Test
    public void matarElfo(){
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfo Noturno");
        Dwarf dwarf= new Dwarf("Dwarf");
        int cont = 0;
        
        for(int i = 0; i < 90; i++){
            elfoNoturno.atirarFlechaDwarf(dwarf);
        }
        
        assertEquals(Status.MORTO, elfoNoturno.getStatus());
    }
    
    
    
    
}
