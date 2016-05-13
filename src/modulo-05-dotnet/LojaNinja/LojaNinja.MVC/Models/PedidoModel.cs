using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models
{
    public class PedidoModel
    {

        public int? Id { get; set; }
        [Required]
        [DisplayName("Data da entrega")]
        public DateTime DataEntrega { get; set; }
        [Required]
        [DisplayName("Nome do produto")]
        public string Produto { get; set; }
        [Required]
        public decimal Valor { get; set; }
        [Required]
        [DisplayName("Tipo de pagamento")]
        public EnumTipoPagamento TipoPagamento { get; set; }
        [Required]
        [DisplayName("Nome do cliente")]
        public string Cliente { get; set; }
        [Required]
        public string Cidade { get; set; }
        [Required]
        public string Estado { get; set; }
    }
}