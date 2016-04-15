import java.util.*;

public interface EstrategiasDeCombate {
    
    public ArrayList<Elfo> getOrdemUltimoAtaque();

    public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves);
}
