package PacNum2;

public final class Sortie implements Element{
	private boolean peutTombe=false;
	private boolean tombe=false;
	private char type='X';
	
	private static volatile Sortie instance = null;
	
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
