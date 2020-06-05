drop table GAME_TYPE cascade constraints;
drop table PLAYER cascade constraints;
drop table GAME cascade constraints;
drop table GAME_PLAYER cascade constraints;


drop sequence game_type_seq;
drop sequence player_seq;
drop sequence game_seq;
drop sequence game_player_seq;

create table game_type
(
  game_type_id number(10) primary key,
  type_name varchar2(20) unique not null
);

create table player
(
    player_id number(10) primary key,
    username varchar2(20) unique not null,
    passwrd varchar2(20) not null,
    first_name varchar2(20) not null,
    last_name varchar2(20) not null,
    balance number(12, 2) not null
);

create table game
(
    game_id number(10) primary key,
    deck_id varchar2(20) not null,
    game_type_id number(10) not null,
    score number(4),
    winner_id number(10),
    amount_won number(12, 2),
    constraint fk_game_type foreign key (game_type_id) references game_type(game_type_id),
    constraint fk_game_winner foreign key (winner_id) references player(player_id)
);

create table game_player (
    game_player_id number(10) primary key,
    game_id number(10),
    player_id number(10),
    constraint fk_game_player_game foreign key (game_id) references game(game_id),
    constraint fk_game_player_player foreign key (player_id) references player(player_id)
);

create sequence game_type_seq;
create sequence player_seq;
create sequence game_seq;
create sequence game_player_seq;

commit;