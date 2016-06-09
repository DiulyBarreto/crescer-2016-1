/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author diuly.barreto
 */
public class ConnectionPessoaTest {
    
    public ConnectionPessoaTest() {
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
     * Test of insert method, of class ConnectionPessoa.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Pessoa pessoa = null;
        ConnectionPessoa instance = new ConnectionPessoa();
        instance.insert(pessoa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ConnectionPessoa.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Pessoa pessoa = null;
        ConnectionPessoa instance = new ConnectionPessoa();
        instance.update(pessoa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ConnectionPessoa.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Pessoa pessoa = null;
        ConnectionPessoa instance = new ConnectionPessoa();
        instance.delete(pessoa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listAll method, of class ConnectionPessoa.
     */
    @Test
    public void testListAll() {
        System.out.println("listAll");
        ConnectionPessoa instance = new ConnectionPessoa();
        List<Pessoa> expResult = null;
        List<Pessoa> result = instance.listAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findNames method, of class ConnectionPessoa.
     */
    @Test
    public void testFindNames() {
        System.out.println("findNames");
        String nome = "";
        ConnectionPessoa instance = new ConnectionPessoa();
        List<Pessoa> expResult = null;
        List<Pessoa> result = instance.findNames(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
