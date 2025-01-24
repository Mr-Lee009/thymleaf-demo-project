CREATE TABLE token
(
    id bigint primary key auto_increment,
    access_token nvarchar(1024),
    refresh_token nvarchar(1024),
    create_by nvarchar(1024),
    update_by nvarchar(1024),
    create_time timestamp default current_timestamp,
    update_time timestamp default current_timestamp
);
