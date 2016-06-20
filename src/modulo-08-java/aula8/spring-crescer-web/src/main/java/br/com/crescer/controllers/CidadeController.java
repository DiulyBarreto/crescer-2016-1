/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controllers;

import br.com.crescer.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Diuly
 */

@Controller
public class CidadeController {
    
    @Autowired
    CidadeService service;
    
    @RequestMapping(value = "/cidade")
    String toIndex(Model model) {
        model.addAttribute("cidades", service.findAll());
        return "indexCidade";
    }
}
