/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes.DAO;

import br.com.crescer.aula4.mapeamentoBaseNunes.Cliente;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Diuly
 */
public class ClienteDAO implements IClienteDAO {

    private Session session;
    
    public ClienteDAO(Session session) {
        this.session = session;
    }
    
    @Override
    public void insert(Cliente cliente) {
        session.save(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        session.delete(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        session.update(cliente);
    }

    @Override
    public List<Cliente> listAll() {
        Criteria crit = session.createCriteria(Cliente.class);
        List<Cliente> lista = crit.list();
        return lista;
    }

    @Override
    public Cliente findById(Long id) {
        Criteria crit = session.createCriteria(Cliente.class);
        crit.add(Restrictions.like("idCliente", id));
        return (Cliente)(crit.uniqueResult());
    }
    
}
