create table CommentAndUser
(
    Comment_id varchar(40) not null,
    User_id    varchar(40) not null,
    constraint CommentAndUser_Comment_id_uindex
        unique (Comment_id),
    constraint CommentAndUser_Comment_id_fk
        foreign key (Comment_id) references Comment (id),
    constraint CommentAndUser_User_id_fk
        foreign key (User_id) references User (id)
);

alter table CommentAndUser
    add primary key (Comment_id);

INSERT INTO CH3.CommentAndUser (Comment_id, User_id) VALUES ('06cb73f5-570d-4d77-8bc5-32f1f70223dc', '0f7e9831-a339-447a-a276-13be4bd933a3');
INSERT INTO CH3.CommentAndUser (Comment_id, User_id) VALUES ('df9e1616-676d-4af7-8225-75ffd7d463df', '15addcbf-f339-418f-a5b8-f115a65e89b9');