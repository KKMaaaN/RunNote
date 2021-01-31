create table CrowdAndUser
(
    Crowd_id varchar(40) not null,
    User_id  varchar(40) not null,
    constraint CrowdAndUser_Crowd_id_fk
        foreign key (Crowd_id) references Crowd (id),
    constraint CrowdAndUser_User_id_fk
        foreign key (User_id) references User (id)
);

INSERT INTO CH3.CrowdAndUser (Crowd_id, User_id) VALUES ('2b4af970-af1e-46fc-9f47-1272585e77a4', '0f7e9831-a339-447a-a276-13be4bd933a3');
INSERT INTO CH3.CrowdAndUser (Crowd_id, User_id) VALUES ('6d997208-fb7c-46d9-b47b-63967586f1c9', '15addcbf-f339-418f-a5b8-f115a65e89b9');