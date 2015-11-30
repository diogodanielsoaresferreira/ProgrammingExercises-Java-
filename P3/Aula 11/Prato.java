/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula11;

import aula6.*;
import java.util.*;

public class Prato implements Comparable<Prato> {

	private String nome;
	private List<Alimento> al=new LinkedList<Alimento>();
	
	public Prato(String nome){
		this.nome=nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public List<Alimento> getAl(){
		return al;
	}
	
	public boolean addAl(Alimento alim){
		al.add(alim);
		return true;
	}
	
	public Alimento[] getAlimentos(){
		Alimento[]a = new Alimento[al.size()];
		int j=0;
		Iterator<Alimento> p = al.iterator();
		while(p.hasNext())
			a[j++]=p.next();
		return a;
		
	}
	
	public boolean exists(Alimento alim){
		return al.contains(alim);
	}
	
	public void del(Alimento alim){
		al.remove(alim);
	}
	
	@Override
	public int compareTo(Prato p){
		double cal=0;
		Iterator<Alimento> itAl=al.iterator();
		while(itAl.hasNext()){
			cal += itAl.next().getCalorias();
		}
		Iterator<Alimento> itAl2=p.al.iterator();
		double cal2=0;
		while(itAl2.hasNext()){
			cal2 += itAl2.next().getCalorias();
		}
		
		if(cal>cal2) return 1;
		else if (cal==cal2) return 0;
		else return -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((al == null) ? 0 : al.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Prato other = (Prato) obj;
		if (al == null) {
			if (other.al != null)
				return false;
		} else if (!al.equals(other.al))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if(!super.equals(other))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prato "+nome+" composto por "+al.size()+" ingredientes";
	}
	
	
	
	
}
