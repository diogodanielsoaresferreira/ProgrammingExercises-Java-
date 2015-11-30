/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class Exame5 {

	public static void main(String[] args) {
		for(String a : args){
			System.out.println(a+" contêm "+countPairs(a, 0)+" pares de carateres consecutivos iguais.");
		}
	}
	
	public static int countPairs(String a, int b){
		
		if(a.length()>1){
			if(a.charAt(0)==a.charAt(1)){
				b++;
			}
			b = countPairs(a.substring(1), b);
		}
		else{
			return b;
		}
		
		return b;
	}

}
