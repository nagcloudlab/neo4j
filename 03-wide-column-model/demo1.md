

<!-- run cassandra docker container -->
```bash
docker run -d -p 9042:9042 --name cassandra cassandra
```

<!-- connect to cassandra container -->
```bash
docker exec -it cassandra cqlsh
```

<!-- create keyspace -->
```sql
CREATE KEYSPACE demo WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 1};
```

<!-- use keyspace -->
```sql
USE demo;
```

<!-- create table -->
```sql
CREATE TABLE users (
    id UUID PRIMARY KEY,
    name TEXT,
    email TEXT
);
```

insert 10 rows into the table
```sql
INSERT INTO users (id, name, email) VALUES (uuid(), 'Alice', 'who@mail.com');
INSERT INTO users (id, name, email) VALUES (uuid(), 'Bob', 'who@mail.com');
```

<!-- select all rows from the table -->
```sql
SELECT * FROM users;
```


<!-- CAP theorem -->

### CAP theorem

- Consistency
- Availability
- Partition tolerance

Cassandra is an AP system.


