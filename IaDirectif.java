import java.util.*;

public class IaDirectif {
	private Coordonn� transformation(int a,int b){
		Coordonn� coor=new Coordonn�();
		coor.miseAJour(a, b);
		return coor;
	}
	private Coordonn� cible(Carte c){
		ArrayList <Coordonn�> tabTarget;
		for(int i=0;i<c.tab.length;i++){
			for(int j=0;j<c.tab[i].length;j++){
				if(c.tab[i][j]==Diamant.getIntance()){
					Coordonn� A=new Coordonn�(i,j);
				}
			}
		}
	}
	
	
	
	
	
}
