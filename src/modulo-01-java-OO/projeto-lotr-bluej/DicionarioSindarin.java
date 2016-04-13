import java.util.*;

public class DicionarioSindarin {
    
    public static void main(String[] args) {
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
