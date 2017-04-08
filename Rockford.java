
public final class Rockford { /*
								 * aidé par wikipédia pattern matching singleton
								 */

	private static volatile Rockford instance = null;

	public int nbDiamants = 0;
	public int score;
	private char type = 'R';

	private Rockford() {
		super();
		
	}

	public final static Rockford getInstance() {
		if (Rockford.instance == null) {
			synchronized (Rockford.class) {
				if (Rockford.instance == null) {
					Rockford.instance = new Rockford();
				}
			}
		}
		return Rockford.instance;
	}

	public int getNbDiamants() {
		return nbDiamants;
	}

	public String toString() {
		String s = "";
		s += type;
		return s;
	}

	public void setNbDiamants() {
		this.nbDiamants++;
	}

	
}