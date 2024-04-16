


https://sandbox.neo4j.com/

- choose movie dataset
- select neo4j_browser or workspace


cypher introduction
===========================

Cypher is a declarative query language for Neo4j graph databases.


```cypher
MATCH (p:Person)
RETURN p
```

```cypher
MATCH (p:Person {name:'Tom Hanks'})
RETURN p
```

```cypher
MATCH (p:Person {name:'Tom Hanks'})
RETURN p.born
```

In Cypher, labels, property keys, and variables are case-sensitive. 
Cypher keywords are not case-sensitive.


Neo4j best practices include:

 -> Name labels using CamelCase.
 -> Name property keys and variables using camelCase.
 -> User UPPERCASE for Cypher keywords.


```cypher
MATCH (p:Person)
WHERE p.name = 'Tom Hanks'
RETURN p
```

```cypher
MATCH (p:Person)
WHERE p.name = 'Tom Hanks' OR p.name = 'Rita Wilson'
RETURN p.name, p.born
```


Finding Relationships
===========================

Our Goal

As a movie fanatic
I would like to find movies for a particular actor
So that I can watch a movie this evening

```cypher
MATCH (p:Person {name:'Tom Hanks'})
RETURN p
```

```cypher
MATCH (p:Person {name:'Tom Hanks'})-[:ACTED_IN]-(m:Movie)
RETURN p,m
```

```cypher
MATCH (p:Person {name:'Tom Hanks'})-[:ACTED_IN]->(m:Movie)
RETURN p,m
```


Filtering queries
===========================

```cypher
MATCH (p:Person)-[:ACTED_IN]->(m:Movie)
WHERE m.released = 2008 OR m.released = 2009
RETURN p,m
```

```cypher
MATCH (p:Person)-[:ACTED_IN]->(m:Movie)
WHERE m.title='The Matrix'
RETURN p.name
```

```cypher
MATCH (p)-[:ACTED_IN]->(m)
WHERE p:Person AND m:Movie AND m.title='The Matrix'
RETURN p.name
```

Filtering using ranges

```cypher
MATCH (p:Person)-[:ACTED_IN]->(m:Movie)
WHERE 2000 <= m.released <= 2003
RETURN p.name, m.title, m.released

Filtering by existence of a property

```cypher
MATCH (p:Person)-[:ACTED_IN]->(m:Movie)
WHERE p.name='Jack Nicholson' AND m.tagline IS NOT NULL
RETURN p.name, m.title, m.tagline
```

Filtering by partial strings

```cypher
MATCH (p:Person)-[:ACTED_IN]->(m:Movie)
WHERE p.name STARTS WITH 'Tom' AND m.title CONTAINS 'Matrix'
RETURN p.name, m.title
```

```cypher
MATCH (p:Person)-[:WROTE]->(m:Movie)
WHERE NOT exists( (p)-[:DIRECTED]->(m) )
RETURN p.name, m.title
```

```cypher
MATCH (p:Person)
WHERE p.born IN [1965, 1970, 1975]
RETURN p.name, p.born
```


```cypher
MATCH (p:Person)-[r:ACTED_IN]->(m:Movie)
WHERE  'Neo' IN r.roles AND m.title='The Matrix'
RETURN p.name, r.roles
```

What properties does a node or relationship have?

```cypher
MATCH (p:Person)-[r:ACTED_IN]->(m:Movie)
RETURN keys(p), keys(r), keys(m)
```



-------------------------------------------------------------
SQL vs Cypher
-------------------------------------------------------------

SQL

```sql
SELECT * FROM Person WHERE name='Tom Hanks'
```

Cypher

```cypher
MATCH (p:Person {name:'Tom Hanks'})
RETURN p
```

or

```cypher
MATCH (p:Person)
WHERE p.name = 'Tom Hanks'
RETURN p
```

-------------------------------------------------------------

SQL

```sql
SELECT p.name, m.title
FROM Person p
JOIN ACTED_IN a ON p.id = a.person_id
JOIN Movie m ON a.movie_id = m.id
WHERE p.name = 'Tom Hanks'
```

Cypher

```cypher
MATCH (p:Person)-[:ACTED_IN]->(m:Movie)
WHERE p.name = 'Tom Hanks'
RETURN p.name, m.title
```

-------------------------------------------------------------