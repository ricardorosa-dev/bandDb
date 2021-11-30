INSERT INTO album (name, released) VALUES ('album 1', 2005);
INSERT INTO album (name, released) VALUES ('album 2', 1997);

INSERT INTO band (name, genre, year) VALUES ('band1', 'rock', 1997);
INSERT INTO band (name, genre, year) VALUES ('band2', 'pop', 2005);

INSERT INTO instrument (name, category) VALUES ('guitar', 'chordophone');
INSERT INTO instrument (name, category) VALUES ('violin', 'chordophone');

INSERT INTO musician (name, Date_of_Birth) VALUES ('Bob', TO_DATE('11-07-1997', 'dd-MM-yyyy'));
INSERT INTO musician (name, Date_of_Birth) VALUES ('John', TO_DATE('06-12-1965', 'dd-MM-yyyy'));

INSERT INTO website (url, visits_Per_Month, online_Store) VALUES ('www.band.com', 1400, true);
INSERT INTO website (url, visits_Per_Month, online_Store) VALUES ('www.band2.com.br', 300, false);
