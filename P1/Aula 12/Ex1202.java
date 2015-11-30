/**
 * Diogo Daniel Soares Ferreira, 2014
 */
package p1;
import  java.util.Scanner;
import static java.lang.System.*;

public class Ex1202 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {

		int i=0;
		double sum=0;
		double distmax=0;
		int l=1, c=2;
		double [][]pontos = new double [l][c];
		

		Ponto2D af = new Ponto2D();
		af.x=0;
		af.y=0;
		Ponto2D x=new Ponto2D();
		
		do{
			
		out.print("Introduza as coordenadas de um ponto.\nX: ");
		x.x=sc.nextDouble();
		out.print("\nY: ");
		x.y=sc.nextDouble();
		
		if (x.x==0 && x.y==0) break;
		
		if(i==0){
			pontos[0][0]=x.x;
			pontos[0][1]=x.y;
		}
		else pontos=adPonto(pontos, x.x, x.y, l, c);

		
		l++;
		i++;
		
		sum += distanciaorigem(x);
		
		
		if(distanciaorigem(x)>distmax){ af.x=x.x; af.y = x.y; distmax = distanciaorigem(x);}
		
		}while (x.x!=0 || x.y!=0);
		

		out.println("A soma das distâncias dos " + i + " pontos à origem é " + sum + ".");
		out.println("O ponto mais afastado da origem foi: (" + af.x + ", " + af.y + ")");
		out.println("Os pontos inseridos foram :");
		
		for(int k=0; k<l-1; k++){
			for(int j=0; j<c; j++){
				out.printf("%4.1f| ",pontos[k][j]);
			}
			out.print("\n");
		}
		
	}
	
	
	public static Ponto2D lerponto(){
		
		Ponto2D a;
		a = new Ponto2D();
		
		out.print("Insira a coordenada X: ");
		a.x=sc.nextDouble();
		
		out.print("\nInsira a coordenada Y: ");
		a.y=sc.nextDouble();
		
		return a;
	}
	
	public static void imprimePonto(Ponto2D x){
		
		out.println(x.x + ", " + x.y);
		
	}
	
	public static double distancia(Ponto2D x, Ponto2D y){
		
		double d;
		
		d=Math.sqrt(Math.pow((x.x-y.x), 2) + Math.pow((x.y-y.y), 2));
		
		return d;
	}

	public static double distanciaorigem (Ponto2D x){
		double d;
		
		d=Math.sqrt(Math.pow(x.x, 2) + Math.pow(x.y, 2));
		
		return d;
	}
	
	public static class Ponto2D{
		
		public double x;
		public double y;
		
	}
	
	public static double[][] adPonto(double m[][], double x, double y, int l, int c){
		double [][]m2=new double [l+1][2];

		m2[0][0]=x;
		m2[0][1]=y;
		
		for(int i=0; i<l-1; i++){
			for(int j=0; j<c; j++){
				m2[i+1][j]=m[i][j];
			}
		}
		
		return m2;
	}
}
