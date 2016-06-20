/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.repositories;

import br.com.crescer.entity.Cidade;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Diuly
 */
public interface CidadeRepository extends CrudRepository<Cidade, Long> {
    
}
