/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diuly
 */
public class MeuStringUtilTest {
    
    public MeuStringUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class MeuStringUtil.
     */
    @org.junit.Test
    public void testIsEmptyComStringVazia() {
        String s = "";
        
        MeuStringUtil teste = new MeuStringUtil();
       
        assertTrue(teste.isEmpty(s));
    }
    
    @org.junit.Test
    public void testIsEmptyComStringNula() {
        String s = null;
        
        MeuStringUtil teste = new MeuStringUtil();
       
        assertTrue(teste.isEmpty(s));
    }
    
    @org.junit.Test
    public void testIsEmptyComStringComEspacos() {
        String s = "                ";
        
        MeuStringUtil teste = new MeuStringUtil();
       
        assertTrue(teste.isEmpty(s));
    }
    
    @org.junit.Test
    public void testIsEmptyComStringComTexto() {
        String s = "Teste";
        
        MeuStringUtil teste = new MeuStringUtil();
       
        assertFalse(teste.isEmpty(s));
    }
    
    @org.junit.Test
    public void testContaVogaisComUmaVogal() {
        String s = "abcd";
        
        MeuStringUtil teste = new MeuStringUtil();
        
        assertEquals(1, teste.contaVogais(s));
    }
    
    @org.junit.Test
    public void testContaVogaisComNenhumaVogal() {
        String s = "bcdfghj";
        
        MeuStringUtil teste = new MeuStringUtil();
        
        assertEquals(0, teste.contaVogais(s));
    }
    
    @org.junit.Test
    public void testContaVogaisComTodasVogais() {
        String s = "aeiou";
        
        MeuStringUtil teste = new MeuStringUtil();
        
        assertEquals(5, teste.contaVogais(s));
    }
    
    @org.junit.Test
    public void testContaVogaisntercalandoVogaisEConsoantes() {
        String s = "ABIFEHUSA";
        
        MeuStringUtil teste = new MeuStringUtil();
        
        assertEquals(5, teste.contaVogais(s));
    }
    
    @org.junit.Test
    public void testInvertStringComPalavraSOLIDA() {
        String s = "SOLIDA";
        
        MeuStringUtil teste = new MeuStringUtil();
        
        assertEquals("ADILOS", teste.invertString(s));
    }
    
    @org.junit.Test
    public void testInvertStringComPalavraDuvida() {
        String s = "Duvida";
        
        MeuStringUtil teste = new MeuStringUtil();
        
        assertEquals("adivuD", teste.invertString(s));
    }
    
    @org.junit.Test
    public void testInvertStringComPalavraVazia() {
        String s = "";
        
        MeuStringUtil teste = new MeuStringUtil();
        
        assertEquals("", teste.invertString(s));
    }
}
