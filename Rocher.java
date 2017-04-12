package PacNum2;

public final class Rocher implements Element{
	private boolean peutTombe=true;
	private boolean tombe=false;
	private char type='r';
	
	private static volatile Rocher instance = null;
	
	private Rocher() {
		super();
	}

	public final static Rocher getInstance() {
		if (Rocher.instance == null) {
			synchronized (Rocher.class) {
				if (Rocher.instance == null) {
					Rocher.instance = new Rocher();
				}
			}
		}
		return Rocher.instance;
	}

	public String toString() {
		String s = "";
		s += type;
		return s;
	}

}
