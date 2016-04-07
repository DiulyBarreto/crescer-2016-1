

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest{
    @Test
    public void criarData(){
        DataTerceiraEra data = new DataTerceiraEra(7,4, 2016);
        
        // testa o dia
        int esperado = 7;
        assertEquals(esperado, data.getDia());
        
        // testa o mes
        esperado = 4;
        assertEquals(esperado, data.getMes());
        
        // testa o ano
        esperado = 2016;
        assertEquals(esperado, data.getAno());
    }
    
    @Test
    public void testarSeOAnoEhBissexto(){
        // bissexto
        DataTerceiraEra data = new DataTerceiraEra(7,4, 2016);
        boolean esperado = true;
        boolean obtido = data.ehBissexto();
        assertEquals(esperado, obtido);
        
        DataTerceiraEra data1 = new DataTerceiraEra(7,4, 3024);
        assertEquals(esperado, data1.ehBissexto());
     
    }
    
    @Test
    public void testarSeOAnoNAOEhBissexto(){
        // não bissexto
        DataTerceiraEra data = new DataTerceiraEra(7,4, 1995);
        boolean esperado = false;
        boolean obtido = data.ehBissexto();
        assertEquals(esperado, obtido);
        
        DataTerceiraEra outraData = new DataTerceiraEra(2, 5, 2013);
        obtido = outraData.ehBissexto();
        assertEquals(esperado, obtido);
        
    }
}