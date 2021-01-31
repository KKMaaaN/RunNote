create table User
(
    id           varchar(40)        not null,
    name         varchar(40)        not null,
    gender       tinyint default -1 null,
    email        varchar(40)        null,
    phoneNumber  varchar(40)        not null,
    passWord     varchar(40)        not null,
    nationality  varchar(40)        not null,
    introduction varchar(80)        not null,
    createTime   date               not null,
    avatar       blob               null,
    constraint User_email_uindex
        unique (email),
    constraint User_id_uindex
        unique (id),
    constraint User_phoneNumber_uindex
        unique (phoneNumber)
);

INSERT INTO CH3.User (id, name, gender, email, phoneNumber, passWord, nationality, introduction, createTime, avatar) VALUES ('0f7e9831-a339-447a-a276-13be4bd933a3', 'kould', 1, '2815680434@qq.com', '15626956201', '123456', 'China', '00后java後端程序員', '2021-01-22', 0x);
INSERT INTO CH3.User (id, name, gender, email, phoneNumber, passWord, nationality, introduction, createTime, avatar) VALUES ('15addcbf-f339-418f-a5b8-f115a65e89b9', 'kould', 1, '2815680435@qq.com', '15626956202', '123456', 'China', '00?java?????', '2021-01-22', 0x);
INSERT INTO CH3.User (id, name, gender, email, phoneNumber, passWord, nationality, introduction, createTime, avatar) VALUES ('99f9ba9b-cea1-42cb-b601-51b0911e58a5', '更新后的名字', 0, '2222222@qq.com', '13750015609', '123456', 'CN', '一個新用戶的簡介', '2021-01-22', 0x);