/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula5;

public abstract class Figura implements Comparable<Figura> {
	
	private Point centro;
	
	Figura(Point centro){
		this.centro = centro;
	}
	
	public Point getCentro(){
		return centro;
	}

	public abstract double area();
	public abstract double per();
	
	@Override
	public int compareTo(Figura fig){
		assert fig!=null;
		
		if(this.area()>fig.area()){
			return 1;
		}
		else if(this.area()<fig.area()){
			return -1;
		}
		else return 0;
		
	}
	
}
