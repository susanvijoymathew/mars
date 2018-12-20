INSERT INTO Role(Role) VALUES('US_PROMO');
INSERT INTO Role(Role) VALUES('MARS_ADMIN');


INSERT INTO User_Details(First_Name, Last_Name, Email_Address, Role_Id)
    VALUES('Susan', 'Mathew', 'susan.vijoy.mathew@gmail.com',
        (SELECT Id FROM Role where Role = 'MARS_ADMIN'));


INSERT INTO Area(Name, Type, Level) VALUES('World', 'Root', 0);

INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Africa', 'Continent', 1, (SELECT Id FROM Area WHERE Name = 'World'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Algeria', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Africa'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Algiers', 'City', 3, (SELECT Id FROM Area WHERE Name = 'Algeria'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Botswana', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Africa'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Gaborone', 'City', 3, (SELECT Id FROM Area WHERE Name = 'Botswana'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Egypt', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Africa'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Cairo', 'City', 3, (SELECT Id FROM Area WHERE Name = 'Egypt'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Ghana', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Africa'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Accra', 'City', 3, (SELECT Id FROM Area WHERE Name = 'Ghana'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Kenya', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Africa'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Nairobi', 'City', 3, (SELECT Id FROM Area WHERE Name = 'Kenya'));

INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Asia', 'Continent', 1, (SELECT Id FROM Area WHERE Name = 'World'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('China', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Asia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Beijing', 'City', 3, (SELECT Id FROM Area WHERE Name = 'China'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('India', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Asia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('New Delhi', 'City', 3, (SELECT Id FROM Area WHERE Name = 'India'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('North Korea', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Asia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Pyongyang', 'City', 3, (SELECT Id FROM Area WHERE Name = 'North Korea'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Kuwait', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Asia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Kuwait City', 'City', 3, (SELECT Id FROM Area WHERE Name = 'Kuwait'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Malaysia', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Asia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Kuala Lumpur', 'City', 3, (SELECT Id FROM Area WHERE Name = 'Malaysia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Russia', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Asia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Moscow', 'City', 3, (SELECT Id FROM Area WHERE Name = 'Russia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Turkey', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Asia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Ankara', 'City', 3, (SELECT Id FROM Area WHERE Name = 'Turkey'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Vietnam', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Asia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Hanoi', 'City', 3, (SELECT Id FROM Area WHERE Name = 'Vietnam'));

INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Europe', 'Continent', 1, (SELECT Id FROM Area WHERE Name = 'World'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Austria', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Europe'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Vienna', 'City', 3, (SELECT Id FROM Area WHERE Name = 'Austria'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Czech Republic', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Europe'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Prague', 'City', 3, (SELECT Id FROM Area WHERE Name = 'Czech Republic'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Denmark', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Europe'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Copenhagen', 'City', 3, (SELECT Id FROM Area WHERE Name = 'Denmark'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('France', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Europe'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Paris', 'City', 3, (SELECT Id FROM Area WHERE Name = 'France'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Germany', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Europe'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Berlin', 'City', 3, (SELECT Id FROM Area WHERE Name = 'Germany'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Italy', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Europe'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Rome', 'City', 3, (SELECT Id FROM Area WHERE Name = 'Italy'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('United Kingdom', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Europe'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('London', 'City', 3, (SELECT Id FROM Area WHERE Name = 'United Kingdom'));

INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('North America', 'Continent', 1, (SELECT Id FROM Area WHERE Name = 'World'));

INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Canada', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'North America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Alberta', 'Province', 3, (SELECT Id FROM Area WHERE Name = 'Canada'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Edmonton', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Alberta'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('British Columbia', 'Province', 3, (SELECT Id FROM Area WHERE Name = 'Canada'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Victoria', 'City', 4, (SELECT Id FROM Area WHERE Name = 'British Columbia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Saskatchewan', 'Province', 3, (SELECT Id FROM Area WHERE Name = 'Canada'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Regina', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Saskatchewan'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Manitoba', 'Province', 3, (SELECT Id FROM Area WHERE Name = 'Canada'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Winnipeg', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Manitoba'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Ontario', 'Province', 3, (SELECT Id FROM Area WHERE Name = 'Canada'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Toronto', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Ontario'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Quebec', 'Province', 3, (SELECT Id FROM Area WHERE Name = 'Canada'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Quebec City', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Quebec'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Nunavut', 'Province', 3, (SELECT Id FROM Area WHERE Name = 'Canada'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Iqaluit', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Nunavut'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Yukon', 'Province', 3, (SELECT Id FROM Area WHERE Name = 'Canada'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Whitehorse', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Yukon'));

INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Mexico', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'North America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Aguascalientes', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Aguascalientes', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Aguascalientes' and Type = 'State'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Baja California', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Mexicali', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Baja California'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Campeche', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('San Francisco de Campeche', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Campeche'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Chiapas', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Tuxtla Gutierrez', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Chiapas'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Chihuahua', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Chihuahua', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Chihuahua' and Type = 'State'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Coahuila', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Saltillo', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Coahuila'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Colima', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Colima', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Colima' and Type = 'State'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Durango', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Victoria de Durango', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Durango'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Guanajuato', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Guanajuato', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Guanajuato' and Type = 'State'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Guerrero', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Chilpancingo de los Bravo', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Guerrero'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Hidalgo', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Pachuca', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Hidalgo'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Jalisco', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Guadalajara', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Jalisco'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Mexico', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Toluca de Lerdo', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'State'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Michoacan', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Morelia', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Michoacan'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Morelos', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Cuernavaca', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Morelos'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Nayarit', 'State', 3, (SELECT Id FROM Area WHERE Name = 'Mexico' and Type = 'Country'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Tepic', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Nayarit'));

INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('United States of America', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'North America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Alabama', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Montgomery', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Alabama'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Alaska', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Juneau', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Alaska'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Arizona', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Phoenix', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Arizona'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Arkansas', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Little Rock', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Arkansas'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('California', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('San Francisco', 'City', 4, (SELECT Id FROM Area WHERE Name = 'California'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Los Angeles', 'City', 4, (SELECT Id FROM Area WHERE Name = 'California'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Sacramento', 'City', 4, (SELECT Id FROM Area WHERE Name = 'California'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Colorado', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Denver', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Colorado'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Connecticut', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Hartford', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Connecticut'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Delaware', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Dover', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Delaware'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Florida', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Tallahassee', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Florida'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Georgia', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Atlanta', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Georgia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Hawaii', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Honolulu', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Hawaii'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Idaho', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Boise', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Idaho'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Illinois', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Schaumburg', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Illinois'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Palatine', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Illinois'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Chicago', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Illinois'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Indiana', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Indianapolis', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Indiana'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Iowa', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Des Moines', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Iowa'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Kansas', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Topeka', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Kansas'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Kentucky', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Frankfurt', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Kentucky'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Louisiana', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Baton Rouge', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Louisiana'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Maine', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Augusta', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Maine'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Maryland', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Annapolis', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Maryland'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Massachusetts', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Boston', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Massachusetts'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Michigan', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Lansing', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Michigan'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Jackson City', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Michigan'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Ann Arbor', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Michigan'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Detroit', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Michigan'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Minnesota', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('St. Paul', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Minnesota'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Mississippi', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Jackson', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Mississippi'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Missouri', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Jefferson City', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Missouri'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Montana', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Helena', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Montana'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Nebraska', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Lincoln', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Nebraska'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Nevada', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Carson City', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Nevada'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('New Hampshire', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Concord', 'City', 4, (SELECT Id FROM Area WHERE Name = 'New Hampshire'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('New Jersey', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Trenton', 'City', 4, (SELECT Id FROM Area WHERE Name = 'New Jersey'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('New Mexico', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Santa Fe', 'City', 4, (SELECT Id FROM Area WHERE Name = 'New Mexico'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('New York', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('New York', 'City', 4, (SELECT Id FROM Area WHERE Name = 'New York'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('North Carolina', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Raleigh', 'City', 4, (SELECT Id FROM Area WHERE Name = 'North Carolina'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('North Dakota', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Bismarck', 'City', 4, (SELECT Id FROM Area WHERE Name = 'North Dakota'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Ohio', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Columbus', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Ohio'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Oklahoma', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Oklahoma City', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Oklahoma'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Oregon', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Salem', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Oregon'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Pennsylvania', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Harrisburg', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Pennsylvania'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Rhode Island', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Providence', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Rhode Island'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('South Carolina', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Columbia', 'City', 4, (SELECT Id FROM Area WHERE Name = 'South Carolina'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('South Dakota', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Pierre', 'City', 4, (SELECT Id FROM Area WHERE Name = 'South Dakota'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Tennessee', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Nashville', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Tennessee'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Texas', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Austin', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Texas'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Utah', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Salt Lake City', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Utah'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Vermont', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Montpelier', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Vermont'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Virginia', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Richmond', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Virginia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Washington', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Olympia', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Washington'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('West Virginia', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Charleston', 'City', 4, (SELECT Id FROM Area WHERE Name = 'West Virginia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Wisconsin', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Madison', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Wisconsin'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Wyoming', 'State', 3, (SELECT Id FROM Area WHERE Name = 'United States of America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Cheyenne', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Wyoming'));

INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('South America', 'Continent', 1, (SELECT Id FROM Area WHERE Name = 'World'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Argentina', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'South America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Buenos Aires', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Argentina'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Brazil', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'South America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Brasilia', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Brazil'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Peru', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'South America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Lima', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Peru'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Suriname', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'South America'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Paramaribo', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Suriname'));

INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Antartica', 'Continent', 1, (SELECT Id FROM Area WHERE Name = 'World'));

INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Oceania', 'Continent', 1, (SELECT Id FROM Area WHERE Name = 'World'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Australia', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Oceania'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Canberra', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Australia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Melbourne', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Australia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Sydney', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Australia'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Fiji', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Oceania'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Suva', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Fiji'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('New Zealand', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Oceania'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Wellington', 'City', 4, (SELECT Id FROM Area WHERE Name = 'New Zealand'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Samoa', 'Country', 2, (SELECT Id FROM Area WHERE Name = 'Oceania'));
INSERT INTO Area(Name, Type, Level, Parent_Id)
    VALUES('Apia', 'City', 4, (SELECT Id FROM Area WHERE Name = 'Samoa'));


INSERT INTO Product(Name, Category) VALUES('Hamburger', 'Sandwich');
INSERT INTO Product(Name, Category) VALUES('Cheeseburger', 'Sandwich');
INSERT INTO Product(Name, Category) VALUES('Chicken Sandwich', 'Sandwich');
INSERT INTO Product(Name, Category) VALUES('Fries', 'Sides');
INSERT INTO Product(Name, Category) VALUES('Salad', 'Sides');
INSERT INTO Product(Name, Category) VALUES('Coffee', 'Drink');
INSERT INTO Product(Name, Category) VALUES('Tea', 'Drink');
INSERT INTO Product(Name, Category) VALUES('Coke', 'Drink');
INSERT INTO Product(Name, Category) VALUES('Lemonade', 'Drink');
INSERT INTO Product(Name, Category) VALUES('Chocolate Chip Cookie',  'susan');
INSERT INTO Product(Name, Category) VALUES('Apple Pie', 'Dessert');
INSERT INTO Product(Name, Category) VALUES('Oreo Milk Shake', 'Dessert');


INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('69 cents cheeseburger', 'Cheeseburger for $0.69 for a limited time.',
        (SELECT Id FROM Area WHERE Name = 'Boise'),
        (SELECT Id FROM Product WHERE Name = 'Hamburger'), --'2018-10-01', '2018-10-21',
        DATEADD('DAY', -20, CURRENT_DATE), DATEADD('DAY', -5, CURRENT_DATE), DATEADD('DAY', -30, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('59 cents hamburger', 'Hamburger for $0.59 for a limited time.',
        (SELECT Id FROM Area WHERE Name = 'Schaumburg'),
        (SELECT Id FROM Product WHERE Name = 'Hamburger'), --'2018-10-01', '2018-10-21',
        DATEADD('DAY', -5, CURRENT_DATE), DATEADD('DAY', +5, CURRENT_DATE), DATEADD('DAY', -30, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('$1 Drinks', 'Any size drink for $1',
        (SELECT Id FROM Area WHERE Name = 'Schaumburg'),
        (SELECT Id FROM Product WHERE Name = 'Coke'),
        DATEADD('DAY', -7, CURRENT_DATE), DATEADD('DAY', +7, CURRENT_DATE), DATEADD('DAY', -30, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('$1 Sandwich', 'Get a Sandwich for $1. Only available through our mobile app',
        (SELECT Id FROM Area WHERE Name = 'Palatine'),
        (SELECT Id FROM Product WHERE Name = 'Hamburger'),
        DATEADD('DAY', -7, CURRENT_DATE), CURRENT_DATE, DATEADD('DAY', -90, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('Buy McCafe, Get 1 for $0.01', 'Buy a medium or large McCafe, get 1 for $0.01. Only through our mobile app',
        (SELECT Id FROM Area WHERE Name = 'Palatine'),
        (SELECT Id FROM Product WHERE Name = 'Coffee'),
        CURRENT_DATE, DATEADD('DAY', +21, CURRENT_DATE), DATEADD('DAY', -14, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('2 for $5 Mix and Match', '2 for $5. Select from Big Mac, Filet-O-Fish, Classic Chicken Sandwich, 10 pc. Chicken McNuggets',
        (SELECT Id FROM Area WHERE Name = 'Chicago'),
        (SELECT Id FROM Product WHERE Name = 'Hamburger'),
        DATEADD('DAY', -1, CURRENT_DATE), CURRENT_DATE, DATEADD('DAY', -14, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('$4.99 20 pc Chicken McNuggets', '20 pc Chicken McNuggets for $4.99',
        (SELECT Id FROM Area WHERE Name = 'Chicago'),
        (SELECT Id FROM Product WHERE Name = 'Chicken Sandwich'),
       CURRENT_DATE, DATEADD('DAY', +1, CURRENT_DATE), DATEADD('DAY', -21, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('$1 Drinks', 'Any size drink for $1',
        (SELECT Id FROM Area WHERE Name = 'Boise'),
        (SELECT Id FROM Product WHERE Name = 'Coke'),
        DATEADD('DAY', +5, CURRENT_DATE), DATEADD('DAY', +20, CURRENT_DATE), DATEADD('DAY', -30, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );


INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('69 cents cheeseburger', 'Cheeseburger for $0.69 for a limited time.',
        (SELECT Id FROM Area WHERE Name = 'Lansing'),
        (SELECT Id FROM Product WHERE Name = 'Hamburger'),
        DATEADD('DAY', -20, CURRENT_DATE), DATEADD('DAY', -5, CURRENT_DATE), DATEADD('DAY', -30, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('59 cents hamburger', 'Hamburger for $0.59 for a limited time.',
        (SELECT Id FROM Area WHERE Name = 'Ann Arbor'),
        (SELECT Id FROM Product WHERE Name = 'Hamburger'),
        DATEADD('DAY', -5, CURRENT_DATE), DATEADD('DAY', +5, CURRENT_DATE), DATEADD('DAY', -30, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('$1 Drinks', 'Any size drink for $1',
        (SELECT Id FROM Area WHERE Name = 'Jackson City'),
        (SELECT Id FROM Product WHERE Name = 'Coke'),
        DATEADD('DAY', -7, CURRENT_DATE), DATEADD('DAY', +7, CURRENT_DATE), DATEADD('DAY', -30, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('$1 Sandwich', 'Get a Sandwich for $1. Only available through our mobile app',
        (SELECT Id FROM Area WHERE Name = 'Detroit'),
        (SELECT Id FROM Product WHERE Name = 'Hamburger'),
        DATEADD('DAY', -7, CURRENT_DATE), CURRENT_DATE, DATEADD('DAY', -90, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('Buy McCafe, Get 1 for $0.01', 'Buy a medium or large McCafe, get 1 for $0.01. Only through our mobile app',
        (SELECT Id FROM Area WHERE Name = 'Detroit'),
        (SELECT Id FROM Product WHERE Name = 'Coffee'),
        CURRENT_DATE, DATEADD('DAY', +21, CURRENT_DATE), DATEADD('DAY', -14, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('2 for $5 Mix and Match', '2 for $5. Select from Big Mac, Filet-O-Fish, Classic Chicken Sandwich, 10 pc. Chicken McNuggets',
        (SELECT Id FROM Area WHERE Name = 'Ann Arbor'),
        (SELECT Id FROM Product WHERE Name = 'Hamburger'),
        DATEADD('DAY', -1, CURRENT_DATE), CURRENT_DATE, DATEADD('DAY', -14, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('$4.99 20 pc Chicken McNuggets', '20 pc Chicken McNuggets for $4.99',
        (SELECT Id FROM Area WHERE Name = 'Jackson City'),
        (SELECT Id FROM Product WHERE Name = 'Chicken Sandwich'),
       CURRENT_DATE, DATEADD('DAY', +1, CURRENT_DATE), DATEADD('DAY', -21, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('$1 Drinks', 'Any size drink for $1',
        (SELECT Id FROM Area WHERE Name = 'Lansing'),
        (SELECT Id FROM Product WHERE Name = 'Coke'),
        DATEADD('DAY', +5, CURRENT_DATE), DATEADD('DAY', +20, CURRENT_DATE), DATEADD('DAY', -30, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );

    
    
    INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('69 cents cheeseburger', 'Cheeseburger for $0.69 for a limited time.',
        (SELECT Id FROM Area WHERE Name = 'Los Angeles'),
        (SELECT Id FROM Product WHERE Name = 'Hamburger'),
        DATEADD('DAY', -20, CURRENT_DATE), DATEADD('DAY', -5, CURRENT_DATE), DATEADD('DAY', -30, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('59 cents hamburger', 'Hamburger for $0.59 for a limited time.',
        (SELECT Id FROM Area WHERE Name = 'San Francisco'),
        (SELECT Id FROM Product WHERE Name = 'Hamburger'),
        DATEADD('DAY', -5, CURRENT_DATE), DATEADD('DAY', +5, CURRENT_DATE), DATEADD('DAY', -30, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('$1 Drinks', 'Any size drink for $1',
        (SELECT Id FROM Area WHERE Name = 'Sacramento'),
        (SELECT Id FROM Product WHERE Name = 'Coke'),
        DATEADD('DAY', -7, CURRENT_DATE), DATEADD('DAY', +7, CURRENT_DATE), DATEADD('DAY', -30, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('$1 Sandwich', 'Get a Sandwich for $1. Only available through our mobile app',
        (SELECT Id FROM Area WHERE Name = 'Los Angeles'),
        (SELECT Id FROM Product WHERE Name = 'Hamburger'),
        DATEADD('DAY', -7, CURRENT_DATE), CURRENT_DATE, DATEADD('DAY', -90, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('Buy McCafe, Get 1 for $0.01', 'Buy a medium or large McCafe, get 1 for $0.01. Only through our mobile app',
        (SELECT Id FROM Area WHERE Name = 'Sacramento'),
        (SELECT Id FROM Product WHERE Name = 'Coffee'),
        CURRENT_DATE, DATEADD('DAY', +21, CURRENT_DATE), DATEADD('DAY', -14, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('2 for $5 Mix and Match', '2 for $5. Select from Big Mac, Filet-O-Fish, Classic Chicken Sandwich, 10 pc. Chicken McNuggets',
        (SELECT Id FROM Area WHERE Name = 'San Francisco'),
        (SELECT Id FROM Product WHERE Name = 'Hamburger'),
        DATEADD('DAY', -1, CURRENT_DATE), CURRENT_DATE, DATEADD('DAY', -14, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('$4.99 20 pc Chicken McNuggets', '20 pc Chicken McNuggets for $4.99',
        (SELECT Id FROM Area WHERE Name = 'Los Angeles'),
        (SELECT Id FROM Product WHERE Name = 'Chicken Sandwich'),
       CURRENT_DATE, DATEADD('DAY', +1, CURRENT_DATE), DATEADD('DAY', -21, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
INSERT INTO Promotion(Name, Description, Area_Id, Product_Id, Start_Date, End_Date, Modified_Date, Modified_User_Id)
    VALUES('$1 Drinks', 'Any size drink for $1',
        (SELECT Id FROM Area WHERE Name = 'Sacramento'),
        (SELECT Id FROM Product WHERE Name = 'Coke'),
        DATEADD('DAY', +5, CURRENT_DATE), DATEADD('DAY', +20, CURRENT_DATE), DATEADD('DAY', -30, CURRENT_DATE),
        (SELECT Id from User_Details where Email_Address = 'susan.vijoy.mathew@gmail.com')
    );
