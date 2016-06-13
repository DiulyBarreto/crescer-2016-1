/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes.DAO;

import br.com.crescer.aula4.mapeamentoBaseNunes.PedidoItem;
import java.util.List;

/**
 *
 * @author Diuly
 */
public interface IPedidoItemDAO {
    void insert(PedidoItem pItem);
    void delete(PedidoItem pItem);
    void update(PedidoItem pItem);
    List<PedidoItem> listAll();
    PedidoItem findById(Long id);
}
