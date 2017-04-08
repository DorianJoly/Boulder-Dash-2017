
public final class Mur { /* aidé par wikipédia pattern matching singleton */

	private static volatile Mur instance = null;
	private char type = 'w';

	private Mur() {
		super();
	}

	public final static Mur getInstance() {
		if (Mur.instance == null) {
			synchronized (Mur.class) {
				if (Mur.instance == null) {
					Mur.instance = new Mur();
				}
			}
		}
		return Mur.instance;
	}

	public String toString() {
		String s = "";
		s += type;
		return s;
	}

}
