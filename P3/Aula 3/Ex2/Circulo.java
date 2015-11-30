/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

public class Circulo extends Figura {
	private double raio;
	
	public Circulo(double x, double y, double r){
		super(new Point(x,y));
		this.raio=r;
	}
	
	public Circulo(double r){
		super(new Point(0,0));
		this.raio=r;
	}
	
	public Circulo(Circulo c){
		super(c.getCentro());
		this.raio = c.getR();
	}
	
	@Override
	public String toString(){
		return "Círculo com centro no "+getCentro().toString()+" e de raio "+raio+".";
	}
	
	public double getR(){
		return raio;
	}
	
	
	public double area(){
		return Math.PI*Math.pow(raio, 2);
	}
	
	public double per(){
		return 2*Math.PI*raio;
	}
	
	public boolean equals(Circulo c2){
		if(c2.raio==raio && getCentro().getX()==c2.getCentro().getX() && getCentro().getY()==c2.getCentro().getY())
			return true;
		return false;
	}
	
	public boolean intCirc(Circulo c2){
		if(getCentro().distTo(c2.getCentro())-raio-c2.getR()<=0) return true;
		
		return false;
	}
	
}
