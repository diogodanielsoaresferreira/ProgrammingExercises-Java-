/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula7;

public class Hora implements Comparable<Hora>, Cloneable {
	
	private int min, hora;
	
	private Hora(int hora, int min){
		this.hora = hora;
		this.min = min;
	}
	
	public static Hora newHora(int hora, int min){
		if (hora>23 || hora<0) return null;
		if (min>60 || min<0) return null;
		return new Hora(hora, min);
	}
	
	public int getHora(){
		return hora;
	}
	
	public int getMin(){
		return min;
	}
	
	@Override
	public int compareTo(Hora h){
		if(h.getHora()<hora) return -1;
		else if (h.getHora()>hora) return 1;
		
		if(h.getMin()<min) return -1;
		else if (h.getMin()>min) return 1;
		
		return 0;
	}
	
	public void add(Hora h){
		Hora c= Hora.newHora(h.getHora(), h.getMin());
		
		while(!(c.getHora()==0 && c.getMin()==0)){
			c.retMin();
			this.addMin();
		}
		
	}
	
	public long toLong(){
		return min+60*hora;
	}
	
	public static Hora longToHour(long l){
		return Hora.newHora((int)l/60,(int)l%60);
	}
	
	public void addMin(){
		min++;
		if(min<60) return;
		min=0;
		hora++;
		if(hora<24) return;
		hora=0;
	}
	
	public void retMin(){
		min--;
		if(min>=0) return;
		min=59;
		hora--;
		if(hora>=0) return;
		hora=23;
	}
	
	public Hora diff(Hora h){
		Hora c = Hora.newHora(h.hora, h.min);
		Hora ret = Hora.newHora(this.getHora(), this.getMin());
		while(!(c.getHora()==0 && c.getMin()==0)){
			c.retMin();
			ret.addMin();
		}
		
		return ret;
	}
	
	@Override
	public String toString(){
		return String.format("%02d", hora)+":"+String.format("%02d", min);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hora;
		result = prime * result + min;
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
		Hora other = (Hora) obj;
		if (hora != other.hora)
			return false;
		if (min != other.min)
			return false;
		return true;
	}
	
	
}
