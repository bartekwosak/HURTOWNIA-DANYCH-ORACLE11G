load data
infile 'grupa_klienteli.csv'
append into table GRUPA_KLIENTELI
fields terminated by ','
(ID_GRUPY,NAZWA_GRUPY)