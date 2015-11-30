/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;

public class p93 {

	public static void main(String[] args) {
		
		int b = 0;
		char c;
		
		p93stack <Integer> stack = new p93stack <Integer>(args.length);
		
		if(args.length<3){
			err.println("Argumentos inválidos!");
			exit(1);
		}
		
		for(String a : args){
			try{
				b = Integer.parseInt(a);
			}
			catch(NumberFormatException e){
				if(a.charAt(0)=='+' || a.charAt(0)=='-' || a.charAt(0)=='X' || a.charAt(0)=='/')
					c = a.charAt(0);
				else{
					err.println("Símbolo não identificado.");
					exit(1);
				}
			}
			
			finally{
				if(Character.isDigit(a.charAt(0))){
					stack.push(b);
					stack.print();
				}
				else{
					if(stack.size()<2){
						err.println("Não há argumentos suficientes para realizar a conta.");
						exit(1);
					}
					else{
						int x = stack.top();
						stack.pop();
						int y = stack.top();
						stack.pop();
						int z;
						switch(a.charAt(0)){
						
						case '+':
							z = x+y;
							break;
						case '-':
							z = y-x;
							break;
						case 'X':
							z = x*y;
							break;
						case '/':
							z = y/x;
							break;
						default:
							z=0;
							break;
						}
						stack.push(z);
						stack.print();

					}
				}
			}
		}
		
	}

}
