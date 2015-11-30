/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import java.util.Scanner;
    
public class JogaJogoDoGalo {
  public static void main(String[] args) {
	  
    Scanner sin = new Scanner(in);
    
    char jogador1 = 'X';
    char jogador2 = 'O';
    
    int x=0;
    int y=0;
    
    try{
    	for(int i=0;i<10;i++){
    	    JogoDoGalo jogo = new JogoDoGalo(jogador1, jogador2);
    	    int lin, col;
    		
    	    System.out.println("Jogo "+(i+1)+":");
    		
	    	while (!jogo.terminado()) {
	    	    jogo.mostraTabuleiro();
	    		out.print("(lin col): ");
	    		
			    lin = sin.nextInt();
			    col = sin.nextInt();
			    jogo.jogada(lin, col);
			    
			    if(jogo.terminado())
			    	jogo.mostraTabuleiro();
	    	}
	
		    out.println();
		    
		    if (jogo.ultimoJogadorGanhou()){
		    	out.println("Jogador "+jogo.ultimoJogador()+" ganhou!");
			    if(jogo.ultimoJogador()=='X') x++;
			    else y++;
		    }

		    else
		    	out.println("Jogo empatado!");
		    System.out.println("Jogador X: "+x+" vitórias");
		    System.out.println("Jogador Y: "+y+" vitórias");
		    if(x==3 || y==3){
		    	System.out.println("O jogo acabou! Ganhou o jogador "+(x==3?"x":"y"));
		    	exit(0);
		    }
    	}
    }
    catch(Throwable e){
    	System.out.println("Jogada inválida!");
    	exit(1);
    }
    if(x>y){
    	System.out.println("O jogador x ganhou!");
    }
    else if(y>x){
    	System.out.println("O jogador y ganhou!");
    }
    else{
    	System.out.println("Houve um empate!");
    }
  }
}
