/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes.DAO;

import br.com.crescer.aula4.mapeamentoBaseNunes.Material;
import java.util.List;

/**
 *
 * @author Diuly
 */
public interface IMaterialDAO {
    void insert(Material material);
    void delete(Material material);
    void update(Material material);
    List<Material> listAll();
    Material findById(Long id);
}
