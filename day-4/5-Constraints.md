


Unique node property Contraints
===============================

CREATE CONSTRAINT email_constraint
FOR (n:Person) REQUIRE n.email is UNIQUE


create (n:Person{name:'Paul',email:'abc@example.com'})
create (n:Person{name:'Anna',email:'abc@example.com'})

CREATE (n:Employee{name: 'Dennis Lawal', email:'abc@example.com'})





https://neo4j.com/docs/cypher-manual/current/constraints/