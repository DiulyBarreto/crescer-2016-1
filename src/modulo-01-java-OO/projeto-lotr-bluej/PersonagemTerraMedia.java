public class PersonagemTerraMedia {
    
    protected int vida;
    protected Status status = Status.VIVO;
    protected String nome;
    protected int experiencia;
    protected Inventario inventario = new Inventario();
    
    public PersonagemTerraMedia(String nome) {
        this.nome = nome;
    }
    
    public PersonagemTerraMedia(String nome, int experiencia, int vida) {
        this(nome);
        this.experiencia = experiencia;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getExperiencia() {
        return experiencia;
    }
    
    public void adicionarItem(Item item) {
        inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        inventario.removerItem(item);
    }
    
    public Inventario getInventario() {
        return inventario;
    }
    
}
