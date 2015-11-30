/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

/**
 * Uma estrutura de dados de tipo pilha, mas com os métodos alternativos:
 * - popN(n): retira os n elementos de topo da pilha
 * - topMatches(seqChars): verifica se os últimos caracteres na pilha
 *                         coincidem com seqChars
 * - toString(): devolve uma String com todos os caracteres contidos
 *               na pilha (desde o mais antigo até ao mais recente)
 */

public class Stack2 {
	
	Stack2(){
		top = null;
		size = 0;
	}
	
	public void push(char c){
		size++;
		Node n = new Node();
		n.c = c;
		if (top!=null)
			n.next = top;
		top = n;
	}
	
	public int size(){
		return size;
	}
	
	public char top(){
		assert !isEmpty();
		return top.c;
	}
	
	public boolean isEmpty(){
		return size==0;
	}

	public void popN(int n){
		assert size >= n;
		size -= n;
		for(int i=0;i<n;i++){
			top = top.next;
		}
		
	}
	
	//Função não funciona para expressões com parêntesis
	public boolean topMatches(String s){
		Node search = top;

		for(int i=0;i<s.length();i++){
			if(search==null) return false;
			if((s.charAt(i)=='e')){
				if(!(search.c=='e' || search.c=='D'))
					return false;
			}
			else{
				if(s.charAt(i)!=search.c) return false;
			}
			
			search  = search.next;
		}
		
		return true;
		
	}
	
	public String toStrings(){
		assert !isEmpty();
		String c = printc(top);
		return c;
	}
	
	public String printc(Node t){
		String r = "";
		if(t.next!=null)
			r = printc(t.next);
		return r += t.c;
	}
	
	
	public class Node{
		Node next;
		char c;
	}
	private Node top;
	private int size;
}
