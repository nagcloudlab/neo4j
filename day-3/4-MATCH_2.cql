

//--------------------------------------------------------------------------------
// Fetching Relationship Types
//--------------------------------------------------------------------------------


MATCH(T{name:"Tom Hanks"}) -[r]->(k)
RETURN type(r);


MATCH(T{name:"Tom Hanks"}) -[r]->(k)
RETURN count(type(r));



//--------------------------------------------------------------------------------
// Matching on Relationship Types
//--------------------------------------------------------------------------------

MATCH(n{name:"Paul Blythe"}) -[r:FOLLOWS]->(m)
RETURN m.name;

MATCH(n{name:"Angela Scope"}) -[r:FOLLOWS]->(m)
RETURN m.name;

MATCH(n{name:"Angela Scope"}) -[r:FOLLOWS]->(m)
RETURN *;




//--------------------------------------------------------------------------------
// Matching with Multiple Relationship Types
//--------------------------------------------------------------------------------

MATCH(n{name:"Charlize Theron"})-[r:ACTED_IN|DIRECTED|PRODUCED]->(k)
RETURN k;

MATCH(n)-[r:ACTED_IN|DIRECTED|PRODUCED]->(k)
RETURN n.name, type(r), k.name;


//--------------------------------------------------------------------------------
// MATCH and CREATE
//--------------------------------------------------------------------------------


// MATCH
// (Z{name:"Robert Zemeckis"}),
// (T{name:"Tom Hanks"})
// CREATE
// (Z)-[:COLLEAGE_OF]->(T)-[:COLLEAGE_OF]->(Z)
// RETURN *;


//--------------------------------------------------------------------------------
// Using Multiple Relationships-1
//--------------------------------------------------------------------------------

MATCH(T{name:"Tom Hanks"}) -[r:ACTED_IN]->(m)<-[:DIRECTED]-(p) 
RETURN p.name;

MATCH(T{name:"Tom Hanks"}) -[r:ACTED_IN]->(m)<-[:DIRECTED]-(p) 
RETURN *;


//--------------------------------------------------------------------------------
// Using Multiple Relationships-2
//--------------------------------------------------------------------------------

MATCH(T{name:"Tom Hanks"}) -[r:ACTED_IN]->(m)<-[:ACTED_IN]-(p)
RETURN m;

MATCH(T{name:"Tom Hanks"}) -[r:ACTED_IN]->(m)<-[:ACTED_IN]-(p)
RETURN m.title;

MATCH(T{name:"Tom Hanks"}) -[r:ACTED_IN]->(m)<-[:ACTED_IN]-(p)
RETURN DISTINCT m.title;


//--------------------------------------------------------------------------------
// Using Multiple Relationships-3
//--------------------------------------------------------------------------------

MATCH(R{name:"Robert Zemeckis"}) -[:DIRECTED]->(M)<-[:ACTED_IN]-(actors)
RETURN M.title,actors.name;

MATCH(R{name:"Robert Zemeckis"}) -[:DIRECTED]->(M)<-[:ACTED_IN]-(actors)
RETURN *;