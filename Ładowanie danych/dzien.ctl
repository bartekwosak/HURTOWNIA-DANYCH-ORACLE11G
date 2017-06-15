load data
infile 'dzien.csv'
append into table DZIEN_TYGODNIA
fields terminated by ','
(ID_DNIA,NAZWA)