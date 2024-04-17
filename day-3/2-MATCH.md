


Get all nodes

```cypher
MATCH (n) RETURN n
```

Create Nodes

```cypher
:play movies
```


----------------------------------------------------------
Match Nodes with Labels
----------------------------------------------------------


MATCH (n:Person) 
RETURN n

MATCH (n:Movie)
RETURN n

MATCH(n{title:"The Da Vinci Code"})
SET n:Action
return n

MATCH(m:Movie:Action)
return m

MATCH(m:Action)
return m


----------------------------------------------------------
Matching Related Nodes
----------------------------------------------------------

MATCH (n) -- (m)
return *

MATCH (n)
RETURN n

CREATE (),(),(),(),()


----------------------------------------------------------
Matching Related Nodes - Exercice
----------------------------------------------------------

MATCH(t{name:'Tom Hanks'})--(n)
RETURN *


MATCH(t{name:'Tom Hanks'})--(n)
RETURN n


----------------------------------------------------------
Matching with Labels
----------------------------------------------------------

MATCH(n{name:"Robert Zemeckis"})--(m:Movie)
RETURN m


MATCH(n{name:"Robert Zemeckis"})--(m:Movie)
RETURN *


----------------------------------------------------------
Matching by incomming Relationships
----------------------------------------------------------

MATCH(polar{title:"The Polar Express"})<--(k)
RETURN k


----------------------------------------------------------
Copying Properties from one Nodes
----------------------------------------------------------

 CREATE (a{name:'A', city:'New York'})
 
 MATCH(a{name:'A'})
 CREATE(n{name:'B', city:a.city})
 RETURN n.city


----------------------------------------------------------
Copying Properties from Relationships
----------------------------------------------------------

CREATE
(a{name:'A'}), 
(b{name:'B'}),
(c{name:'C'}),
(a)-[r:KNOWS{since:'2016'}]->(b)
RETURN *


MATCH(a{name:'A'})-[r]->(b{name:'B'})
CREATE (b)<-[r2:KNOWS{since:r.since}]-(c{name:'C'})
RETURN properties(r2)