/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "Pedido")
public class Pedido implements Serializable {
    
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SQPEDIDO")
    @SequenceGenerator(name = "SQPEDIDO", sequenceName = "SQPEDIDO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPEDIDO")
    private Long idPedido;
    
    @ManyToOne
    @JoinColumn(name = "IDCLIENTE")
    private Cliente cliente;
    
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "DATAPEDIDO")
    private Date dataPedido;
    
    @Basic(optional = true)
    @Temporal(TemporalType.DATE)
    @Column(name = "DATAENTREGA")
    private Date dataEntrega;
    
    @Basic(optional = false)
    @Column(name = "VALORPEDIDO")
    private double valorPedido;
    
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "SITUACAO")
    private SituacaoPedido situacao;

    public SituacaoPedido getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPedido situacao) {
        this.situacao = situacao;
    }

    public Long getIdPedido() {
        return idPedido;
    }   

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }
    
    
    
            
            
}
