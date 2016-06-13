/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes.DAO;

import br.com.crescer.aula4.mapeamentoBaseNunes.Pedido;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Diuly
 */
public class PedidoDAO implements IPedidoDAO {

    private Session session;
    
    public PedidoDAO(Session session) {
        this.session = session;
    }
    
    @Override
    public void insert(Pedido pedido) {
        session.save(pedido);
    }

    @Override
    public void delete(Pedido pedido) {
        session.delete(pedido);
    }

    @Override
    public void update(Pedido pedido) {
        session.update(pedido);
    }

    @Override
    public List<Pedido> listAll() {
        Criteria crit = session.createCriteria(Pedido.class);
        List<Pedido> lista = crit.list();
        return lista;
    }

    @Override
    public Pedido findById(Long id) {
        Criteria crit = session.createCriteria(Pedido.class);
        crit.add(Restrictions.like("idPedido", id));
        return (Pedido)(crit.uniqueResult());
    }
    
}
