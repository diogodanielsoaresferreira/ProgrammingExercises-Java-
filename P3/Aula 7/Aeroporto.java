/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula7;

import java.nio.file.*;
import java.io.*;
import java.util.*;

import static java.lang.System.*;

public class Aeroporto {

	public static void main(String[] args) {
		
		Stack<Voo> voosdia = new Stack<Voo>();
		AssociativeArray<String> companhias = new AssociativeArray<String>(30);
		
		addCompanhias("F:\\Universidade\\2º ano\\1º Semestre\\Programação III\\Práticas\\Aula 7\\aula7_material\\companhias.txt", companhias);
		addVoos("F:\\Universidade\\2º ano\\1º Semestre\\Programação III\\Práticas\\Aula 7\\aula7_material\\voos.txt",voosdia, companhias);
		saveF("F:\\Universidade\\2º ano\\1º Semestre\\Programação III\\Práticas\\Aula 7\\aula7_material\\Infopublico.txt",voosdia);
		saveBinaryF("F:\\Universidade\\2º ano\\1º Semestre\\Programação III\\Práticas\\Aula 7\\aula7_material\\Infopublico.bin",voosdia);
		for(byte i : (readBinaryF("F:\\Universidade\\2º ano\\1º Semestre\\Programação III\\Práticas\\Aula 7\\aula7_material\\Infopublico.bin")))
			out.print((char)i);
		out.println(mediaAtrasosPorCompanhia(voosdia, companhias));
		saveCidades("F:\\Universidade\\2º ano\\1º Semestre\\Programação III\\Práticas\\Aula 7\\aula7_material\\cidades.txt",voosdia);
		
	}
	
	public static void addCompanhias(String name, AssociativeArray<String> companhias){
		Path p = Paths.get(name);
		
		try{
			if (Files.notExists(p) || !Files.isReadable(p))
				throw new java.io.IOException();
			
			File f = new File(name);
			Scanner read = new Scanner(f);

			read.nextLine();
			while(read.hasNextLine()){
				String line[] = read.nextLine().split("\t");
				if(line==null) break;
				companhias.set(line[0], line[1]);
			}
			
			read.close();
		}
		catch(IOException | IndexOutOfBoundsException e){
			err.println("Erro na leitura do ficheiro.");
		}
	}

	public static void addVoos(String name, Stack<Voo> s, AssociativeArray<String> companhias){
		Path p = Paths.get(name);
		
		try{
			if (Files.notExists(p) || !Files.isReadable(p))
				throw new java.io.IOException();
			
			File f = new File(name);
			Scanner read = new Scanner(f);

			read.nextLine();
			while(read.hasNextLine()){
				String line[] = read.nextLine().split("\t");
				if(line==null) break;
				if(line.length==4){
					s.push(new Voo(Hora.newHora(Integer.parseInt(line[0].split(":")[0]), Integer.parseInt(line[0].split(":")[1])),line[1],companhias.get(line[1].split(" ")[0]),line[2],Hora.newHora(Integer.parseInt(line[3].split(":")[0]), Integer.parseInt(line[3].split(":")[1]))));
				}else if(line.length==3){
					s.push(new Voo(Hora.newHora(Integer.parseInt(line[0].split(":")[0]), Integer.parseInt(line[0].split(":")[1])),line[1],companhias.get(line[1].split(" ")[0]),line[2]));
				}else break;
			}
			
			read.close();
		}
		catch(IOException | IndexOutOfBoundsException e){
			err.println("Erro na leitura do ficheiro.");
		}
	}
	
	public static String printVoos(Stack<Voo> v){
		String r="Hora   Voo             Companhia                 Origem Atraso  Obs\n";
		Object[] s = v.nodesToArray();
		for(int i=s.length-1;i>=0;i--){
			r+=(Voo)s[i]+"\n";
		}
		return r;
	}
	
	public static void saveF(String name, Stack<Voo> v){
		
		try{
			
			File f = new File(name);
			PrintWriter write = new PrintWriter(f);
			write.print(printVoos(v));
			write.close();
		}
		catch(IOException e){
			err.println("Erro na escrita do ficheiro.");
		}
	}
	
	public static void saveBinaryF(String name, Stack<Voo> v){
		
		try{
			
			Path path = Paths.get(name);
		    Files.write(path, printVoos(v).getBytes()); 
		}
		catch(IOException e){
			err.println("Erro na escrita do ficheiro.");
		}
	}
	
	public static byte[] readBinaryF(String name){
		try {
			RandomAccessFile file = new RandomAccessFile(name, "rw");
			byte []b = new byte[(int) file.length()];
			file.read(b);
			return b;
		} catch (IOException  e) {
			err.println("Erro na leitura do ficheiro.");
		}
		return new byte[0];
	}
	
	public static String mediaAtrasosPorCompanhia(Stack<Voo> v, AssociativeArray<String> c){
		String[] keys = c.keysToArray();
		HashMap<String, Hora> atr = new HashMap<String, Hora>();
		
		for(String key : keys){
				atr.put(c.get(key) ,atraso(v, c.get(key)));
		}
		
		String r="";
		String namemin= "";
		Hora min;
		int j=atr.size();
		
		for(int i=0;i<j;i++){
			min=Hora.newHora(23, 59);
			for(String key : keys){
				if(atr.containsKey(c.get(key)))
					if(min.compareTo(atr.get(c.get(key)))==-1){
						min=atr.get(c.get(key));
						namemin=c.get(key);
					}
			}
			atr.remove(namemin);
			r+=namemin+": "+min+"\n";
		}
		
		return r;
		
	}
	
	public static void saveCidades(String name, Stack<Voo> v){
		Path p = Paths.get(name);
		
		try{
			
			File f = new File(name);
			PrintWriter write = new PrintWriter(f);
			int max;
			String smax;
			HashMap<String, Integer> h = getNumberByCity(v);
			int size=h.size();
			write.println("Origem    Voos");
			for(int i=0;i<size;i++){
				max = 0;
				smax = "";
				for(String s : h.keySet()){
					if(h.containsKey(s)){
						if(h.get(s)>max){
							max = h.get(s);
							smax = s;
						}
					}
				}
				h.remove(smax);
				write.println(smax+": "+max);
			}
			
			write.close();
		}
		catch(IOException e){
			err.println("Erro na escrita do ficheiro.");
		}
		
	}
	
	private static HashMap<String, Integer> getNumberByCity(Stack<Voo> v){
		HashMap<String, Integer> h= new HashMap<String, Integer>();

		Object[] s = v.nodesToArray();
		for(int i=s.length-1;i>=0;i--){
			int j=0;
			if(h.containsKey(((Voo)s[i]).getOrigem()))
					j=h.get((((Voo)s[i]).getOrigem()));
			h.put(((Voo)s[i]).getOrigem(), j+1);
		}

		return h;
	}
	
	private static Hora atraso(Stack<Voo> v, String companhia){
		Hora atraso=Hora.newHora(0, 0);
		int n=0;
		for(Object voo : v.nodesToArray()){
			if(((Voo)voo).getCompanhia().equals(companhia)){
				n++;
				if(((Voo)voo).getAtraso()!=null)
					atraso.add(((Voo)voo).getAtraso());
			}
		}
		if(n!=0)
			atraso=Hora.longToHour((atraso.toLong()/n));
		return atraso;
		
	}
	
	
}
