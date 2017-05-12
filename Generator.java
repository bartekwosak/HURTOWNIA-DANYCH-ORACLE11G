package generator.platek;

import java.util.Random;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class Stanowisko extends Pracownik {
	private Integer pensja;
	private Integer stawkaGodzinowa;

	public Stanowisko() throws FileNotFoundException {
		PrintWriter zapis = new PrintWriter("stanowisko.csv");
		for (int i = 1; i < stanowiska.length + 1; i++) {
			if (stanowiska[i - 1] == "Kierownik") {
				this.pensja = 3200;
				this.stawkaGodzinowa = this.pensja/160;
			}
			if (stanowiska[i - 1] == "Szwacz" || stanowiska[i - 1] == "Kaletnik" || stanowiska[i - 1] == "Szewc") {
				this.pensja = 2600;
				this.stawkaGodzinowa = this.pensja/160;;
			}
			if (stanowiska[i - 1] == "Kierowca" || stanowiska[i - 1] == "Magazynier") {
				this.pensja = 2100;
				this.stawkaGodzinowa = this.pensja/160;;
			}
			zapis.println(i + "," + stanowiska[i - 1] + "," + this.pensja + "," + this.stawkaGodzinowa);
		}
		zapis.close();
	}
}

class Pracownik extends Generator {
	private String imie;
	private String nazwisko;
	private Integer peselRok;
	private Integer peselMiesiac;
	private Integer peselDzien;
	private Integer peselKoncowka;
	private Integer idStanowiska;

	public Pracownik() throws FileNotFoundException {
		PrintWriter zapis = new PrintWriter("pracownik.csv");
		for (int i = 1; i < 16; i++) {
			this.imie = imiona[r.nextInt(this.imiona.length)];
			this.nazwisko = nazwiska[r.nextInt(this.nazwiska.length)];
			this.peselRok = 70 + r.nextInt(11);
			this.peselMiesiac = 1 + r.nextInt(12);
			this.peselDzien = 2 + r.nextInt(20);
			this.peselKoncowka = (13677 + r.nextInt(4500));
			this.idStanowiska = 1 + r.nextInt(6);
			if (i == 1) {
				this.idStanowiska = 1;
			}
			if (i > 1 && i < 6) {
				this.idStanowiska = 2;
			}
			if (i > 5 && i < 10) {
				this.idStanowiska = 3;
			}
			if (i > 9 && i < 13) {
				this.idStanowiska = 4;
			}
			if (i == 13) {
				this.idStanowiska = 5;
			}
			if (i > 13) {
				this.idStanowiska = 6;
			}
			if ((this.peselDzien > 0 && this.peselDzien < 10) || (this.peselMiesiac > 0 && this.peselMiesiac < 10)) {
				zapis.println(i + "," + this.imie + "," + this.nazwisko + "," + this.peselRok + "0" + this.peselMiesiac
						+ "0" + this.peselDzien + this.peselKoncowka + "," + this.idStanowiska);
			} else {
				zapis.println(i + "," + this.imie + "," + this.nazwisko + "," + this.peselRok + this.peselMiesiac
						+ this.peselDzien + this.peselKoncowka + "," + this.idStanowiska);
			}
		}
		zapis.close();
	}
}

class GrupaKlienteli extends Klient {

	public GrupaKlienteli() throws FileNotFoundException {
		PrintWriter zapis = new PrintWriter("grupa_klienteli.csv");
		for (int i = 1; i < nazwaGrupyKlienteli.length + 1; i++) {
			zapis.println(i + "," + nazwaGrupyKlienteli[i - 1]);
		}
		zapis.close();
	}
}

class Klient extends Generator {
	private String imie;
	private String nazwisko;
	private Integer idGrupyKlienteli;

	public Klient() throws FileNotFoundException {
		PrintWriter zapis = new PrintWriter("klient.csv");
		for (int i = 1; i < 5001; i++) {
			this.imie = imiona[r.nextInt(this.imiona.length)];
			this.nazwisko = nazwiska[r.nextInt(this.nazwiska.length)];
			this.idGrupyKlienteli = 1 + r.nextInt(3);
			zapis.println(i + "," + this.imie + "," + this.nazwisko + "," + this.idGrupyKlienteli);
		}
		zapis.close();
	}

}

class TypProduktu extends TypZlecenia {

	public TypProduktu() throws FileNotFoundException {
		PrintWriter zapis = new PrintWriter("typ_produktu.csv");
		for (int i = 1; i < typyProduktow.length + 1; i++) {
			zapis.println(i + "," + this.typyProduktow[i - 1]);
		}
		zapis.close();
	}
}

