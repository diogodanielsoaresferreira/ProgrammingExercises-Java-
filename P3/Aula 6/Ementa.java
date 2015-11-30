/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula6;

import java.util.Arrays;

public class Ementa {

	private String nome;
	private Stack<Prato>[] pratospordia= new Stack[7];
	
	public Ementa(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public Prato[] getPratPorDia(int i){
		if(pratospordia[i]== null) return new Prato[0];
		Object[] e = pratospordia[i].nodesToArray();
		Prato[] a = new Prato[e.length];
		for (int j=0;j<e.length;j++){
			a[j] = (Prato)e[j];
		}
		return a;
	}
	
	public void addPrato(Prato p, DiaSemana d){
		if(pratospordia[d.ordinal()]==null)
			pratospordia[d.ordinal()] = new Stack<Prato>();
		pratospordia[d.ordinal()].push(p);
	}
	
	public void remPrato(Prato p, int k){
		if(!pratospordia[k].exists(p)){
			System.out.print("\nO prato não está atualmente na ementa nesse dia.");
			return;
		}
		
		pratospordia[k].del(p);
		System.out.print("\nO prato foi removido com sucesso da ementa para o dia escolhido.");
		
	}
	
	@Override
	public String toString() {
		String ret ="";
		for(int i=0;i<pratospordia.length;i++){
			if(pratospordia[i]!=null && !pratospordia[i].isEmpty())
				for(Object e: pratospordia[i].nodesToArray()){
					Prato a = (Prato)e;
					ret += "\n"+a.toString()+", dia "+DiaSemana.day(i);
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
