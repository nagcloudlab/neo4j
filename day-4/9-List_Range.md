
------------------------------------------
List
------------------------------------------

return range(0,10)
return range(4,5)
return range(-6,0)
return range(0,8,2)
return range(-10,0,3)
return range(0,6,-1)
return range(5,0,2)
return range(5,0,-2)


------------------------------------------
Accessing elements in a list
------------------------------------------

return range(0,10)[2]
return range(0,10)[-9]
return range(0,10)[4]
return range(0,10)[-7]

with [4,9,20,50] as a
return a[2]


------------------------------------------
Accessing elements in a list
------------------------------------------

return range(0,10)[0..3]
return range(0,10)[4..10]
return range(0,10)[4..-1]
return range(0,10)[0..7]
return range(0,10)[0..-4] 

return range(0,10)[2..]
return range(0,10)[-3..]
return range(0,10)[..4]
return range(0,10)[..-3]
return range(5,11)[..3]


------------------------------------------
Accessing elements in a list
------------------------------------------

return range(0..10)[6..20]
return range(0..10)[16]


------------------------------------------
Accessing elements in a list
------------------------------------------

return size(range(0,10)[0..6])

with ['a','d','q'] as list 
return size(list) as list