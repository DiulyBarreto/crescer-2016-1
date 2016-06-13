/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes.DAO;

import br.com.crescer.aula4.mapeamentoBaseNunes.ProdutoMaterial;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Diuly
 */
public class ProdutoMaterialDAO implements IProdutoMaterialDAO {

    private Session session;
    
    public ProdutoMaterialDAO(Session session) {
        this.session = session;
    }
    
    @Override
    public void insert(ProdutoMaterial pMaterial) {
        session.save(pMaterial);
    }

    @Override
    public void delete(ProdutoMaterial pMaterial) {
        session.delete(pMaterial);
    }

    @Override
    public void update(ProdutoMaterial pMaterial) {
        session.update(pMaterial);
    }

    @Override
    public List<ProdutoMaterial> listAll() {
        Criteria crit = session.createCriteria(ProdutoMaterial.class);
        List<ProdutoMaterial> lista = crit.list();
        return lista;    
    }

    @Override
    public ProdutoMaterial findById(Long id) {
        Criteria crit = session.createCriteria(ProdutoMaterial.class);
        crit.add(Restrictions.like("idProdutoMaterial", id));
        return (ProdutoMaterial)(crit.uniqueResult());
    }
    
}
