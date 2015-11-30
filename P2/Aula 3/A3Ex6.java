/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * N� Mecanogr�fico: 76504
 * Universidade de Aveiro, 2015
 */
package pt.ua.prog;

import static java.lang.System.*;
import java.util.Scanner;

public class A3Ex6 {

	final static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {

		int o;
		Data x = new Data();
		Data.date(x);
																				//Falta representa�ao interna desde 1 de janeiro de 2000
		do{
			out.println("\n1 - Cria novo objeto com a data atual");
			out.println("2 - Cria novo objeto com uma qualquer data");
			out.println("3 - Indica se a data � v�lida");
			out.println("4 - Escreve data");
			out.println("5 - Escreve data por extenso");
			out.println("6 - Dia anterior");
			out.println("7 - Dia seguinte");
			out.println("8 - Ver se data � maior que nova data comparada");
			out.println("9 - Ver se data � igual � nova data comparada");
			out.println("10 - Ver se data � menor que nova data comparada");
			out.println("11 - Calcular quantos dias h� entre duas datas");
			out.println("0 - Termina");
			out.println();
			out.println("Nota: \tSe n�o houver outra indica��o, todas as opera��es \n\tfazem-se sobre o �ltimo objeto criado");
			out.println();
			out.print("\nOp��o: ");
			o=sc.nextInt();
			
			switch(o){

				case 1:
					x = new Data();
					Data.date(x);
					out.println("Data atual inicializada!");
					break;
				case 2:
					x.newdate();
					break;
				case 3:
					if(Data.isvaliddate(x)) out.println("A data � v�lida!");
					else out.println("A data n�o � v�lida!");
					break;
				case 4:
					out.println(x.printdate());
					break;
				case 5:
					x.getextdate();
					break;
				case 6:
					x.vaiParaOntem();
					break;
				case 7:
					x.vaiParaAmanha();
					break;
				case 8:
					Data y = new Data();
					out.print("\nData para comparar.\nAno: ");
					int ano = sc.nextInt();
					out.print("\nM�s: ");
					int mes = sc.nextInt();
					out.print("\nDia: ");
					int dia = sc.nextInt();
					y.setYear(dia, mes, ano);
					boolean maior = x.maiorQue(y);
					if(maior) out.print("\nA sua data � maior que a comparada!\n");
					else out.print("A sua data n�o � maior que a comparada!");
					break;
				case 9:
					Data y2 = new Data();
					out.print("\nData para comparar.\nAno: ");
					int ano2 = sc.nextInt();
					out.print("\nM�s: ");
					int mes2 = sc.nextInt();
					out.print("\nDia: ");
					int dia2 = sc.nextInt();
					y2.setYear(dia2, mes2, ano2);
					boolean igual = x.igualA(y2);
					if(igual) out.print("\nA sua data � igual que a comparada!\n");
					else out.print("A sua data n�o � igual que a comparada!");
					break;
				case 10:
					Data y3 = new Data();
					out.print("\nData para comparar.\nAno: ");
					int ano3 = sc.nextInt();
					out.print("\nM�s: ");
					int mes3 = sc.nextInt();
					out.print("\nDia: ");
					int dia3 = sc.nextInt();
					y3.setYear(dia3, mes3, ano3);
					boolean menor = x.menorQue(y3);
					if(menor) out.print("\nA sua data � menor que a comparada!\n");
					else out.print("A sua data n�o � menor que a comparada!");
					break;
				case 11:
					Data y4 = new Data();
					out.print("\nData para contar.\nAno: ");
					int ano4 = sc.nextInt();
					out.print("\nM�s: ");
					int mes4 = sc.nextInt();
					out.print("\nDia: ");
					int dia4 = sc.nextInt();
					y4.setYear(dia4, mes4, ano4);
					int days = x.diasentredatas(y4);
					out.print("\nH� "+days+" dias entre as duas datas.\n");
					break;
				case 0:
					out.print("Obrigado por jogar!");
					break;
				default:
					out.println("Op��o inv�lida!");
					break;
			}
		}while(o!=0);
	}

}
