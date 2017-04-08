
public final class Diamant { /* aidé par wikipédia pattern matching singleton */

	private static volatile Diamant instance = null;
	private char type = 'd';

	private Diamant() {
		super();
	}

	public final static Diamant getInstance() {
		if (Diamant.instance == null) {
			synchronized (Diamant.class) {
				if (Diamant.instance == null) {
					Diamant.instance = new Diamant();
				}
			}
		}
		return Diamant.instance;
	}

	public String toString() {
		String s = "";
		s += type;
		return s;
	}
}