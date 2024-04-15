


```bash
mysql -u root -p 
create database social_network;
use social_network;
show tables;
```


-- create person table

```sql
CREATE TABLE person (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL
);
```

--- insert data into person table , 10 rows

```sql
INSERT INTO person (name, age) VALUES ('Alice', 25);
INSERT INTO person (name, age) VALUES ('Bob', 30);
INSERT INTO person (name, age) VALUES ('Charlie', 35);
INSERT INTO person (name, age) VALUES ('David', 40);
INSERT INTO person (name, age) VALUES ('Eve', 45);
INSERT INTO person (name, age) VALUES ('Frank', 50);
INSERT INTO person (name, age) VALUES ('Grace', 55);
INSERT INTO person (name, age) VALUES ('Heidi', 60);
INSERT INTO person (name, age) VALUES ('Ivan', 65);
INSERT INTO person (name, age) VALUES ('Judy', 70);
```

-- create friendship table

```sql
CREATE TABLE friendship (
    person1_id INT NOT NULL,
    person2_id INT NOT NULL,
    PRIMARY KEY (person1_id, person2_id),
    FOREIGN KEY (person1_id) REFERENCES person(id),
    FOREIGN KEY (person2_id) REFERENCES person(id)
);
```

-- insert data into friendship table

```sql
INSERT INTO friendship (person1_id, person2_id) VALUES (1, 2);
INSERT INTO friendship (person1_id, person2_id) VALUES (1, 3);
INSERT INTO friendship (person1_id, person2_id) VALUES (1, 4);
INSERT INTO friendship (person1_id, person2_id) VALUES (2, 3);
INSERT INTO friendship (person1_id, person2_id) VALUES (2, 4);
INSERT INTO friendship (person1_id, person2_id) VALUES (3, 4);
INSERT INTO friendship (person1_id, person2_id) VALUES (5, 6);
INSERT INTO friendship (person1_id, person2_id) VALUES (5, 7);
INSERT INTO friendship (person1_id, person2_id) VALUES (5, 8);
INSERT INTO friendship (person1_id, person2_id) VALUES (6, 7);
INSERT INTO friendship (person1_id, person2_id) VALUES (6, 8);
INSERT INTO friendship (person1_id, person2_id) VALUES (7, 8);
INSERT INTO friendship (person1_id, person2_id) VALUES (9, 10);
```

-- select Alice's friends

```sql
SELECT p2.name
FROM person p1
JOIN friendship f ON p1.id = f.person1_id
JOIN person p2 ON f.person2_id = p2.id
WHERE p1.name = 'Alice';
```

-- select Alice's friends' friends

```sql
SELECT p3.name
FROM person p1
JOIN friendship f1 ON p1.id = f1.person1_id
JOIN person p2 ON f1.person2_id = p2.id
JOIN friendship f2 ON p2.id = f2.person1_id
JOIN person p3 ON f2.person2_id = p3.id
WHERE p1.name = 'Alice';
```

-- select Alice's friends' friends' friends

```sql
SELECT p4.name
FROM person p1
JOIN friendship f1 ON p1.id = f1.person1_id
JOIN person p2 ON f1.person2_id = p2.id
JOIN friendship f2 ON p2.id = f2.person1_id
JOIN person p3 ON f2.person2_id = p3.id
JOIN friendship f3 ON p3.id = f3.person1_id
JOIN person p4 ON f3.person2_id = p4.id
WHERE p1.name = 'Alice';
```
