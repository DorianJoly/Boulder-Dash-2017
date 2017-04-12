package PacNum2;

public final class MurMagique implements Element{
	private boolean peutTombe=false;
	private boolean tombe=false;
	private char type='M';
	
	private static volatile MurMagique instance = null;
	
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
