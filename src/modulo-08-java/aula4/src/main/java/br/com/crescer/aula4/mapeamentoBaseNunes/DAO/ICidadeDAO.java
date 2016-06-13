/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes.DAO;

import br.com.crescer.aula4.mapeamentoBaseNunes.Cidade;
import java.util.List;

/**
 *
 * @author Diuly
 */
interface ICidadeDAO {
    
    void insert(Cidade cidade);
    void delete(Cidade cidade);
    void update(Cidade cidade);
    List<Cidade> listAll();
    Cidade findById(Long id);
}
