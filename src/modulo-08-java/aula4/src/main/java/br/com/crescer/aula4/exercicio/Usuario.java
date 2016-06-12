/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.exercicio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "USUARIO")
/**
 *
 * @author diuly.barreto
 */
public class Usuario implements Serializable {
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    
    @Basic(optional = false)
    @Column(name = "NM_USUARIO")
    private String nomeUsuario;
    
    @OneToMany (mappedBy = "USUARIO", cascade = CascadeType.ALL)    
    private List<Amigo> amigos;
    
    public void setIdPessoa(Long id) {
        this.idUsuario = id;
    }
    
    public Long getIdUsuario() {
        return idUsuario;
    }
    
    public void setNomeUsuario(String nome) {
        this.nomeUsuario = nome;
    }
    
    public String getNomeUsuario() {
        return nomeUsuario;
    }
    
    public List<Amigo> getAmigos() {
        return amigos;
    }
    
    public void setAmigos(List<Amigo> amigos) {
        this.amigos = amigos;
    }
}
