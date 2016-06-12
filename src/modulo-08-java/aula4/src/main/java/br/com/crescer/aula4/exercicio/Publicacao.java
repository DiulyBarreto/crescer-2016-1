/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.exercicio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Diuly
 */

@Entity
@Table(name = "PUBLICACAO")
public class Publicacao implements Serializable {
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PUBLICACAO")
    @SequenceGenerator(name = "SEQ_PUBLICACAO", sequenceName = "SEQ_PUBLICACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_PUBLICACAO")
    private Long idPublicacao;
    
    @Basic(optional = false)
    @Column(name = "CONTEUDO")
    private String conteudo;
    
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_PUBLICACAO")
    private Date data;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    public Long getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(Long idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
