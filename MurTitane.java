package PacNum2;

public final class MurTitane implements Element {
	private boolean peutTombe=false;
	private boolean tombe=false;
	private char type='W';
	
	private static volatile MurTitane instance = null;
	
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
