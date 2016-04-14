public abstract class PersonagemTerraMedia {
    
    protected int vida;
    protected Status status = Status.VIVO;
    protected String nome;
    protected int experiencia;
    protected Inventario inventario = new Inventario();
    
    public PersonagemTerraMedia(String nome) {
        this.nome = nome;
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
    
    public int getVida(){
        return vida;
    }
    
    public Status getStatus(){
        return status;
    }
    
    public abstract void tentarSorte();
}
