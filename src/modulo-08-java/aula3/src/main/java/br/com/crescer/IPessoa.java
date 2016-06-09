/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.util.List;

/**
 *
 * @author diuly.barreto
 */
public interface IPessoa {
    void insert(Pessoa pessoa);
    void update(Pessoa pessoa);
    void delete(Pessoa pessoa);
    List<Pessoa> listAll();
    List<Pessoa> findNames(String nome);
}
