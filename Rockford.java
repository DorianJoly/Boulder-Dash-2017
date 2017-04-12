package PacNum2;

public final class Rockford implements Element{
	private boolean peutTombe=false;
	private boolean tombe=false;
	private char type='R';
	private boolean mort=false;
	
	private static volatile Rockford instance = null;
	
	private Rockford() {
		super();
	}

	public final static Rockford getInstance() {
		if (Rockford.instance == null) {
			synchronized (Rockford.class) {
				if (Rockford.instance == null) {
					Rockford.instance = new Rockford();
				}
			}
		}
		return Rockford.instance;
	}

	public String toString() {
		String s = "";
		s += type;
		return s;
	}

	public boolean getmort(){
		return mort;
	}
	
	public void setmort(){
		mort=true;
	}
	
}
