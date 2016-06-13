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
@Table(name = "Cliente")
public class Cliente implements Serializable {
    
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SQCLIENTE")
    @SequenceGenerator(name = "SQCLIENTE", sequenceName = "SQCLIENTE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDCLIENTE")
    private Long idCliente;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nomeCliente;
    
    @Basic(optional = false)
    @Column(name = "RAZAOSOCIAL")
    private String razaoSocial;
    
    @Basic(optional = true)
    @Column(name = "ENDERECO")
    private String endereco;  
    
    @Basic(optional = true)
    @Column(name = "BAIRRO")
    private String bairro; 
    
    @ManyToOne
    @JoinColumn(name = "IDCIDADE")
    private Cidade cidade;
    
    @Basic(optional= false)
    @Column(name = "CEP")
    private Long cep;
    
    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name = "SITUACAO")
    private SituacaoCliente situacao;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public SituacaoCliente getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCliente situacao) {
        this.situacao = situacao;
    }
}
