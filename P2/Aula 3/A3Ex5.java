/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import java.util.Scanner;

public class A3Ex5 {

	final static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		long a;
		Caixa b = new Caixa();
		do{
			out.println("\n1 - Adicionar moedas");
			out.println("2 - Retirar dinheiro");
			out.println("3 - Ver moedas da carteira");
			out.println("4 - Ver total da carteira");
			out.println("0 - Termina");
			out.print("Opção -> ");
			a = sc.nextInt();
			
			if(a==1){
				out.print("\nQual moeda deseja adicionar?");
				long i= sc.nextLong();
				b.adicionaMoeda(i);
			}
			else if(a==2){
				out.print("\nDeseja retirar até ficar com quanto?");
				long r= sc.nextLong();
				b.retiraDinheiro(r);
			}
			else if(a==3) {
				long [] c;
				c = b.moedas();
				for(int z=0;z<c.length;z++) out.print("\n"+c[z]);
			}
			else if(a==4){
					out.println(b.total() + " cêntimos!");
			}
			else if(a==0);
			else out.println("\nEntrada inválida!");

		}while(a!=0);
	}

}
