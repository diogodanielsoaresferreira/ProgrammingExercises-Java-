package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex810 {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		Pessoa a = new Pessoa();
		
		readData(a);
		imc(a);
		impress(a);

	}
	
	public static Pessoa readData(Pessoa a){
		
		out.print("Escreva o seu nome: ");
		a.name = sc.nextLine();
		
		out.print("\nInsira a sua idade: ");
		a.age = sc.nextInt();
		while(a.age<18){
			out.print("\nIdade inválida. Insira novamente a sua idade");
			a.age = sc.nextInt();
		}
		
		out.print("\nEscreva o seu sexo (m/f): ");
		a.sex=sc.next().charAt(0);
		while(a.sex!='m' && a.sex!='f'){
			out.print("\nEntrada inválida. Escreva o seu sexo (m/f): ");
			a.sex=sc.next().charAt(0);
		}
		
		out.print("\nInsira a sua altura (m): ");
		a.height = sc.nextDouble();
		while(a.height<0){
			out.print("\nEntrada inválida. Insira a sua altura novamente: ");
			a.height = sc.nextDouble();
		}
		
		out.print("\nInsira o seu peso (Kg): ");
		a.weight = sc.nextDouble();
		while(a.weight<0){
			out.print("\nEntrada inválida. Insira o seu peso novamente: ");
			a.weight = sc.nextDouble();
		}
		
		return a;
	}
	
	public static Pessoa imc(Pessoa a){
		
		a.imc=(a.weight)/(Math.pow(a.height, 2));
		
		return a;
	}
	
	public static void impress(Pessoa a){
		String sexo="";
		String comentario="";
		
		switch(a.sex){
		
		case 'm': sexo= "Masculino"; break;
		case 'f': sexo = "Feminino"; break;
		
		}
		
		if(a.imc<18.5) comentario="Abaixo do peso";
		else if(a.imc<=24.9) comentario="Saudável";
		else if(a.imc<=29.9) comentario="Peso em excesso";
		else if(a.imc<=34.9) comentario="Obesidade grau I";
		else if(a.imc<=39.9) comentario="Obesidade grau II";
		else if(a.imc>=40.0) comentario="Obesidade grau III";
		
		
		out.println("\n|--------------------------------------|");
		out.println("| Calculo do Indice de Massa Corporal  |");
		out.println("|--------------------------------------|");
		out.printf("\n| Nome: %30s |", a.name);
		out.printf("\n| Sexo: %17s              |", sexo);
		out.printf("\n| IMC : %4.1f (kg/m2)                   |", a.imc);
		out.printf("\n| Comentario: %25s|", comentario);
		out.printf("\n|--------------------------------------|");
		
	}

	
	public static class Pessoa{
		
		String name;
		int age;
		char sex;
		double weight;
		double height;
		double imc;
	}
	
}
