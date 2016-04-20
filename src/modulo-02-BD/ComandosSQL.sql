-- 1 - Exibir em ordem de data de admiss�o
SELECT NomeEmpregado
	From Empregado
	Order by DataAdmissao ASC;

-- 2 - Exibir nome e sal�rio anual para sal�rio anual < 18.500,00
SELECT NomeEmpregado, Salario * 12
	From Empregado
	Where Cargo = 'Atendente' or (Salario * 12) < 18500.00;

-- 3 - ID de Uberl�ndia
SELECT IDCidade
	From Cidade
	Where Nome = 'Uberl�ndia';

-- 4 - Exibir todas as cidades do Rio Grande do Sul
SELECT IDCidade, Nome
	From Cidade
	Where UF = 'RS';