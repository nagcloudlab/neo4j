
match(n:Person)
return  n.name
limit 3;

match(n:Person)
return  n.name
order by n.name ASC
limit 3;

match(n:Person)
return  n.name
order by n.name DESC
limit 3;

match(n:Person)
return  n.name
order by n.name DESC
limit 2*2;

match(n:Person)
return  n.name
order by n.name DESC
limit 10-3;

match(n:Person)
return  n.name
order by n.name DESC
limit toInteger(ceil(0.9));

match(n:Person)
return  n.name
order by n.name DESC
limit 1;

match(n:Person)
return  n.name
order by n.name DESC
limit toInteger(floor(3.2));



// ---


create(n:Person{name:"Brian Moore"})
return n
limit 0;


