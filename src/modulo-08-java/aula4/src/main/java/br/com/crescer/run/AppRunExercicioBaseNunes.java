/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.run;

import br.com.crescer.aula4.mapeamentoBaseNunes.Cidade;
import br.com.crescer.aula4.mapeamentoBaseNunes.Cliente;
import static br.com.crescer.run.AppRunExercicio.GET_TRANSACTION;
import static br.com.crescer.run.AppRunExercicio.em;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Diuly
 */
public class AppRunExercicioBaseNunes {
    static final EntityManagerFactory emf  = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em  = emf.createEntityManager();
    static final EntityTransaction GET_TRANSACTION = em.getTransaction();
    
    public static void main(String[] args) {
        GET_TRANSACTION.begin();
        
        Cidade cidade = new Cidade();
        cidade.setNomeCidade("Butia");
        cidade.setUf("RS");
        em.persist(cidade);
        
        Cliente cliente = new Cliente();
        cliente.setNomeCliente("Diuly");
        cliente.setRazaoSocial("Diuly CIA LITDA");
        cliente.setCidade(cidade);
        cliente.setEndereco("Rua 15 de novembro");
        cliente.setBairro("Vila Nova");
        cliente.setCep(96750000l);
        cliente.setSituacao('P');
        em.persist(cliente);
        
        GET_TRANSACTION.commit();
        em.close();
        emf.close();
    }
}
