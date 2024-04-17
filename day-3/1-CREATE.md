
----------------------------------------------------------
Creating Empty Nodes
----------------------------------------------------------

Get All Nodes

```cypher
MATCH (n) RETURN n
```

Creating Empty Nodes

```cypher
CREATE ()
```

Create Multiple Empty Nodes

```cypher
CREATE (), (), (), (), ()
```


----------------------------------------------------------
Variables
----------------------------------------------------------


error: `Variable `n` not defined (line 1, column 8 (offset: 7))`
```cypher
CREATE ()
RETURN n
```

Node with variable

```cypher
CREATE (n)
RETURN n
```

Create Multiple Nodes with variable

```cypher
CREATE (n), (m), (o), (p), (q)
RETURN n, m, o, p, q
```

Get All Nodes

```cypher
MATCH (n) RETURN n
```

Delete All Nodes

```cypher
MATCH (n) DETACH DELETE n
```

Create Node 

```cypher
CREATE(n)
RETURN n
```


----------------------------------------------------------
Create Node with Labels
----------------------------------------------------------

Create Node with Label

```cypher
CREATE (n:Person)
RETURN n
```

```cypher
CREATE (n:Employee)
RETURN n
```


create node with multiple labels

```cypher
CREATE (nag:Person:Employee:Trainer)
RETURN nag
```


----------------------------------------------------------
Create Node with Properties
----------------------------------------------------------

Create Node with Properties

```cypher
CREATE (n{name: 'Nag', age: 35, email:'nag@mail.com'})
RETURN n
```


----------------------------------------------------------
Create Node with Labels and Properties
----------------------------------------------------------


Create Node with Label and Properties

```cypher
CREATE (n:Person{name: 'Nag', age: 35, email:'nag@mail.com'})
RETURN n
```


----------------------------------------------------------
Creating Relationships
----------------------------------------------------------

Create Relationship

```cypher
CREATE (n:Person{name: 'Nag', age: 35})-[:LIVES_IN]->(c:City{name: 'Chennai'})
RETURN n, c
```

Create Multiple Relationships

```cypher
CREATE (n:Person{name: 'Nag', age: 35})-[:LIVES_IN]->(c:City{name: 'Chennai'}),(n)-[:WORKS_FOR]->(comp:Company{name: 'TSE'})
RETURN n, c, comp
```

Create Multiple Relationships with Properties

```cypher
CREATE (n:Person{name: 'Nag', age: 35})-[:LIVES_IN]->(c:City{name: 'Chennai'}),(n)-[:WORKS_FOR{from: '2010', to: '2020'}]->(comp:Company{name: 'TSE'})
RETURN n, c, comp
```


----------------------------------------------------------
Asterisk
----------------------------------------------------------

Create Multiple Nodes with Asterisk

```cypher
CREATE (n:Person{name: 'Nag', age: 35}),(o:Person{name: 'Indu', age: 33}),(m:Person{name: 'Riya', age: 8}),
(q:Person{name: 'Dhiya', age: 5}) 
RETURN *
```

```cypher
CREATE (:Person{name: 'Nag', age: 35})-[:LIVES_IN]->(:City{name: 'Chennai'})
RETURN *
```


----------------------------------------------------------
Exercise
----------------------------------------------------------

Write a Cypher Query to create below graph

Peter is married to Anne and they have a house.

```cypher
CREATE (p:Person{name: 'Peter'})-[:MARRIED_TO]->(a:Person{name: 'Anne'})-[:HAS]->(h:House{name: 'Home'})
RETURN p, a, h
```


----------------------------------------------------------
Relationships with uncommon characters
----------------------------------------------------------

Create Relationship with uncommon characters

```cypher
create (a{name:'Andrew'})<-[:`the forgotten friend of`]-(m{name:'Mike'})
return *

create (a:Person{name:'Andrew'})<-[:`the forgotten friend of`]-(m:Person{name:'Mike'})
return *

```

----------------------------------------------------------
Exercise
----------------------------------------------------------

