
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstrategiaNoturnosPorUltimoTest {
    @Test
    public void ordenarArrayCom3ElfosNoturnosPorUltimo(){
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
         EstrategiasDeCombate e = new EstrategiaNoturnosPorUltimo();
         ArrayList<Elfo> exercito = new ArrayList<>();
         exercito.add(elfo3); // posição 2 depois do ataque
         exercito.add(elfo4); // posição 3 depois do ataque
         exercito.add(elfo5); // posição 4 depois do ataque
         exercito.add(elfo1); // posição 0 depois do ataque
         exercito.add(elfo2); // posição 1 depois do ataque
         
         e.atacar(exercito, dwarves);
         
         assertEquals(elfo1, e.getOrdemDoUltimoAtaque().get(0));
         assertEquals(elfo2, e.getOrdemDoUltimoAtaque().get(1));
         assertEquals(elfo3, e.getOrdemDoUltimoAtaque().get(2));
         assertEquals(elfo4, e.getOrdemDoUltimoAtaque().get(3));
         assertEquals(elfo5, e.getOrdemDoUltimoAtaque().get(4));
    }
    
    @Test
    public void ordenarArrayCom2ElfosNoturnosMortos(){
         Dwarf d1 = new Dwarf("D1");
         Dwarf d2 = new Dwarf("D2");
         Dwarf d3 = new Dwarf("D3");
         ArrayList<Dwarf> dwarves = new ArrayList<>();
         dwarves.add(d1);
         dwarves.add(d2);
         dwarves.add(d3);
         Elfo elfo1 = new ElfoVerde("Andy");
         Elfo elfo2 = new ElfoVerde("Ave");
         Elfo elfo3 = criarElfoEDepoisMataLo("Diuly");
         Elfo elfo4 = criarElfoEDepoisMataLo("Adão");
         
         EstrategiasDeCombate e = new EstrategiaNoturnosPorUltimo();
         ArrayList<Elfo> exercito = new ArrayList<>();
         exercito.add(elfo3); 
         exercito.add(elfo2); // posição 0 depois do ataque
         exercito.add(elfo4); 
         exercito.add(elfo1); // posição 1 depois do ataque
         
         e.atacar(exercito, dwarves);
         
         assertEquals(elfo2, e.getOrdemDoUltimoAtaque().get(0));
         assertEquals(elfo1, e.getOrdemDoUltimoAtaque().get(1));
         assertFalse(e.getOrdemDoUltimoAtaque().contains(elfo3));
         assertFalse(e.getOrdemDoUltimoAtaque().contains(elfo4));
    }
    
    private Elfo criarElfoEDepoisMataLo(String nome){
        Elfo elfo = new ElfoNoturno(nome);
        for(int i = 0; i < 90; i++){
            elfo.atirarFlechaDwarf(new Dwarf("Adão"));
        }
        
        return elfo;
    }
}
