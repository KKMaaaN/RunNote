create table Crowd
(
    id         varchar(40) not null,
    crowdName  varchar(40) not null,
    createTime date        not null,
    avatar     blob        null,
    constraint Group_id_uindex
        unique (id)
);

alter table Crowd
    add primary key (id);

INSERT INTO CH3.Crowd (id, crowdName, createTime, avatar) VALUES ('2b4af970-af1e-46fc-9f47-1272585e77a4', '修改后的社團名', '2021-01-22', 0x);
INSERT INTO CH3.Crowd (id, crowdName, createTime, avatar) VALUES ('6d997208-fb7c-46d9-b47b-63967586f1c9', 'java?????', '2021-01-24', 0x);
INSERT INTO CH3.Crowd (id, crowdName, createTime, avatar) VALUES ('e5baaf72-287e-4950-ae99-3c12d1ac77fb', 'java愛好者社團', '2021-01-21', 0x);