package PacNum2;

import java.util.Scanner;

public class Menu {

	public static Scanner sc = new Scanner(System.in);

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Binevenue dans ce jeu de boulder dash");
		int x;
		do {
			do {
				System.out.println("Rentrer une valeur entre 1 et 3");
				System.out.println("1=Jouer");
				System.out.println("2=Information // regles");
				System.out.println("3=Quitter");

				while (!sc.hasNextInt()) {
					sc.next();
					System.out.println("Ce n'est pas un entier");
				}
				x = sc.nextInt();
			} while (x < 1 || x > 3);
			if (x == 2) {
				info();
			}
			if (x == 1) {
				jouer1();
			}
		} while (x != 3);
		System.out.println("Merci d'avoir jouer à ce jeu, \nA bientot");
	}

	/**
	 * donne les infos par rapport au tournoi
	 */
	public static void info() {
		System.out.println("Ce jeu est un jeu donc le principe est de collecté un maximum de diamant sans mourir\n et de finir le niveau avant la fin du temps");
	}

	/**
	 * permet de lancer le tournoi
	 */
	public static void jouer1() {
		start();
	}
	/**
	 * recup le niv
	 * @param L
	 * @return
	 */
	private static Niveau lecteur(LectureBDCFF L) {
		System.out
				.println("Maintenant donner le nom de la carte du niveau à lire");
		Niveau n = null;
		boolean lecture = true;
		String var1;
		do {
			try {
				var1 = sc.next();
				n = L.lecture(var1); // faire la lecture de la carte
				lecture = true;
			} catch (Exception e) {
				lecture = false;
				sc.next();
			}
		} while (!lecture);
		return n;
	}
	/**
	 * permet de boucler
	 */
	public static void start() {
		boolean boucledebut = true;
		while (boucledebut) {
			boucledebut = false;
			// recup carte
			LectureBDCFF L = new LectureBDCFF();
			Niveau n = lecteur(L);
			int choixJoueur = joueur_bot();
			if (choixJoueur == 0) {
			//	botJoueur(n);
			} else if (choixJoueur == 1) {
			//	botSimplet(n);
			} else if (choixJoueur == 2) {
			//	botEvolué(n);
			} else if (choixJoueur == 3) {
			//	botDirectif(n);
			} else if (choixJoueur == 4) {
			//	botDirectifEvolué(n);
			} else if (choixJoueur == 5) {
			//	botParfait(n);
			}
			System.out.println("Votre score est de " + n.score);

			boucledebut = again();
		}
	}
	/**
	 * 
	 * @return
	 */
	private static int joueur_bot(){
		System.out.println("Vous voulez jouer ou faire jouer des bot ??(1=vous 2=bot)");
		int var1;
		do{
			while(!sc.hasNextInt()){
				sc.next();
				System.out.println("Ce n'est pas un entier");
			}var1=sc.nextInt();
		}while(var1!=1||var1!=2);
		if(var1==1)return 0;
		else {
			var1=0;
			System.out.println("Quel niveau vous voulez donner au bot ??\n1=Simplet(déplacement Aleatoire)\n2=Evolué\n3=Directif\n4=Directif Evolué\n5=Parfait");
			do{
				while(!sc.hasNextInt()){
					sc.next();
					System.out.println("Ce n'est pas un entier");
				}var1=sc.nextInt();
			}while(var1<1||var1>5);
			return var1;
		}
	}
	/**
	 * 
	 * @return
	 */
	
	private static boolean again() {
		int rejoue;
		System.out.println("Voulez vous rejoué ?(oui=1 && non=2)");
		do {
			while (!sc.hasNextInt()) {
				sc.next();
				System.out.println("Ce n'est pas un entier");
			}
			rejoue = sc.nextInt();
		} while (rejoue != 1 || rejoue != 2);
		if (rejoue == 1) {
			return true;
		} else {
			return false;
		}
	}

	private void explosion(int x, int y, Carte c) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (c.tab[i][j].type != 'W') {
					c.tab[i][j] = Vide.getInstance();
				}
			}
		}
	}

	

