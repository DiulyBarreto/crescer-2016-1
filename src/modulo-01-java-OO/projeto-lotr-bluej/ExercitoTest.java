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
    public void agrupar2MortosE3Vivos(){
        Elfo elfoMorto1 = criarElfoEDepoisMataLo("Diuly");
        Elfo elfoMorto2 = criarElfoEDepoisMataLo("Gui");
        Elfo elfo1 = new ElfoVerde("Andy");
        Elfo elfo2 = new ElfoVerde("Ave");
        Elfo elfo3 = new ElfoVerde("Anders");
        Exercito exercito = new Exercito();
        exercito.alistarElfo(elfoMorto1);
        exercito.alistarElfo(elfoMorto2);
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        
        exercito.agruparPorStatus();
        
        assertEquals(3, exercito.getExercitoAgrupado().get(Status.VIVO).size());
        assertEquals(2, exercito.getExercitoAgrupado().get(Status.MORTO).size());
    }
    
    
    private Elfo criarElfoEDepoisMataLo(String nome){
        Elfo elfo = new ElfoNoturno(nome);
        for(int i = 0; i < 90; i++){
            elfo.atirarFlechaDwarf(new Dwarf("Adão"));
        }
        
        return elfo;
    }
    
    @Test
    public void buscarElfosPeloStatusVIVO(){
        Elfo elfoMorto1 = criarElfoEDepoisMataLo("Diuly");
        Elfo elfoMorto2 = criarElfoEDepoisMataLo("Gui");
        Elfo elfo1 = new ElfoVerde("Andy");
        Elfo elfo2 = new ElfoVerde("Ave");
        Elfo elfo3 = new ElfoVerde("Anders");
        Exercito exercito = new Exercito();
        exercito.alistarElfo(elfoMorto1);
        exercito.alistarElfo(elfoMorto2);
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.agruparPorStatus();
        
        ArrayList<Elfo> elfos = exercito.buscar(Status.VIVO);
        
        assertTrue(elfos.contains(elfo1));
        assertTrue(elfos.contains(elfo2));
        assertTrue(elfos.contains(elfo3));
    }
    
    @Test
    public void buscarElfosPeloStatusMORTO(){
        Elfo elfoMorto1 = criarElfoEDepoisMataLo("Diuly");
        Elfo elfoMorto2 = criarElfoEDepoisMataLo("Gui");
        Elfo elfo1 = new ElfoVerde("Andy");
        Elfo elfo2 = new ElfoVerde("Ave");
        Elfo elfo3 = new ElfoVerde("Anders");
        Exercito exercito = new Exercito();
        exercito.alistarElfo(elfoMorto1);
        exercito.alistarElfo(elfoMorto2);
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.agruparPorStatus();
        
        ArrayList<Elfo> elfos = exercito.buscar(Status.MORTO);
        
        assertTrue(elfos.contains(elfoMorto1));
        assertTrue(elfos.contains(elfoMorto2));
    }
    
    @Test
    public void buscarElfosPeloStatusMORTOENaoEncontrar(){
        Elfo elfo1 = new ElfoVerde("Andy");
        Elfo elfo2 = new ElfoVerde("Ave");
        Elfo elfo3 = new ElfoVerde("Anders");
        Exercito exercito = new Exercito();
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.agruparPorStatus();
        
        ArrayList<Elfo> elfos = exercito.buscar(Status.MORTO);
        
        assertNull(elfos);
    }
    
    @Test
    public void atacar3DwarvesCom2ElfosVerdesE3ElfosNoturnos(){
        Dwarf d1 = new Dwarf("D1");
        Dwarf d2 = new Dwarf("D2");
        Dwarf d3 = new Dwarf("D3");
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        dwarves.add(d1);
        dwarves.add(d2);
        dwarves.add(d3);
        Elfo elfo1 = new ElfoVerde("Andy");
        Elfo elfo2 = new ElfoVerde("Ave");
        ElfoNoturno elfo3 = new ElfoNoturno("Diuly");
        ElfoNoturno elfo4 = new ElfoNoturno("Adão");
        ElfoNoturno elfo5 = new ElfoNoturno("João");
        Exercito exercito = new Exercito();
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.alistarElfo(elfo4);
        exercito.alistarElfo(elfo5);
        
        exercito.atacar(dwarves);
        int qtdDeAtaquesEsperado = 10; // 15 - 5 (os elfos noturnos só podem fazer 4 ataques, restando 5 ataques que não poderão ser realizados)
        assertEquals(qtdDeAtaquesEsperado, exercito.getOrdemDoUltimoAtaque().size());
    }
    
    @Test
    public void atacar3DwarvesComExercitoNulo(){
        Dwarf d1 = new Dwarf("D1");
        Dwarf d2 = new Dwarf("D2");
        Dwarf d3 = new Dwarf("D3");
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        dwarves.add(d1);
        dwarves.add(d2);
        dwarves.add(d3);
        
        Exercito exercito = new Exercito();
        exercito.atacar(dwarves);
        
        int qtdDeAtaquesEsperado = 0;
        assertEquals(qtdDeAtaquesEsperado, exercito.getOrdemDoUltimoAtaque().size());
    }
    
    @Test
    public void exercitoCom3DwarvesVerdesE3DwarvesNoturnosAtacaNenhumDwarf(){
        
        Elfo elfo1 = new ElfoVerde("Andy");
        Elfo elfo2 = new ElfoVerde("Ave");
        Elfo elfo3 = new ElfoVerde("Anders");
        Elfo elfo4 = new ElfoNoturno("Diuly");
        Elfo elfo5 = new ElfoNoturno("Adão");
        Elfo elfo6 = new ElfoNoturno("João");
        Exercito exercito = new Exercito();
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.alistarElfo(elfo4);
        exercito.alistarElfo(elfo5);
        exercito.alistarElfo(elfo6);
        
        exercito.atacar(new ArrayList<Dwarf>());
        
        int qtdDeAtaquesEsperado = 0;
        assertEquals(qtdDeAtaquesEsperado, exercito.getOrdemDoUltimoAtaque().size());
    }
    
}
