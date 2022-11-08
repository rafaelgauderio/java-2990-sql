---CONSULTA dos empregados que NÃO estão em algum projeto - DIFERENÇA
SELECT empregados.cpf, empregados.Enome, departamentos.dnome
FROM empregados
INNER JOIN departamentos 
ON departamentos.dnumero = empregados.dnumero
WHERE empregados.cpf NOT IN (
		SELECT empregados.cpf
		FROM empregados		
		INNER JOIN trabalha
		ON trabalha.cpf_emp = empregados.cpf 
	)
ORDER BY cpf;
		