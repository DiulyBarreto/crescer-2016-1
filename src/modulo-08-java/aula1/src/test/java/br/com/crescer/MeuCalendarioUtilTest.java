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
public class MeuCalendarioUtilTest {
    
    public MeuCalendarioUtilTest() {
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
     * Test of diaDaSemana method, of class MeuCalendarioUtil.
     */
    @Test
    public void testDiaDaSemana30_04_1996() {
        String data = "30/04/1996";
        
        MeuCalendarioUtil teste = new MeuCalendarioUtil();
        
        assertEquals("Terça-feira", teste.diaDaSemana(data));
    }
    
    @Test
    public void testDiaDaSemana08_06_2016() {
        String data = "08/06/2016";
        
        MeuCalendarioUtil teste = new MeuCalendarioUtil();
        
        assertEquals("Quarta-feira", teste.diaDaSemana(data));
    }
    
    @Test
    public void testDiaDaSemanaComDataNula() {
        String data = null;
        
        MeuCalendarioUtil teste = new MeuCalendarioUtil();
        
        assertNull(teste.diaDaSemana(data));
    }
    
    @Test
    public void testDiaDaSemanaComDataInvalida() {
        String data = "30.04.1996";
        
        MeuCalendarioUtil teste = new MeuCalendarioUtil();
        
        assertNull(teste.diaDaSemana(data));
    }
    
}
