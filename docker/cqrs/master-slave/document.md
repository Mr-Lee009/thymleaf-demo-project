# Config Master
```mysql
# tao user
DROP USER IF EXISTS 'repl'@'%';
CREATE USER 'repl'@'%' IDENTIFIED WITH mysql_native_password BY 'replpass';
GRANT REPLICATION SLAVE ON *.* TO 'repl'@'%';
FLUSH PRIVILEGES;

FLUSH TABLES WITH READ LOCK;
SHOW MASTER STATUS;

# unlock khi dump DB xong va import DB vao SALVE
UNLOCK TABLES;

# show log
SHOW BINLOG EVENTS IN 'binlog.000005' ;
```
# Config Slave

```mysql

SET GLOBAL server_id=2;
STOP SLAVE;
CHANGE MASTER TO MASTER_HOST='10.1.37.239',
    MASTER_USER='repl',
    MASTER_PASSWORD='replpass',
    MASTER_PORT = 3307,
    MASTER_LOG_FILE='binlog.000005',
    MASTER_LOG_POS=2477,
    MASTER_CONNECT_RETRY=10;
START SLAVE;

SHOW SLAVE STATUS;

```
