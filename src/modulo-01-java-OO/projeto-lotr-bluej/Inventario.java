import java.util.ArrayList;

public class Inventario{
    
    private ArrayList<Item> lista = new ArrayList<>();
    
    public void adicionarItem(Item item){
        lista.add(item);
    }
    
    public void removerItem(Item item){
        lista.remove(item);
    }
    
    public ArrayList getLista(){
        return this.lista;
    }
}