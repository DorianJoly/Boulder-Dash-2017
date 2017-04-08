
public final class MurTitane { /*
								 * aid� par wikip�dia pattern matching singleton
								 */

	private static volatile MurTitane instance = null;
	private char type = 'W';

	private MurTitane() {
		super();
	}

	public final static MurTitane getInstance() {
		if (MurTitane.instance == null) {
			synchronized (MurTitane.class) {
				if (MurTitane.instance == null) {
					MurTitane.instance = new MurTitane();
				}
			}
		}
		return MurTitane.instance;
	}

	public String toString() {
		String s = "";
		s += type;
		return s;
	}
}