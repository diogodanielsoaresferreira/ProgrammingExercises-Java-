package p2;
import static java.lang.System.*;
import java.util.Scanner;

/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * N� Mecanogr�fico: 76504
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
			out.println("3 - Indica se a data � v�lida");
			out.println("4 - Escreve data");
			out.println("5 - Escreve data por extenso");
			out.println("6 - Dia anterior");
			out.println("7 - Dia seguinte");
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
