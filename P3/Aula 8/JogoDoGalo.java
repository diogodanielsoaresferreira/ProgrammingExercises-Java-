/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula8;

import java.io.IOException;

public class JogoDoGalo {
	private char c1;
	private char c2;
	private int i=0;
	char [][] array = new char[3][3];
	
	private JogoDoGalo(char c1){
		this.c1 = c1;
		if(c1=='O')
			c2='X';
		if(c1=='X')
			c2='O';
	}
	
	public static JogoDoGalo newJogoDoGalo(char c){
		if(c!='O' && c!='X')
			return null;
		else
			return new JogoDoGalo(c);
	}
	
	public int jogada(int l, int c){
		try{
			if(checkEnd()!=-1 || array[l][c]=='O' || array[l][c]=='X')
				throw new IOException();
		}
		catch(IOException e){
			System.err.println("Erro no programa.");
			System.exit(1);
		}
		array[l][c]= (i%2==0) ? c1:c2;
		i++;
		return checkEnd();
	}
	
	public char getChar(int l, int c){
		return array[l][c];
	}
	
	// 0 ou 1 para final de jogo com vitoria do jogador 1 ou 2
	// 2 para final empatado
	// -1 para não final do jogo
	private int checkEnd(){
		if(checkWin()!=-1) return checkWin();
		if(i==9) return 2;
		return -1;
	}
	
	private int checkWin(){
		if(array[0][0]==array[1][0] && array[1][0]==array[2][0] & array[0][0]!='\0') return i%2;
		if(array[0][1]==array[1][1] && array[1][1]==array[2][1] & array[0][1]!='\0') return i%2;
		if(array[0][2]==array[1][2] && array[1][2]==array[2][2] & array[0][2]!='\0') return i%2;
		if(array[0][0]==array[0][1] && array[0][1]==array[0][2] & array[0][0]!='\0') return i%2;
		if(array[1][0]==array[1][1] && array[1][1]==array[1][2] & array[1][0]!='\0') return i%2;
		if(array[2][0]==array[2][1] && array[2][1]==array[2][2] & array[2][0]!='\0') return i%2;
		if(array[0][0]==array[1][1] && array[1][1]==array[2][2] & array[0][0]!='\0') return i%2;
		if(array[0][2]==array[1][1] && array[1][1]==array[2][0] & array[0][2]!='\0') return i%2;
		return -1;
	}
	
}
