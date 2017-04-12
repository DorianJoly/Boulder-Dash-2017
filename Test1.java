import java.util.Scanner;
import java.io.*;

public class Test1 {
	public static Scanner in=new Scanner(System.in);
	public static int aleatoire (int min, int max){
		return (int) (Math.random () * (max-min+1)) +min;
	}
	public static void start(int time){
		Carte c=new Carte();
		int x_position=c.position_x,y_position=c.position_y;	
		System.out.println(c.toString());
		while(time!=0){
			boolean validé=false;
			while(!validé){
				time(time);
				System.out.println("Donner direction :\n1:Gauche\n2:Haut\n3:Droite\n4:Bas\n5:Pas de Mouvement");
				int direction=in.nextInt();//aleatoire(1,5);
				validé=essaie(direction,c,x_position,y_position);
			}
			time--;
		}
		
	}
	public static boolean essaie(int direction,Carte c, int x_position,int y_position){
		/*
		 -1 = Gauche
		 -2 = Haut
		 -3 = Droite 
		 -4 = Bas 
		 -5 = Pas Mouv
		 */
	try{
		if(direction==1 && c.tab[x_position][y_position-1]!='w'&&c.tab[x_position][y_position-1]!='W'){
			c.déplacement(0,-1);
			System.out.println(c.toString());
			return true;
		}else if(direction==2 && c.tab[x_position-1][y_position]!='w'&&c.tab[x_position-1][y_position]!='W'){
			c.déplacement(-1,0);
			System.out.println(c.toString());
			return true;
		}else if(direction==3 && c.tab[x_position][y_position+1]!='w'&&c.tab[x_position][y_position+1]!='W'){
			c.déplacement(0,1);
			System.out.println(c.toString());
			return true;
		}else if(direction==4 && c.tab[x_position+1][y_position]!='w'&&c.tab[x_position+1][y_position]!='W'){
			c.déplacement(1,0);
			System.out.println(c.toString());
			return true;
		}else 
			System.out.println(c.toString());
			return true;
	}catch(MouvementException e){
		System.out.println(e);
		return false;
	}
	
	}

	public boolean Fin(){
		/* instancier carte c et niveau n*/
		return c.tab[c.position_x][c.position_y]=='X'&&c.nbDiamants==n.DiamondsRequired;
				}
	public static void time(int x){
		System.out.println("Nombre de déplacement Restant = "+x);
	}
}
