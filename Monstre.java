package PacNum2;

public final class Monstre implements Element {
	private boolean peutTombe=false;
	private boolean tombe=false;
	private char type='L';
	
	private static volatile Monstre instance = null;
	
	private Monstre() {
		super();
	}

	public final static Monstre getInstance() {
		if (Monstre.instance == null) {
			synchronized (Monstre.class) {
				if (Monstre.instance == null) {
					Monstre.instance = new Monstre();
				}
			}
		}
		return Monstre.instance;
	}

	public String toString() {
		String s = "";
		s += type;
		return s;
	}

}
