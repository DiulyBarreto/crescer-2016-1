public class Elfo extends Inventario{
    private String nome;
    private int experiencia, flechas;
    
    public Elfo(String nome) {
        this.nome = nome;
        flechas = 42;
    }
    
    public Elfo(String nome, int flechas){
        this.nome = nome;
        this.flechas = flechas;
    }
    
    public void atirarFlecha() {
        experiencia++;
        flechas--;
    }
    
    public void atirarFlechaDwarf(Dwarf d){
        atirarFlecha();
        d.receberFlecha();
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public int getFlechas(){
        return flechas;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String toString(){
        return nome+" possui "+flechas+" flechas e "+experiencia+" niveis de experiência.";
    }
}