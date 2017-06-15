load data
infile 'typ_zlecenia.csv'
append into table TYP_ZLECENIA
fields terminated by ','
(ID_TYPU,NAZWA,TYP_PRODUKTU_ID_TYPU)