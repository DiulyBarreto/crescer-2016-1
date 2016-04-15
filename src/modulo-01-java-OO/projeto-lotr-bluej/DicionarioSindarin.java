import java.util.*;

public class DicionarioSindarin {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao tradutor Sindarin! Escolha um idioma: ");
        System.out.println("[P]ortuguês [I]nglês");
        String idioma = scanner.nextLine();
        TradutorSindarin tradutor = criarTradutor(idioma);
        System.out.println("Naur significa "+ tradutor.traduzir("naur"));
    }
    
    public static TradutorSindarin criarTradutor(String idioma){
        TradutorSindarin tradutor = null;
        switch(idioma.toLowerCase()) {
            case "i":
                tradutor = new SindarinParaIngles();
                break;
            default:
                tradutor = new SindarinParaPortugues();
                break;
        }
        
        return tradutor;
        // rodarExemploHashMap();
    }
        
    private static void rodarExemplosHashMap() {
        HashMap<String, String> dicionarioSindarin = new HashMap<>();
        dicionarioSindarin.put("terra", "amar");
        dicionarioSindarin.put("fogo", "naur");
        dicionarioSindarin.put("vento", "gwaew");
        dicionarioSindarin.put("água", "nen");
        dicionarioSindarin.put("coração", "gûr");
        
        String terraEmSindarin = dicionarioSindarin.get("terra");
        // sobrepor o valor de uma determinada chave
        dicionarioSindarin.put("água", "nîn");
        // remover chave - valor
        dicionarioSindarin.remove("água");
        // Está vazio?
        boolean estaVazio = dicionarioSindarin.isEmpty();
        //Tamanho
        int tamanhoDePares = dicionarioSindarin.size();
        
        // contém chave?
        boolean contemAgua = dicionarioSindarin.containsKey("água");
        // contém valor?
        boolean contemNaur = dicionarioSindarin.containsValue("naur");
        
        for (String chave : dicionarioSindarin.keySet()) {
             System.out.println(chave);
         }
        
        int qtdNaur = 0;
        for(String valor : dicionarioSindarin.values()) {
            if(valor.equals("naur")){
                qtdNaur++;
            }
        }
        System.out.println("Quantos tem naur: "+qtdNaur);
        
           
        for (Map.Entry<String, String> chaveValor : dicionarioSindarin.entrySet()) {
            if(chaveValor.getValue().equals("naur")){
                qtdNaur++;
                System.out.println("A chave " + chaveValor.getKey() + " significa naur");
            }
        }
        System.out.println("Quantos tem naur: " + qtdNaur);
      
        dicionarioSindarin.put("FB", "facobook");
        dicionarioSindarin.put("EA", "badoo");
      
        for (Map.Entry<String, String> chaveValor : dicionarioSindarin.entrySet()) {
            System.out.println ("K: "+ chaveValor.getKey() + " - V: " + chaveValor.getValue());
        }
    }
    
}
