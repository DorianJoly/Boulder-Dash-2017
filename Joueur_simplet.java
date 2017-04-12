import java.util.*;

public class Joueur_simplet {
	private int niveauIA = 1;

	private static int aleatoire(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}

	/*
	 * direction = 
	 * 1:Gauche 
	 * 2:Haut 
	 * 3:Droite 
	 * 4:Bas 
	 * 5:Pas de Mouv
	 */
	private boolean deplacementIA(Carte carte) {
		int direction;
		do {
			direction = (aleatoire(1, 5));
		} while (carte.essaie(direction));
		carte.deplacement(direction);
		return true;
	}

	protected boolean activeIA(Carte carte, int time) {
		while (carte.estMort() || carte.aFini() || time == 0) {
			deplacementIA(carte);
			time--;
		}
		if ((time == 0 && !carte.aFini) || (carte.estMort)) {
			System.out.println("Echec");
		} else if (carte.aFini) {
			System.out.println("Wp guy ;D");
		}

	}

}
