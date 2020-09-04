package testing;

import java.util.ArrayList;

public class Turing {
	/**
	 * DEFI NUMERO 1
	 */
	public void defi_1 () {
		/* Si on liste tous les entiers naturels inférieurs à 20 qui sont multiples de 5 ou de 7, on obtient 5, 7, 10, 14 et 15. 
		 * La somme de ces nombres est 51.
		 * -> Trouver la somme de tous les multiples de 5 ou de 7 inférieurs à 2013 */
		int i = 0;
		ArrayList<Integer> tableau = new ArrayList<Integer>();
		int somme = 0;
		while (i <= 2013) {
			// Pour savoir si un nombre est multiple de 7, on pose la division de ce nombre par 7:
			// Si elle tombe juste, c’est bien un multiple de 7.
			if (i%7 == 0) { 
				tableau.add(i);
				somme += i;
			} else {
				//Les multiples de 5 sont les nombres qui se terminent par 0 ou 5
				String stringNumber = String.valueOf(i);
				int lastChar = stringNumber.charAt(stringNumber.length()-1);
				if (lastChar == '0' || lastChar == '5') {
					tableau.add(i);
					somme += i;
				}
					
			}
			i++;
		}
		System.out.println(tableau);
		System.err.println(somme);
	}
	/**
	 * DEFI NUMERO 2
	 */
	public void defi_2 () {
		/* Chaque nouveau terme de la suite de Fibonacci est généré en ajoutant les deux termes précédents. 
		 * En commençant avec 1 et 1, les 10 premiers termes sont les suivants:
		 * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
		 * -> En prenant en compte les termes de la suite de Fibonacci dont les valeurs ne dépassent pas 4 millions, trouver la somme des termes impairs */
		int i = 1;
		int j = 1;
		int nombre = 0;
		ArrayList <Integer> suite = new ArrayList<Integer>();
		int total = 0;
		while (nombre < 4000000){  // Création suite de fibonnaci < 4M
			nombre = i + j;
			if (nombre < 4000000 && nombre%2 > 0) {
				// Ajout élément suite si < 4M && impair
				suite.add(nombre);
				total += nombre;
			}
				
			i = j;
			j = nombre;
		}
		System.out.println(suite);
		System.err.println(total);
	}
	/**
	 * DEFI NUMERO 3
	 */
	public void defi_3 () {
		/* Les facteurs premiers du nombre 2013 sont 3, 11 et 61, car 3 x 11 x 61 = 2013.
		 * -> Quel est le plus grand facteur premier du nombre 20130101 ? */
		double nombre = 20130101;
		double reste = nombre;
		int i = 2;
		ArrayList <Integer> liste = new ArrayList <Integer>();
		while (reste >= 0) {
			reste = nombre/i; // On divise par "i" le nombre de départ
			int entier = (int) reste;
			if (reste == entier) { // OK : le reste est un nombre entier, donc "i" est un facteur
				System.out.println(i + " est un facteur");
				liste.add(i);
				nombre = reste; // Le prochain passage testera l'entier "reste"
			} else { // NOK : "i" n'est pas un facteur
				i++; // Le prochain passage testera le "i" suivant
			}
			
		}
		System.err.println(liste.get(liste.size()-1));
	}
	/**
	 * DEFI NUMERO 4
	 */
	public void defi_4 () {
		/* Un nombre palindrome se lit de la même façon de gauche à droite et de droite à gauche.
		 * Le plus grand palindrome que l'on peut obtenir en multipliant deux nombres de deux chiffres est 9009 = 99 x 91.
		 * -> Quel est le plus grand palindrome que l'on peut obtenir en multipliant un nombre de 4 chiffres avec un nombre de 3 chiffres ? */
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(0); // On entre un 0 dans la liste pour comparer plus tard
		for (int i = 1000; i<=9999; i++) { // parcorurs nombres à 4 positions
			for (int j=100; j<=999; j++) { // parcorurs nombres à 3 positions
				int nombre = i*j;
				if (isPalindrome(nombre)) {
					for (int index=0; index<liste.size(); index++) {
						if (nombre > liste.get(index)) {
							liste.remove(liste.get(index));
							liste.add(nombre);
						}
					}
						
				}
			}
		}
		System.out.println(liste);
	}
	public Boolean isPalindrome (int nombre) {
		String stringNumber = String.valueOf(nombre);
		String stringNumberInversee = "";
		for (int i=stringNumber.length()-1; i>=0; i--) {
			stringNumberInversee += stringNumber.charAt(i);
		}
		if (stringNumber.contentEquals(stringNumberInversee)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * DEFI NUMERO 5
	 */
	public void test_5 () {
		/* 215 = 32768 et la somme de ses chiffres vaut 3 + 2 + 7 + 6 + 8 = 26.
		 * -> Que vaut la somme des chiffres composant le nombre 22222? */
		int nombre = 22222;
		int resultat = 0;
		String stringNumber = String.valueOf(nombre);
		for (int i=0; i<stringNumber.length(); i++) {
			int chiffre = Character.getNumericValue(stringNumber.charAt(i));
			resultat += chiffre;
		}
		System.err.println(resultat);
	}
	/**
	 * DEFI NUMERO 6
	 */
	public void test_6 () {
		/*n! signifie n x (n-1) x ... x 3 x 2 x 1
		Par exemple, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800.
		La somme des chiffres du nombre 10! vaut 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
		-> Trouver la somme des chiffres du nombre 2013!*/
		long nombre = 20;
		long total = 1;
		while (nombre > 0) {
			total *= nombre;
			nombre--;
		}
		System.err.println(total); // ici, on réutilise la fonction du test précédent pour finir
	}
	/**
	 * DEFI NUMERO 7
	 */
	public void defi_7 () {
		/** En énumérant les six premiers nombres premiers : 2, 3, 5, 7, 11 et 13, on voit que le 6ème nombre premier est 13.
 		 *	Quel est le 23456ème nombre premier ? */
		ArrayList<Integer> nombresPremiers = new ArrayList<Integer>();
		for (int i=1; i<=23456; i++) { // Parcours du nombre total
			ArrayList<Integer> liste = new ArrayList<Integer>();
			for (int j=1; j<=i; j++) { // Parcours pour chaque nombre de 0 à ce nombre
				float resultat = (float) i/j;
				int resultatInt = i/j;
				if (resultat == resultatInt && i != j) { // tous les resultats, un tableau par nombre
					liste.add(resultatInt);
				}
			}
			if (liste.size() == 1) { // Un seul resultat => nombre premier
				nombresPremiers.add(i); 
			}
		}
		System.err.println(nombresPremiers.get(nombresPremiers.size()-1));
	}
	
}
