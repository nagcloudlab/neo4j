

Understanding Parameters
------------------------

:param name => "Tony"

create (n:Person{name:$name})

match(n:Person)
set n.name = $name
return n


:params {name:'Mike', age:22}
create(n:Person{name:$name, age:$age})
return n

--------------------------------------------------

Assigning a name to parameters

:params {profile: {name:'Mike', age:22}}

with keys($profile) as keys
return keys

unwind keys($profile) as k
return k

--------------------------------------------------

Accessing a value from  parameter

unwind keys($profile) as k
return $profile[k]

--------------------------------------------------

Accessing and Deleting parameters

:params

:params {}

--------------------------------------------------

Updating properties using parameters

create(n:Person{name:'Ben', dept:'Dev'})

:param {'new_info': {name:'Ben', position:'Senior Manager', dept:'Sales'}}

match(n:Person)
where n.name ='Ben' AND n.dept = 'Dev'
set n = $new_info
return ns


--------------------------------------------------

parameters by Example

:params {'prop':[{'name':'John','age' : 24,'phone':'0142147'},
{'name':'Kate','age' : 30,'phone':'01410142'},{'name':'Ahmed','age' : 24,'phone':'01246782'}]}

unwind $prop as properties
create (n:Person)
set n = properties
return n

--------------------------------------------------


Using Params , skip and limit

:params {'a':1, 'b':2}

match(m:Movie)
return m.title
skip tointeger($b)
limit tointeger($a)

--------------------------------------------------

Using Params with id

:params {'id': 40}

match(n)
where id(n) = $id
return n

--------------------------------------------------

Using Params with list of id

:params{'id':[40,70,2,4]}

match(n)
where id(n) IN $id
return n

--------------------------------------------------