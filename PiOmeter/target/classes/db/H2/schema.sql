DROP TABLE web_requests;
DROP TABLE locations;

CREATE TABLE locations (
	location_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	name varchar(50) NOT NULL,
	numberofgoodhits integer,
	numberofbadhits integer,
	averageduration double,
	PRIMARY KEY (location_id)
);	

CREATE TABLE web_requests (
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	requesturl varchar(50) NOT NULL,
	startdate date NOT NULL,
	enddate date NOT NULL,
	success boolean,
	location_id integer,
	PRIMARY KEY (id),
	FOREIGN KEY (location_id) REFERENCES locations(location_id)
);	

 
