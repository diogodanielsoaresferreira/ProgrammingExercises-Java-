/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula5;

public class Retangulo extends Figura {
	private double l,h;
	
	public Retangulo( double x, double y,double l, double h){
		super(new Point(x,y));
		assert l>0 && h>0;
		this.l = l;
		this.h = h;
	}
	
	public Retangulo(Point x,double l, double h){
		super(x);
		assert l>0 && h>0;
		this.l = l;
		this.h = h;
	}
	
	
	public Retangulo(double l, double h){
		super(new Point(0,0));
		assert l>0 && h>0;
		this.l = l;
		this.h = h;
	}
	
	
	public Retangulo(Retangulo r){
		super(r.getCentro());
		this.l=r.getL();
		this.h=r.getH();
	}
	
	public double area(){
		return l*h;
	}
	
	public double per(){
		return l*2+h*2;
	}

	public double getL(){
		return l;
	}
	
	public double getH(){
		return h;
	}
	
	@Override
	public String toString(){
		return "Retângulo com centro no "+super.getCentro().toString()+", com comprimento "+l+" e largura "+h+", área "+area()+" e perímetro "+per()+".";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(h);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(l);
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
		Retangulo other = (Retangulo) obj;
		if (Double.doubleToLongBits(h) != Double.doubleToLongBits(other.h))
			return false;
		if (Double.doubleToLongBits(l) != Double.doubleToLongBits(other.l))
			return false;
		if (!super.getCentro().equals(other.getCentro()))
			return false;
		return true;
	}
	

	
}
