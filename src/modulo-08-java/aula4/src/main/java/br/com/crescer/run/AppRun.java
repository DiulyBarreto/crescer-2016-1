/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.run;

import br.com.crescer.aula4.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author diuly.barreto
 */
public class AppRun {

    static final EntityManagerFactory emf  = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em  = emf.createEntityManager();
    
    public static void main(String[] args) {
//        System.out.println(em.isOpen());
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNomePessoa("Diuly");
//        em.getTransaction().begin();
//        em.persist(pessoa);
//        em.getTransaction().commit();

          Query query = em.createQuery("SELECT p FROM Pessoa p");
          List<Pessoa> pessoas = query.getResultList(); // faz o select no banco
          for(Pessoa p : pessoas) {
              System.out.println(p.getNomePessoa());
          }
          
    }
}
