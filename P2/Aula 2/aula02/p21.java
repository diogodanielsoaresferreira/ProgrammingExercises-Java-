/*************************************************************************
 * Compilation: javac j21.java 
 * Execution: java j21
 *************************************************************************/

public class p21 {
	// Exemplo simples de utilização da class Complex
	public static void main(String[] args) {
		Complexo a = new Complexo(5.0, 6.0);

		// Vamos usar métodos de 'a'
		System.out.println("(" + a.real() + " + " + a.imag() + "i)");
		System.out.println("  parte real = " + a.real());
		System.out.println("  parte imaginaria = " + a.imag());
		System.out.println("  modulo = " + a.abs());
		System.out.printf("  fase   =  %2.2f\n", a.phase());
	}

}
