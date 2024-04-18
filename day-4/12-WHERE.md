


Understanding WHERE


match(n)
where n:Person
Return n.name

match(n:Person)
return n.name

match(n)
where n:Movie
Return n.title

match(n:Movie)
Return n.title

--------------------------------------------------

Filter on node properties

MATCH(n:Person)
WHERE n.born < 1960
RETURN n.name, n.born
order by n.born DESC


MATCH(n:Person)
WHERE n.born > 1960
RETURN n.name, n.born
order by n.born DESC


MATCH(n:Person)
WHERE n.born = 1960
RETURN n.name, n.born
order by n.born DESC


MATCH(n:Person)
WHERE n.born = 1960 OR n.born > 1960 OR n.born < 1960
RETURN n.name, n.born
order by n.born DESC

--------------------------------------------------

 Filter on relationship properties

match()-[r]->()
return properties(r)

match(n:Person)-[r]->()
where r.roles = ["Kit Keller"]
RETURN n.name


match(n:Person)-[r]->()
where r.roles = ["Kit Keller"]
SET r.Attendance = [1,2,5,9,8]


match(n:Person)-[r]->()
where r.roles = ["Kit Keller"]
return properties(r)

--------------------------------------------------

Prefix string search using STARTS WITH
--------------------------------------
MATCH(n:Person)
WHERE n.name STARTS WITH 'Tom'
RETURN n.name, n.born


MATCH(n:Person)
WHERE n.name STARTS WITH 'T'
RETURN n.name, n.born


MATCH(n:Person)
WHERE n.name STARTS WITH 'B'
RETURN n.name, n.born



MATCH(n:Person)
WHERE n.name STARTS WITH 'Ki'
RETURN n.name, n.born

--------------------------------------------------

Suffix string search using ENDS WITH
--------------------------------------
MATCH(n:Person)
WHERE n.name ENDS WITH 'l'
RETURN n.name, n.born


CREATE ({string:"l"})


MATCH(n:Person),(m{string:"l"})
WHERE n.name ENDS WITH 'l'
CREATE (n)-[:ENDS_WITH]->(m)
RETURN *


MATCH(n:Person)
WHERE n.name ENDS WITH 'ell'
RETURN n.name, n.born



MATCH(n:Person)
WHERE n.name ENDS WITH 'David Mitchell'
RETURN n.name, n.born



MATCH(n:Person)
WHERE n.name ENDS WITH 'Mitchell'
RETURN n.name, n.born

--------------------------------------------------

Substring Search
----------------
MATCH (m:Movie)
WHERE m.title CONTAINS 'trix'
RETURN m.title, m.tagline

MATCH (m:Movie)
WHERE m.title CONTAINS 'aded'
RETURN m.title, m.tagline

MATCH (m:Movie)
WHERE m.title CONTAINS 'Rel'
RETURN m.title, m.tagline

MATCH (m:Movie)
WHERE m.title CONTAINS 'The'
RETURN m.title, m.tagline

--------------------------------------------------

String Matching Negation
-------------------------
match(m:Movie)
WHERE NOT m.title CONTAINS 'aded'
RETURN m.title, m.tagline


match(m:Movie)
WHERE NOT m.title STARTS WITH 'The'
RETURN m.title, m.tagline


match(m:Movie)
WHERE NOT m.title ENDS WITH 'Away'
RETURN m.title, m.tagline

--------------------------------------------------


Filtering on relationship properties
-------------------------------------

MATCH(n:Person)
WHERE (n)-[:FOLLOWS]->({name:"Angela Scope"})
RETURN n.name

MATCH(n)-[:FOLLOWS]->({name:"Angela Scope"})
RETURN n.name

MATCH(n)-[:FOLLOWS]->({name:"Angela Scope"})
RETURN *

MATCH(n:Person)
WHERE (n)-[:FOLLOWS]->()
RETURN n.name

MATCH(n:Person)
WHERE (n)-[:FOLLOWS]->()
RETURN *


MATCH(n:Person),(m:Person)
WHERE (n)-[:FOLLOWS]->(m)
RETURN m.name

MATCH(n:Person),(m:Person)
WHERE (n)-[:FOLLOWS]->(m)
RETURN * 


--------------------------------------------------

Existential subquery
--------------------



match(n:Person)
where EXISTS{(n)-[:FOLLOWS]->()}
return n.name


-----------------

match(n:Person)-[:FOLLOWS]->(person2)
where person2.name STARTS WITH 'Angela'
return n.name


match(n:Person)
where EXISTS{
	match (n)-[:FOLLOWS]->(person2)
	where person2.name STARTS WITH 'Angela'
	}
return n.name


--------------------

match(person)-[:FOLLOWS]->(person2)-[:FOLLOWS]->(person3)
where person3.name CONTAINS 'Thomp'
return person.name


match(person)
where exists{
	match(person)-[:FOLLOWS]->(person2)
where exists{
	match(person2)-[:FOLLOWS]->(person3)
	where person3.name CONTAINS 'Thomp'
}
}
return person.name

--------------------------------------------------

List With WHERE
---------------
MATCH(m:Movie)
WHERE m.title IN ["Bicentennial Man", "Charlie Wilson's War", 
"The Polar Express", "Unforgiven", "The Da Vinci Code"]
RETURN m.title, m.released, m.tagline

--------------------------------------------------

Range comparison
----------------

match(n) retrun n.name
order by n.name asc


match(n)
where n.name > "Angela Scope"
return n.name
order by n.name asc


match(n)
where n.name <= "Angela Scope"
return n.name
order by n.name asc


match(n)
where n.name >= "Angela Scope"
return n.name
order by n.name asc


match(n)
where n.name <> "Angela Scope"
return n.name
order by n.name asc


--------------------------------------------------

match(n)
where n.name >= "Aaron Sorkin" and
n.name <= "Angela Scope" or n.name
>= "Audrey Tautou" and n.name <= "Bill
Paxton"
return n.name
order by n.name asc

--------------------------------------------------