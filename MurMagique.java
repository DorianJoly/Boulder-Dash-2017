
public final class MurMagique { /*
								 * aidé par wikipédia pattern matching singleton
								 */

	private static volatile MurMagique instance = null;
	private char type = 'M';

	private MurMagique() {
		super();
	}

	public final static MurMagique getInstance() {
		if (MurMagique.instance == null) {
			synchronized (MurMagique.class) {
				if (MurMagique.instance == null) {
					MurMagique.instance = new MurMagique();
				}
			}
		}
		return MurMagique.instance;
	}

	
	public String toString() {
		String s = "";
		s += type;
		return s;
	}
}