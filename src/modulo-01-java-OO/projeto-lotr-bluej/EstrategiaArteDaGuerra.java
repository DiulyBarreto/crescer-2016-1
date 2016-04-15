import java.util.*;

public class EstrategiaArteDaGuerra implements EstrategiasDeCombate {
    
    ArrayList<Elfo> ordemUltimoAtaque = new ArrayList<>();
    
    // recebe o exercito, e os dwarves a serem combatidos
    public void atacar(ArrayList<Elfo> exercito, ArrayList<Dwarf> dwarves) {
        int totalElfosNoturnosQuePodemAtacar = (int)(exercito.size() * dwarves.size() * 0.3);
        
        for(int i = 0; i < exercito.size(); i++) {
            for(int j = 0; j < dwarves.size(); j++) {
                
                if(exercito.get(i).getStatus().equals(Status.VIVO)) {
                    if(exercito.get(i) instanceof ElfoNoturno && totalElfosNoturnosQuePodemAtacar > 0) {
                        exercito.get(i).atirarFlechaDwarf(dwarves.get(j));
                        totalElfosNoturnosQuePodemAtacar--;
                        ordemUltimoAtaque.add(exercito.get(i));
                        
                    }else if(!(exercito.get(i) instanceof ElfoNoturno)) {
                        exercito.get(i).atirarFlechaDwarf(dwarves.get(j));
                        ordemUltimoAtaque.add(exercito.get(i));
                    }
                }
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemUltimoAtaque() {
        return ordemUltimoAtaque;
    }
}
   
    
