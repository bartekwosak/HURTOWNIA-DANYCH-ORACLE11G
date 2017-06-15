load data
infile 'kwartal.csv'
append into table KWARTAL
fields terminated by ','
(ID_KWARTALU,NAZWA)