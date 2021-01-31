create table BlogAndUser
(
    Blog_id varchar(40) not null
        primary key,
    User_id varchar(40) not null,
    constraint BlogAndUser_Blog_id_fk
        foreign key (Blog_id) references Blog (id),
    constraint BlogAndUser_User_id_fk
        foreign key (User_id) references User (id)
);

INSERT INTO CH3.BlogAndUser (Blog_id, User_id) VALUES ('5a0d875c-b6e9-4ffc-8c5b-6130a71806e6', '0f7e9831-a339-447a-a276-13be4bd933a3');
INSERT INTO CH3.BlogAndUser (Blog_id, User_id) VALUES ('e91c6323-d2af-42c3-8076-9ed69e0f58d2', '0f7e9831-a339-447a-a276-13be4bd933a3');