create 
(T:Person{name:'Tim'}),
(K:Person{name:'Kate'}),
(J:Person{name:'John'}),
(T)-[:Follows]->(J),
(T)-[:Follows]->(K),
(K)-[:Follows]->(T),
(J)-[:Follows]->(K)
return *

---

create 
(T:Person{name:'Tim'}),
(K:Person{name:'Kate'}),
(J:Person{name:'John'}),
(K)-[:Follows]->(T)-[:Follows]->(J)-[:Follows]->(K)<-[:Follows]-(T)
return *


----------------------------------------------------------
Path variable to represent path
----------------------------------------------------------


create path = (n:Supplier{name:'A'})-[r:Supplied]-> (m:Client{name:'B'})
return path

create p = (h:Property{name:"House"})<-[r:Has]-(b:Person{name:"Peter"})-[:Married]->(a:Person{name:"Anne"})
return p

create p1 = ({name:"Peter", age:25, email:"p@gmail.com"}),
({name:"Peter", age:25, email:"p@gmail.com"}),
({name:"Peter", age:25, email:"p@gmail.com"})
return p1

create p1 = ({name:"Peter1", age:25, email:"p@gmail.com"}),
p2 = ({name:"Peter2", age:25, email:"p@gmail.com"}),
p3 = ({name:"Peter3", age:25, email:"p@gmail.com"})
return p2


----------------------------------------------------------
Create Relationship b/w nodes e.g Family Tree
----------------------------------------------------------

Without labels
---------------
create 
(D{name:'Dan'}),
(K{name:'Kate'}),
(M{name:'Mike'}),
(L{name:'Luke'}),
(S{name:'Steve'}),
(F{name:'Favour'}),
(faith{name:'Faith'}),
(J{name:'Jane'}),
(D)-[:MARRIED_TO]->(K)-[:MARRIED]->(D),
(D)-[:PARENT_OF]->(M)<-[:PARENT_OF]-(K),
(D)-[:PARENT_OF]->(L)<-[:PARENT_OF]-(K),
(D)-[:PARENT_OF]->(S)<-[:PARENT_OF]-(K),
(F)-[:MARRIED_TO]->(S)-[:MARRIED]->(F),
(F)-[:PARENT_OF]->(faith)<-[:PARENT_OF]-(S),
(F)-[:PARENT_OF]->(J)<-[:PARENT_OF]-(S)
RETURN *



With labels
-----------

create 
(D:Person{name:'Dan'}),
(K:Person{name:'Kate'}),
(M:Person{name:'Mike'}),
(L:Person{name:'Luke'}),
(S:Person{name:'Steve'}),
(F:Person{name:'Favour'}),
(faith:Person{name:'Faith'}),
(J:Person{name:'Jane'}),
(D)-[:MARRIED_TO]->(K)-[:MARRIED]->(D),
(D)-[:PARENT_OF]->(M)<-[:PARENT_OF]-(K),
(D)-[:PARENT_OF]->(L)<-[:PARENT_OF]-(K),
(D)-[:PARENT_OF]->(S)<-[:PARENT_OF]-(K),
(F)-[:MARRIED_TO]->(S)-[:MARRIED]->(F),
(F)-[:PARENT_OF]->(faith)<-[:PARENT_OF]-(S),
(F)-[:PARENT_OF]->(J)<-[:PARENT_OF]-(S)
RETURN *



----------------------------------------------------------
Create Relationship b/w nodes e.g Crime Investigation
----------------------------------------------------------

create
(d:Person{name:"Dan"}),
(c:Vehicle{name:"Car"}),
(a:Person{name:"Andrew"}),
(e:Person{name:"Eric"}),
(dog:Animal{name:"Dog"}),
(l:Location{name:"AB Street"}),
(crime:Crime{title:"Killing of a dog"}),
(d)-[:Party_to]->(crime)<-[:Involved_in]-(c),
(a)-[:Party_to]->(crime)<-[:Investigated_by]-(e),
(dog)-[:Victim_of]->(crime)<-[:Occurred_at]-(l),
(dog)-[:Killed_at]->(l)
return *