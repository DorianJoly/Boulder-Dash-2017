package PacNum2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Carte {
	public static Scanner in = new Scanner(System.in);
	public Element tab[][];
	private int position_x;
	private int position_y;
	private static int nbDiamants;
	private int score = 0;
	private int pousseRocher = 0;

	/**
	 * constructeur qui permet de charger la carte
	 * 
	 * @param tab1
	 *            la carte a charger
	 */


	public Carte(char tab1[][], int DiamantsRequis, int MagicWall) throws CarteInvalidException {
		try {
			carteValide(tab1, DiamantsRequis, MagicWall);
		} catch (CarteInvalidException e) {
			System.out.println(e.getMessage());
		}
		tab = new Element[tab1.length][tab1[1].length];
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[1].length; j++) {

				if (tab1[i][j] == 'M') {
					tab[i][j] = Monstre.getInstance();

				} else if (tab1[i][j] == 'P') {
					tab[i][j] = Rockford.getInstance();

				} else if (tab1[i][j] == ' ') {
					tab[i][j] = null;

				} else if (tab1[i][j] == '.') {
					tab[i][j] = Poussiere.getInstance();

				} else if (tab1[i][j] == 'r') {
					tab[i][j] = Rocher.getInstance();
				} else if (tab1[i][j] == 'w') {
					tab[i][j] = Mur.getInstance();
				} else if (tab1[i][j] == 'W') {
					tab[i][j] = MurTitane.getInstance();
				} else if (tab1[i][j] == 'M') {
					tab[i][j] = MurMagique.getInstance();
				}

				if (tab1[i][j] == 'R') { /* tester si l'objet est Rockford */
					position_x = i;
					position_y = j;
				}
			}
		}
	}

	private void carteValide(char tab[][], int diamantsRequis, int magicWall) throws CarteInvalidException {
		int diamants = magicWall, depart = 0, sortie = 0;

		for (int i = 0; i < tab.length; i++) {
			if (tab[0][i] != 'W' || tab[tab.length - 1][i] != 'W') {
				throw new CarteInvalidException("Mur incomplet");
			}
			for (int j = 0; j < tab[1].length; j++) {
				if (i == 0 || i == tab.length - 1) {
					if (tab[i][j] != 'W') {
						throw new CarteInvalidException("Mur incomplet");
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
			throw new CarteInvalidException("Sortie non identifiable");
		if (depart != 1)
			throw new CarteInvalidException("Point de dÃ©part inconnu");
		if (diamants < diamantsRequis)
			throw new CarteInvalidException("Diamants insuffisants");

	}

	public void deplacement(int deplacement_x, int deplacement_y) throws MouvementException {
		if (verifInTableau(deplacement_x, deplacement_y) && (tab[deplacement_x][deplacement_y] != Mur.getInstance()
				&& tab[deplacement_x][deplacement_y] != MurTitane.getInstance()
				&& tab[deplacement_x][deplacement_y] != MurMagique.getInstance())) {
			if (tab[position_x + deplacement_x][position_y + deplacement_y] == Rocher.getInstance()) {
				BougerRocher(deplacement_x, deplacement_y);
			} else {
				position_x += deplacement_x;
				position_y += deplacement_y;
				tab[position_x][position_y] = Rockford.getInstance();
				tab[position_x - deplacement_x][position_y - deplacement_y] = null;
			}
			deplacement_rochers(); /* rockford mort? */
		}

		else {
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

	public void BougerRocher(int deplacement_x, int deplacement_y) { // a
																		// compléter
		if (pousseRocher == 1) {
			position_x += deplacement_x;
			position_y += deplacement_y;
			tab[position_x][position_y] = Rockford.getInstance();
			tab[position_x + deplacement_x][position_y + deplacement_y] = Rocher.getInstance();
			pousseRocher = 0;
		} else {
			int derriere_x = deplacement_x + deplacement_x;
			int derriere_y = deplacement_y + deplacement_y;
			if (verifInTableau(derriere_x, derriere_y) && tab[position_x + derriere_x][position_y
					+ derriere_y] == null) /*
											 * faire la verification rocher
											 * bougeable
											 */
				pousseRocher = 1;

		}
	}

	public void deplacement_rochers() {
		for (int i = 0; i < tab.length - 1; i++) {
			for (int j = 0; j < tab[1].length; j++) {
				if (tab[i][j] == Rocher.getInstance() && tab[i + 1][j] == null) {
					tab[i + 1][j] = Rocher.getInstance();
					tab[i][j] = null;
				}
			}
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				s = s + tab[i][j].toString();
			}
			s = s + "\n";
		}

		return s;
	}

	public int getScore() {
		return score;
	}

	protected void setScore(int s) {
		score = s;
	}
}

/*
 * 
 * else if(tab[i][j]='P'){
 * 
 * }else if(tab[i][j]='X'){
 * 
 * }
 */
