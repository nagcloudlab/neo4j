

Cypher WITH clause
---------------------------

The `WITH` clause is used to chain multiple queries together. 
It is used to pass the results of one query to the next query. 
The `WITH` clause is used to pass the results

----------------------------------------------------------------------------
Udenstanding WITH clause
----------------------------------------------------------------------------

match(j{name:"John Cusack"}), (s{title:"Stand By Me"})
with j
return s.title

match(j{name:"John Cusack"}), (s{title:"Stand By Me"})
with j,s
return s.title


match(j{name:"John Cusack"}), (s{title:"Stand By Me"})
with j
return j.name


-------------------------------------------------------------
WITH clause Examples
-------------------------------------------------------------

MATCH(n)-[r]->(m)
WITH *, toUpper(n.name) AS name
return n.name, name


-------------------------------------------------------------


match(n{title:"When Harry Met Sally"})<--(otherNodes)
with n, toUpper(otherNodes.name) AS UpperNames
where UpperNames ENDS WITH 'Y'
return n.title, UpperNames

//-------
match(n{title:"When Harry Met Sally"})<--(otherNodes)
with n, otherNodes.name AS UpperNames
where UpperNames ENDS WITH 'y'
return n.title, UpperNames


//-------
match(n{title:"When Harry Met Sally"})<--(otherNodes)
with n, otherNodes.name AS UpperNames
return n.title, UpperNames


//-------
match(n{title:"When Harry Met Sally"})<--(otherNodes)
with n, otherNodes.name AS UpperNames
return *


----------------------------------------------------------------------------
WITH clause with alias
----------------------------------------------------------------------------

match(n)-[:FOLLOWS]->(m)
with *
return n.name

match(n)-[r]->(m)
with *
return n.name, type(r)

match(n)-[r]->(m)
with *, toLower(m.title) 
return n.name, ABC


match(n)-[r]->(m)
with *, toLower(m.title) AS ABC
return n.name, ABC

match(n)-[r]->(m)
with *, m.title
return n.name

match(n)-[r]->(m)
with *, m.title AS PQL
return n.name

match(n)-[r]->(m)
with *, r, m
return n.name


match(n)-[r]->(m)
with *, toUpper(n.name) as NAME
return NAME, n.name


----------------------------------------------------------------------------
More on WITH clause
----------------------------------------------------------------------------

match(n:Person)
return n.name
order by n.name

match(n:Person)
order by n.name
return n.name


match(n:Person)
with n
order by n.name
return n.name


match(n:Person)
with n
order by n.name
return n.name
limit 5



----------------------------------------------------------------------------
WITH clause and Collect
----------------------------------------------------------------------------

create({num:1}),({num:2}),({num:3}),({num:4}),({num:5}),({num:6}),({num:7}),({num:8})

match(n)
return n.num

match(n)
return collect(n.num)


match(n)
return collect(n.num)
order by n.num
skip 2


match(n:Person)
with n
orderby n.name
skip 2
limit 3
return collect(n.num)


----------------------------------------------------------------------------
WITH
----------------------------------------------------------------------------

match(n{name:"Meg Ryan"})--(m)
where m.released >1989
return m


match(n{name:"Meg Ryan"})--(m)
with m
order by m.released
where m.released >1989
return m


match(n{name:"Meg Ryan"})--(m)
with m
order by m.released DESC 
where m.released >1989
return m


match(n{name:"Meg Ryan"})--(m)
with m
order by m.released DESC 
limit 1
match (m)<-[:ACTED_IN]-(t)
with t
order by t.born ASC
limit 1
return t.name


match(n{name:"Meg Ryan"})--(m)
with m
order by m.released DESC 
limit 1
match (m)<-[:ACTED_IN]-(t)
with t
order by t.born ASC
return t.name, t.born 


