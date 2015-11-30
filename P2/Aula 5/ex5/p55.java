/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import java.util.*;
import java.io.*;

import static java.lang.System.*;

public class p55 {

	final static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args){
		File read;
		String file;
		Scanner ler = null;
		int col = 0;
		
		try{
			read=new File(args[0]);
			ler = new Scanner(read);
			col = Integer.parseInt(args[1])-1;
		}
		catch(FileNotFoundException | ArrayIndexOutOfBoundsException e){
			err.println("Erro nos argumentos de entrada.");
			exit(1);
		}
		
		while(ler.hasNextLine()){
			String nextL = ler.nextLine();
			int i=partsInt(nextL);
			if(col>i-1) out.println("\t");
			else out.println(divideInParts(nextL)[col]);
			
			
		}


		
	}
	
	
	public static String[] divideInParts (String l){
		String [] parts = new String[0];
		String a="";
		
		for(int i=0;i<l.length();i++){
			if (i!=0 && i!=l.length()-1) {
				if (Character.isWhitespace(l.charAt(i)));
				else if (!Character.isWhitespace(l.charAt(i)) && Character.isWhitespace(l.charAt(i - 1))) {
					if(a!=""){
						parts=addStr(parts, a);
						a="";
						a += l.charAt(i);
					}
					else{
						a += l.charAt(i);
					}
					
				} 
				else a += l.charAt(i);
			}
			else if (i==0){
				if (Character.isWhitespace(l.charAt(i)));
				else a += l.charAt(i);
				
			}
			else{
				if(!Character.isWhitespace(l.charAt(i))){
					a+=l.charAt(i);
					parts=addStr(parts, a);
				}
				else{
					parts=addStr(parts, a);
				}
			}
		}
		
		return parts;
	}
	
	public static int partsInt(String l){
		
		return divideInParts(l).length;
	}
	
	public static String[] addStr (String [] StAr, String a){
		String [] l2 = new String [StAr.length+1];
		
		for(int i=0;i<StAr.length;i++){
			l2[i]=StAr[i];
		}
		
		l2[StAr.length]=a;
		StAr=l2;
		
		return StAr;
	}

}
