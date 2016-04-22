-- 1
SELECT left(Nome, CHARINDEX(' ', Nome))
	From Associado

-- 2
SELECT Nome, year(GetDate()) - year(DataNascimento) as Idade
	From Associado

-- 3
SELECT NomeEmpregado, datediff(month, DataAdmissao, convert(datetime, '31/12/2000', 103)) as MesesTrabalhados
	From Empregado
	Where DataAdmissao BETWEEN convert(datetime, '01/05/1980', 103) and convert(datetime, '20/01/1982', 103);

-- 4
SELECT top(1) Cargo, Count(1) as Total
from Empregado
Group by Cargo
Order by COUNT(Cargo) DESC

-- 6
SELECT Nome, (year(DataNascimento)+50), DATENAME(WEEKDAY, DataNascimento)
From Associado

-- 7
SELECT UF, COUNT(1)
From Cidade
Group by UF

-- 8
SELECT Nome, UF, COUNT(1)
	From Cidade
	Group by Nome, UF
	Having Count(1) > 1

-- 9
SELECT (MAX(IDAssociado) + 1)
From Associado

-- 12
SELECT Nome,
CASE when Sexo = 'F' then 'Feminino'
when Sexo = 'M' then 'Masculino'
End Genero
From Associado

-- 13 
SELECT NomeEmpregado, Salario,
CASE WHEN Salario <= 1164.00 then '0%'
WHEN Salario > 1164.00 and Salario <= 2326.00 then '15%'
WHEN Salario > 2326.00 then '27.5%'
END
From Empregado
