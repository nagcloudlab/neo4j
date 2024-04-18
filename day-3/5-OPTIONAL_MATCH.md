


//--------------------------------
// Optional Match
//--------------------------------


// why use optional match?

// OPTIONAL MATCH is used to retrieve data that may not exist.
// In the above example, we want to retrieve all the movies and their actors.
// However, not all movies have actors, so we use OPTIONAL MATCH to retrieve the data that may not exist.
// OPTIONAL MATCH is similar to MATCH, but it will return null for the data that does not exist.



OPTIONAL match(m{title:'Cloud Atlas'})
OPTIONAL match(m)-->(n)
RETURN m.title, n.name;


// Find all the movies and their actors

MATCH (m:Movie)
OPTIONAL MATCH (m)<-[:ACTED_IN]-(a:Person)
RETURN m.title, collect(a.name) as actors;

