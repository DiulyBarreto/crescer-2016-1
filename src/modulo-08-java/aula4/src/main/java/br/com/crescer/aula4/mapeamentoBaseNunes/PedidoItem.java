/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4.mapeamentoBaseNunes;

import java.io.Serializable;
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

/**
 *
 * @author Diuly
 */

@Entity
@Table(name = "PedidoItem")
public class PedidoItem implements Serializable {
    
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SQPRODUTO")
    @SequenceGenerator(name = "SQPEDIDOITEM", sequenceName = "SQPEDIDOITEM", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPEDIDOITEM")
    private Long idPedidoItem;
    
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private int quantidade;
    
    @Basic(optional = true)
    @Column(name = "PRECOUNITARIO")
    private double precoUnitario;
    
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "SITUACAO")
    private SituacaoPedido situacao;
    
    @ManyToOne
    @JoinColumn(name = "IDPEDIDO")
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;

    public Long getIdPedidoItem() {
        return idPedidoItem;
    }

    public void setIdPedidoItem(Long idPedidoItem) {
        this.idPedidoItem = idPedidoItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public SituacaoPedido getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPedido situacao) {
        this.situacao = situacao;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
