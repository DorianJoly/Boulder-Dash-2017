package PacNum2;

public class Niveau {
	String name;
	int score;
	boolean fini=false;
	int caveDelay;
	int caveTime;
	int diamondsRequired;
	int primaryDiamondValue;
	int secondaryDiamondValue;
	int amoebaTime;
	int magicWallTime;
	Carte carte;

	public Niveau(String name, int caveDelay, int caveTime, int diamondsRequired, int primaryDiamondValue,
			int secondaryDiamondValue, int amoebaTime, int magicWallTime, Carte carte) {
		this.name = name;
		this.caveDelay = caveDelay;
		this.caveTime = caveTime;
		this.diamondsRequired = diamondsRequired;
		this.primaryDiamondValue = primaryDiamondValue;
		this.secondaryDiamondValue = secondaryDiamondValue;
		this.amoebaTime = amoebaTime;
		this.magicWallTime = magicWallTime;
		this.carte = carte;
	}

	public boolean aFini(){
		return fini;
	}
	public void setFini(){
		fini=true;
	}
	
	public void mettreAJourScore(){
		score=score+100;
	}
	
	
	public String toString() {
		String s;
		s = "nom :" + name + "\n CaveTime :" + caveTime + "\n Diamonds Required :" + diamondsRequired
				+ "\n Primary Diamond Value :" + primaryDiamondValue + "\n Secondary Diamond Value :"
				+ secondaryDiamondValue + "\n AmoebaTime :" + amoebaTime + "\n Magic Wall Time :" + magicWallTime + "\n"
				+ carte.toString();
		return s;
	}

	public int retourScore() {
		return (primaryDiamondValue + secondaryDiamondValue);

	}

}
