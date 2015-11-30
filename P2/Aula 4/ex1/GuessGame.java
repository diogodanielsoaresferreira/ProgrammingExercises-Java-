/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import java.lang.Math;

public class GuessGame {
	
	private int randomNum, numAttempts=0,min, max;
	int [] attempt = new int[0];
	int secretNumber;
	
	GuessGame(int min, int max){
		assert max>min : "Intervalo de valores não é válido!";
		randomNum = (int)(Math.random() * (max - min) + min);
		this.min=min;
		this.max=max;
		secretNumber=randomNum;
	}
	
	public int min(){
		return min;
	}
	
	public int max(){
		return max;
	}
	
	public boolean validAttempt(int n){
		return (n<=max && n>=min);
	}
	
	public boolean finished(){
		for(int i=0;i<attempt.length;i++){
			if (randomNum==attempt[i]) return true;
		}
		return false;
	}
	
	public void play(int n){
		int [] a2 = new int [attempt.length+1];
		
		assert n<=max && n>=min : "Número introduzido não pertence ao intervalo.";
		if(finished()) return;
		for(int i=0;i<attempt.length;i++){
			a2[i]=attempt[i];
		}
		a2[attempt.length]=n;
		attempt=a2;
		numAttempts++;
	}
	
	public boolean attemptIsHigher(){
		
		if(attempt[attempt.length-1]>randomNum) return true;
		else return false;
	}
	
	public boolean attemptIsLower(){
		
		if(attempt[attempt.length-1]<randomNum) return true;
		else return false;
	}
	
	public int numAttempts(){
		return this.numAttempts;
	}
	
}
