public class Dwarf{
    private int vida = 110;
    private String nome;
    private Status status = Status.VIVO;
    private Inventario inventario = new Inventario();
    private DataTerceiraEra dataNascimento = new DataTerceiraEra(1, 1, 1);
    private int experiencia = 0;
    
    public Dwarf(String nome){
        this.nome = nome;
    } 
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this(nome);
        this.dataNascimento = dataNascimento;
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
    
    public DataTerceiraEra getDataNascimento(){
        return dataNascimento;
    }
    
    public double getNumeroSorte(){
        double numSorte = 101;
        if(dataNascimento.ehBissexto() && vida >= 80 && vida <= 90)
            numSorte = numSorte * -33;
        else if(!dataNascimento.ehBissexto() && this.nome != null && (this.nome.equals("Seixas") || this.nome.equals("Meireles")))
            numSorte = (numSorte * 33) % 100;
            
        return numSorte;
    }
    
    public void receberFlecha(){
        double numeroSorte = getNumeroSorte();
        
        if(numeroSorte < 0)
           experiencia += 2;
        else if(numeroSorte > 100)
           perdeVida();
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public void tentarSorte(){
        if(getNumeroSorte() == -3333.0){
            for(int i = 0; i < inventario.getLista().size(); i++){
                inventario.getLista().get(i).aumentarQuantidadeItens(1000);
            }
        }
    }
}