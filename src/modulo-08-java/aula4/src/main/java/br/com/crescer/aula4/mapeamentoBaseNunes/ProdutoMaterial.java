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
@Table (name = "ProdutoMaterial")
public class ProdutoMaterial implements Serializable {
    
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SQPRODUTOMATERIAL")
    @SequenceGenerator(name = "SQPRODUTOMATERIAL", sequenceName = "SQPRODUTOMATERIAL", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPRODUTOMATERIAL")
    private Long idProdutoMaterial;
    
    @ManyToOne
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name = "IDMATERIAL")
    private Material material;
    
    @Basic(optional = true)
    @Column(name = "QUANTIDADE")
    private double quantidade;

    public Long getIdProdutoMaterial() {
        return idProdutoMaterial;
    }

    public void setIdProdutoMaterial(Long idProdutoMaterial) {
        this.idProdutoMaterial = idProdutoMaterial;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
    
}
