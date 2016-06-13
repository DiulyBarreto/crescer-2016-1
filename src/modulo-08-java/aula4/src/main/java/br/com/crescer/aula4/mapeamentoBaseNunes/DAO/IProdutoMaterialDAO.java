/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes.DAO;

import br.com.crescer.aula4.mapeamentoBaseNunes.ProdutoMaterial;
import java.util.List;

/**
 *
 * @author Diuly
 */
public interface IProdutoMaterialDAO {
    void insert(ProdutoMaterial pMaterial);
    void delete(ProdutoMaterial pMaterial);
    void update(ProdutoMaterial pMaterial);
    List<ProdutoMaterial> listAll();
    ProdutoMaterial findById(Long id);
}
