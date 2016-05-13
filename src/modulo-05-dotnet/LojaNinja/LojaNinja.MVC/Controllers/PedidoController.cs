using LojaNinja.Dominio;
using LojaNinja.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        public ActionResult Cadastro()
        {
            return View();
        }

        public ActionResult Salvar(PedidoModel model)
        {
            var pedido = new Pedido(model.DataEntrega, model.Produto, model.Valor, model.TipoPagamento, model.Cliente, model.Cidade, model.Estado);

            ViewBag.MensagemSucesso = "Pedido salvo com sucesso!";
            return View("Detalhes", pedido);
        }
    }
}