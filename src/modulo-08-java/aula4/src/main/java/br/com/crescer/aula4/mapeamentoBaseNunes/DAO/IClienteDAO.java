/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes.DAO;

import br.com.crescer.aula4.mapeamentoBaseNunes.Cliente;
import java.util.List;

/**
 *
 * @author Diuly
 */
interface IClienteDAO {
    void insert(Cliente cliente);
    void delete(Cliente cliente);
    void update(Cliente cliente);
    List<Cliente> listAll();
    Cliente findById(Long id);
}
