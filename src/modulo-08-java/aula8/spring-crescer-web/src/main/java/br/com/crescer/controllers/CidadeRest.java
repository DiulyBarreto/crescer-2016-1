/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controllers;

import br.com.crescer.entity.Cidade;
import br.com.crescer.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diuly
 */

@RestController
@RequestMapping("/rest/cidade")
public class CidadeRest {
    
    @Autowired
    CidadeService service;
    
     @RequestMapping(method = RequestMethod.GET) 
     public Iterable<Cidade> list() {
         return service.findAll();
     }
     
     @RequestMapping(value="/save", method = RequestMethod.POST)
     public Cidade save(@RequestBody Cidade c) {
         return service.save(c);
     }
     
     @RequestMapping(value="/delete", method = RequestMethod.POST)
     public void delete(@RequestBody Cidade cidade) {
         service.delete(cidade.getIdCidade());
     }
}
