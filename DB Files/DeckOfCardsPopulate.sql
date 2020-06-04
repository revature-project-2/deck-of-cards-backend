create or replace trigger game_type_pk_trig
before insert or update on game_type
for each row
begin
	if INSERTING then
		select game_type_seq.nextval into :new.game_type_id from dual;
	elsif UPDATING then
		select :old.game_type_id into :new.game_type_id from dual;
  end if;
end;
/

insert into game_type (type_name)
values ('Blackjack');

insert into game_type (type_name)
values ('Solitaire');

insert into player (player_id, username, passwrd, first_name, last_name, balance)
values (1, 'snichols', 'pass', 'Sierra', 'Nichols', 10000);

insert into game (game_id, player_id, deck_id, game_type_id, amount_won)
values (1, 1, '1a2b3c', 1, 2000);

commit;