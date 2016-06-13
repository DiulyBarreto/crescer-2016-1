/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.run;

import br.com.crescer.aula4.mapeamentoBaseNunes.Cidade;
import br.com.crescer.aula4.mapeamentoBaseNunes.Cliente;
import br.com.crescer.aula4.mapeamentoBaseNunes.DAO.CidadeDAO;
import br.com.crescer.aula4.mapeamentoBaseNunes.Material;
import br.com.crescer.aula4.mapeamentoBaseNunes.Pedido;
import br.com.crescer.aula4.mapeamentoBaseNunes.PedidoItem;
import br.com.crescer.aula4.mapeamentoBaseNunes.Produto;
import br.com.crescer.aula4.mapeamentoBaseNunes.ProdutoMaterial;
import br.com.crescer.aula4.mapeamentoBaseNunes.SituacaoCliente;
import br.com.crescer.aula4.mapeamentoBaseNunes.SituacaoPedido;
import static br.com.crescer.run.AppRunExercicio.GET_TRANSACTION;
import static br.com.crescer.run.AppRunExercicio.em;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hibernate.Session;
import java.util.List;

/**
 *
 * @author Diuly
 */
public class AppRunExercicioBaseNunes {
    static final EntityManagerFactory emf  = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em  = emf.createEntityManager();
    static final EntityTransaction GET_TRANSACTION = em.getTransaction();
    static Session session = em.unwrap(Session.class);
    
    public static void main(String[] args) {
        GET_TRANSACTION.begin();
//        Cidade cidade = new Cidade();
//        cidade.setNomeCidade("Butia");
//        cidade.setUf("RS");
//        em.persist(cidade);
        
//        Cliente cliente = new Cliente();
//        cliente.setNomeCliente("Nathan");
//        cliente.setRazaoSocial("Nathan CIA LITDA");
//        cliente.setCidade(em.find(Cidade.class, 4670l));
//        cliente.setEndereco("Rua 15 de novembro");
//        cliente.setBairro("Vila Nova");
//        cliente.setCep(96750000l);
//        cliente.setSituacao(SituacaoCliente.I);
//        em.persist(cliente);

//        Produto produto = new Produto();
//        produto.setNome("Faca Ninja");
//        produto.setDataCadastro(new Date());
//        produto.setPrecoCusto(52.25);
//        produto.setPrecoVenda(58.59);
//        produto.setSituacao('A');
//        em.persist(produto);
        
//        Pedido pedido = new Pedido();
//        pedido.setDataPedido(new Date());
//        pedido.setCliente(em.find(Cliente.class, 12505l));
//        pedido.setValorPedido(58.59);
//        pedido.setSituacao(SituacaoPedido.C);
//        em.persist(pedido);
        
//        PedidoItem pedidoItem = new PedidoItem();
//        pedidoItem.setPedido(em.find(Pedido.class, 40001l));
//        pedidoItem.setProduto(em.find(Produto.class, 8004l));
//        pedidoItem.setPrecoUnitario(52.25);
//        pedidoItem.setQuantidade(1);
//        pedidoItem.setSituacao(SituacaoPedido.Q);
//        em.persist(pedidoItem);
        
//        Material material = new Material();
//        material.setDescricao("AÇO INOX");
//        material.setPesoLiquido(1.25);
//        material.setPrecoCusto(25.50);
//        em.persist(material);
//
//        ProdutoMaterial pMaterial = new ProdutoMaterial();
//        pMaterial.setMaterial(em.find(Material.class, 25001l));
//        pMaterial.setProduto(em.find(Produto.class, 8004l));
//        pMaterial.setQuantidade(1);
//        em.persist(pMaterial);
        
       CidadeDAO dao = new CidadeDAO(session);
//       cidade.setNomeCidade("Feliciano");
//       cidade.setUf("RS");
//       dao.insert(cidade);

//       Cidade cidade = dao.findById(4685l);
//       cidade.setNomeCidade("Dom Feliciano2");
//       dao.update(cidade);
//       dao.delete(cidade);

       List<Cidade> cidades = dao.listAll();
       
       GET_TRANSACTION.commit();
       em.close();
       emf.close();
       
       for(Cidade cid : cidades) {
           System.out.println("Nome: " + cid.getNomeCidade());
       }
       
    }
}
