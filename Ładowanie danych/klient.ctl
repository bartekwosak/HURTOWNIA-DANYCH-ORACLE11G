load data
infile 'klient.csv'
append into table KLIENT
fields terminated by ','
(ID_KLIENTA,IMIE,NAZWISKO,GRUPA_KLIENTELI_ID_GRUPY)