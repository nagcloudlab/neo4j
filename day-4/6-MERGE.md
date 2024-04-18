
--------------------------------------------------------
Create vs Merge:
--------------------------------------------------------


create(:Person{name:"Victor"})
merge(:Person{name:"Moses"})
create(:Person{name:"Moses"})

merge(:Person{name:"Paul"})
merge(:Person:Developer{name:"Paul"})


BAD WAY:
Search manually first:
---------------------
Match(n{name:"Angela Scope", age:27})
return n

Then Create:
------------
create (n{name:"Angela Scope", age:27})

GOOD WAY:
---------
merge(n{name:"Angela Scope", age:27})
return n


--------------------------------------------------------
MERGE on Relationship:
--------------------------------------------------------


create
(r:Person{name:"Rita"}),
(p:Person{name:"Peter"}),
(j:Person{name:"Jane"}),
(k:Person{name:"Kate"}),
(v:Person{name:"Victor"}),
(r)<-[:LOVES]-(p)-[:KNOWS]->(v)<-[:KNOWS]-(k)<-[:KNOWS]-(j)-[:KNOWS]->(p)



match(p{name:"Peter"}),(k{name:"Kate"})
merge (p)-[r:KNOWS]->(k)
return *


match(p{name:"Peter"}),(k{name:"Kate"})
create (p)-[r:KNOWS]->(k)
return *


match(p{name:"Peter"}),(k{name:"Kate"})
merge (p)-[r:KNOWS]->(k)
return *


merge(p{name:"Peter"})
merge(k{name:"Kate"})
merge (p)-[r:KNOWS]->(k)
return p.name, type(r), k.name


match(p{name:"Peter"}),(k{name:"Kate"})
create (p)-[r:KNOWS]->(k)
return *


merge (p{name:"Peter"})
merge (k{name:"Kate"})
merge (p)-[r:KNOWSS]->(k)
return *


merge (p)-[r:KNOWSS]->(k)
return *


--------------------------------------------------------
MERGE on Multiple Relationships:
--------------------------------------------------------


	
create
(r:Person{name:"Rita"}),
(p:Person{name:"Peter"}),
(j:Person{name:"Jane"}),
(k:Person{name:"Kate"}),
(v:Person{name:"Victor"}),
(r)<-[:LOVES]-(p)-[:KNOWS]->(v)<-[:KNOWS]-(k)<-[:KNOWS]-(j)-[:KNOWS]->(p)
RETURN *


match(j{name:"Jane"}),(v{name:"Victor"})
merge (j)-[r:FOLLOWS]->(v)-[:LOVES]->(t:person{name:'Tina', age:22, nationality:"Candian "})
return *


--------------------------------------------------------
MERGE on CREATE
--------------------------------------------------------

merge(a:Person{name:"Ay"})
ON CREATE 
	SET a.age = 27
RETURN *


--------------------------------------------------------
MERGE on MATCH
--------------------------------------------------------

merge(m:Movie)
ON MATCH SET m.exists = "yes"
RETURN m.title, m.exists



--------------------------------------------------------
MERGE on CREATE and MATCH
--------------------------------------------------------

MERGE (n{name:"Angela Scope"})
ON CREATE
	SET n.nationality = "British"
ON MATCH
	SET n.nationality = "British"
RETURN *



MERGE (n{name:"Angelas Scopes"})
ON CREATE
	SET n.nationality = "British"
ON MATCH
	SET n.nationality = "British"
RETURN *



MERGE (n{name:"Acope"})
ON MATCH
	SET n.nationality = "British"
ON CREATE
	SET n.nationality = "British"

RETURN *


--------------------------------------------------------
MERGE on MATCH for multiple properties
--------------------------------------------------------


MATCH(person{name:'Hugo Weaving'})
RETURN properties(person)


MERGE (person{name:'Hugo Weaving'})
ON MATCH SET person.address = "21 Brown Street, Victoria Island, Lagos", person.married = "No"
RETURN person.name, person.address, person.married