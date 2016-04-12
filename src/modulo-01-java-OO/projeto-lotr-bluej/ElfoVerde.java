public class ElfoVerde extends Elfo {
    
    public ElfoVerde(String nome){
        super(nome);
    }
    
    public ElfoVerde(String nome, int flechas){
        super(nome, flechas);
    }
    
    public void atirarFlechaDwarf(Dwarf d) {
        super.atirarFlechaDwarf(d);
        experiencia++;
    }
    
    public void adicionarItem(Item item) {
        
        if(item.getDescricao() != null && (item.getDescricao().equalsIgnoreCase("Espada de aço valiriano") || item.getDescricao().equalsIgnoreCase("Arco e Flecha de Vidro")))
            inventario.adicionarItem(item);
    }
}