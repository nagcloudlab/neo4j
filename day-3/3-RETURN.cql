

//----------------------------------------------------------------------------------
// Return Node Properties
//----------------------------------------------------------------------------------

MATCH(n)
RETURN n.name;

MATCH(n)
RETURN n.name, n.age;

MATCH(n)
RETURN n.name, n.born;

//----------------------------------------------------------------------------------
// Relationship Type
//----------------------------------------------------------------------------------

MATCH(n{name:"Frank Darabont"})-[r]->(m{title:"The Green Mile"})
RETURN type(r);

MATCH(n)-[r]-(m)
RETURN r;

MATCH(n)-[r]-(m)
RETURN type(r);

MATCH(n)-[r]-(m)
RETURN r.roles;

MATCH(n)-[r:DIRECTED]-(m)
RETURN r;

MATCH(n)-[r:DIRECTED]-(m)
RETURN type(r);


//----------------------------------------------------------------------------------
// Alias
//----------------------------------------------------------------------------------

MATCH(n) RETURN n.name AS NAME, n.born; 


//----------------------------------------------------------------------------------
// Distinct
//----------------------------------------------------------------------------------


MATCH(n) 
RETURN DISTINCT n.born
ORDER BY n.born ASC;


//----------------------------------------------------------------------------------
// Returning Properties
//----------------------------------------------------------------------------------



MATCH (n)
RETURN properties(n);

MATCH (n{name:"Tom Hanks"})
RETURN properties(n);

MATCH (n{name:"Tom Hanks"})-[r]->()
RETURN properties(r);


MATCH()-[r]->()
RETURN properties(r);

MATCH()-[r]->()
RETURN *;


// ----------------------------------------------------------------------------------
// Returning all labels
// ----------------------------------------------------------------------------------

CREATE(n:Person:Actor:Director:Producer{name:'Victor'});

MATCH(n{name:"Victor"})
RETURN labels(n);


// ----------------------------------------------------------------------------------
// Returning all Relationships
// ----------------------------------------------------------------------------------

MATCH p = ({name:"Paul Blythe"})-->()-->()-->()
RETURN p;

MATCH p = ({name:"Paul Blythe"})-->()-->()-->({title:"Cloud Atlas"})
RETURN relationships(p)