public class Dwarf{
    private int vida = 110;
    private String nome;
    private Status status = Status.VIVO;
    private Inventario inventario = new Inventario();
    
    public Dwarf(String nome){
        this.nome = nome;
    } 
    
    public void perdeVida(){
        if(vida >= 10)
            vida -= 10;
        
        if(vida == 0)
            status = Status.MORTO;
    }
    
    public void setNome(String novoNome){
        this.nome = novoNome;
    }
    
    public String getNome(){
           return nome;
    }
    
    public int getVida(){
        return vida;
    }
    
    public Status getStatus(){
        return status;
    }
    
    public void adicionarItem(Item item){
        inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item){
        inventario.removerItem(item);
    }
    
    public Inventario getInventario(){
        return inventario;
    }
}