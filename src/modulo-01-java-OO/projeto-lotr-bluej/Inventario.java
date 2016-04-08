import java.util.ArrayList;

public class Inventario{
    
    private ArrayList<Item> lista = new ArrayList<>();
    
    public void adicionarItem(Item item){
        lista.add(item);
    }
    
    public void removerItem(Item item){
        lista.remove(item);
    }
    
    public ArrayList<Item> getLista(){
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
    
    public Item getItemComMaiorQuantidade(){
        Item maior = lista.get(0);
        
        for(int i = 1; i < lista.size(); i++){
            if(lista.get(i).getQuantidade() > maior.getQuantidade())
                maior = lista.get(i);
        }
        
        return maior;
    }
    
   
}