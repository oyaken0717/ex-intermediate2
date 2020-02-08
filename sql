CREATE TABLE teams(

	id serial primary key,
	league_name text,
	team_name text,
	
	headquarters text,
	inauguration text,
	history text

);

CREATE TABLE hotels(
	
  id serial primary key,
	area_name text,
	hotel_name text,
	address text,
	nearest_station text,
	price integer,
	parking text

);