--
--

PRAGMA foreign_keys = ON;

CREATE TABLE person (
  id          INTEGER PRIMARY KEY ASC,
  name        TEXT,
  sorted_name TEXT
);
CREATE INDEX person_idx ON person(name);


CREATE TABLE work (
  id        INTEGER PRIMARY KEY ASC,
  name      TEXT,
  media_type INTEGER,

  FOREIGN KEY(media_type) REFERENCES media_types(id)
);


CREATE TABLE media_types (
  id          INTEGER PRIMARY KEY ASC,
  parent_type INTEGER,
  name        TEXT
);

INSERT INTO media_types (id,parent_type,name) values( 1,0,"audio");
INSERT INTO media_types (id,parent_type,name) values( 2,0,"software");
INSERT INTO media_types (id,parent_type,name) values( 3,0,"image");
INSERT INTO media_types (id,parent_type,name) values( 4,0,"print");
INSERT INTO media_types (id,parent_type,name) values( 5,0,"video");

INSERT INTO media_types (id,parent_type,name) values( 6,1,"audiobook");
INSERT INTO media_types (id,parent_type,name) values( 7,1,"music");

INSERT INTO media_types (id,parent_type,name) values( 8,2,"application");
INSERT INTO media_types (id,parent_type,name) values( 9,2,"game");
INSERT INTO media_types (id,parent_type,name) values(10,2,"operating system");

INSERT INTO media_types (id,parent_type,name) values(11,3,"artwork");
INSERT INTO media_types (id,parent_type,name) values(12,3,"graphic");
INSERT INTO media_types (id,parent_type,name) values(13,3,"photo");

INSERT INTO media_types (id,parent_type,name) values(14,4,"book");
INSERT INTO media_types (id,parent_type,name) values(15,4,"comic");
INSERT INTO media_types (id,parent_type,name) values(16,4,"magazine");

INSERT INTO media_types (id,parent_type,name) values(17,5,"clip");
INSERT INTO media_types (id,parent_type,name) values(18,5,"home video");
INSERT INTO media_types (id,parent_type,name) values(19,5,"movie");
INSERT INTO media_types (id,parent_type,name) values(20,5,"tv episode");


CREATE TABLE system_messages (
  timestamp INTEGER,
  reporter  TEXT,
  content   TEXT
);
CREATE INDEX system_messages_idx ON system_messages(timestamp);