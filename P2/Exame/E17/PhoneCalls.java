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

public class PhoneCalls
{
	public static void main(String [] args){
		try{
			File calls = new File("calls.cls");
			File name = new File("names.nms");
			Scanner readcalls = new Scanner (calls);
			Scanner readcalls2 = new Scanner (calls);
			Scanner readname = new Scanner (name);
			
			p101queue<String> call = new p101queue();
			
			while(readcalls.hasNextLine()){
				call.in(readcalls.nextLine());
			}
			
			AssociativeArray<String> names = new AssociativeArray(20);
			
			while(readname.hasNextLine()){
				String num = readname.next();
				String nam = readname.nextLine();
				names.set(num, nam);
			}
			if(args.length!=0){
				p101queue<String> call1 = new p101queue();
				p101queue<String> call2 = new p101queue();
				while(readcalls2.hasNextLine()){
					String c = (readcalls2.nextLine());
					String [] d = c.split(" ");
					for(String i : args){
						if(d[0].equals(i))
							call2.in(d[1]+d[2]);
						if(d[1].equals(i))
							call1.in(d[0]+d[2]);
					}
				}
				
				for(String j : args){
					String n;
					if(names.exists(j))
						n = names.get(j);
					else
						n = j;
					out.print("\nCalls made by"+n+":");
					while(!call2.isEmpty()){
						String z = call2.peek();
						String num = z.substring(0, 9);
						String sec = z.substring(9, 12);
						if(names.exists(num))
							num = names.get(num);
						out.print("\n\t- to phone "+num+" ("+sec+" seconds)");
						call2.out();
					}
					out.print("\nCalls received by"+n+":");
					while(!call1.isEmpty()){
						String z = call1.peek();
						String num = z.substring(0, 9);
						String sec = z.substring(9, 11);
						if(names.exists(num))
							num = names.get(num);
						out.print("\n\t- from phone "+num+" ("+sec+" seconds)");
						call1.out();
					}
				}
			}
			
			else{
				while(!call.isEmpty()){
					String cal = call.peek();
					call.out();
					String[] ca = cal.split(" ");
					if(names.exists(ca[0]))
						out.print("\n"+names.get(ca[0])+" to ");
					else
						out.print("\n"+ca[0]+" to ");
					
					if(names.exists(ca[1]))
						out.print(names.get(ca[1]));
					else
						out.print(ca[1]);
					
					out.print(" ("+ca[2]+" seconds)");
				}
			}
		}
		catch(Throwable e){
			err.println("Erro na leitura de ficheiros.");
		}
	}
}

