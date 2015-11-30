package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex503 {

	public static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		int mes, ano, i=0;
		boolean bis=false;
		
		do{
			out.print("Insira o Mês: ");
			mes = sc.nextInt();
		}while(mes<1 || mes>12);
		do{
			out.print("\nInsira o Ano: ");
			ano = sc.nextInt();
		}while (ano<1);
		
		if(((ano%4==0) && (ano%400==0)) || ((ano%4==0) && (ano%100!=0))) bis = true;
		
		switch (mes){
		
			case 1:i=31; break;
			case 2:i=(bis==true)?29:28; break;
			case 3:i=31; break;
			case 4:i=30; break;
			case 5:i=31; break;
			case 6:i=30; break;
			case 7:i=31; break;
			case 8:i=31; break;
			case 9:i=30; break;
			case 10:i=31; break;
			case 11:i=30; break;
			case 12:i=31; break;
		}
		out.print(i);
	}

}
