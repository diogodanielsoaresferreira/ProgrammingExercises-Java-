/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula13;

import java.util.*;
import java.util.Map.Entry;

public class BrincaEBeira {


	public static void main(String[] args) {
		
		List<String> empregados= new LinkedList<>();
		List<String> brinq=new ArrayList<>();
		HashMap <String, String> freeToyMap = new HashMap<>();
		
		empregados.add("António Sala");
		empregados.add("Mar");
		empregados.add("Tó Viola");
		empregados.add("Tó José");
		empregados.add("Diogo Daniel");
		empregados.add("Carlos Daniel");
		empregados.add("Carlos Brites");
		
		brinq.add("Heliscócio");
		brinq.add("Carro dos bombeiros");
		brinq.add("John Cena");
		brinq.add("Cristiano Ronaldo");
		brinq.add("Ferrari");
		
		freeToyMap.put(empregados.get((int)(Math.random()*empregados.size())), brinq.get((int)(Math.random()*brinq.size())));
		int rand=(int)(Math.random()*empregados.size());
		while (freeToyMap.containsKey(empregados.get(rand))){
			rand=(int)(Math.random()*empregados.size());
		}
		freeToyMap.put(empregados.get(rand), brinq.get((int)(Math.random()*brinq.size())));
		
		System.out.println(freeToyMap);
		
		Iterator<String> it=empregados.iterator();
		while (it.hasNext()){
			brinq.add(it.next().split(" ")[0]);
		}
		
		System.out.println(brinq);
		
		brinq.clear();
		
		HashMap<String, Integer> fName=new HashMap<>();
		Iterator<String> itB=empregados.iterator();
		
		while (itB.hasNext()){
			String b=itB.next().split(" ")[0];
			if(fName.containsKey(b)){
				fName.put(b,fName.get(b)+1);
			}
			else{
				fName.put(b, 1);
			}
		}
		
		System.out.println(fName);
		
		HashMap<String, Integer> hm=new HashMap<String, Integer>();
		Iterator<String> i=empregados.iterator();
		hm.put(i.next(), 1);
		while(i.hasNext()){
			hm.put(i.next(), 0);
		}
		
		System.out.println(hm);
		
	}

}
