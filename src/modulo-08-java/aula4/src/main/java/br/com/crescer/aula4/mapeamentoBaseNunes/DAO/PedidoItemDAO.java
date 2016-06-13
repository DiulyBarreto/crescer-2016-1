/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes.DAO;

import br.com.crescer.aula4.mapeamentoBaseNunes.PedidoItem;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Diuly
 */
public class PedidoItemDAO implements IPedidoItemDAO {

    private Session session;
    
    public PedidoItemDAO(Session session) {
        this.session = session;
    }
    
    @Override
    public void insert(PedidoItem pItem) {
        session.save(pItem);
    }

    @Override
    public void delete(PedidoItem pItem) {
        session.delete(pItem);
    }

    @Override
    public void update(PedidoItem pItem) {
        session.update(pItem);
    }

    @Override
    public List<PedidoItem> listAll() {
        Criteria crit = session.createCriteria(PedidoItem.class);
        List<PedidoItem> lista = crit.list();
        return lista;
    }

    @Override
    public PedidoItem findById(Long id) {
        Criteria crit = session.createCriteria(PedidoItem.class);
        crit.add(Restrictions.like("idPedidoItem", id));
        return (PedidoItem)(crit.uniqueResult());
    }
    
}
