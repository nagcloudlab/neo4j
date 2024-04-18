


-------------------------------------------------------------------
Pattern Matching
-------------------------------------------------------------------

match (n)--(m)
return *

match (n)--(m)
return count(*)

match (n)<-->(m)
return count(*)

match (n)<-[r]->(m)
return count(r)

match p = (n)<-[r]->(m)
return count(p)

match p = (n)<-[r]->(m)
return p


-------------------------------------------------------------------
Variable Length Relationships
-------------------------------------------------------------------

<!-- Min-1 Max-infinity -->

match p = ()-[*]-()
return p

match p = ()-[*]->()
return p


<!-- Min-1 Max-1 -->
match p = ()-[*1..1]->()
return p


match p = ()-[*2..2]->()
return p

match p = ()-[*1..2]->()
return p

match p = ()-[*2..3]->()
return p


match p = ()-[*3..3]->()
return p



match p = ()-[:FOLLOWS*1]->()
return p


match p = ()-[:FOLLOWS*3]->()
return p


match p = (a)-->(b)<--(a)
return p


match p = (a)-->(b)<--(a),(a)--> (b)
return p



match p = ({name:"Paul Blythe"})-[:FOLLOWS*2..4]->()
return p


match  p = ()-[:ACTED_IN|DIRECTED*2]->()
return p


-------------------------------------------------------------------
Zero Length Path
-------------------------------------------------------------------


match p = (J{name:"Jessica Thompson"})-[*0]->()
return p

match p = (J{name:"Jessica Thompson"})-[*0..1]->()
return p


match p = (J{name:"Jessica Thompson"})-[*0..1]-()
return p


-------------------------------------------------------------------
Shortest Path
-------------------------------------------------------------------

match p = shortestPath((a)-[*]-(b))
return p


-------------------------------------------------------------------
Summary
-------------------------------------------------------------------



match p = ()-->()
return p

match p = (a)-->(c)<--(b)
return p

match p = (a)-[:FOLLOWS]->(b)-[:FOLLOWS]->(c)
return p

match p = (a)-[:FOLLOWS]-(b)-[:FOLLOWS]-(c)
return p
 

match p = (a)-[*]->(b)
return p

match p = (a)-[*2]->(b)
return p


match p = (a)-[*2..5]->(b)
return p

match p = (a)-[*2..]->(b)
return p

match p = (a)-[:REVIEWED*..2]->(b)
return p

match p = (a)-[:REVIEWED*2]->(b)
return p

match p = (a)-[:REVIEWED*1..]->(b)
return p

match p = (a)-[:FOLLOWS*..1]->(b)
return p

match p = (a)-[*..5]->(b)
return p

match p = (a)-[:FOLLOWS*..3]->(b)
return p

match p = (a)-[*..0]->(b)
return p






