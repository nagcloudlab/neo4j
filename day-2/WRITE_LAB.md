

Use MERGE to create nodes in the graph.
Use MERGE to create relationships in the graph.
Create, update and remove properties for nodes and relationships in the graph.
Perform conditional MERGE processing, depending on what is in the graph.
Delete nodes and relationships from the graph.


---------------------------------------------------------------------
Creating nodes
---------------------------------------------------------------------

```cypher
MERGE (p:Person {name: 'Michael Caine'})
```

```cypher
MATCH (p:Person {name: 'Michael Caine'})
RETURN p
```

```cypher
MERGE (p:Person {name: 'Katie Holmes'})
MERGE (m:Movie {title: 'The Dark Knight'})
RETURN p, m
```


---------------------------------------------------------------------
Creating Relationships
---------------------------------------------------------------------

Type
Direction

```cypher
MATCH (p:Person {name: 'Michael Caine'})
MATCH (m:Movie {title: 'The Dark Knight'})
MERGE (p)-[:ACTED_IN]->(m)
RETURN p, m
```

```cypher
MATCH (p:Person {name: 'Michael Caine'})-[r:ACTED_IN]->(m:Movie {title: 'The Dark Knight'})
RETURN p,m
```

```cypher
MATCH (p:Person {name: 'Michael Caine'})<-[:ACTED_IN]-(m:Movie {title: 'The Dark Knight'})
RETURN p, m
```

Creating nodes and relationships using multiple clauses

```cypher
MERGE (p:Person {name: 'Chadwick Boseman'})
MERGE (m:Movie {title: 'Black Panther'})
MERGE (p)-[:ACTED_IN]-(m)
RETURN p, m
```

```cypher
MATCH (p:Person {name: 'Chadwick Boseman'})-[:ACTED_IN]-(m:Movie {title: 'Black Panther'})
RETURN p, m
```


Using MERGE to create nodes and a relationship in single clause

```cypher
MERGE (p:Person {name: 'Christian Bale'})-[:ACTED_IN]->(m:Movie {title: 'The Dark Knight'})
RETURN p, m
```


---------------------------------------------------------------------
Updating Properties
---------------------------------------------------------------------


Adding properties for a node or relationship


1. Inline as part of the MERGE clause

```cypher
MERGE (p:Person {name: 'Michael Caine'})
MERGE (m:Movie {title: 'Batman Begins'})
MERGE (p)-[:ACTED_IN {roles: ['Alfred Penny']}]->(m)
RETURN p,m
```

2. Using the SET keyword for a reference to a node or relationship

```cypher
MATCH (p:Person)-[r:ACTED_IN]->(m:Movie)
WHERE p.name = 'Michael Caine' AND m.title = 'The Dark Knight'
SET r.roles = ['Alfred Penny']
RETURN p, r, m
```


Setting multiple properties

```cypher
MATCH (p:Person)-[r:ACTED_IN]->(m:Movie)
WHERE p.name = 'Michael Caine' AND m.title = 'The Dark Knight'
SET r.roles = ['Alfred Penny'], r.screenTime = 120, r.year = 2008
RETURN p, r, m
```

Updating properties

```cypher
MATCH (p:Person)-[r:ACTED_IN]->(m:Movie)
WHERE p.name = 'Michael Caine' AND m.title = 'The Dark Knight'
SET r.roles = ['Mr. Alfred Pennyworth']
RETURN p, r, m
```

Removing properties

```cypher
MATCH (p:Person)-[r:ACTED_IN]->(m:Movie)
WHERE p.name = 'Michael Caine' AND m.title = 'The Dark Knight'
REMOVE r.roles
RETURN p, r, m
```

```cypher
MATCH ( p:Person)
WHERE p.name = 'Gene Hackman'
SET p.born=null
RETURN p
```

** You should never remove the property that is used as the primary key for a node.


---------------------------------------------------------------------
Merge Processing
---------------------------------------------------------------------


Customizing MERGE behavior

```cypher
// Find or create a person with this name
MERGE (p:Person {name: 'McKenna Grace'})
// Only set the `createdAt` property if the node is created during this query
ON CREATE SET p.createdAt = datetime()
// Only set the `updatedAt` property if the node was created previously
ON MATCH SET p.updatedAt = datetime()
// Set the `born` property regardless
SET p.born = 2006
RETURN p
```


Merging with relationships

```cypher
// Find or create a person with this name
MERGE (p:Person {name: 'Michael Caine'})
// Find or create a movie with this title
MERGE (m:Movie {title: 'The Cider House Rules'})
// Find or create a relationship between the two nodes
MERGE (p)-[:ACTED_IN]->(m)
RETURN p, m
```

```cypher
MERGE (p:Person {name: 'Michael Caine'})-[:ACTED_IN]->(m:Movie {title: 'The Cider House Rules'})
RETURN p, m
```

Here is what happens in the query processor:

Neo4j will attempt to find a Person node with the name Michael Caine.
If it does not exist, it creates the node.
Then, it will attempt to expand the ACTED_IN relationships in the graph for this node.
If there are any ACTED_IN relationships from this node, it looks for a Movie with the title 'The Cider House Rules'.
If there is no node for the Movie, it creates the node.
If there is no relationship between the two nodes, it then creates the ACTED_IN relationship between them.


---------------------------------------------------------------------
Deleting data
---------------------------------------------------------------------

In a Neo4j database you can delete:

    nodes
    relationships
    properties
    labels

Deleting a node
    
```cypher
MERGE (p:Person {name: 'Jane Doe'})
RETURN p
    ```

```cypher
MATCH (p:Person)
WHERE p.name = 'Jane Doe'
DELETE p
```


Deleting a relationship

```cypher
MATCH (m:Movie {title: 'The Matrix'})
MERGE (p:Person {name: 'Jane Doe'})
MERGE (p)-[:ACTED_IN]->(m)
RETURN p, m
```

```cypher
MATCH (p:Person {name: 'Jane Doe'})-[r:ACTED_IN]->(m:Movie {title: 'The Matrix'})
DELETE r
RETURN p, m
```

```cypher
MATCH (p:Person {name: 'Jane Doe'})
MATCH (m:Movie {title: 'The Matrix'})
MERGE (p)-[:ACTED_IN]->(m)
RETURN p, m
```

```cypher
MATCH (p:Person {name: 'Jane Doe'})
DELETE p
```

Deleting a node and its relationships

```cypher
MATCH (p:Person {name: 'Jane Doe'})
DETACH DELETE p
```

```cypher
MATCH (p:Person {name: 'Jane Doe'})-[r]-()
DELETE p, r
```

Deleting all nodes and relationships

```cypher
MATCH (n)
DETACH DELETE n
```


Deleting labels

```cypher
MATCH (p:Person {name: 'Jane Doe'})
RETURN p
```

```cypher
MATCH (p:Person {name: 'Jane Doe'})
SET p:Developer
RETURN p
```

```cypher
MATCH (p:Person {name: 'Jane Doe'})
REMOVE p:Developer
RETURN p
```

```cypher
MATCH (p:Person {name: 'Jane Doe'})
DETACH DELETE p
```

What labels are on the node?

```cypher
MATCH (p:Person {name: 'Jane Doe'})
RETURN labels(p)
```

```cypher
CALL db.labels()
```