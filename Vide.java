package PacNum2;

public final class Vide implements Element{
	private boolean peutTombe=false;
	private boolean tombe=false;
	private char type=' ';
	
	private static volatile Vide instance = null;
	
	private Vide() {
		super();
	}

	public final static Vide getInstance() {
		if (Vide.instance == null) {
			synchronized (Vide.class) {
				if (Vide.instance == null) {
					Vide.instance = new Vide();
				}
			}
		}
		return Vide.instance;
	}

	public String toString() {
		String s = "";
		s += type;
		return s;
	}

}
