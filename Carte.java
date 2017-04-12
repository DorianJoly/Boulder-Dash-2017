import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Carte {
	public static Scanner in = new Scanner(System.in);
	private char tab[][];
	private int position_x;
	private int position_y;
	private static int nbDiamants;

	/**
	 * constructeur qui permet de charger la carte
	 * 
	 * @param tab1
	 *            la carte a charger
	 */
	public Carte() {
		tab = new char[15][15];
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				tab[i][j] = 'O';
			}
		}
		position_x = 5;
		position_y = 5;
		tab[position_x][position_y] = 'R';
	}

	public Carte(char tab1[][], int DiamantsRequis, int MagicWall) throws CarteInvalideException {

		try {
			carteValide(tab1, DiamantsRequis, MagicWall);
		} catch (CarteInvalideException e) {
			System.out.println(e.getMessage());
		}
		tab = new char[tab1.length][tab1[1].length];
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[1].length; j++) {
				tab[i][j] = tab1[i][j];
				if (tab[i][j] == 'R') {
					position_x = i;
					position_y = j;
				}
			}
		}
	}

	private void carteValide(char tab[][], int DiamantsRequis, int MagicWall) throws CarteInvalideException {
		int diamants = MagicWall, depart = 0, sortie = 0;

		for (int i = 0; i < tab.length; i++) {
			if (tab[0][i] != 'W' || tab[tab.length - 1][i] != 'W') {
				throw new CarteInvalideException("Mur incomplet");
			}
			for (int j = 0; j < tab[1].length; j++) {
				if (i == 0 || i == tab.length - 1) {
					if (tab[i][j] != 'W') {
						throw new CarteInvalideException("Mur incomplet");
					}
				}

				if (tab[i][j] == 'X')
					sortie++;

				if (tab[i][j] == 'P')
					depart++;

				if (tab[i][j] == 'd')
					diamants++;

			}
		}
		if (sortie != 1)
			throw new CarteInvalideException("Sortie non identifiable");
		if (depart != 1)
			throw new CarteInvalideException("Point de départ inconnu");
		if (diamants < DiamantsRequis)
			throw new CarteInvalideException("Diamants insuffisants");

	}

	public void deplacement(int deplacement_x, int deplacement_y) throws MouvementException {
		if (verifInTableau(deplacement_x, deplacement_y)) {
			tab[position_x][position_y] = 'O';
			position_x += deplacement_x;
			position_y += deplacement_y;
			tab[position_x][position_y] = 'R';
		} else {
			throw new MouvementException("Deplacement Impossible");
		}
	}

	public boolean verifInTableau(int x, int y) {
		if ((x + position_x) <= tab.length || (x + position_x) >= tab.length || (y + position_y) <= tab[0].length
				|| (y + position_y) >= tab[0].length) {
			return true;
		}
		return false;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				s = s + tab[i][j];
			}
			s = s + "\n";
		}

		return s;
	}

}

/*
 * bool carte.essaie(int direction) -> essaie juste si on peux bouger mais ne le
 * fait pas 
 * void carte.deplacement(int direction) -> fait bouger Rockford en
 * fonction de l'entier 
 * bool carte.EstMort() -> teste si Rockford est mort 
 * bool carte.aFini() -> teste si le niveau est fini
 */

/*
 * direction -> 1: gauche 2: haut 3: droite 4: bas 5: rien
 */
