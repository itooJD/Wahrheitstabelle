package main;

import java.util.ArrayList;

public class Starter {
	public static void main(String[] args) {
		Wahrheitstabelle tabelle = new Wahrheitstabelle();
		tabelle.setSize(3);
		System.out.println("A1\tA2\tA3\tB");
		Boolean[] array = new Boolean[] { false, false, false, true };
		tabelle.addVektor(array);
		array = new Boolean[] { true, false, false, false };
		tabelle.addVektor(array);
		array = new Boolean[] { false, true, false, false };
		tabelle.addVektor(array);
		array = new Boolean[] { true, true, false, false };
		tabelle.addVektor(array);
		array = new Boolean[] { false, false, true, true };
		tabelle.addVektor(array);
		array = new Boolean[] { true, false, true, false };
		tabelle.addVektor(array);
		array = new Boolean[] { false, true, true, true };
		tabelle.addVektor(array);
		array = new Boolean[] { true, true, true, false };
		tabelle.addVektor(array);
		System.out.println(tabelle.toString());

		System.out.println(tabelle.einfacheBedingungsueberdeckung(tabelle.getEingabeVektor(2)));
	}
}
