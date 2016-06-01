-- Exercício 1
select c.IDCliente, c.Nome, d.Nome as NomeCidade, d.UF
FROM Cliente c INNER JOIN Cidade d on c.IDCidade = d.IDCIDADE;

-- Exercício 2
SELECT COUNT(*) from Pedido Where DATAPEDIDO BETWEEN TO_DATE('01/05/2016', 'DD/MM/RRRR') and TO_DATE('31/05/2016', 'DD/MM/RRRR')+.99999;

-- Exercício 3
select * from Cliente Where UPPER(NOME) like '%LTDA' or UPPER(RAZAOSOCIAL) like '%LTDA%';

-- Exercício 4
-- Nome: Galocha Maragato Preço de custo: 35.67 Preço de venda: 77.95 Situação: A 
CREATE SEQUENCE SQPRODUTO START WITH 8001 INCREMENT BY 1;
INSERT INTO PRODUTO (IDPRODUTO, Nome, PRECOCUSTO, PRECOVENDA, SITUACAO)
VALUES (SQPRODUTO.NEXTVAL, 'Galocha Maragato', 35.67, 77.95, 'A');

commit

-- Exercício 5
select p.IDPRODUTO, p.NOME, p.DATACADASTRO, p.PRECOCUSTO, p.PRECOVENDA, p.SITUACAO 
from produto p left join pedidoitem i on i.idproduto = p.idproduto Where i.idproduto is null;

-- Exercício 6
select * from pedido where IDCLIENTE = :pIDCLIENTE;

-- Exercício 7
select COUNT(*) from pedidoitem i inner join pedido p on i.IDPEDIDO = p.IDPEDIDO
where i.IDPRODUTO = :pIDPRODUTO and
p.DATAPEDIDO >= TO_DATE('01/01/2016', 'DD/MM/YYYY')+.99999;

-- Exercício 8
