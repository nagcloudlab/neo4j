


Understanding SET
-----------------


create (n:Person{fname:"James"})

match(n{fname:"James"})
set n.age = 25
return n

match(n{fname:"James"})
set n.lname = "Peter"
return n


match(n{fname:"James"})
set n.location = "USA", n.degree = "Bsc"
return n.location, n.degree

--------------------------------------------------

Set multiple properties

create (n{name:"Jacob"})
return n

match(n{name:"Jacob"})
set n = {weight:"65kg", age:40, phone:"0142508"}
return properties(n)

--------------------------------------------------

Set multiple properties , delete all , add more

create (n:Person{name:"Jacob", age:40})
return n

match(n{name:"Jacob"})
set n = {weight:"65kg", phone:"0142508"}
return properties(n)


match(n{name:"Jacob"})
set n += {weight:"65kg",phone:"0142508"}
return properties(n)


match(n{name:"Jacob"})
set n = { }
return properties(n)


match(n{name:"Jacob"})
set n + = { }
return properties(n)


match(n{name:"Jacob"})
set n + = {salary: "25,000"}
return properties(n)


--------------------------------------------------


Set single | multiple labels

create (n:{name:"Luke"})
return n


match(n{name:"Luke"})
set n:Person
return labels(n)


match(n{name:"Luke"})
set n:Actor:Director:Producer:Dancer
return labels(n)

--------------------------------------------------

Remove Single | All properties of Node

match(n{name:"Jacob"})
set n.age = null
return properties(n)

match(n{name:"Jacob"})
return properties(n)

match(n{name:"Jacob"})
set n = {}
return properties(n)

--------------------------------------------------

Updating Property

create (n:Person{name:"K", salary:25})
return n

match(n{name:"K"})
set n.salary = toString(n.salary)
return n.salary


match(n{name:"K"})
set n.salary = toInteger(n.salary)
return n.salary

--------------------------------------------------

Copying Properties between Nodes

create 
(a:person{name:"A", eye_color:"black", height:"170cm"}),
(b:person{name:"B"})
return *


match(a{name:"A"}), (b{name:"B"})
set b = a
return properties(b)

--------------------------------------------------

copying properties between relationships


({name:"Tom Hanks"})-[r2]->({title:"The Green Mile"})
return properties(r2)

match
({name:"Tom Hanks"})-[r1]->({title:"Cast Away"}),

({name:"Tom Hanks"})-[r2]->({title:"The Green Mile"})
set r2 = r1
return properties(r2)


--------------------------------------------------