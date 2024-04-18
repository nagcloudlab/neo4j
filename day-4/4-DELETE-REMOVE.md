

match(n{name:"A"})
delete n


match(n{name:"Tom Skerritt"})
detach 
delete n


match(t{title:"Top Gun"})<-[r:WROTE]-(j{name:"Jim Cash"})
delete r


--------------------------------

match(n{name:"Jim Cash"})
set n:Actor:Writer, n.weight = "100kg"
return n


match(n{name:"Jim Cash"})
remove n.born
return n

match(n{name:"Jim Cash"})
remove n:Person:Writer
return n

match(n{name:"Jim Cash"})
remove n:Actor
return n

match(n{name:"Jim Cash"})
remove n.weight, n.name
return n