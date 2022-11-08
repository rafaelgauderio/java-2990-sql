---LEFT JOIN traz todo mundo, inclusive que não tem relação. campos NULL
SELECT empregados.cpf, empregados.Enome, departamentos.dnome, trabalha.*
FROM empregados
INNER JOIN departamentos 
ON departamentos.dnumero = empregados.dnumero
LEFT JOIN trabalha ON trabalha.cpf_emp = empregados.cpf
WHERE trabalha.cpf_emp IS NULL -- null faz mostrar os que não trabalhar em projeto nenhum
ORDER BY empregados.cpf