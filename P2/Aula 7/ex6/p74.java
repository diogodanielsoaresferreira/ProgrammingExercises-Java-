/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import pt.ua.gboard.*;
import pt.ua.gboard.games.*;

public class p74 {

	public static void main (String [ ] args){
		
		boolean QueensP [][] = new boolean [16][16];
		
		
		boolean result = placeQueens(QueensP,0);
		
		ChessBoard cboard = new ChessBoard (16) ;
		
		if(result){
			for(int i=0;i<QueensP.length;i++){
				for(int j=0;j<QueensP.length;j++){
					if(QueensP[i][j])
						cboard.put(ChessPieceType.WHITE_QUEEN, i,j);
					
				}
			}
		}
		else
			out.print("Impossível de colocar!");
		
		//cboard.put(ChessPieceType.WHITE_QUEEN, 0 , 0 ) ;
		//GBoard.sleep(1000); // 1 second
		//cboard.remove (0,0);
		//GBoard.sleep(500) ;
		//cboard.put(ChessPieceType.WHITE_QUEEN,7,7);
	}
	
	public static boolean isAttacked(boolean[][] queensPosition, int lin, int col){
		
		assert queensPosition != null;
		assert lin>=0 & lin<queensPosition.length;
		assert col>=0 & col<queensPosition.length;
		
		boolean result = false;
		
		for(int c=0; !result && c<col; c++){
			result = queensPosition[lin][c] ||
					(lin-col+c >= 0 && queensPosition[lin-col+c][c]) ||
					(lin+col-c < queensPosition.length && queensPosition[lin+col-c][c]);
		}
		
		if(result)return result;
		
		result = 	(col-2>=0 					&& lin-1>=0						&& queensPosition[lin-1][col-2])||
					(col-2>=0 					&& lin+1<queensPosition.length 	&& queensPosition[lin+1][col-2])||
					(col-1>=0 					&& lin-2>=0						&& queensPosition[lin-2][col-1])||
					(col-1>=0 					&& lin+2<queensPosition.length 	&& queensPosition[lin+2][col-1])||
					(col+1<queensPosition.length && lin-2>=0 					&& queensPosition[lin-2][col+1])||
					(col+1<queensPosition.length && lin+2<queensPosition.length && queensPosition[lin+2][col+1])||
					(col+2<queensPosition.length && lin-1>=0 					&& queensPosition[lin-1][col+1])||
					(col+2<queensPosition.length && lin+1<queensPosition.length && queensPosition[lin+1][col+2]);
		
		
		return result;
		
	}
	
	public static boolean placeQueens(boolean [][]queensPosition, int col){
		assert queensPosition != null;
		assert col>=0 && col<queensPosition.length;
		
		boolean result;
		if(col==queensPosition.length){
			return true;
		}
		else{
			result = false;
		}
		
		for(int lin=0; !result && lin<queensPosition.length;lin++){
			if(!isAttacked(queensPosition, lin, col)){
				queensPosition[lin][col] = true;
				result = placeQueens(queensPosition, col+1);
				if(!result)
					queensPosition[lin][col] = false;
			}
		}		
			return result;
	}
		

}
