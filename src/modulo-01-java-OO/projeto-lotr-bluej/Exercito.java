import java.util.*;

public class Exercito {
    
    private HashMap<String, Elfo> exercitoElfos = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoAgrupado = new HashMap<>();
    
    public void alistarElfo(Elfo elfo) {
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
            exercitoElfos.put(elfo.getNome(), elfo);
    }
    
    public Elfo buscarNome(String chave) {
        if (exercitoElfos.containsKey(chave))
            return exercitoElfos.get(chave);
            
        return null;
    }
    
    public HashMap<String, Elfo> getAlistados() {
        return exercitoElfos;
    }
    
    public void agruparPorStatus() {
        ArrayList vivo = new ArrayList();
        ArrayList morto = new ArrayList();
        
        for(Elfo elfo : exercitoElfos.values()){
            //exercitoAgrupado.get(elfo.getStatus()).add(elfo);
            
            if(elfo.getStatus() == Status.VIVO)
                vivo.add(elfo);
            else
                morto.add(elfo);
             
            exercitoAgrupado.put(Status.VIVO, vivo);
            exercitoAgrupado.put(Status.MORTO, morto);
        }
        
    }
    
    public HashMap<Status, ArrayList<Elfo>> getExercitoAgrupado(){
        return exercitoAgrupado;
    }
}

