/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class p64 {

	public static void main(String[] args) {
		String b = "";
		
		try{
			b=invertString(args[0]);
			System.out.println(b);
		}
		catch(IndexOutOfBoundsException e){
			System.err.println("Nenhum argumento detetado!");
			System.out.println(e.getMessage());
		}
		
	}
	
	public static String invertString(String a){
		String c="";
		
		if(a.length()==0) return "";
		
		for(int i=0;i<a.length()-1;i++){
			c+=a.charAt(i);
		}
		
		return a.charAt(a.length()-1)+invertString(c);
		
	}

}
