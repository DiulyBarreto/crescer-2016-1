using LojaNinja.Dominio;
using System;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace LojaNinja.MVC.Models
{
    public class PedidoModel
    {
        public int? Id { get; set; }
        [DisplayName("Data da entrega")]
        public DateTime DataEntrega { get; set; }
        [DisplayName("Nome do produto")]
        public string Produto { get; set; }
        public decimal Valor { get; set; }
        [DisplayName("Tipo de pagamento")]
        public TipoPagamento TipoPagamento { get; set; }
        [DisplayName("Nome do cliente")]
        public string Cliente { get; set; }
        public string Cidade { get; set; }
        public string Estado { get; set; }
    }
}