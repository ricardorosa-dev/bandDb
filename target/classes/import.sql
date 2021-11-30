INSERT INTO band (name, genre, year) VALUES ('Tool', 'rock', 1990);
INSERT INTO band (name, genre, year) VALUES ('Soen', 'progressive metal', 2010);

INSERT INTO album (name, released, band_id) VALUES ('Undertow', 1993, 1);
INSERT INTO album (name, released, band_id) VALUES ('AEnima', 1996, 1);
INSERT INTO album (name, released, band_id) VALUES ('Lateralus', 2001, 1);
INSERT INTO album (name, released, band_id) VALUES ('10,000 Days', 2006, 1);
INSERT INTO album (name, released, band_id) VALUES ('Fear Inoculum', 2019, 1);
INSERT INTO album (name, released, band_id) VALUES ('Cognitive', 2012, 2);
INSERT INTO album (name, released, band_id) VALUES ('Tellurian', 2014, 2);
INSERT INTO album (name, released, band_id) VALUES ('Lykaia', 2017, 2);
INSERT INTO album (name, released, band_id) VALUES ('Lotus', 2019, 2);
INSERT INTO album (name, released, band_id) VALUES ('Imperial', 2021, 2);

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

INSERT INTO musician_instruments (musician_id, instrument_id) VALUES (1, 2);
INSERT INTO musician_instruments (musician_id, instrument_id) VALUES (2, 3);
INSERT INTO musician_instruments (musician_id, instrument_id) VALUES (3, 1);
INSERT INTO musician_instruments (musician_id, instrument_id) VALUES (4, 4);
INSERT INTO musician_instruments (musician_id, instrument_id) VALUES (5, 1);
INSERT INTO musician_instruments (musician_id, instrument_id) VALUES (6, 2);
INSERT INTO musician_instruments (musician_id, instrument_id) VALUES (7, 3);
INSERT INTO musician_instruments (musician_id, instrument_id) VALUES (8, 4);
INSERT INTO musician_instruments (musician_id, instrument_id) VALUES (9, 5);

INSERT INTO band_musician (band_id, musician_id, joined, role) VALUES (1, 1, 1990, 'vocals');
INSERT INTO band_musician (band_id, musician_id, joined, role) VALUES (1, 2, 1990, 'guitars');
INSERT INTO band_musician (band_id, musician_id, joined, role) VALUES (1, 3, 1990, 'drums');
INSERT INTO band_musician (band_id, musician_id, joined, role) VALUES (1, 4, 1995, 'bass');
INSERT INTO band_musician (band_id, musician_id, joined, role) VALUES (2, 5, 2010, 'drums');
INSERT INTO band_musician (band_id, musician_id, joined, role) VALUES (2, 6, 2010, 'vocals');
INSERT INTO band_musician (band_id, musician_id, joined, role) VALUES (2, 7, 2018, 'guitar');
INSERT INTO band_musician (band_id, musician_id, joined, role) VALUES (2, 8, 2020, 'bass');
INSERT INTO band_musician (band_id, musician_id, joined, role) VALUES (2, 9, 2014, 'keyboards');

INSERT INTO website (url, visits_Per_Month, online_Store, BAND_ID) VALUES ('https://toolband.com', 1400, true, 1);
INSERT INTO website (url, visits_Per_Month, online_Store, BAND_ID) VALUES ('https://soenmusic.com', 300, true, 2);
