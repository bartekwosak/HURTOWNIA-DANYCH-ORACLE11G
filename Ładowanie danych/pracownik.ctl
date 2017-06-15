load data
infile 'pracownik.csv'
append into table PRACOWNIK
fields terminated by ','
(ID_PRACOWNIKA,IMIE,NAZWISKO,PESEL,STANOWISKO_ID_STANOWISKO)