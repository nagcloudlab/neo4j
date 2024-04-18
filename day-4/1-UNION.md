
match(n:Person)
return n.name

match(n:Movie)
return n.title


match(n:Person)
return n.name AS result
union 
match(n:Movie)
return n.title AS result
order by n.title DESC



match(n:Person)
return n.name AS result, labels(n) AS label
union 
match(n:Movie)
return n.title AS result, labels(n) AS label
union
match(n:Movie)
return n.released AS result, labels(n) AS label