class TypZlecenia extends Generator {
	private int id = 1;

	public TypZlecenia() throws FileNotFoundException {
		PrintWriter zapis = new PrintWriter("typ_zlecenia.csv");
		for (int i = 0; i < typyZlecenKaletnicze.length; i++) {
			for (int j = 0; j < typyProduktow.length - 4; j++) {
				zapis.println(this.id + "," + typyZlecenKaletnicze[i] + "," + (j + 1));
				id++;
			}
		}
		for (int i = 0; i < typyZlecenSzewskie.length; i++) {
			for (int j = typyProduktow.length - 1; j > 7; j--) {
				zapis.println(this.id + "," + typyZlecenSzewskie[i] + "," + (j + 1));
				id++;
			}
		}
		zapis.close();
	}

}

class Dzien extends Miesiac {
	public Dzien() throws FileNotFoundException {
		PrintWriter zapis = new PrintWriter("dzien.csv");
		for (int i = 1; i < nazwaDnia.length + 1; i++) {
			zapis.println(i + "," + nazwaDnia[i - 1]);
		}
		zapis.close();
	}
}

class Miesiac extends Kwartal {
	public Miesiac() throws FileNotFoundException {
		PrintWriter zapis = new PrintWriter("miesiac.csv");
		for (int i = 1; i < nazwaMiesiaca.length + 1; i++) {
			zapis.println(i + "," + nazwaMiesiaca[i - 1]);
		}
		zapis.close();
	}
}

class Kwartal extends Rok {
	public Kwartal() throws FileNotFoundException {
		PrintWriter zapis = new PrintWriter("kwartal.csv");
		for (int i = 1; i < nazwaKwartalu.length + 1; i++) {
			zapis.println(i + "," + nazwaKwartalu[i - 1]);
		}
		zapis.close();
	}
}

class Rok extends Data {
	public Rok() throws FileNotFoundException {
		PrintWriter zapis = new PrintWriter("rok.csv");
		for (int i = 1; i < lata.length + 1; i++) {
			zapis.println(i + "," + lata[i - 1]);
		}
		zapis.close();
	}
}

class Data extends Generator {
	private Integer dzien;
	private Integer miesiac;
	private Integer rok;
	private String data;
	private Integer idDnia;
	private Integer idMiesiaca;
	private Integer idKwartalu;
	private Integer idRoku;

	public Data() throws FileNotFoundException {
		Random rand = new Random();
		PrintWriter zapis = new PrintWriter("data.csv");

		for (int i = 0; i < 10000; i++) {
			miesiac = 1 + rand.nextInt(12);
			rok = 2011 + rand.nextInt(6);

			if (miesiac == 1 || miesiac == 3 || miesiac == 5 || miesiac == 7 || miesiac == 8 || miesiac == 10
					|| miesiac == 12) {
				dzien = 1 + rand.nextInt(31);
			}
			if (miesiac == 4 || miesiac == 6 || miesiac == 9 || miesiac == 11) {
				dzien = 1 + rand.nextInt(30);
			}
			if ((miesiac == 2) && (rok == 2012 || rok == 2016)) {
				dzien = 1 + rand.nextInt(29);
			} else
				dzien = 1 + rand.nextInt(28);

			idDnia = 1 + rand.nextInt(nazwaDnia.length);
			idMiesiaca = miesiac;

			if (miesiac >= 1 && miesiac <= 3) {
				idKwartalu = 1;
			}
			if (miesiac >= 4 && miesiac <= 6) {
				idKwartalu = 2;
			}
			if (miesiac >= 7 && miesiac <= 9) {
				idKwartalu = 3;
			}
			if (miesiac >= 10 && miesiac <= 12) {
				idKwartalu = 4;
			}

			switch (rok) {
			case 2011:
				idRoku = 1;
				break;
			case 2012:
				idRoku = 2;
				break;
			case 2013:
				idRoku = 3;
				break;
			case 2014:
				idRoku = 4;
				break;
			case 2015:
				idRoku = 5;
				break;
			case 2016:
				idRoku = 6;
				break;
			}

			data = rok + "/" + miesiac + "/" + dzien;
			zapis.println(i + 1 + "," + this.idDnia + "," + this.idMiesiaca + "," + this.idKwartalu + "," + this.idRoku
					+ "," + this.data);
		}
		zapis.close();
	}
}

