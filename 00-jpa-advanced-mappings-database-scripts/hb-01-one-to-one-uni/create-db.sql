CREATE TABLE instructor_detail (
  id SERIAL NOT NULL,
  youtube_channel varchar(128) DEFAULT NULL,
  hobby varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE instructor (
  id SERIAL NOT NULL,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  instructor_detail_id int DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK_DETAIL_idx (instructor_detail_id),
  CONSTRAINT FK_DETAIL FOREIGN KEY (instructor_detail_id) REFERENCES instructor_detail (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE INDEX FK_DETAIL_idx ON instructor(instructor_detail_id);