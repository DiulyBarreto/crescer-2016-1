/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.run;

import br.com.crescer.aula4.exercicio.Amigo;
import br.com.crescer.aula4.exercicio.Publicacao;
import br.com.crescer.aula4.exercicio.Usuario;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Diuly
 */
public class AppRunExercicio {
    static final EntityManagerFactory emf  = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em  = emf.createEntityManager();
    static final EntityTransaction GET_TRANSACTION = em.getTransaction();
    
    public static void main(String[] args) {
        GET_TRANSACTION.begin();
        
        Usuario usuario1 = new Usuario();
        usuario1.setNomeUsuario("Diuly");
        em.persist(usuario1);
        
        Usuario usuario2 = new Usuario();
        usuario2.setNomeUsuario("Pedro");
        em.persist(usuario2);
        
        Amigo amigo = new Amigo();
        amigo.setUsuario(usuario1);
        amigo.setData(new Date());
        amigo.setUsuarioAmigo(usuario2);
        usuario1.getAmigos().add(amigo);

        Publicacao publicacao = new Publicacao();
        publicacao.setConteudo("Estou tão cansada hoje.");
        publicacao.setUsuario(em.find(Usuario.class, 2l));
        publicacao.setData(new Date());
        em.persist(publicacao);
        
        GET_TRANSACTION.commit();
        em.close();
        emf.close();
        
    }
}
