/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controllers;

import java.util.Date;

/**
 *
 * @author diuly.barreto
 */
public class Pessoa {
    private Date nascimento;
    private String nome;
    
    public void setNascimento(Date date) {
        this.nascimento = date;
    }
    
    public Date getNascimento() {
        return nascimento;
    }

    public void setNome(String n) {
        this.nome = n;
    }
    
    public String getNome() {
        return nome;
    }
    
}
