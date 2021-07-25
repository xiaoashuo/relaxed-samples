DELETE FROM user;

INSERT INTO user (id, pid, name) VALUES
(1, 1, 'Jone'),(2, 1, 'Jack'),(3, 1, 'Tom'),
(4, 2, 'Sandy'),(5, 2, 'Billie');

INSERT INTO user_addr (id, USER_ID, name) VALUES
(1, 1, 'addr1'),(2,2,'addr2');