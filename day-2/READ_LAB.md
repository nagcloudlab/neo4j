

- Cypher is a query language designed for graphs.

------------------------------------------------------------------------
- Nodes are represented by parentheses ().
- We use a colon to signify the label(s), for example (:Person).
- Relationships between nodes are written with two dashes, for example (:Person)--(:Movie).
- The direction of a relationship is indicated using a greater than or less than symbol < or > , 
    for example (:Person)-->(:Movie).
- The type of the relationship is written using the square brackets between the two dashes: [ and ], 
    for example [:ACTED_IN]
- Properties drawn in a speech bubble are specified in a JSON like syntax.
- Properties in Neo4j are key/value pairs, for example {name: 'Tom Hanks'}.
------------------------------------------------------------------------

```cypher
MATCH (p:Person)
RETURN p
```

```cypher
MATCH (p:Person {name: 'Tom Hanks'})
RETURN p
```

```cypher
MATCH (p:Person {name: 'Tom Hanks'})
RETURN  p.born
```

```cypher
MATCH (p:Person)
WHERE p.name = 'Tom Hanks'
RETURN p.born
```

```cypher
MATCH (p:Person)
WHERE p.name = 'Tom Hanks' OR p.name = 'Rita Wilson'
RETURN p.name, p.born
```



Finding Relationships


```cypher
MATCH (p:Person {name: 'Tom Hanks'})
RETURN p
```

```cypher
MATCH (p:Person {name: 'Tom Hanks'})-[:ACTED_IN]->(m)
RETURN m.title
```

```cypher
MATCH (p:Person {name: 'Tom Hanks'})-[:ACTED_IN]->(m:Movie)
RETURN m.title
```


Filtering Queries

```cypher
MATCH (p:Person)-[:ACTED_IN]->(m:Movie)
WHERE m.released = 2008 OR m.released = 2009
RETURN p, m
```

Filtering by node labels

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
```

Filtering by existence of a property

```cypher
MATCH (p:Person)-[:ACTED_IN]->(m:Movie)
WHERE p.name='Jack Nicholson' AND m.tagline IS NOT NULL
RETURN m.title, m.tagline
```

Filtering by partial strings

```cypher
MATCH (p:Person)-[:ACTED_IN]->()
WHERE p.name STARTS WITH 'Michael'
RETURN p.name
```

```cypher
MATCH (p:Person)-[:ACTED_IN]->()
WHERE toLower(p.name) STARTS WITH 'michael'
RETURN p.name
```

Filtering by patterns in the graph

```cypher
MATCH (p:Person)-[:WROTE]->(m:Movie)
WHERE NOT exists( (p)-[:DIRECTED]->(m) )
RETURN p.name, m.title
```

Filtering using lists

```cypher
MATCH (p:Person)
WHERE p.born IN [1965, 1970, 1975]
RETURN p.name, p.born
```

What properties does a node or relationship have?

```cypher
MATCH (p:Person)
RETURN p.name, keys(p)
```

What properties exist in the graph?

```cypher
CALL db.propertyKeys()
```


