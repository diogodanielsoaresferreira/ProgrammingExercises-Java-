/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import java.util.Scanner;

public class p91 {

	final static Scanner sc = new Scanner (System.in);
	@SuppressWarnings(value = "unchecked")
	public static void main(String[] args) {
		String a;
		
		out.print("Insira a sua frase: ");
		a = sc.nextLine();
		
		String[] array = separateWords(a);
		p91queue <Character> queue = new p91queue<Character> (a.length());
		p91stack <Character> stack = new p91stack<Character> ();
		
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[i].length();j++){
				queue.in(array[i].charAt(j));
				stack.push(array[i].charAt(j));
			}
		}
		
		boolean igual = true;
		
		for(;!queue.isEmpty() || !stack.isEmpty();){
			if(stack.top()!=queue.peek()) igual = false;
			stack.pop();
			queue.out();
		}
		
		if(igual) out.println("Palíndromo.");
		else out.println("Não é palíndromo.");
	}
	
	public static String[] separateWords(String a){
		assert a.length() >= 1;
		
		String b="";
		String [] array = new String[0];
		
		for(int i=0;i<a.length();i++){
			if(i==0){
				if(!Character.isWhitespace(a.charAt(i))){
					b += Character.toLowerCase(a.charAt(i));
				}
			}
			else if(i==a.length()-1){
				if(Character.isWhitespace(a.charAt(i)) && !Character.isWhitespace(a.charAt(i-1))){
					array = addElement(b, array);
					b = "";
				}
				else if(Character.isWhitespace(a.charAt(i)) && Character.isWhitespace(a.charAt(i-1))){
					// Does Nothing.

				}
				else{
					b += a.charAt(i);
					array = addElement(b, array);
				}
			}
			else{
				if(Character.isWhitespace(a.charAt(i)) && !Character.isWhitespace(a.charAt(i-1))){
					array = addElement(b, array);
					b = "";
				}
				else if(Character.isWhitespace(a.charAt(i)) && Character.isWhitespace(a.charAt(i-1))){
					// Does Nothing.
				}
				else{
					b += a.charAt(i);
				}
				
			}
			
		}
	return array;
	}
	
	public static String[] addElement(String a, String[] array){
		String[] array2 = new String[array.length+1];
		
		int i;
		for(i=0;i<array.length;i++){
			array2[i] = array[i];
		}
		array2[i]=a;
		
		return array2;
	}

}
