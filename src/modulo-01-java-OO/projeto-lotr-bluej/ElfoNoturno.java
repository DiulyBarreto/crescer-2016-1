public class ElfoNoturno extends Elfo {
    
    private double vida = 100.0;
    
    public ElfoNoturno(String nome){
        super(nome);
    }
    
    public ElfoNoturno(String nome, int flechas){
        super(nome, flechas);
    }
    
    // 7.1
    public void atirarFlechaDwarf(Dwarf d){
        super.atirarFlechaDwarf(d);
        experiencia += 2;
        perderCincoPorCentoVida();
    }
    
    /* 7.2
    Elfos noturnos não podem morrer atualmente pq depois de determinada quantidade de flechadas os 5% a serem descontados da vida serão insignificantes, fazendo
    com que o valor nunca chegue a exatamente 0. */
    
    public void perderCincoPorCentoVida(){
        this.vida -= this.vida * 0.05;
        
        //7.3 (Agora elfos noturnos morrem.)
        if(this.vida < 1)
            status = Status.MORTO;
    }
    
    public double getVidaElfoNoturno(){
        return this.vida;
    }
    
}
