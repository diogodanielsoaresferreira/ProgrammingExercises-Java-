/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula4;

public class Circulo extends Figura {
	private double raio;
	
	public Circulo(double x, double y, double r){
		super(new Point(x,y));
		this.raio=r;
	}
	
	public Circulo(Point p, double r){
		super(p);
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(raio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circulo other = (Circulo) obj;
		if (Double.doubleToLongBits(raio) != Double.doubleToLongBits(other.raio))
			return false;
		if(!super.getCentro().equals(other.getCentro()))
			return false;
		return true;
	}

	
	public boolean intCirc(Circulo c2){
		if(getCentro().distTo(c2.getCentro())-raio-c2.getR()<=0) return true;
		
		return false;
	}
	
}
