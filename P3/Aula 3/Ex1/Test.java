/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

public class Test {
	public static void main(String args[]){
		Estudante est = new Estudante ("Andreia", 9855678, new Data(18, 7, 1974));
		Bolseiro bls = new Bolseiro ("Maria", 8976543, new Data(11, 5, 1976));
		bls.setBolsa(745);
		
		System.out.println("Estudante:" + est.getName());
		System.out.println(est);
		System.out.println("Bolseiro:" + bls.getName() + ", NMec: " + bls.getCC()+ ", Bolsa:" + bls.getBolsa());
		System.out.println(bls);
	}
}
