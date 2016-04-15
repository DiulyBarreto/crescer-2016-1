import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaArteDaGuerraTest
{
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

