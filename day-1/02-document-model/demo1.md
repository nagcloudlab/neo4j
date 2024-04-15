

<!-- - mongodb - document-model -->


```bash
docker run -d -p 27017:27017 --name mongodb mongo
```

```bash
docker exec -it mongodb mongosh
```

<!-- create items collection and insert many documents -->

```javascript
use ecommerce-db
db.items.deleteMany({})
db.items.insertMany([
  { _id:1, name: 'Samsung Galaxy S10', price: 799.99, stock: 100 },
  { _id:2,name: 'iPhone 11', price: 999.99, stock: 50 },
  { _id:3,name: 'Google Pixel 4', price: 799.99, stock: 75 }
])
```

<!-- create orders collection and insert 2 documents -->

```javascript

db.orders.deleteMany({})
db.orders.insertMany([
  { _id:1, items: [ { _id:1, qty: 2 }, { _id:2, qty: 1 } ] },
  { _id:2, items: [ { _id:2, qty: 1 }, { _id:3, qty: 1 } ] }
])

```

create users collection and insert 1 documents

```javascript
db.users.deleteMany({})
db.users.insertOne({ _id:1, name: 'John Doe', orders: [ { _id:1 }, { _id:2 } ] })
```


```javascript
db.items.find()
db.orders.find()
db.users.find()
```


<!-- find total orders amount for user with name 'John Doe' -->

```javascript
db.users.aggregate([
  { $match: { name: 'John Doe' } },
  { $lookup: {
    from: 'orders',
    localField: 'orders._id',
    foreignField: '_id',
    as: 'orders'
  } },
  { $unwind: '$orders' },
  { $lookup: {
    from: 'items',
    localField: 'orders.items._id',
    foreignField: '_id',
    as: 'orders.items'
  } },
  { $unwind: '$orders.items' },
  { $addFields: {
    'orders.items.total': { $multiply: [ '$orders.items.price', '$orders.items.qty' ] }
  } },
  { $group: {
    _id: '$_id',
    name: { $first: '$name' },
    total: { $sum: '$orders.items.total' }
  } }
])
```