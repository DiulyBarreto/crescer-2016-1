using LojaNinja.Dominio;
using LojaNinja.MVC.Models;
using LojaNinja.MVC.Services;
using LojaNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        private RepositorioVendas repositorio = new RepositorioVendas();

        public ActionResult Cadastro(int? id)
        {
            UsuarioLogadoModel usuarioLogado = ServicoDeSessao.UsuarioLogado;
            ViewBag.NomeUsuarioLogado = usuarioLogado.Nome;
            
            if (id.HasValue)
            {
                var pedido = repositorio.ObterPedidoPorId(id.Value);

                var model = new PedidoModel();
                
                return View("Cadastro", model);
            }
            else
            {
               return View("Cadastro");
            }
        }

        public ActionResult Listagem(string cliente, string produto)
        {
            var pedidos = repositorio.FiltrarPorClienteEProduto(cliente, produto);

            return View(pedidos);
        }

        public ActionResult Detalhes(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);

            return View(pedido);
        }


        public ActionResult Salvar(PedidoModel model)
        {
            if(ModelState.IsValid)
            {
                try
                {
                    var pedido = new Pedido(model.DataEntrega, model.Produto, model.Valor, model.TipoPagamento, model.Cliente, model.Cidade, model.Estado);
                    repositorio.IncluirPedido(pedido);

                    ViewBag.MensagemSucesso = "Pedido salvo com sucesso!";
                    return View("Detalhes", pedido);
                }
                catch (ArgumentException e)
                {
                    ModelState.AddModelError("", e.Message);
                }
            }
            return View("Cadastro", model);
        }

        public ActionResult Excluir(int id)
        {
            repositorio.ExcluirPedido(id);

            ViewBag.Mensagem = "Pedido excluído!";

            return View("Mensagem");
        }

    }
}