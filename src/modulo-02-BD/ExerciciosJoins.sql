-- 1 : Selecione o nome do empregado e nome do departamento que cada um est� relacionado.
SELECT e.NomeEmpregado, d.NomeDepartamento
	From Empregado e inner join Departamento d on e.IDDepartamento = d.IDDepartamento

-- 2 : Exibir o nome do associado e sua cidade, exibir tamb�m associados sem Cidade relacionada.
SELECT a.Nome as NomeAssociado, c.Nome as NomeCidade
	From Associado a left join Cidade c on a.IDCidade = c.IDCidade

-- 3 : Lista os Estados (UF) e total de Cidades, exibir apenas as cidades que n�o possuem associados relacionados
SELECT c.UF as Estados, COUNT(c.Nome) as Total_Cidades
	From Associado a right join Cidade c on a.IDCidade = c.IDCidade
	Where a.IDCidade is null
	Group by UF

-- 4 : Fa�a uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique se a cidade �
-- da regi�o Sul (RS, SC, PR), se for imprimir ***(3 asteriscos), sen�o imprimir nulo.
SELECT a.Nome, c.Nome as NomeCidade,
	Case 
		When c.UF = 'RS' or c.UF = 'SC' or c.UF = 'PR' then '***'
		else 'null'
	END
	From Associado a left join Cidade c on a.IDCidade = c.IDCidade

-- 5 : Liste o nome do empregado, o nome do gerente, e o departamento de cada um.
SELECT e.NomeEmpregado as NomeEmpregado,
	   d.NomeDepartamento as Departamento_Empregado,
	   g.NomeEmpregado as NomeGerente,
	   de.NomeDepartamento as Departamento_Gerente
	From Empregado e inner join Empregado g on e.IDGerente = g.IDEmpregado inner join Departamento d on e.IDDepartamento = d.IDDepartamento
	inner join Departamento de on g.IDDepartamento = de.IDDepartamento

-- CORRIGIR e TERMINAR AS OUTRAS