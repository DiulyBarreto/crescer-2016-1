/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes.DAO;

import br.com.crescer.aula4.mapeamentoBaseNunes.Pedido;
import java.util.List;

/**
 *
 * @author Diuly
 */
public interface IPedidoDAO {
    void insert(Pedido pedido);
    void delete(Pedido pedido);
    void update(Pedido pedido);
    List<Pedido> listAll();
    Pedido findById(Long id);
}
