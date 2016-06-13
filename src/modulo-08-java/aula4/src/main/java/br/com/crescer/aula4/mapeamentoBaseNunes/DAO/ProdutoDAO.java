/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes.DAO;

import br.com.crescer.aula4.mapeamentoBaseNunes.Produto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Diuly
 */
public class ProdutoDAO implements IProdutoDAO {

    private Session session;
    
    public ProdutoDAO(Session session) {
        this.session = session;
    }
    
    @Override
    public void insert(Produto produto) {
        session.save(produto);
    }

    @Override
    public void delete(Produto produto) {
        session.delete(produto);
    }

    @Override
    public void update(Produto produto) {
        session.update(produto);
    }

    @Override
    public List<Produto> listAll() {
        Criteria crit = session.createCriteria(Produto.class);
        List<Produto> lista = crit.list();
        return lista;    
    }

    @Override
    public Produto findById(Long id) {
        Criteria crit = session.createCriteria(Produto.class);
        crit.add(Restrictions.like("idProduto", id));
        return (Produto)(crit.uniqueResult());
    }
    
}
