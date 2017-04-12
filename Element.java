package PacNum2;

public interface Element {
	boolean tombe=false;
	boolean peutTombe=false;
	char type=' ';
	Diamant diam=Diamant.getInstance();
	Monstre monster=Monstre.getInstance();
	Mur mur=Mur.getInstance();
	MurMagique MM=MurMagique.getInstance();
	MurTitane MT=MurTitane.getInstance();
	Poussiere Pous=Poussiere.getInstance();
	Rocher Roc=Rocher.getInstance();
	Rockford Rocky=Rockford.getInstance();
	Sortie sortie=Sortie.getInstance();
	Vide vide=Vide.getInstance();
}
