/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes.DAO;

import br.com.crescer.aula4.mapeamentoBaseNunes.Produto;
import java.util.List;

/**
 *
 * @author Diuly
 */
public interface IProdutoDAO {
    void insert(Produto produto);
    void delete(Produto produto);
    void update(Produto produto);
    List<Produto> listAll();
    Produto findById(Long id);
}
