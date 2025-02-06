CREATE TABLE RULE
(
    id          int primary key,
    rule_name   nvarchar(1024),
    create_by   nvarchar(1024),
    update_by   nvarchar(1024),
    create_time timestamp default current_timestamp,
    update_time timestamp default current_timestamp
);

CREATE TABLE RULE2
(
    id          int primary key,
    rule_name   nvarchar(1024),
    create_by   nvarchar(1024),
    update_by   nvarchar(1024),
    create_time timestamp default current_timestamp,
    update_time timestamp default current_timestamp
);
