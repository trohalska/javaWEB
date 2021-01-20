sudo -u postgres -i

psql postgres;
CREATE USER root WITH PASSWORD 'qwerty';
CREATE DATABASE [your login];
CREATE DATABASE cashflow;
exit;

-- изменить права юзера
=# ALTER USER role_specification WITH OPTION1 OPTION2 OPTION3;