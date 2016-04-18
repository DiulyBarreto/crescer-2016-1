
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstrategiaAtaqueIntercaladoTest
{
    @Test
    public void atacarComPelotaoMeioAMeio() {
        Elfo elfo1 = new ElfoVerde("Andy");
        Elfo elfo2 = new ElfoVerde("Ave");
        Elfo elfo3 = new ElfoNoturno("Diuly");
        Elfo elfo4 = new ElfoNoturno("Adão");
        ArrayList<Elfo> pelotao = new ArrayList<>();
        pelotao.add(elfo1);
        pelotao.add(elfo2);
        pelotao.add(elfo3);
        pelotao.add(elfo4);
        Dwarf d1 = new Dwarf("D1");
        Dwarf d2 = new Dwarf("D2");
        Dwarf d3 = new Dwarf("D3");
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        dwarves.add(d1);
        dwarves.add(d2);
        dwarves.add(d3);
        
        EstrategiasDeCombate e = new EstrategiaAtaqueIntercalado();
        e.atacar(pelotao, dwarves);
        
        // certificar que todos atacaram todos os dwarves
        assertTrue(pelotao.get(0) instanceof ElfoVerde);
        assertTrue(pelotao.get(1) instanceof ElfoNoturno);
        assertTrue(pelotao.get(2) instanceof ElfoVerde);
        assertTrue(pelotao.get(3) instanceof ElfoNoturno);
        
    }
    
    @Test
    public void atacarComPelotaoNaoProporcional() {
        Elfo elfo1 = new ElfoVerde("Andy");
        Elfo elfo2 = new ElfoVerde("Ave");
        Elfo elfo3 = new ElfoVerde("Andy");
        Elfo elfo4 = new ElfoNoturno("Diuly");
        Elfo elfo5 = new ElfoNoturno("Adão");
        ArrayList<Elfo> pelotao = new ArrayList<>();
        pelotao.add(elfo1);
        pelotao.add(elfo2);
        pelotao.add(elfo3);
        pelotao.add(elfo4);
        pelotao.add(elfo5);
        Dwarf d1 = new Dwarf("D1");
        Dwarf d2 = new Dwarf("D2");
        Dwarf d3 = new Dwarf("D3");
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        dwarves.add(d1);
        dwarves.add(d2);
        dwarves.add(d3);
        
        EstrategiasDeCombate e = new EstrategiaAtaqueIntercalado();
        e.atacar(pelotao, dwarves);
        
        // certificar que todos atacaram todos os dwarves
        assertTrue(e.getOrdemDoUltimoAtaque().isEmpty());
    }
    
    @Test
    public void atacarComDoisMortosNoPelotao() {
        Elfo elfo1 = new ElfoVerde("Andy");
        Elfo elfo2 = new ElfoVerde("Ave");
        Elfo elfo3 = new ElfoNoturno("Diuly");
        Elfo elfo4 = new ElfoNoturno("Adão");
        Elfo elfo5 = criarElfoEDepoisMataLo("Pedro");
        Elfo elfo6 = criarElfoEDepoisMataLo("Lucas");
        ArrayList<Elfo> pelotao = new ArrayList<>();
        pelotao.add(elfo1);
        pelotao.add(elfo2);
        pelotao.add(elfo3);
        pelotao.add(elfo4);
        pelotao.add(elfo5);
        pelotao.add(elfo6);
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        Dwarf d1 = new Dwarf("D1");
        Dwarf d2 = new Dwarf("D2");
        Dwarf d3 = new Dwarf("D3");
        dwarves.add(d1);
        dwarves.add(d2);
        dwarves.add(d3);
        
        EstrategiasDeCombate e = new EstrategiaAtaqueIntercalado();
        e.atacar(pelotao, dwarves);
        
        assertFalse(e.getOrdemDoUltimoAtaque().contains(elfo5));
        assertFalse(e.getOrdemDoUltimoAtaque().contains(elfo6));
        
    }
    
    private Elfo criarElfoEDepoisMataLo(String nome){
        Elfo elfo = new ElfoNoturno(nome);
        for(int i = 0; i < 90; i++){
            elfo.atirarFlechaDwarf(new Dwarf("Adão"));
        }
        
        return elfo;
    }
    
    @Test
    public void ataqueIntercaladoComecandoPorElfoNoturno() {
        Elfo elfo1 = new ElfoNoturno("Diuly");
        Elfo elfo2 = new ElfoNoturno("Adão");
        Elfo elfo3 = new ElfoVerde("Andy");
        Elfo elfo4 = new ElfoVerde("Ave");
        ArrayList<Elfo> pelotao = new ArrayList<>();
        pelotao.add(elfo1);
        pelotao.add(elfo2);
        pelotao.add(elfo3);
        pelotao.add(elfo4);
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        Dwarf d1 = new Dwarf("D1");
        Dwarf d2 = new Dwarf("D2");
        Dwarf d3 = new Dwarf("D3");
        dwarves.add(d1);
        dwarves.add(d2);
        dwarves.add(d3);
        
        EstrategiasDeCombate e = new EstrategiaAtaqueIntercalado();
        e.atacar(pelotao, dwarves);
        
        assertTrue(e.getOrdemDoUltimoAtaque().get(0) instanceof ElfoNoturno);
        assertTrue(e.getOrdemDoUltimoAtaque().get(1) instanceof ElfoVerde);
        assertTrue(e.getOrdemDoUltimoAtaque().get(2) instanceof ElfoNoturno);
        assertTrue(e.getOrdemDoUltimoAtaque().get(3) instanceof ElfoVerde);
    }
    
    @Test
    public void ataqueIntercaladoComecandoPorElfoVerde() {
        Elfo elfo1 = new ElfoVerde("Andy");
        Elfo elfo2 = new ElfoVerde("Ave");
        Elfo elfo3 = new ElfoNoturno("Diuly");
        Elfo elfo4 = new ElfoNoturno("Adão");
        ArrayList<Elfo> pelotao = new ArrayList<>();
        pelotao.add(elfo1);
        pelotao.add(elfo2);
        pelotao.add(elfo3);
        pelotao.add(elfo4);
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        Dwarf d1 = new Dwarf("D1");
        Dwarf d2 = new Dwarf("D2");
        Dwarf d3 = new Dwarf("D3");
        dwarves.add(d1);
        dwarves.add(d2);
        dwarves.add(d3);
        
        EstrategiasDeCombate e = new EstrategiaAtaqueIntercalado();
        e.atacar(pelotao, dwarves);
        
        assertTrue(e.getOrdemDoUltimoAtaque().get(0) instanceof ElfoVerde);
        assertTrue(e.getOrdemDoUltimoAtaque().get(1) instanceof ElfoNoturno);
        assertTrue(e.getOrdemDoUltimoAtaque().get(2) instanceof ElfoVerde);
        assertTrue(e.getOrdemDoUltimoAtaque().get(3) instanceof ElfoNoturno);
    }
}
