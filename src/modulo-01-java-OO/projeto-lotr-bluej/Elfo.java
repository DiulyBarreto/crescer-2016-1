public class Elfo {
    private String nome;
    private int experiencia, flechas = 42;
    
    public Elfo(String nome) {
        this.nome = nome;
    }
    
    public void atirarFlecha() {
        experiencia++;
        flechas--;
    }
    
    public void atirarFlechaDwarf(Dwarf d){
        atirarFlecha();
        d.perdeVida();
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