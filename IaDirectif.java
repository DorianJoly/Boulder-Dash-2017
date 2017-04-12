import java.util.*;

public class IaDirectif {
	private Coordonné transformation(int a,int b){
		Coordonné coor=new Coordonné();
		coor.miseAJour(a, b);
		return coor;
	}
	private Coordonné cible(Carte c){
		ArrayList <Coordonné> tabTarget;
		for(int i=0;i<c.tab.length;i++){
			for(int j=0;j<c.tab[i].length;j++){
				if(c.tab[i][j]==Diamant.getIntance()){
					Coordonné A=new Coordonné(i,j);
				}
			}
		}
	}
	
	
	
	
	
}
