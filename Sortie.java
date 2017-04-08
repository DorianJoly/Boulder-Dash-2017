
public final class Sortie { /* aidé par wikipédia pattern matching singleton */

	private static volatile Sortie instance = null;
	private char type = 'X';

	private Sortie() {
		super();
	}

	public final static Sortie getInstance() {
		if (Sortie.instance == null) {
			synchronized (Sortie.class) {
				if (Sortie.instance == null) {
					Sortie.instance = new Sortie();
				}
			}
		}
		return Sortie.instance;
	}

	public String toString() {
		String s = "";
		s += type;
		return s;
	}
}
