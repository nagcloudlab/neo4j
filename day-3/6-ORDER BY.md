

// ORDER BY Example-1

match(n)
return n.name, n.born
order by n.born;


match(n)
return n.name, n.born
order by n.born ASC;


match(n)
return n.name, n.born
order by n.born DESC;



// ORDER BY Example-2

match(n)
return n.born, n.name
order by n.born, n.name;


// ORDER BY Example-3

match(n)
return n.born, n.name
order by n.born, n.name;


match(n)
return n.born, n.name
order by n.born, n.name DESC;

match(n)
return n.born, n.name
order by n.born DESC, n.name ASC;

match(n)
return n.born, n.name
order by n.born DESC, n.name DESC;


// ORDER BY Example-4

match(n)
return n.name
order by n.born;