import java.util.*;

public class EstrategiaArteDaGuerra implements EstrategiasDeCombate {
    
    ArrayList<Elfo> ordemUltimoAtaque = new ArrayList<>();
    
    // recebe o exercito, e os dwarves a serem combatidos
    public void atacar(ArrayList<Elfo> exercito, ArrayList<Dwarf> dwarves) {
        int totalElfosNoturnosQuePodemAtacar = (int)(exercito.size() * dwarves.size() * 0.3);
        
        for(int i = 0; i < exercito.size(); i++) {
            if(exercito.get(i).getStatus().equals(Status.VIVO)) {
                for(int j = 0; j < dwarves.size(); j++) {
                    boolean ehNoturno = exercito.get(i) instanceof ElfoNoturno;
                    
                    if(ehNoturno && totalElfosNoturnosQuePodemAtacar > 0) {
                        totalElfosNoturnosQuePodemAtacar--;
                    }else if(ehNoturno) {
                        continue;
                    }
                    
                    exercito.get(i).atirarFlechaDwarf(dwarves.get(j));
                    ordemUltimoAtaque.add(exercito.get(i));
                }
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemUltimoAtaque;
    }
}
   
    
