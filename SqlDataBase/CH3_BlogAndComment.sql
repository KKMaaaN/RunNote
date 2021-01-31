create table BlogAndComment
(
    Blog_id    varchar(40) not null,
    Comment_id varchar(40) not null
        primary key,
    constraint BlogAndComment_Blog_id_fk
        foreign key (Blog_id) references Blog (id),
    constraint BlogAndComment_Comment_id_fk
        foreign key (Comment_id) references Comment (id)
);

INSERT INTO CH3.BlogAndComment (Blog_id, Comment_id) VALUES ('5a0d875c-b6e9-4ffc-8c5b-6130a71806e6', '06cb73f5-570d-4d77-8bc5-32f1f70223dc');
INSERT INTO CH3.BlogAndComment (Blog_id, Comment_id) VALUES ('5a0d875c-b6e9-4ffc-8c5b-6130a71806e6', '389d7931-830b-49cd-8feb-df090dcbb1e8');
INSERT INTO CH3.BlogAndComment (Blog_id, Comment_id) VALUES ('5a0d875c-b6e9-4ffc-8c5b-6130a71806e6', 'df9e1616-676d-4af7-8225-75ffd7d463df');