/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author diuly.barreto
 */
@Entity
@Table(name = "PESSOA")

public class Pessoa implements Serializable {

    

    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PESSOA")
    @SequenceGenerator(name = "SEQ_PESSOA", sequenceName = "SEQ_PESSOA", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_PESSOA")
    private Long idPessoa;

    @Basic(optional = false)
    @Column(name = "NM_PESSOA")
    private String nmPessoa;
    
    public void setIdPessoa(Long id) {
        this.idPessoa = id;
    }
    
    public Long getId() {
        return idPessoa;
    }
    
    public void setNomePessoa(String nome) {
        this.nmPessoa = nome;
    }
    
    public String getNomePessoa() {
        return nmPessoa;
    }
    
}
