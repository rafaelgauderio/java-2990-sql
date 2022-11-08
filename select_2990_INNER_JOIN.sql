---CONSULTA dos empregados que estão em algum projeto
SELECT empregados.cpf, empregados.Enome, departamentos.dnome
FROM empregados
INNER JOIN departamentos 
ON departamentos.dnumero = empregados.dnumero
INNER JOIN trabalha
ON trabalha.cpf_emp = empregados.cpf
INNER JOIN projetos
ON projetos.dnumero = departamentos.dnumero
