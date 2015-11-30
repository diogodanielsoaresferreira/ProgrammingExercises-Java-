/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula5;

public class Test2 {

	public static void main(String args[]){
		
		Veículo[] v = new Veículo[4];
		v[0] = new Bicicleta("Vermelho",1,"Orbita",1999,45,"Orbita","Orbita",4);
		v[1] = new Automóvel("Branco",5,"Mercedes",2006,220,20,2,23, 6);
		v[2] = new Mota("Preto", 2, "Yamaha", 2010,160, 250, 5, 20, "NEXX");
		v[3] = new CarroPolicia("Verde",2,"Opel",2011,300,40,2,23, 6,"GNR","25");
		
		UtilCompare.sortArray(v);
		for(Veículo veic: v){
			System.out.println(veic);
		}
	}
	
}
