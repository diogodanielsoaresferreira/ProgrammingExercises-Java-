package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex605 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		double b;
		Pessoa a = new Pessoa();
		
		a = introutil();
		b = tas(a);
		resultado(b);

	}
	
	public static Pessoa introutil(){
		
		Pessoa a = new Pessoa();
		
		out.print("Qual o seu nome? ");
		a.nome = sc.nextLine();
		out.print("\nQual é o seu sexo (m/f)? ");
		a.sex = sc.next().charAt(0);
		while (a.sex != 'm' && a.sex != 'f'){
			out.print("\nInválido. Insira m/f: ");
			a.sex = sc.next().charAt(0);
		}
		out.print("\nQual é o seu peso (em Kg)? ");
		a.pes = sc.nextDouble();
		while(a.pes<=0){
			out.print("\nInsira um valor válido: ");
			a.pes = sc.nextDouble();
		}
		out.print("\nInsira agora a quantidade de bebida ingerida, em ml: ");
		a.beb = sc.nextDouble();
		while(a.beb<=0){
			out.print("\nInsira um valor válido: ");
			a.beb = sc.nextDouble();
		}
		out.print("\nQual o teor alcoólico da bebida ingerida, de 1 a 100? ");
		a.teor = sc.nextDouble();
		while(a.teor<0 || a.teor>100){
			out.print("\nInsira um valor válido: ");
			a.teor = sc.nextDouble();
		}
		char b;
		do{
		out.print("\nFoi consumida em jejum (s/n)? ");
		b = sc.next().charAt(0);
		}while(b!='s' && b!='n');
		if(b=='s') a.jejum = true;
		else a.jejum=false;
		
		return a;
	}
	
	public static double tas (Pessoa a){
		double b;
		final double DensidadeAlcool = 0.8;
		
		b=(DensidadeAlcool*a.beb*(a.teor/100))/(a.pes*coeficiente(a));
				
		return b;
	}
	
	public static double coeficiente(Pessoa a){
		double b;
		
		if(a.sex=='f' || a.jejum==true) b=0.6;
		else if(a.sex=='m' || a.jejum==true) b=0.7;
		else b=1.1;
		
		return b;
	}
	
	public static void resultado (double b){
		out.println("A sua taxa de alcoolemia é de " + b +".");
	}
	
	public static class Pessoa{
		String nome;
		char sex;
		double pes;
		double beb;
		double teor;
		boolean jejum;
	}

}
