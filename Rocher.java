
public final class Rocher { /* aidé par wikipédia pattern matching singleton */

	private static volatile Rocher instance = null;
	private char type = 'r';

	private Rocher() {
		super();
	}

	public final static Rocher getInstance() {
		if (Rocher.instance == null) {
			synchronized (Rocher.class) {
				if (Rocher.instance == null) {
					Rocher.instance = new Rocher();
				}
			}
		}
		return Rocher.instance;
	}

	public String toString() {
		String s = "";
		s += type;
		return s;
	}
}