INSERT INTO album (name, released) VALUES ('Undertow', 1993);
INSERT INTO album (name, released) VALUES ('AEnima', 1996);
INSERT INTO album (name, released) VALUES ('Lateralus', 2001);
INSERT INTO album (name, released) VALUES ('10,000 Days', 2006);
INSERT INTO album (name, released) VALUES ('Fear Inoculum', 2019);
INSERT INTO album (name, released) VALUES ('Cognitive', 2012);
INSERT INTO album (name, released) VALUES ('Tellurian', 2014);
INSERT INTO album (name, released) VALUES ('Lykaia', 2017);
INSERT INTO album (name, released) VALUES ('Lotus', 2019);
INSERT INTO album (name, released) VALUES ('Imperial', 2021);

INSERT INTO band (name, genre, year) VALUES ('Tool', 'rock', 1990);
INSERT INTO band (name, genre, year) VALUES ('Soen', 'progressive metal', 2010);

INSERT INTO instrument (name, category) VALUES ('drums', 'idiophone');
INSERT INTO instrument (name, category) VALUES ('voice', 'aerophone');
INSERT INTO instrument (name, category) VALUES ('guitar', 'chordophone');
INSERT INTO instrument (name, category) VALUES ('bass', 'chordophone');
INSERT INTO instrument (name, category) VALUES ('keyboards', 'electrophone');

INSERT INTO musician (name, Date_of_Birth) VALUES ('Maynard James Keenan', TO_DATE('17-04-1964', 'dd-MM-yyyy'));
INSERT INTO musician (name, Date_of_Birth) VALUES ('Adam Jones', TO_DATE('15-01-1965', 'dd-MM-yyyy'));
INSERT INTO musician (name, Date_of_Birth) VALUES ('Danny Carey', TO_DATE('10-05-1961', 'dd-MM-yyyy'));
INSERT INTO musician (name, Date_of_Birth) VALUES ('Justin Chancellor', TO_DATE('19-09-1971', 'dd-MM-yyyy'));
INSERT INTO musician (name, Date_of_Birth) VALUES ('Martin Lopez', TO_DATE('20-05-1978', 'dd-MM-yyyy'));
INSERT INTO musician (name, Date_of_Birth) VALUES ('Joel Ekelöf', TO_DATE('01-08-1980', 'dd-MM-yyyy'));
INSERT INTO musician (name, Date_of_Birth) VALUES ('Cody Lee Ford', TO_DATE('01-01-2000', 'dd-MM-yyyy'));
INSERT INTO musician (name, Date_of_Birth) VALUES ('Oleksii Kobel', TO_DATE('01-01-2000', 'dd-MM-yyyy'));
INSERT INTO musician (name, Date_of_Birth) VALUES ('Lars Åhlund', TO_DATE('01-01-2000', 'dd-MM-yyyy'));

INSERT INTO website (url, visits_Per_Month, online_Store) VALUES ('https://toolband.com', 1400, true);
INSERT INTO website (url, visits_Per_Month, online_Store) VALUES ('https://soenmusic.com', 300, true);
