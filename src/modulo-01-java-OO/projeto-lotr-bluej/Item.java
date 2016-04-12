public class Item{
    private int quantidade;
    private String descricao;
    
    public Item(int quantidade, String descricao){
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public void aumentarQuantidadeItens(int quantidade){
        this.quantidade += quantidade;
    }
    
    public boolean equals(Object obj){
        Item outro = (Item)obj;
        
        return outro != null && this.quantidade == outro.getQuantidade() && this.descricao.equals(outro.getDescricao()) ;
    }
}