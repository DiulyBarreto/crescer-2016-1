-- 1 : Selecione o nome do empregado e nome do departamento que cada um está relacionado.
SELECT e.NomeEmpregado, d.NomeDepartamento
	From Empregado e inner join Departamento d on e.IDDepartamento = d.IDDepartamento

-- 2 : Exibir o nome do associado e sua cidade, exibir também associados sem Cidade relacionada.
SELECT a.Nome as NomeAssociado, c.Nome as NomeCidade
	From Associado a left join Cidade c on a.IDCidade = c.IDCidade

-- 3 : Lista os Estados (UF) e total de Cidades, exibir apenas as cidades que não possuem associados relacionados
SELECT c.UF as Estados, COUNT(c.Nome) as Total_Cidades
	From Associado a right join Cidade c on a.IDCidade = c.IDCidade
	Where a.IDCidade is null
	Group by UF

	-- CORRIGIR e TERMINAR AS OUTRAS
-- 4 : Faça uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique se a cidade é
-- da região Sul (RS, SC, PR), se for imprimir ***(3 asteriscos), senão imprimir nulo.
/*SELECT a.Nome, c.Nome as NomeCidade
	From Associado a left join Cidade c on a.IDCidade = c.IDCidade
	Where c.UF in ('SC', 'RS', 'PR')


-- 5 : Liste o nome do empregado, o nome do gerente, e o departamento de cada um.
/*SELECT e.NomeEmpregado as NomeEmpregado,
	   (SELECT 1 From Departamento Where Empregado.IDDepartamento = Departamento.IDDepartamento),
	   g.NomeEmpregado as NomeGerente,
	   d.NomeDepartamento as Departamento_Gerente
	   
	   
	From Empregado e left join (Empregado g left join Departamento d on g.IDDepartamento = d.IDDepartamento)*/

