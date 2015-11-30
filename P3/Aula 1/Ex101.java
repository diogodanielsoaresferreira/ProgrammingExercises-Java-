/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº Mec. 76504
 * 
 */
package aula1;


import static java.lang.System.*;
import java.util.Scanner;

public class Ex101 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {

		out.print("Introduza a sua frase: ");
		String s = sc.nextLine();
		out.println("\nA sua frase possui "+carNum(s)+" carater(es) numérico(s).");
		if(isMai(s))
			out.println("A sua frase apenas possui letras maiúsculas.");
		else if(isMin(s))
			out.println("A sua frase apenas possui letras minúsculas.");
		out.println("A sua frase tem "+splitWords(s).length+" palavras, que são:");
		for(String a: splitWords(s))
			out.println(a);
		out.println("Se trocarmos os carateres 2 a 2, a frase passa a ser: \""+change2(s)+"\".");
	}
	
	public static int carNum(String args){
		int i=0;
		for(int j=0;j<args.length();j++)
			if(Character.isDigit(args.charAt(j)))
				i++;
		
		return i;
	}
	
	public static boolean isMai(String args){
		for(int i=0;i<args.length();i++)
			if(Character.isLowerCase(args.charAt(i)))
				return false;
		
		return true;
	}
	
	public static boolean isMin(String args){
		for(int i=0;i<args.length();i++)
			if(Character.isUpperCase(args.charAt(i)))
				return false;
		
		return true;
	}
	
	public static String[] splitWords(String args){
		return args.split("\\s+ ");
	}
	
	public static String change2(String args){
		String s = "";
		char a = ' ';
		
		for(int i=0;i<args.length();i++){
			if(i%2==0){
				a = args.charAt(i);
			}
			else{
				s += Character.toString(args.charAt(i))+Character.toString(a);
				a = ' ';
			}
		}
		
		if(a != ' ')
			s += a;
		return s;
	}

}