class Zlecenie extends Generator {
	private Integer idDaty;
	private Integer idTypuZlecenia;
	private Integer idKlienta;
	private Integer idPracownika;
	private Double cenaUslugi;
	private Double kosztMaterialu;
	private Double zysk;

	public Zlecenie() throws Exception {
		PrintWriter zapis = new PrintWriter("zlecenie.csv");
		for (int i = 1; i < 30001; i++) {
			this.idDaty = 1 + r.nextInt(10000);
			this.idTypuZlecenia = 1 + r.nextInt(100);
			this.idKlienta = 1 + r.nextInt(5000);
			this.idPracownika = 1 + r.nextInt(15);
			this.cenaUslugi = r.nextDouble();
			this.cenaUslugi *= 10000;
			this.cenaUslugi = (double) Math.round(this.cenaUslugi);
			this.cenaUslugi /= 100;
			this.kosztMaterialu = r.nextDouble();
			this.kosztMaterialu *= 5000;
			this.kosztMaterialu = (double) Math.round(this.kosztMaterialu);
			this.kosztMaterialu /= 100;
			if (this.cenaUslugi <= 1) {
				this.cenaUslugi = (double) Math.round(this.cenaUslugi * 100);
			}
			if (this.cenaUslugi <= 10 && this.cenaUslugi > 1) {
				this.cenaUslugi = (double) Math.round(this.cenaUslugi * 50);
			}
			if (this.kosztMaterialu >= this.cenaUslugi) {
				Double temp = this.kosztMaterialu;
				Double temp2 = this.cenaUslugi;
				this.cenaUslugi = temp;
				this.kosztMaterialu = temp2;
			}
			this.zysk = this.cenaUslugi - this.kosztMaterialu;
			this.zysk *= 100;
			this.zysk = (double) Math.round(this.zysk);
			this.zysk /= 100;
			zapis.println(i + "," + this.idDaty + "," + this.idTypuZlecenia + "," + this.idKlienta + ","
					+ this.idPracownika + "," + this.cenaUslugi + "," + this.kosztMaterialu + "," + this.zysk);
		}
		zapis.close();
	}


}

public class Generator {
	public Random r = new Random();
	protected String[] stanowiska = { "Kierownik", "Szwacz", "Szewc", "Kaletnik", "Kierowca", "Magazynier" };
	protected String[] imiona = { "Jan", "Marek", "Andrzej", "Tomasz", "Anna", "Katarzyna", "Piotr", "Kamil",
			"Sebastian", "Karol", "Michal", "Pawel", "Rafal" };
	protected String[] nazwiska = { "Nowak", "Wojcik", "Kowalczyk", "Wozniak", "Kaczmarek", "Mazur", "Krawczyk",
			"Adamczyk", "Dudek" };
	protected String[] nazwaGrupyKlienteli = { "Staly", "Nowy", "Konkurencja" };
	protected String[] typyProduktow = { "Skora", "Pasek", "Torebka", "Plaszcz", "Torba", "Saszetka", "Teczka",
			"Walizka", "Buty obcas", "Buty wizytowe", "Buty sportowe", "Czolenka" };
	protected String[] typyZlecenKaletnicze = { "Wymiana flekow", "Naprawa suwaka", "Szycie - skora", "Szycie - zamsz",
			"Szycie - syntetyk", "Wymiana suwaka", "Przerobki drobne - skora", "Regeneracja", "Zmiana kroju",
			"Zszywanie" };
	protected String[] typyZlecenSzewskie = { "Wymiana flekow", "Wymiana wkladki", "Naprawa suwaka", "Wymiana suwaka",
			"Wymiana podeszwy" };
	protected String[] nazwaDnia = { "poniedzialek", "wtorek", "sroda", "czwartek", "piatek", "sobota", "niedziela" };
	protected String[] nazwaMiesiaca = { "styczen", "luty", "marzec", "kwiecien", "maj", "czerwiec", "lipiec",
			"sierpien", "wrzesien", "pazdziernik", "listopad", "grudzien" };
	protected String[] nazwaKwartalu = { "pierwszy", "drugi", "trzeci", "czwarty" };
	protected Integer[] lata = { 2011, 2012, 2013, 2014, 2015, 2016 };

	public Generator() {
	}

	public static void main(String[] args) throws Exception {
		new Stanowisko();
		new Pracownik();
		new GrupaKlienteli();
		new Klient();
		new TypProduktu();
		new TypZlecenia();
		new Dzien();
		new Miesiac();
		new Kwartal();
		new Rok();
		new Data();
		new Zlecenie();
	}
}