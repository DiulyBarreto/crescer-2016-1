﻿using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace LojaNinja.Repositorio
{
    public class RepositorioVendas
    {
        //private const string ARQUIVO = @"C:\Users\diuly.barreto\Documents\crescer-2016-1\src\modulo-05-dotnet\LojaNinja\vendas.txt";
        private const string ARQUIVO = @"C:\Users\Diuly\Documents\crescer-2016-1\src\modulo-05-dotnet\LojaNinja\vendas.txt";
        private static readonly object objetoLock = new object();

        public List<Pedido> ObterPedidos()
        {
            var linhasArquivo = File.ReadAllLines(ARQUIVO, Encoding.UTF8).ToList();


            return ConverterPedidosParaObjetos(linhasArquivo);
        }

        public List<Pedido> ConverterPedidosParaObjetos(List<string> linhasArquivo)
        {
            var listaPedidos = new List<Pedido>();

            linhasArquivo.RemoveAt(0);

            foreach(var linha in linhasArquivo)
            {
                var id = Convert.ToInt32(linha.Split(';')[0]);
                var dataPedido = Convert.ToDateTime(linha.Split(';')[1]);
                var dataEntregaDesejada = Convert.ToDateTime(linha.Split(';')[2]);
                var nomeProduto = linha.Split(';')[3];
                var valorVenda = Convert.ToDecimal(linha.Split(';')[4]);
                TipoPagamento tipoPagamento;
                Enum.TryParse(linha.Split(';')[5], out tipoPagamento);
                var nomeCliente = linha.Split(';')[6];
                var cidade = linha.Split(';')[7];
                var estado = linha.Split(';')[8];
                var urgente = Convert.ToBoolean(linha.Split(';')[9]);

                var pedido = new Pedido(id, dataPedido, dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado, urgente);
                listaPedidos.Add(pedido);
            }
            return listaPedidos;
        }

        public Pedido ObterPedidoPorId(int id)
        {
            return this.ObterPedidos().FirstOrDefault(x => x.Id == id);
        }

        private string ConvertePedidoEmLinhaCSV(Pedido pedido, int proximoId)
        {
            return string.Format(Environment.NewLine + "{0};{1};{2};{3};{4};{5};{6};{7};{8};{9}",
                                proximoId,
                                pedido.DataPedido.ToString("dd/MM/yyyy HH:mm"),
                                pedido.DataEntregaDesejada.ToString("dd/MM/yyyy HH:mm"),
                                pedido.NomeProduto,
                                pedido.Valor,
                                pedido.TipoPagamento,
                                pedido.NomeCliente,
                                pedido.Cidade,
                                pedido.Estado,
                                pedido.PedidoUrgente);
        }

        public void AtualizarPedido(Pedido pedido)
        {
            //TODO: Implementar
        }

        public void IncluirPedido(Pedido pedido)
        {
            lock (objetoLock)
            {
                var utlimoId = this.ObterPedidos().Max(x => x.Id);
                var idGerado = utlimoId + 1;
                var novaLinha = ConvertePedidoEmLinhaCSV(pedido, idGerado);

                File.AppendAllText(ARQUIVO, novaLinha);

                pedido.AtualizarId(idGerado);
            }
        }

        public void ExcluirPedido(int id)
        {
            var pedidos = ObterPedidos();
            var pedidosNovos = pedidos.Where(pedido => pedido.Id != id);
            File.WriteAllText(ARQUIVO, "Número Pedido;Data Pedido;Data Desejo Entrega;Nome Produto;Valor Venda;Tipo Pagamento;Nome Cliente;Cidade;Estado;Urgente");
            foreach (var linha in pedidosNovos)
            {
                File.AppendAllText(ARQUIVO, ConvertePedidoEmLinhaCSV(linha, linha.Id));
            }

        }

        public List<Pedido> FiltrarPorClienteEProduto(string cliente, string produto)
        {
            var pedidos = this.ObterPedidos()
             .Where(p =>
                 (cliente == null || cliente == "" || p.NomeCliente.ToLower().Contains(cliente.ToLower()))
                 &&
                 (produto == null || produto == "" || p.NomeProduto.ToLower() == produto.ToLower())).ToList();

            return pedidos;
        }
        
    }
}
