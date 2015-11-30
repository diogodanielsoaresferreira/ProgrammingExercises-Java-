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

public class Restaurante
{
   public static void main(String[] args)
   {
	   try{
		   AssociativeArray<Integer> ent = new AssociativeArray(20);
		   p101queue <String> ref = new p101queue();
		   File food = new File(args[0]);
		   Scanner readf = new Scanner (food);
		   while(readf.hasNextLine()){
			   String line = readf.nextLine();
			   if(line.split(":")[0].equals("entrada")){
				   if(ent.exists(line.split(" ")[1]))
					   ent.set(line.split(" ")[1],(Integer)((int)(ent.get(line.split(" ")[1])+1)));
				   else
					   ent.set(line.split(" ")[1],1);
			   }
			   else{
				   ref.in(line.substring(7));
			   }
			   while(!ref.isEmpty()){
				   if(checkCanRemove(ref.peek(), ent)){
					   out.println("Refeição servida: "+ref.peek());
					   ref.out();
				   }
				   else break;
			   }
		   }
		   out.println("Comida em Stock:");
		   for(String i : ent.keysToArray())
				out.println("\t"+i+" : "+ent.get(i));
		   while(!ref.isEmpty()){
			   out.println("Refeições não servidas: "+ref.peek());
			   ref.out();
		   }
	   }
	   catch(Throwable e){
		   err.println("Erro nos ficheiros.\n"+e.getMessage());
	   }
   }
   
   public static boolean checkCanRemove(String peek, AssociativeArray ent){
	   
	   String [] div = peek.split(":");
	   String s = "";
	   for(int i=0;i<div.length-1;i++){
		   if(i>0) s = div[i].substring(2);
		   else s=div[0];
		   if(!ent.exists(s)) return false;
		   int a = (int)ent.get(s);
		   int b = Integer.parseInt(div[i+1].substring(0, 1));
		   if(!(a>=b)) return false;
	   }
	   for(int i=0;i<div.length-1;i++){
		   if(i>0) s = div[i].substring(2);
		   else s=div[0];
		   int a = (int)ent.get(s);
		   int b = Integer.parseInt(div[i+1].substring(0, 1));
		   ent.set(s, a-b);
	   
	   }
	   return true;
   }
}
