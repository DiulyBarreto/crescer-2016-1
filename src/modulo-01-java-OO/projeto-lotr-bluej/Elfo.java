public class Elfo extends PersonagemTerraMedia {
    
    protected int flechas;
    protected static int contadorElfos = 0;
    
    public Elfo(String nome) {
        super(nome);
        flechas = 42;
        vida = 100;
        contadorElfos++;
    }
    
    public Elfo(String nome, int flechas){
        this(nome);
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
    
    public int getFlechas(){
        return flechas;
    }
    
    public String toString(){
        return nome+" possui "+flechas+" flechas e "+experiencia+" niveis de experiência.";
    }
}