import java.util.*;

public interface EstrategiasDeCombate {
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque();

    public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves);
}
