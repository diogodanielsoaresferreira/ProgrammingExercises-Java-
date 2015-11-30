package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex1106 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		long b=0;
		
		b=lerChave();
		mostraChave(b);

	}
	
	public static long lerChave(){
		int a;
		long b=(long) Math.pow(2, 51);
		boolean []tot=new boolean[50];
		
		for(int j=0;j<50;j++){
			tot[j]=false;
		}
		
		for (int i=0; i<6; i++){
			out.print("\nElemento " + (i+1) + " da chave: ");
			a = sc.nextInt();
			
			while(a<1|| a>49 || pertenceChave(a, tot)){
				out.print("\nEntrada inválida! Elemento " + (i+1) + " da chave: ");
				a = sc.nextInt();
			}
			
			tot[a]=true;
			b+=(Math.pow(2, a-1));
		}
		return b;
	}
	
	public static boolean pertenceChave(int a, boolean []tot){
		
		if(tot[a]==true)return true;
		
		return false;
	}
	
	public static void mostraChave(long b){

		String longs = (Long.toBinaryString(b));
		
		
		out.print("\nAposta de Totoloto");

		for(int i=0; i<49; i++){
			if(i==0 || i==7 || i==14 || i==21 || i==28 || i==35 || i==42) out.print("\n");
			if(longs.charAt(51-i)=='1'){
				out.print("X\t");
			}
				else out.print((i+1) + "\t");

			}
		}
	}