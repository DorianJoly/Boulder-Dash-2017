package PacNum2;

public final class Mur implements Element{
	private boolean peutTombe=false;
	private boolean tombe=false;
	private char type='w';
	
	private static volatile Mur instance = null;
	
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
