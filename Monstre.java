
public class Monstre {
	private char type = 'F';
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
