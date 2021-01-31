create table Blog
(
    id           varchar(40) not null,
    title        varchar(40) not null,
    introduction varchar(80) not null,
    content      text        not null,
    createTime   date        not null,
    image        blob        null,
    constraint Blog_id_uindex
        unique (id)
);

alter table Blog
    add primary key (id);

INSERT INTO CH3.Blog (id, title, introduction, content, createTime, image) VALUES ('5a0d875c-b6e9-4ffc-8c5b-6130a71806e6', '一篇Blog的標題', '某些事情的開始', 'Blog的正文', '2021-01-21', null);
INSERT INTO CH3.Blog (id, title, introduction, content, createTime, image) VALUES ('b05098a3-cf7d-4b81-8f4f-5c352c80a86e', '更新后的Blog標題', '更新后的簡介', '更新后的正文', '2021-01-21', 0x);
INSERT INTO CH3.Blog (id, title, introduction, content, createTime, image) VALUES ('e91c6323-d2af-42c3-8076-9ed69e0f58d2', '??Blog???', '???????', 'Blog???', '2021-01-24', null);