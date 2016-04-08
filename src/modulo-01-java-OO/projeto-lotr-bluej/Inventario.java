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
    
    public String getDescricoesItens(){
        String descricoes = "";
        
        for(int i = 0; i < lista.size(); i++){
            
            if(i == lista.size() - 1)
                descricoes += lista.get(i).getDescricao();
            else
                descricoes += lista.get(i).getDescricao()+", ";
        }
            
        return descricoes;
    }
}