private void botJoueur(Niveau n){
	int choixDirection=choixDirec(n);
}

private int choixDirec(Niveau n){
	int var1;
	int time=n.caveTime;
	boolean essaieDir,sortie=false;
	int coor[];
	do{
	
	
	
	System.out.println("Quel direction voulez vous vous deplacer ??\n1=Gauche\n2=Haut\n3=Droite\n4=Bas\n5=Pas Bouger");
	do{
		while(!sc.hasNextInt()){
			sc.next();
			System.out.println("Ce n'est pas un entier");
		}var1=sc.nextInt();
	}while(var1<1||var1>5);
	coor=recupCoorRock(n.carte);
	
	essaieDir=essaie(n,var1,coor[0],coor[1]);
	if(essaieDir){
		deplacement(n,var1,coor[0],coor[1]);//rouler se fait dedans  si jamais il y a un rocher
		
		graviter(n.carte);
		
		coor=recupCoorRock(n.carte);
		sortie=n.aFini();
		mort(n);
		
		time--;
	}
     
	
	}while(time!=0 || sortie);
	return n.carte.getScore();
}

	
	private boolean rouler(int direction, Niveau n, int x, int y) { // x et y la
																	// ou est le
																	// rocher
		if (direction == 1 && n.carte.tab[x][y - 1].type == ' ') {
			n.carte.tab[x][y - 1] = Rocher.getInstance();
			n.carte.tab[x][y] = Vide.getInstance();
			return true;
		}
		if (direction == 3 && n.carte.tab[x][y + 1].type == ' ') {
			n.carte.tab[x][y + 1] = Rocher.getInstance();
			n.carte.tab[x][y] = Vide.getInstance();
			return true;
		}
		return false;
	}

	private void graviter(Carte c) {
		for (int i = c.tab.length; i > 0; i--) {
			for (int j = c.tab[0].length; j > 0; j--) {
				if (c.tab[i][j].type == 'r') {
					if (c.tab[i + 1][j].type == ' ') { // en bas
						c.tab[i + 1][j] = Rocher.getInstance();
						c.tab[i][j] = Vide.getInstance();
					} else if (c.tab[i][j + 1].type == ' '
							&& c.tab[i + 1][j + 1].type == ' '
							&& (c.tab[i + 1][j].type == 'r' || c.tab[i + 1][j].type == 'w')) { // a
																								// droite
						c.tab[i + 1][j + 1] = Rocher.getInstance();
						c.tab[i][j] = Vide.getInstance();
					} else if (c.tab[i][j - 1].type == ' '
							&& c.tab[i + 1][j - 1].type == ' '
							&& (c.tab[i + 1][j].type == 'r' || c.tab[i + 1][j].type == 'w')) { // a
																								// gauche
						c.tab[i + 1][j - 1] = Rocher.getInstance();
						c.tab[i][j] = Vide.getInstance();
					} else if (c.tab[i + 1][j].type == 'M'
							&& c.tab[i + 2][j].type == ' ' && c.tab[i][j].tombe) { // en
																					// bas
																					// par
																					// M
																					// M
						c.tab[i + 2][j] = Diamant.getInstance();
						c.tab[i][j] = Vide.getInstance();
					} else if (c.tab[i + 1][j].type == 'R' && c.tab[i][j].tombe) { // en
																					// bas
																					// //pour
																					// la
																					// mort
						c.tab[i + 1][j] = Rocher.getInstance();
						c.tab[i][j] = Vide.getInstance();
						explosion(i + 1, j, c);
					} else if (c.tab[i][j + 1].type == ' '
							&& c.tab[i + 1][j + 1].type == 'R'
							&& (c.tab[i + 1][j].type == 'r' || c.tab[i + 1][j].type == 'w')) { // a
																								// droite
						c.tab[i + 1][j + 1] = Rocher.getInstance();
						c.tab[i][j] = Vide.getInstance();
						explosion(i + 1, j + 1, c);
					} else if (c.tab[i][j - 1].type == ' '
							&& c.tab[i + 1][j - 1].type == 'R'
							&& (c.tab[i + 1][j].type == 'r' || c.tab[i + 1][j].type == 'w')) { // a
																								// gauche
						c.tab[i + 1][j - 1] = Rocher.getInstance();
						c.tab[i][j] = Vide.getInstance();
						explosion(i + 1, j + 1, c);
					} else if (c.tab[i + 1][j].type == 'M'
							&& c.tab[i + 2][j].type == 'R' && c.tab[i][j].tombe) { // en
																					// bas
																					// par
																					// M
																					// M
						c.tab[i + 2][j] = Diamant.getInstance();
						c.tab[i][j] = Vide.getInstance();
						explosion(i + 2, j, c);
					}
				}
				if (c.tab[i][j].type == 'd') {
					if (c.tab[i + 1][j].type == 'd') { // en bas
						c.tab[i + 1][j] = Diamant.getInstance();
						c.tab[i][j] = Vide.getInstance();
					} else if (c.tab[i][j + 1].type == ' '
							&& c.tab[i + 1][j + 1].type == ' '
							&& (c.tab[i + 1][j].type == 'r' || c.tab[i + 1][j].type == 'w')) { // a
																								// droite
						c.tab[i + 1][j + 1] = Diamant.getInstance();
						c.tab[i][j] = Vide.getInstance();
					} else if (c.tab[i][j - 1].type == ' '
							&& c.tab[i + 1][j - 1].type == ' '
							&& (c.tab[i + 1][j].type == 'r' || c.tab[i + 1][j].type == 'w')) { // a
																								// gauche
						c.tab[i + 1][j - 1] = Diamant.getInstance();
						c.tab[i][j] = Vide.getInstance();
					} else if (c.tab[i + 1][j].type == 'M'
							&& c.tab[i + 2][j].type == ' ' && c.tab[i][j].tombe) { // en
																					// bas
																					// par
																					// M
																					// M
						c.tab[i + 2][j] = Diamant.getInstance();
						c.tab[i][j] = Vide.getInstance();
					} else if (c.tab[i + 1][j].type == 'R' && c.tab[i][j].tombe) { // en
																					// bas
																					// //pour
																					// la
																					// mort
						c.tab[i + 1][j] = Diamant.getInstance();
						c.tab[i][j] = Vide.getInstance();
						explosion(i + 1, j, c);
					} else if (c.tab[i][j + 1].type == ' '
							&& c.tab[i + 1][j + 1].type == 'R'
							&& (c.tab[i + 1][j].type == 'r' || c.tab[i + 1][j].type == 'w')) { // a
																								// droite
						c.tab[i + 1][j + 1] = Diamant.getInstance();
						c.tab[i][j] = Vide.getInstance();
						explosion(i + 1, j + 1, c);
					} else if (c.tab[i][j - 1].type == ' '
							&& c.tab[i + 1][j - 1].type == 'R'
							&& (c.tab[i + 1][j].type == 'r' || c.tab[i + 1][j].type == 'w')) { // a
																								// gauche
						c.tab[i + 1][j - 1] = Diamant.getInstance();
						c.tab[i][j] = Vide.getInstance();
						explosion(i + 1, j + 1, c);
					} else if (c.tab[i + 1][j].type == 'M'
							&& c.tab[i + 2][j].type == 'R' && c.tab[i][j].tombe) { // en
																					// bas
																					// par
																					// M
																					// M
						c.tab[i + 2][j] = Rocher.getInstance();
						c.tab[i][j] = Vide.getInstance();
						explosion(i + 2, j, c);
					}
				}
			}
		}
	}

	protected boolean essaie(Niveau n, int i, int x, int y) {
		if (i == 1
				&& (n.carte.tab[x][y - 1] == Poussiere.getInstance()
						|| n.carte.tab[x][y - 1] == Vide.getInstance()
						|| rouler(i, n, x, y) || (n.carte.tab[x][y - 1] == Sortie
						.getInstance() && (n.score >= n.diamondsRequired * 100)))) {
			return true;
		} else if (i == 2
				&& (n.carte.tab[x - 1][y] == Poussiere.getInstance()
						|| n.carte.tab[x - 1][y] == Vide.getInstance()
						|| rouler(i, n, x, y) || (n.carte.tab[x - 1][y] == Sortie
						.getInstance() && (n.score >= n.diamondsRequired * 100)))) {
			return true;
		} else if (i == 3
				&& (n.carte.tab[x][y + 1] == Poussiere.getInstance()
						|| n.carte.tab[x][y + 1] == Vide.getInstance()
						|| rouler(i, n, x, y) || (n.carte.tab[x][y + 1] == Sortie
						.getInstance() && (n.score >= n.diamondsRequired * 100)))) {
			return true;
		} else if (i == 4
				&& (n.carte.tab[x + 1][y] == Poussiere.getInstance()
						|| n.carte.tab[x + 1][y] == Vide.getInstance() || rouler(
							i, n, x, y))
				|| (n.carte.tab[x + 1][y] == Sortie.getInstance() && (n.score >= n.diamondsRequired * 100))) {
			return true;
		} else if (i == 5) {
			return true;
		} else {
			return false;
		}
	}

	protected void deplacement(Niveau n, int i, int x, int y) {
		// gauche
		if (i == 1) {
			if (Diamant.getInstance() == n.carte.tab[x][y - 1]) {
				n.mettreAJourScore();
			}
			n.carte.tab[x][y - 1] = n.carte.tab[x][y];
			n.carte.tab[x][y] = Vide.getInstance();
		}// haut
		else if (i == 2) {
			if (Diamant.getInstance() == n.carte.tab[x - 1][y]) {
				n.mettreAJourScore();
			}
			n.carte.tab[x - 1][y] = n.carte.tab[x][y];
			n.carte.tab[x][y] = Vide.getInstance();
		}// droite
		else if (i == 3) {
			if (Diamant.getInstance() == n.carte.tab[x][y + 1]) {
				n.mettreAJourScore();
			}
			n.carte.tab[x][y + 1] = n.carte.tab[x][y];
			n.carte.tab[x][y] = Vide.getInstance();
		}// bas
		else if (i == 4) {
			if (Diamant.getInstance() == n.carte.tab[x + 1][y]) {
				n.mettreAJourScore();
			}
			n.carte.tab[x + 1][y] = n.carte.tab[x][y];
			n.carte.tab[x][y] = Vide.getInstance();
		} else {// pas bougé
			n.carte.tab[x][y] = n.carte.tab[x][y];
		}
	}

	private void mort(Niveau n) {
		int tab1[] = recupCoorRock(n.carte);
		int x = tab1[0], y = tab1[1];
		if (n.carte.tab[x - 1][y].type == 'F'
				|| n.carte.tab[x - 1][y].type == 'B'
				|| n.carte.tab[x - 1][y].type == 'a'
				|| n.carte.tab[x][y - 1].type == 'F'
				|| n.carte.tab[x][y - 1].type == 'B'
				|| n.carte.tab[x][y - 1].type == 'a'
				|| n.carte.tab[x][y + 1].type == 'F'
				|| n.carte.tab[x][y + 1].type == 'B'
				|| n.carte.tab[x][y + 1].type == 'a'
				|| n.carte.tab[x + 1][y].type == 'F'
				|| n.carte.tab[x + 1][y].type == 'B'
				|| n.carte.tab[x + 1][y].type == 'a')
			Rockford.getInstance().setmort();
	}

	private int[] recupCoorRock(Carte c) {
		int tab1[] = new int[2];
		for (int i = 0; i < c.tab.length; i++) {
			for (int j = 0; j < c.tab[0].length; j++) {
				if (c.tab[i][j].type == 'R') {
					tab1[0] = i;
					tab1[1] = j;
					return tab1;
				}
			}
		}
		tab1[0] = 0;
		tab1[1] = 0;

		return tab1;
	}

}
