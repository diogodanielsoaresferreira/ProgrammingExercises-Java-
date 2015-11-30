/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;
//
// Considerando "prestacao" constante,
// a)	D0=(((100+taxa)*1/100)-prestacao;
//		D1=(((100+taxa)*M(0)/100)-prestacao;
//		D2=(((100+taxa)*(M(1))/100)-prestacao;
//		...
//		Dn=(((100+taxa)*(M(n-1))/100)-prestacao;

public class p66 {

	public static void main(String[] args) {

		double t=0, P=0, M=0;
		int n=0;
		
		try{
			n = Integer.parseInt(args[0]);
			M = Double.parseDouble(args[1]);
			t = Double.parseDouble(args[2]);
			P = Double.parseDouble(args[3]);
			
		}
		catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
			System.out.println("Erro ao ler valores de entrada.");
			System.exit(1);
		}
		
		System.out.println("Método Iterativo: "+itDn(M, t,P,n));
		System.out.println("Método Recursivo: "+recDn(M, t,P,n));
		
	}
	
	public static double itDn(double M, double t, double P, int n){
		double div=M;
		
		for(int i=0;i<n;i++){
			div=((100+t)*div/100)-P;
		}
		
		return div;
		
	}
	
	public static double recDn(double M, double t, double P, int n){
		
		if(n==0) return M;

		M = ((100+t)*recDn(M,t,P,n-1)/100)-P;
		
		return M;
	}

}
