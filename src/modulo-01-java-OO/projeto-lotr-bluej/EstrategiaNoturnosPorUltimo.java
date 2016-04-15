import java.util.*;

public class EstrategiaNoturnosPorUltimo implements EstrategiasDeCombate {
    ArrayList<Elfo> ordemUltimoAtaque = new ArrayList<>();
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemUltimoAtaque;
    }

    public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves) {
        ArrayList<Elfo> ultimos = new ArrayList<>();
       
        for(int i = 0; i < pelotao.size(); i++){
            if(pelotao.get(i).getStatus().equals(Status.VIVO)){
                if(pelotao.get(i) instanceof ElfoVerde){
                    for(int j = 0; j < dwarves.size(); j++){
                        pelotao.get(i).atirarFlechaDwarf(dwarves.get(j));
                    }
                    ordemUltimoAtaque.add(pelotao.get(i));
                }else
                ultimos.add(pelotao.get(i));
            }
        }
        
        for(int i = 0; i < ultimos.size(); i++){
            for(int j = 0; j < dwarves.size(); j++){
                ultimos.get(i).atirarFlechaDwarf(dwarves.get(j));
            }
        }
        
        ordemUltimoAtaque.addAll(ultimos);
    }
}
