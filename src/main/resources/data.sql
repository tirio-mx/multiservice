DROP TABLE IF EXISTS TEST;

CREATE TABLE TEST (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250) NOT NULL
);

INSERT INTO TEST (description) VALUES
  ('Description 1'),
  ('Description 2');
