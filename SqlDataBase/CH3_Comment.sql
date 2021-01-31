create table Comment
(
    id         varchar(40) not null,
    content    text        not null,
    createTime date        not null,
    constraint Comment_id_uindex
        unique (id)
);

alter table Comment
    add primary key (id);

INSERT INTO CH3.Comment (id, content, createTime) VALUES ('06cb73f5-570d-4d77-8bc5-32f1f70223dc', '這篇Blog真不錯', '2021-01-21');
INSERT INTO CH3.Comment (id, content, createTime) VALUES ('389d7931-830b-49cd-8feb-df090dcbb1e8', '更新后的評論', '2021-01-21');
INSERT INTO CH3.Comment (id, content, createTime) VALUES ('df9e1616-676d-4af7-8225-75ffd7d463df', '??Blog???', '2021-01-24');