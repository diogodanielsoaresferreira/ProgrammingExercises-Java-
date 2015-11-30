/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * N� Mecanogr�fico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class p51 {

	final static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int min, max, tent=0;
		GuessGame a;
		
		try{
			min = Integer.parseInt(args[0]);
			max = Integer.parseInt(args[1]);
			out.print("\nValores m�ximos e m�nimos atualizados.");
			a = new GuessGame(min, max);
		}
		catch(NumberFormatException e){
			min=0;
			max=20;
			out.print("Valor m�nimo 0 e valor m�ximo 20");
			a = new GuessGame(min, max);
		}
		catch(ArrayIndexOutOfBoundsException e){
			min=0;
			max=20;
			out.print("Valor m�nimo 0 e valor m�ximo 20");
			a = new GuessGame(min, max);
		}
		
		//if (args.length==2){
		//	min = Integer.parseInt(args[0]);
		//	max = Integer.parseInt(args[1]);
		//	out.print("\nValores m�ximos e m�nimos atualizados.");
		//	a = new GuessGame(min, max);
		//}
		//else{
		//	min=0;
		//	max=20;
		//	out.print("Valor m�nimo 0 e valor m�ximo 20");
		//	a = new GuessGame(min, max);
		//}
		
		do{
			out.print("\nQual � o n�mero que acha estar certo?");
			
			try{
				tent = sc.nextInt();
			}
			catch(InputMismatchException e){
				err.println("N�mero inv�lido!");
				exit(1);
			}
			catch(NumberFormatException e){
				err.println("N�mero inv�lido!");
				exit(1);
			}
			
			
			a.play(tent);
			if(a.attemptIsHigher()){
				out.print("\nTente mais baixo!");
			}
			else if(a.attemptIsLower()){
				out.print("\nTente mais alto!");
			}
			else{
				out.print("\nParab�ns! Acertou!");
			}
		}while(!a.finished());
		
		out.print("\nUsou "+a.numAttempts()+" tentativas.");
	}

}
