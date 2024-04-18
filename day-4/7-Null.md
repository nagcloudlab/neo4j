
Null in Neo4j
------------
NULL isn't a keyword. 
Neo4j is used to represent the absence of a value or undefined values.

MATCH (p:Person) RETURN p.nickname
MATCH (p:Person) RETURN p.born order by p.born desc

Null = missing or unknown values

MATCH (a)-[r]->(b)
WHERE a.name = "Laurence Fishburne"
RETURN a.name, type(r), b.title


MATCH (a)-[r]->(b)
WHERE a.name = "Laurence Fishburne"
RETURN a.fname, type(r), b.title




-------
(no changes, no records): This is a message from Neo4j which means that the executed query didn't modify anything in the database (no changes) and didn't return any results (no records).

MATCH (n:People) RETURN n