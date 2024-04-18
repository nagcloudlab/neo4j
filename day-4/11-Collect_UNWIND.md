match(n:Person)
return n.name

match(n:Person)
return collect(n.name)

--------------------------------------------------


unwind [2, 4, 5, 6] as u
return u


--------------------------------------------------

with [1, 2, 4, 8] as list
unwind list as l
return l

--------------------------------------------------

WITH [2,4,4,8,9,9,20] as list
UNWIND list AS rows
WITH DISTINCT rows as dr
RETURN COLLECT(dr) as new_list

WITH [2,4,4,8,9,9,20] as list
UNWIND list AS rows
WITH DISTINCT rows 
RETURN COLLECT(rows) as new_list

--------------------------------------------------

with 
[2,4,6,7] as a,
[17,18,19] as b
UNWIND (a+b) as rows
RETURN rows


with 
[2,4,6,7] as a,
[17,18,19] as b
UNWIND (a+b) as rows
RETURN collect(rows) as list


--------------------------------------------------

WITH [2,4,6] as p
UNWIND p as pp
UNWIND pp as pt
UNWIND pt as pk
return pk

WITH [2,[2,4],[4,8],6] as list
UNWIND list as new_List
UNWIND new_List as L
RETURN L as result

WITH [2,[2,4],[4,8],6] as list
UNWIND list as new_List
RETURN new_List

WITH [2,[2,4],[4,8],6] as list
UNWIND list as new_List
UNWIND new_List as L
RETURN L as result


WITH [2,[4,8,[2,4,7]],8,9] as L1
UNWIND L1 as L2
UNWIND L2 as L3
UNWIND L3 as L4
RETURN L4 as Result