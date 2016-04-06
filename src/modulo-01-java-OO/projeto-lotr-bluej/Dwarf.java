public class Dwarf{
    private int vida = 110;
    private String nome;
    
    public Dwarf(String nome){
        //vida = 110;
        this.nome = nome;
    } 
    
    public void perdeVida(){
        vida -= 10;
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
}