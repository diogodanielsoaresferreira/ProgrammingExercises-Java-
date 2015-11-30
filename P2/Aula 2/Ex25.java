package p2;
import static java.lang.System.*;
import java.util.Scanner;

/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
import p2.Data;

public class Ex25 {

	final static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {

		int o;
		Data x = new Data();
		Data.date(x);
		
		do{
			out.println("\n1 - Cria novo objeto com a data atual");
			out.println("2 - Cria novo objeto com uma qualquer data");
			out.println("3 - Indica se a data é válida");
			out.println("4 - Escreve data");
			out.println("5 - Escreve data por extenso");
			out.println("6 - Dia anterior");
			out.println("7 - Dia seguinte");
			out.println("0 - Termina");
			out.println();
			out.println("Nota: \tSe não houver outra indicação, todas as operações \n\tfazem-se sobre o último objeto criado");
			out.println();
			out.print("\nOpção: ");
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
					if(Data.isvaliddate(x)) out.println("A data é válida!");
					else out.println("A data não é válida!");
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
				case 0:
					out.print("Obrigado por jogar!");
					break;
				default:
					out.println("Opção inválida!");
					break;
			}
		}while(o!=0);
	}

}
