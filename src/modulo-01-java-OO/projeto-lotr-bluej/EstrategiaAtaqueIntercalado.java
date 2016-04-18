import java.util.*;

public class EstrategiaAtaqueIntercalado implements EstrategiasDeCombate {
    
    ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemDoUltimoAtaque;
    }
    
    public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves) {
        if(ehMeioAMeio(pelotao)) {
            ordenarPelotao(pelotao);
            
            for(int i = 0; i < pelotao.size(); i++) {
                if(pelotao.get(i).getStatus().equals(Status.VIVO)) {
                    for(int j = 0; j < dwarves.size(); j++) {
                        pelotao.get(i).atirarFlechaDwarf(dwarves.get(j));
                    }
                    ordemDoUltimoAtaque.add(pelotao.get(i));
                }
            }
        }
            
    }
        
    private void ordenarPelotao(ArrayList<Elfo> pelotao) {
        for(int i = 0; i < pelotao.size() - 1; i++) {
            if(pelotao.get(i).getStatus().equals(Status.VIVO)) {
                if(pelotao.get(i).getClass().equals(pelotao.get(i + 1).getClass())) {
                    for(int j = i+1; j < pelotao.size(); j++) {
                        if(!(pelotao.get(i).getClass().equals(pelotao.get(j).getClass()))) {
                            Elfo aux = pelotao.get(i + 1);
                            pelotao.set(i + 1, pelotao.get(j));
                            pelotao.set(j, aux);
                        }
                        
                    }
                }
            }
            
        }
    }
    
    private boolean ehMeioAMeio(ArrayList<Elfo> pelotao) {
        int contElfosVerdes = 0;
        int contElfosNoturnos = 0;
        
        for(int i = 0; i < pelotao.size(); i++) {
            if(pelotao.get(i).getStatus().equals(Status.VIVO)) {
                if(pelotao.get(i) instanceof ElfoVerde)
                    contElfosVerdes++;
                else
                    contElfosNoturnos++;
            }
        }
        
        return contElfosVerdes == contElfosNoturnos;
    }
}
