--
--

PRAGMA foreign_keys = ON;

CREATE TABLE system_messages (
  timestamp INTEGER,
  reporter  TEXT,
  content   TEXT
);
CREATE INDEX system_messages_idx ON system_messages(timestamp);

CREATE TABLE media_types (
  id          INTEGER PRIMARY KEY ASC,
  parent_type INTEGER,
  name        TEXT
);

INSERT INTO media_types (id,parent_type,name) VALUES( 1,0,"audio");
INSERT INTO media_types (id,parent_type,name) VALUES( 2,0,"software");
INSERT INTO media_types (id,parent_type,name) VALUES( 3,0,"image");
INSERT INTO media_types (id,parent_type,name) VALUES( 4,0,"print");
INSERT INTO media_types (id,parent_type,name) VALUES( 5,0,"video");

INSERT INTO media_types (id,parent_type,name) VALUES( 6,1,"audiobook");
INSERT INTO media_types (id,parent_type,name) VALUES( 7,1,"music");

INSERT INTO media_types (id,parent_type,name) VALUES( 8,2,"application");
INSERT INTO media_types (id,parent_type,name) VALUES( 9,2,"game");
INSERT INTO media_types (id,parent_type,name) VALUES(10,2,"operating system");

INSERT INTO media_types (id,parent_type,name) VALUES(11,3,"artwork");
INSERT INTO media_types (id,parent_type,name) VALUES(12,3,"graphic");
INSERT INTO media_types (id,parent_type,name) VALUES(13,3,"photo");

INSERT INTO media_types (id,parent_type,name) VALUES(14,4,"book");
INSERT INTO media_types (id,parent_type,name) VALUES(15,4,"comic");
INSERT INTO media_types (id,parent_type,name) VALUES(16,4,"magazine");

INSERT INTO media_types (id,parent_type,name) VALUES(17,5,"clip");
INSERT INTO media_types (id,parent_type,name) VALUES(18,5,"home video");
INSERT INTO media_types (id,parent_type,name) VALUES(19,5,"movie");
INSERT INTO media_types (id,parent_type,name) VALUES(20,5,"tv episode");


CREATE TABLE metadata (
  id INTEGER PRIMARY KEY ASC,
  key TEXT,
  value TEXT
);
CREATE INDEX metadata_idx ON metadata(key);


CREATE TABLE people (
  id          INTEGER PRIMARY KEY ASC,
  name        TEXT,
  sorted_name TEXT
);
CREATE INDEX people_idx ON people(name);

CREATE TABLE people_metadata (
  person_id  INTEGER REFERENCES people(id),
  metadata_id INTEGER REFERENCES metadata(id),

  PRIMARY KEY(person_id,metadata_id)
);


CREATE TABLE works (
  id        INTEGER PRIMARY KEY ASC,
  name      TEXT,
  media_type INTEGER,

  FOREIGN KEY(media_type) REFERENCES media_types(id)
);
CREATE INDEX works_idx ON works(name);

CREATE TABLE works_metadata (
  work_id     INTEGER REFERENCES works(id),
  metadata_id INTEGER REFERENCES metadata(id),

  PRIMARY KEY(work_id,metadata_id)
);

CREATE TABLE works_creators (
  work_id   INTEGER REFERENCES works(id),
  person_id INTEGER REFERENCES people(id),

  PRIMARY KEY(work_id,person_id)
);

-- --------------------------------------------------------------------------
-- THE END
