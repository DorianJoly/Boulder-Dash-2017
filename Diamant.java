package PacNum2;

public final class Diamant implements Element {
	private boolean peutTombe=false;
	private boolean tombe=false;
	private char type='.';
	
	private static volatile Diamant instance = null;
	
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
