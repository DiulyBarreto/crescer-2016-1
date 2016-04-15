import java.util.*;

public class Exercito {
    
    private HashMap<String, Elfo> exercitoElfos = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoAgrupado = new HashMap<>();
    private EstrategiasDeCombate estrategia = new EstrategiaArteDaGuerra();
    
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
    
    public void agruparPorStatus(){
        
        for(Map.Entry<String, Elfo> chaveValor : this.exercitoElfos.entrySet()) {
            Elfo elfo = chaveValor.getValue();
            ArrayList<Elfo> array = exercitoAgrupado.get(elfo.getStatus());
            
            if(array == null){
                array = new ArrayList<Elfo>(Arrays.asList(elfo));
                exercitoAgrupado.put(elfo.getStatus(), array);
            }else
                array.add(elfo); // referência
            
        }
    }
    
    public HashMap<Status, ArrayList<Elfo>> getExercitoAgrupado(){
        return exercitoAgrupado;
    }
    
    public ArrayList<Elfo> buscar(Status status){
        return exercitoAgrupado.get(status);
    }
    
    public void atacar(ArrayList<Dwarf> alvos) {
        this.estrategia.atacar(
            new ArrayList<Elfo>(exercitoElfos.values()),
            alvos
        );
    }

    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.estrategia.getOrdemDoUltimoAtaque();
    }

    public void mudarEstrategia(EstrategiasDeCombate estrategia) {
        this.estrategia = estrategia;
    }
}

