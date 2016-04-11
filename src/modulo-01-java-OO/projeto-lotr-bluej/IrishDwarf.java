public class IrishDwarf extends Dwarf {
    
    public IrishDwarf(String nome) {
        super(nome);
    } 
    
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento){
        super(nome, dataNascimento);
    }
    
    public void tentarSorte(){
        if(getNumeroSorte() == -3333.0){
            for(int i = 0; i < inventario.getLista().size(); i++){
                
                int qtdItens = inventario.getLista().get(i).getQuantidade(), somaValores = 0;
                
                // trocar para fórmula PA
                // 
                while(qtdItens > 0){
                    somaValores += qtdItens;
                    qtdItens -= 1;
                }
                    
                inventario.getLista().get(i).aumentarQuantidadeItens(somaValores * 1000);
            }
        }
    }
}