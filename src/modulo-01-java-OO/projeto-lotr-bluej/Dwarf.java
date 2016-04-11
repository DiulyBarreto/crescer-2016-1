public class Dwarf extends PersonagemTerraMedia{
    
    private DataTerceiraEra dataNascimento = new DataTerceiraEra(1, 1, 1);
    
    public Dwarf(String nome){
        super(nome);
        vida = 110;
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
    
    public int getVida(){
        return vida;
    }
    
    public Status getStatus(){
        return status;
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
    
    public void tentarSorte(){
        if(getNumeroSorte() == -3333.0){
            for(int i = 0; i < inventario.getLista().size(); i++){
                inventario.getLista().get(i).aumentarQuantidadeItens(1000);
            }
        }
    }
}