


https://sandbox.neo4j.com/

choose movie dataset



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
