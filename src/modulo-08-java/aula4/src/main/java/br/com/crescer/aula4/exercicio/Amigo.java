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
 * @author diuly.barreto
 */
@Entity
@Table(name = "AMIGO")
public class Amigo implements Serializable {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_AMIGO")
    @SequenceGenerator(name = "SEQ_AMIGO", sequenceName = "SEQ_AMIGO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_AMIGO")
    private Long idAmigo;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_AMIGO")
    private Usuario usuarioAmigo;
    
    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DATA_AMIZADE")
    private Date data;

    public Long getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(Long idAmigo) {
        this.idAmigo = idAmigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioAmigo() {
        return usuarioAmigo;
    }

    public void setUsuarioAmigo(Usuario usuarioAmigo) {
        this.usuarioAmigo = usuarioAmigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
