public class Dwarf{
    private int vida = 110;
    private String nome;
    private Status status = Status.VIVO;
    private Inventario inventario = new Inventario();
    private DataTerceiraEra dataNascimento = new DataTerceiraEra(1, 1, 1);
    
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
        else if(!dataNascimento.ehBissexto() && (nome == "Seixas" || nome == "Meireles"))
            numSorte = (numSorte * 33) % 100;
            
        return numSorte;
    }
}