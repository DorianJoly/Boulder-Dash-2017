
public final class Mur { /* aid� par wikip�dia pattern matching singleton */

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
