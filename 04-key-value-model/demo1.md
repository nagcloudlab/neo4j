

<!-- redis -->

```bash
docker run -d -p 6379:6379 --name redis redis
```

```bash
docker exec -it redis redis-cli
```

```bash
set ping "pong"
```

```bash
get ping
```

```bash
del ping
```
