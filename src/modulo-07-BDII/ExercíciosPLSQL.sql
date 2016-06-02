begin 
  DBMS_OUTPUT.PUT_LINE('Olá mundo');
end;


-- Exercício 1
declare
  vNome varchar2(30);
  vCidade varchar2(30);
  vDataPrimeira date;
  vDataUltima date;
  vTotal number;
  vTotalPedidos number;
  vMediaValor number;
begin
  select c.Nome, cid.Nome, min(p.DataPedido), max(p.DataPedido), sum(p.VALORPEDIDO), Count(p.IDPEDIDO), AVG(p.VALORPEDIDO)
  Into vNome,vCidade, vDataPrimeira, vDataUltima, v/Total, vTotalPedidos, vMediaValor
  from Cliente c inner join Cidade cid on c.IDCidade = cid.IDCidade
  inner join Pedido p on c.IDCliente = p.IDCliente
  Where c.IDCliente = :pIDCliente 
  group by c.Nome, cid.Nome;
  
  DBMS_OUTPUT.PUT_LINE('Nome: ' || vNome);
  DBMS_OUTPUT.PUT_LINE('Cidade: ' || vCidade);
  DBMS_OUTPUT.PUT_LINE('Data primeira compra: ' || vDataPrimeira);
  DBMS_OUTPUT.PUT_LINE('Data última compra: ' || vDataUltima);
  DBMS_OUTPUT.PUT_LINE('Valor total dos pedidos: ' || vTotal);
  DBMS_OUTPUT.PUT_LINE('Quantidade total de pedidos: ' || vTotalPedidos);
  DBMS_OUTPUT.PUT_LINE('Média de valores dos pedidos: ' || vMediaValor);
  
exception
  When no_data_found Then
    DBMS_OUTPUT.PUT_LINE('Cliente inexistente!');
end;

-- Exercício 2
declare
  vCidade varchar2(30) := '&Cidade';
  vUF varchar2(2) := '&UF';
  vCount integer;
  
begin
  select count(*) 
  into vCount
  from Cidade
  Where lower(Nome) = lower(vCidade) and lower(UF) = lower(vUF);
  if vCount > 0 then
    DBMS_OUTPUT.PUT_LINE('Cidade já cadastrada para esta UF.');
  else
    insert into Cidade (IDCidade, Nome, UF)
    Values (SQCidade.nextval, vCidade, vUF);
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Cidade cadastrada!');
  end if;
end;

