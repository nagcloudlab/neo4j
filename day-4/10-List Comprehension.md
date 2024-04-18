
return [x IN range(0,10)]
return [x IN range(0,10) where x = x]
return [x IN range(0,10) where x%2=1 | x]
return [y IN range(5,11) where x%2=0 | x]
return [y IN range(5,11) where y%2=0 | y]
return [y IN range(5,11) where y%2=0 | y-2]
return [y IN range(5,11) where y%2=0 | y^2]
return [y IN range(5,11) where y%2=0 | toInteger(y^2)]


------------------------------------------

return [x IN range(0,10) where x%2=1]

return [y IN range(5,11)|y]

return [y IN range(5,11)|y*2]

return [x IN range(0,10) where x%2=1| x][0]

return [x IN range(0,10) where x%2=1| x][2]

return [x IN range(0,10) where x%2=1| x], [x IN range(0,10) where x%2=1| x][2]

return [y IN range(5,11)|y]

return [y IN range(5,11)|y][3]

return [y IN range(5,11)|y][0..3]

return [y IN range(0,10000)]

match(T{name:"Tom Hanks"})
return [(T)-->(m:Movie) where m.title CONTAINS 'a'| m.released][3..]

match(T{name:"Tom Hanks"})
return [(T)-->(m:Movie) where m.title CONTAINS 'a'| m.released][3]


------------------------------------------

match(T{name:"Tom Hanks"})
return [(T)-->(m:Movie) where m.title CONTAINS 'a'| m.released] as Output

match(T{name:"Tom Hanks"})
return [(T)-->(m:Movie) where m.title CONTAINS 'a'| m.title] as title, [(T)-->(m:Movie) where m.title CONTAINS 'a'| m.released] as released_date

match(T{name:"Tom Hanks"})
return [(T)-->(m:Movie)<-[:ACTED_IN]-(p:Person) |p.name] 