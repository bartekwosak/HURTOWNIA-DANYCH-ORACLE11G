load data
infile 'typ_produktu.csv'
append into table TYP_PRODUKTU
fields terminated by ','
(ID_TYPU,NAZWA)