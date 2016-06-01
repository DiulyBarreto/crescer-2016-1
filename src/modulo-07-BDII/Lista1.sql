-- Exerc�cio 1
select c.IDCliente, c.Nome, d.Nome as NomeCidade, d.UF
FROM Cliente c INNER JOIN Cidade d on c.IDCidade = d.IDCIDADE;

-- Exerc�cio 2
SELECT COUNT(*) from Pedido Where DATAPEDIDO BETWEEN TO_DATE('01/05/2016', 'DD/MM/RRRR') and TO_DATE('31/05/2016', 'DD/MM/RRRR')+.99999;

-- Exerc�cio 3
select * from Cliente Where UPPER(NOME) like '%LTDA' or UPPER(RAZAOSOCIAL) like '%LTDA%';

-- Exerc�cio 4
-- Nome: Galocha Maragato Pre�o de custo: 35.67 Pre�o de venda: 77.95 Situa��o: A 
CREATE SEQUENCE SQPRODUTO START WITH 8001 INCREMENT BY 1;
INSERT INTO PRODUTO (IDPRODUTO, Nome, PRECOCUSTO, PRECOVENDA, SITUACAO)
VALUES (SQPRODUTO.NEXTVAL, 'Galocha Maragato', 35.67, 77.95, 'A');

commit

-- Exerc�cio 5
select p.IDPRODUTO, p.NOME, p.DATACADASTRO, p.PRECOCUSTO, p.PRECOVENDA, p.SITUACAO 
from produto p left join pedidoitem i on i.idproduto = p.idproduto Where i.idproduto is null;

-- Exerc�cio 6
select * from pedido where IDCLIENTE = :pIDCLIENTE;

-- Exerc�cio 7
select SUM(quantidade) from pedidoitem i inner join pedido p on i.IDPEDIDO = p.IDPEDIDO
where i.IDPRODUTO = :pIDPRODUTO and
p.DATAPEDIDO >= TO_DATE('01/2016', 'MM/YYYY');

-- Exerc�cio 8
select to_char(ped.DataPedido, 'mm/yyyy') ANO_MES, 
       COUNT(DISTINCT item.IDPRODUTO) as Produtos_Distintos,
       SUM(ped.ValorPedido) as Valor_Pedidos,
       MIN(ped.ValorPedido) as Menor_Pedido,
       MAX(ped.ValorPedido) as Maior_Pedido,
       AVG(ped.ValorPedido) as Media_Pedidos,
       COUNT(distinct ped.IDPedido) as total_Pedidos
From Pedido ped
  inner join PedidoItem item on item.IDPedido = ped.IDPedido
Group by to_char(ped.DataPedido, 'mm/yyyy');