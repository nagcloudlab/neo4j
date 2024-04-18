
create
(:Person{name:"Mike",age:30}),
(:Person{name:"Peter",age:20}),
(:Person{name:"James",age:62}),
(:Person{name:"Kate",age:null}),
(:Person{name:"Dan",age:44}),
(:Person{name:"Vic",age:18}),
(:Person{name:"Eric",age:null}),
(:Person{name:"Tony",age:40}),
(:Person{name:"Rose",age:33}),
(:Person{name:"Paul",age:55})


MATCH(n:Person)
RETURN n.name,
CASE n.age
WHEN null THEN 'Empty'
WHEN 20 THEN 'Junior'
ELSE n.age
END as age



MATCH(n:Person)
RETURN 
CASE n.name
WHEN 'James' THEN 'Big Boy'
WHEN 'Peter' THEN 'Young Man'
ELSE n.name
END AS name,
n.age


MATCH(n:Person)
RETURN 
CASE n.name
WHEN 'James' THEN 'Big Boy'
WHEN 'Peter' THEN 'Young Man'
ELSE n.name
END AS name,
CASE n.age
WHEN null THEN 'Empty'
WHEN 20 THEN 'Junior'
ELSE n.age
END as age

--------------------------------------------------

Generic form of CASE

create
(:Person{name:"Mike",age:30}),
(:Person{name:"Peter",age:20}),
(:Person{name:"James",age:62}),
(:Person{name:"Kate",age:null}),
(:Person{name:"Dan",age:44}),
(:Person{name:"Vic",age:18}),
(:Person{name:"Eric",age:null}),
(:Person{name:"Tony",age:40}),
(:Person{name:"Rose",age:33}),
(:Person{name:"Paul",age:55})


MATCH(n:Person)
RETURN
CASE 
WHEN n.age = 18 THEN 1
WHEN n.age < 18 THEN 0
WHEN n.age > 18 THEN 2
ELSE -1
END AS age_weight


MATCH(n:Person)
RETURN
CASE 
WHEN n.age > 29 AND n.age < 41 THEN 5
WHEN n.age < 30 AND n.age > 17 THEN 4
WHEN n.age > 40 THEN 6
ELSE 3
END AS Age_Mark

--------------------------------------------------

Set Properties using CASE

MATCH(n:Movie)
WITH  n,
CASE n.released
WHEN 2007 THEN 1
WHEN 2008 THEN 2
WHEN 2009 THEN 3
WHEN 2012 THEN 4
ELSE 0
END AS releasedCode
SET n.releasedCode = releasedCode 

match(n:Movie)
return n.released

match(n:Movie)
return n.released
order by n.released desc

--------------------------------------------------