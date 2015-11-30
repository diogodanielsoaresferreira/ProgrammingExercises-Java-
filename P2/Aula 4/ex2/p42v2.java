/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import java.util.Scanner;

public class p42v2 {

	final static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int min, max, tent;
		GuessGame a;
		
		if (args.length==2){
			min = Integer.parseInt(args[0]);
			max = Integer.parseInt(args[1]);
			out.print("\nValores máximos e mínimos atualizados.");
			a = new GuessGame(min, max);
		}
		else{
			min=0;
			max=20;
			out.print("Valor mínimo 0 e valor máximo 20");
			a = new GuessGame(min, max);
		}
		
		do{
			out.print("\nQual é o número que acha estar certo?");
			tent = sc.nextInt();
			a.play(tent);
			if(a.attemptIsHigher()){
				out.print("\nTente mais baixo!");
			}
			else if(a.attemptIsLower()){
				out.print("\nTente mais alto!");
			}
			else{
				out.print("\nParabéns! Acertou!");
			}
		}while(!a.finished());
		
		out.print("\nUsou "+a.numAttempts()+" tentativas.");
	}

}
