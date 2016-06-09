/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

/**
 *
 * @author diuly.barreto
 */
public class Pessoa {
    
    private long idPessoa;
    private String nome;
    
    public Pessoa (long id, String nome) {
        this.idPessoa = id;
        this.nome = nome;
    }
    
    public long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
