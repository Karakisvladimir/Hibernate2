INSERT INTO clients (name) VALUES
    ('Nina Opoasfjoksa'),
    ('Mike Mitchel'),
    ('Dana International'),
    ('Baba Mila'),
    ('Ded Matvey'),
    ('Gio Tbiliskiy'),
    ('Edik Armany'),
    ('Bruis Villis'),
    ('Arnold Svarz'),
    ('Bibi Netaniahu');

INSERT INTO planets (id, name) VALUES
    ('MARS', 'Mars'),
    ('VENUS', 'Venus'),
    ('EARTH', 'Earth'),
    ('MOON', 'Moon'),
    ('UPITER', 'Upiter');

INSERT INTO tickets (created_at, client_id, from_planet_id, to_planet_id) VALUES
    ('1977-05-25', 1, 'MARS', 'VENUS'),
    ('1977-05-26', 2, 'VENUS', 'EARTH'),
    ('1983-05-25', 3, 'MOON', 'UPITER'),
    ('1980-05-21', 4, 'UPITER', 'MARS'),
    ('1983-05-25', 5, 'EARTH', 'MARS'),
    ('1999-05-19', 6, 'MOON', 'VENUS'),
    ('1977-05-25', 7, 'VENUS', 'UPITER'),
    ('1999-05-19', 8, 'MARS', 'MOON'),
    ('1999-05-19', 9, 'UPITER', 'VENUS'),
    ('1980-05-21', 10, 'EARTH', 'MARS');