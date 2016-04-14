import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ExercitoTest {
    @Test
    public void alistarUmElfoVerde(){
        ElfoVerde elfo = new ElfoVerde("Diuly");
        Exercito exercito = new Exercito();
        exercito.alistarElfo(elfo);
        
        assertEquals(1, exercito.getAlistados().size());
    }
    
    @Test
    public void alistarUmElfoNoturnoEUmElfoVerde(){
        ElfoNoturno elfo1 = new ElfoNoturno("Diuly");
        ElfoVerde elfo2 = new ElfoVerde("Gui");
        Exercito exercito = new Exercito();
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        
        assertEquals(2, exercito.getAlistados().size());
    }
    
    @Test
    public void alistarDoisElfosNormaisUmElfoVerdeEUmElfoNoturno(){
        ElfoVerde elfo1 = new ElfoVerde("Gui");
        Elfo elfo2 = new Elfo("Diuly");
        Elfo elfo3 = new Elfo("Edy");
        ElfoNoturno elfo4 = new ElfoNoturno("Andy");
        Exercito exercito = new Exercito();
        
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.alistarElfo(elfo4);
        
        assertEquals(2, exercito.getAlistados().size());
    }
    
    @Test
    public void encontrarUmElfoVerdePeloNome(){
        ElfoVerde elfo1 = new ElfoVerde("Gui");
        Exercito exercito = new Exercito();
        exercito.alistarElfo(elfo1);
        
        assertEquals(elfo1, exercito.buscarNome("Gui"));
    }
    
    @Test
    public void naoEncontrarUmElfoNoturnoPeloNome(){
        ElfoNoturno elfo1 = new ElfoNoturno("Diuly");
        Exercito exercito = new Exercito();
        exercito.alistarElfo(elfo1);
        
        assertNull(exercito.buscarNome("Diuly Any"));
    }
    
    @Test
    public void encontrarUmElfoNoturnoPeloNome(){
        ElfoNoturno elfo1 = new ElfoNoturno("Diuly");
        Exercito exercito = new Exercito();
        exercito.alistarElfo(elfo1);
        
        assertEquals(elfo1, exercito.buscarNome("Diuly"));
    }
    
    @Test
    public void agruparElfosVivosEMortos(){
        Elfo elfoMorto1 = criarElfoEDepoisMataLo("Renan");
        Elfo elfoMorto2 = criarElfoEDepoisMataLo("Pedro");
        ElfoNoturno elfo1 = new ElfoNoturno("Diuly");
        ElfoVerde elfo2 = new ElfoVerde("Gui");
        Exercito exercito = new Exercito();
        exercito.alistarElfo(elfoMorto1);
        exercito.alistarElfo(elfoMorto2);
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        
        exercito.agruparPorStatus();
        
        assertTrue(exercito.getExercitoAgrupado().get(Status.VIVO).contains(elfo1));
        assertTrue(exercito.getExercitoAgrupado().get(Status.VIVO).contains(elfo2));
        assertTrue(exercito.getExercitoAgrupado().get(Status.MORTO).contains(elfoMorto1));
    }
    
    
    private Elfo criarElfoEDepoisMataLo(String nome){
        Elfo elfo = new ElfoNoturno(nome);
        
        for(int i = 0; i < 90; i++){
            elfo.atirarFlechaDwarf(new Dwarf("Balin"));
        }
        
        return elfo;
    }
}
