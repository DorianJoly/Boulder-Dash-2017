package PacNum2;

public final class Poussiere implements Element {
	private boolean peutTombe=false;
	private boolean tombe=false;
	private char type='.';
	
	private static volatile Poussiere instance = null;
	
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
