
public final class Poussiere { /*
								 * aidé par wikipédia pattern matching singleton
								 */

	private static volatile Poussiere instance = null;
	private char type = '.';

	private Poussiere() {
		super();
	}

	public final static Poussiere getInstance() {
		if (Poussiere.instance == null) {
			synchronized (Poussiere.class) {
				if (Poussiere.instance == null) {
					Poussiere.instance = new Poussiere();
				}
			}
		}
		return Poussiere.instance;
	}

	public String toString() {
		String s = "";
		s += type;
		return s;
	}

}