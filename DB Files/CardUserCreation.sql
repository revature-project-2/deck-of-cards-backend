drop user DeckOfCards cascade;

create user DeckOfCards
    identified by p4ssw0rd
    default tablespace users
    temporary tablespace temp
    quota 10m on users;
    
grant create session to DeckOfCards;
grant create table to DeckOfCards;
grant create view to DeckOfCards;
grant create sequence to DeckOfCards;
grant create trigger to DeckOfCards;
grant create procedure to DeckOfCards;