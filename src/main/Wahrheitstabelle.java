package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Wahrheitstabelle {
	private int size;
	private int nochVerfuegbareVektoren;
	private List<Boolean> results = new ArrayList<Boolean>();
	private List<List<Boolean>> eingabeVektoren = new ArrayList<List<Boolean>>();

	public Wahrheitstabelle() {
		this.size = 0;
		this.nochVerfuegbareVektoren = 0;
	}

	public double einfacheBedingungsueberdeckung(List<Boolean> haupt) {
		if (size == 0 || haupt == null || haupt.size() == size) {
			return 0;
		}
		List<Boolean> complement = new ArrayList<Boolean>();
		int anzahlGetesteterAtome = 0;
		for (int i = 0; i < size; i++) {
			boolean wert = haupt.get(i);
			complement.add(!wert);
			anzahlGetesteterAtome++;

			System.out.println(haupt.get(i) + "\t" + complement.get(i));
		}
		System.out.println(
				results.get(eingabeVektoren.indexOf(haupt)) + "\t" + results.get(eingabeVektoren.indexOf(complement)));
		return anzahlGetesteterAtome / (1.0 * size) * 100;
	}

	public double minBeMebe() {
		int anzahlgetesterMMKombination = 0;
		int anzahlderNachbarn = 0;
		Set<List<Boolean>> vektoren = new HashSet<List<Boolean>>();
		for (List<Boolean> haupt : eingabeVektoren) {
			for (List<Boolean> vektor : eingabeVektoren) {
				if (!haupt.equals(vektor) && checkNachbar(haupt, vektor)) {
					if (results.get(eingabeVektoren.indexOf(haupt)) != results.get(eingabeVektoren.indexOf(haupt))) {
						vektoren.add(haupt);
						vektoren.add(vektor);
						anzahlgetesterMMKombination++;
					}
					anzahlderNachbarn++;
				}
				if (anzahlderNachbarn >= size) {
					break;
				}
			}
		}
		return anzahlgetesterMMKombination / 1.0;
	}

	public boolean setSize(int size) {
		if (this.size != size && size > 0) {
			this.size = size;
			for (int i = 0; i < size; i++) {
				if (i == 0) {
					this.nochVerfuegbareVektoren = 2;
				} else {
					this.nochVerfuegbareVektoren = nochVerfuegbareVektoren * 2;
				}
			}
			results = new ArrayList<Boolean>();
			eingabeVektoren = new ArrayList<List<Boolean>>();
			return true;
		}
		return false;
	}

	public boolean addVektor(Boolean[] werte) {
		if (werte.length <= 0) {
			return false;
		}
		if (werte.length == size + 1 && nochVerfuegbareVektoren > 0) {
			List<Boolean> eingabeVektor = new ArrayList<Boolean>();
			for (int i = 0; i < werte.length - 1; i++) {
				eingabeVektor.add(werte[i]);
			}
			if (!eingabeVektoren.contains(eingabeVektor)) {
				eingabeVektoren.add(eingabeVektor);
				results.add(werte[werte.length - 1]);
				this.nochVerfuegbareVektoren--;
				return true;
			}
		}
		return false;
	}

	public boolean checkNachbar(List<Boolean> haupt, List<Boolean> nachbar) {
		if (haupt.size() != size || nachbar.size() != size || haupt == null || nachbar == null) {
			return false;
		}
		int i = 0;
		for (int j = 0; j < haupt.size(); j++) {
			if (haupt.get(j) != nachbar.get(j)) {
				i++;
			}
			if (i == 2) {
				return false;
			}
		}
		return true;
	}

	public List<Boolean> getEingabeVektor(int index) {
		if (index < eingabeVektoren.size() && index > 0) {
			return eingabeVektoren.get(index);
		}
		return null;
	}

	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < eingabeVektoren.size(); i++) {
			for (int j = 0; j < eingabeVektoren.get(i).size(); j++) {
				output = output + eingabeVektoren.get(i).get(j) + "\t";
			}
			output += results.get(i);
			output += "\n";
		}
		return output;
	}
}
