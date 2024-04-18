

LOAD CSV WITH HEADERS FROM "file:///student.csv" AS row
RETURN row


LOAD CSV FROM "file:///student.csv" AS row
RETURN row

---------------------------------------------------------------

LOAD CSV FROM "https://raw.githubusercontent.com/neo4j-contrib/northwind-neo4j/master/data/shippers.csv" as row
RETURN row


LOAD CSV WITH HEADERS FROM "https://raw.githubusercontent.com/neo4j-contrib/northwind-neo4j/master/data/shippers.csv" as row
RETURN row

---------------------------------------------------------------

CSV with line number


LOAD CSV FROM "file:///student.csv" AS row
RETURN linenumber() as numbers, row


vs



LOAD CSV WITH HEADERS FROM "file:///student.csv" AS row
RETURN linenumber() as numbers, row

---------------------------------------------------------------

LOAD CSV FROM "https://raw.githubusercontent.com/neo4j-contrib/northwind-neo4j/master/data/shippers.csv" AS row
RETURN  DISTINCT file()