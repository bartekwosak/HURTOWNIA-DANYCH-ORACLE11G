load data
infile 'stanowisko.csv'
append into table STANOWISKO
fields terminated by ','
(ID_STANOWISKO,NAZWA,PENSJA,STAWKA_GODZINOWA)