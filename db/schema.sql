CREATE SCHEMA better;

CREATE USER better_user@'%'
  IDENTIFIED BY '1q2aw3zse4xdrcfv';

GRANT ALL ON better.* TO better_user@'%'
WITH GRANT OPTION;

USE better;