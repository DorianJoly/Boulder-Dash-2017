
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LectureBDCFF {

	// TEST
	public Niveau lecture(String nom) {
		String NomFichier = "C:\\Users\\wargl\\Desktop\\workspace projet\\BoulderDashProjet\\" + nom;

		char[][] tab;
		ArrayList<ArrayList> tempo = new ArrayList<ArrayList>();
		boolean map = false;
		String name = "";
		int caveDelay = 0;
		int caveTime = 0;
		int diamondsRequired = 0;
		int primaryDiamondValue = 0;
		int secondaryDiamondValue = 0;
		int amoebaTime = 0;
		int magicWallTime = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(NomFichier))) {
			String Ligne;
			while ((Ligne = br.readLine()) != null) {
				String[] mot = Ligne.split("]");
				if (!mot[0].equals("[/cave")) {
					if ((!mot[0].equals("[map")) && !map) {
						String[] partie = Ligne.split("=");
						switch (partie[0]) {
						case "Name":
							name = partie[1];
							break;
						case "CaveDelay":
							caveDelay = Integer.parseInt(partie[1]);
							break;
						case "CaveTime":
							caveTime = Integer.parseInt(partie[1]);
							break;
						case "DiamondsRequired":
							diamondsRequired = Integer.parseInt(partie[1]);
							break;
						case "DiamondValue":
							String[] val = partie[1].split(" ");
							primaryDiamondValue = Integer.parseInt(val[0]);
							secondaryDiamondValue = Integer.parseInt(val[1]);
							break;
						case "AmoebaTime":
							amoebaTime = Integer.parseInt(partie[1]);
							break;
						case "MagicWallTime":
							magicWallTime = Integer.parseInt(partie[1]);
							break;
						}
					} else if ((!mot[0].equals("[/map")) && map) {
						ArrayList lignetab = new ArrayList<>();
						for (int i = 0; i < Ligne.length(); i++) {
							lignetab.add(Ligne.charAt(i));
						}
						tempo.add(lignetab);
					} else if (mot[0].equals("[map")) {
						map = true;
					}
				}
			}
			int nbliste = tempo.size();
			int taille_listezero = tempo.get(0).size();
			String s = "";
			tab = new char[nbliste][taille_listezero];
			for (int i = 0; i < nbliste; i++) {
				for (int j = 0; j < taille_listezero; j++) {
					tab[i][j] = (char) tempo.get(i).get(j);
					s = s + tab[i][j];
				}
				s = s + "\n";
			}

			System.out.println(s);
			Carte carte = new Carte(tab, diamondsRequired, magicWallTime);
			/* System.out.println(carte); */
			Niveau init = new Niveau(name, caveDelay, caveTime, diamondsRequired, primaryDiamondValue,
					secondaryDiamondValue, amoebaTime, magicWallTime, carte);
			return init;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (CarteInvalideException e) {
			System.out.println(e.getMessage());
		}
		int u = 2 / 0; // faire une erreur
		return null;

	}
}
