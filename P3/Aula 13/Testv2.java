/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Testv2 {
	public static void main(String args[]){
		Localidadev2<Cidade> cid1 = new Localidadev2<>("Szohod", 31212);
		Localidadev2<Cidade> cid2 = new Localidadev2<>("Wadesdah", 23423);
		Localidadev2<Vila> cid3 = new Localidadev2<>("BedRock", 23423);
		Estadov2 est1 = new Estadov2("North Borduria", 223133, cid1);
		Estadov2 est2 = new Estadov2("South Borduria", 84321, cid2);
		Paisv2 p1 = new Paisv2("Borduria", est1.getCapital());
		Paisv2 p2 = new Paisv2("Khemed", cid2);
		Paisv2 p3 = new Paisv2("Aurelia");
		Paisv2 p4 = new Paisv2("Atlantis");
		p1.addRegiao(est1);
		p1.addRegiao(est2);
		p2.addRegiao(new Provincia("Afrinia", 232475, "Aluko Pono"));
		p2.addRegiao(new Provincia("Eriador", 100000, "Dumpgase Liru"));
		p2.addRegiao(new Provincia("Laurania", 30000, "Mukabamba Dabba"));
		List<Paisv2> org = new ArrayList<Paisv2>();
		org.add(p1);
		org.add(p2);
		org.add(p3);
		org.add(p4);
		System.out.println("----Iterar sobre o conjunto");
		Iterator<Paisv2> itr = org.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		System.out.println("-------Iterar sobre o conjunto - For each (java 8)");
		for (Paisv2 pais: org)
			System.out.println(pais);
		p1.sort();
		p1.removeR(est1);
		p1.removeR(est2);
		p1.removeC();
		System.out.println(p1);
		//p2 = new Pais("Khemed", cid3); Erro de compilação :D
	}
}
