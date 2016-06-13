/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes.DAO;

import br.com.crescer.aula4.mapeamentoBaseNunes.Cidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Diuly
 */
public class CidadeDAO implements ICidadeDAO {
    
    private Session session;
    
    public CidadeDAO(Session session) {
        this.session = session;
    }
    
    @Override
    public void insert(Cidade cidade) {
        session.save(cidade);
    }

    @Override
    public void delete(Cidade cidade) {
        session.delete(cidade);
    }

    @Override
    public void update(Cidade cidade) {
        session.update(cidade);
    }

    @Override
    public List<Cidade> listAll() {
        Criteria crit = session.createCriteria(Cidade.class);
        List<Cidade> lista = crit.list();
        return lista;
    }
    
    @Override
    public Cidade findById(Long id) {
        Criteria crit = session.createCriteria(Cidade.class);
        crit.add(Restrictions.like("idCidade", id));
        return (Cidade)(crit.uniqueResult());
    }
    
}
