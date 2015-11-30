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

public class Ementa {

	private String nome;
	private List<Prato>[] pratospordia= new LinkedList[7];
	
	public Ementa(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public Prato[] getPratPorDia(int i){
		if(pratospordia[i]== null) return new Prato[0];
		
		Iterator<Prato> it = pratospordia[i].iterator();
		Prato[] a = new Prato[pratospordia[i].size()];
		int j=0;
		while(it.hasNext()){
			a[j++]=it.next();
		}
		
		return a;
		
	}
	
	public void addPrato(Prato p, DiaSemana d){
		if(pratospordia[d.ordinal()]==null)
			pratospordia[d.ordinal()] = new LinkedList<Prato>();
		pratospordia[d.ordinal()].add(p);
	}
	
	public void remPrato(Prato p, int k){
		if(!pratospordia[k].contains(p)){
			System.out.print("\nO prato não está atualmente na ementa nesse dia.");
			return;
		}
		
		pratospordia[k].remove(p);
		System.out.print("\nO prato foi removido com sucesso da ementa para o dia escolhido.");
		
	}
	
	@Override
	public String toString() {
		String ret ="";
		for(int i=0;i<pratospordia.length;i++){
			if(pratospordia[i]!=null && !pratospordia[i].isEmpty()){
				Iterator<Prato> p=pratospordia[i].iterator();
				while(p.hasNext()){
					ret += "\n"+p.next().toString()+", dia "+DiaSemana.day(i);
				}
			}
			
		}
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + Arrays.hashCode(pratospordia);
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
		Ementa other = (Ementa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (!Arrays.equals(pratospordia, other.pratospordia))
			return false;
		return true;
	}



	public enum DiaSemana{
		Segunda, Terca, Quarta, Quinta, Sexta, Sabado, Domingo;
		
		public static String day(int i){
			switch (i){
				default: return "";
				case 0: return "Segunda";
				case 1: return "Terça";
				case 2: return "Quarta";
				case 3: return "Quinta";
				case 4: return "Sexta";
				case 5: return "Sábado";
				case 6: return "Domingo";
			}
		}
			public static DiaSemana enumDay(int i){
				switch (i){
					default:
					case 0: return DiaSemana.Segunda;
					case 1: return DiaSemana.Terca;
					case 2: return DiaSemana.Quarta;
					case 3: return DiaSemana.Quinta;
					case 4: return DiaSemana.Sexta;
					case 5: return DiaSemana.Sabado;
					case 6: return DiaSemana.Domingo;
				}
		}
	}
	
}
