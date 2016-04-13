import java.util.*;

public class Exercito {
    
    private HashMap<String, Elfo> exercitoElfos = new HashMap<>();
    
    public void alistarElfo(Elfo elfo) {
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
            exercitoElfos.put(elfo.getNome(), elfo);
    }
    
    public Elfo buscarNome(String chave) {
        if (exercitoElfos.containsKey(chave))
            return exercitoElfos.get(chave);
            
        return null;
    }
    
    public HashMap<String, Elfo> getAlistados(){
        return exercitoElfos;
    }
}

