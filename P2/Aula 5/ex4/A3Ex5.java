/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import java.util.*;
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
				try{
					long i= sc.nextLong();
					boolean valido=false;
					while(a>0){
						if (a==5 || a==2 || a==1){
							valido = true;
							break;
						}
						a/=10;
					}
					if(i<0 || !valido) throw new InputMismatchException("Número inválido");

					b.adicionaMoeda(i);
				}
				catch(InputMismatchException i){
					err.println("O valor introduzido não é válido.");
					exit(1);
				}
				catch(NumberFormatException i){
					err.println("O valor introduzido não é válido.");
					exit(1);
				}
			}
			else if(a==2){
				out.print("\nDeseja retirar até ficar com quanto?");
				
				try{
					long r= sc.nextLong();
					if(r<0 || r>b.total()) throw new InputMismatchException("Número inválido");
					
					b.retiraDinheiro(r);
				}
				catch(InputMismatchException i){
					err.println("O valor introduzido não é válido.");
					exit(1);
				}
				catch(NumberFormatException i){
					err.println("O valor introduzido não é válido.");
					exit(1);
				}
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
