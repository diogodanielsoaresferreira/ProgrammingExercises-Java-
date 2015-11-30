/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;

import java.util.Scanner;
import java.io.*;

public class CityTraveler
{
	public static void main(String args[]){
		try{
			p101queue<String> k = new p101queue();
			AssociativeArray names = new AssociativeArray(50);
			int j=0;
			for(String i : args){
				File f = new File(i);
				Scanner readf = new Scanner(f);
				while(readf.hasNextLine()){
					k.in(readf.nextLine()+"-"+i);
				}
				j++;
			}
			while(!k.isEmpty()){
				if(!names.exists(k.peek().split("-")[0]))
					names.set(k.peek().split("-")[0],k.peek().split("-")[1]);
				else{
					String s = (String) names.get(k.peek().split("-")[0]);
					s += " "+k.peek().split("-")[1];
					names.set(k.peek().split("-")[0],s);
				}
				k.out();
			}
			
			for(String i : names.keysToArray())
				out.println(i+" : "+names.get(i));

			
		}
		catch(Throwable e){
			err.println("Erro nos ficheiros.");
		}
		
	}
}
