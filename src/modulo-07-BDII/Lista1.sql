-- Exerc�cio 1
select c.IDCliente, c.Nome, d.Nome as NomeCidade, d.UF
FROM Cliente c INNER JOIN Cidade d on c.IDCidade = d.IDCIDADE

-- Exerc�cio 2
SELECT COUNT(*) from Pedido Where DATAPEDIDO BETWEEN TO_DATE('01/05/2016', 'DD/MM/RRRR') and TO_DATE('31/05/2016', 'DD/MM/RRRR')+.99999;

-- Exerc�cio 3
select * from Cliente Where UPPER(NOME) like UPPER('%LTDA%') or UPPER(RAZAOSOCIAL) like UPPER('%Ltda%');

-- Exerc�cio 4
-- Nome: Galocha Maragato Pre�o de custo: 35.67 Pre�o de venda: 77.95 Situa��o: A 
CREATE SEQUENCE SQPRODUTO START WITH 8001 INCREMENT BY 1;
INSERT INTO PRODUTO (IDPRODUTO, Nome, PRECOCUSTO, PRECOVENDA, SITUACAO)
VALUES (SQPRODUTO.NEXTVAL, 'Galocha Maragato', 35.67, 77.95, 'A');

-- Exerc�cio 5
select p.IDPRODUTO, p.NOME, p.DATACADASTRO, p.PRECOCUSTO, p.PRECOVENDA, p.SITUACAO 
from produto p left join pedidoitem i on i.idproduto = p.idproduto Where i.idproduto is null;

-- Exerc�cio 6
select * from pedido where IDCLIENTE = :pIDCLIENTE;




