/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.exercicio;

import java.io.Serializable;
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

/**
 *
 * @author diuly.barreto
 */
@Entity
@Table(name = "AMIGO")
public class Amigo implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "ID_AMIGO")
    private Long idAmigo;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA")
    private Usuario usuario;
    
}
