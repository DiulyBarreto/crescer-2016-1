/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes.DAO;

import br.com.crescer.aula4.mapeamentoBaseNunes.Material;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Diuly
 */
public class MaterialDAO implements IMaterialDAO {

    private Session session;
    
    public MaterialDAO(Session session) {
        this.session = session;
    }

    @Override
    public void insert(Material material) {
        session.save(material);
    }

    @Override
    public void delete(Material material) {
        session.delete(material);
    }

    @Override
    public void update(Material material) {
        session.update(material);
    }

    @Override
    public List<Material> listAll() {
        Criteria crit = session.createCriteria(Material.class);
        List<Material> lista = crit.list();
        return lista;
    }

    @Override
    public Material findById(Long id) {
        Criteria crit = session.createCriteria(Material.class);
        crit.add(Restrictions.like("idMaterial", id));
        return (Material)(crit.uniqueResult());
    }
    
    
    
}
