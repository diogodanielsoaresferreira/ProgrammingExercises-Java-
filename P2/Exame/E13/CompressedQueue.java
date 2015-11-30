/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * N� Mecanogr�fico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

/**
 * Complete este m�dulo de forma a que o programa principal funcione devidamente.
 * 
 * Uma CompressedQueue � uma fila, mas onde entradas com o mesmo valor s�o comprimidas
 * para um �nico elemento da fila contendo o valor e o n�mero de repeti��es.
 * 
 * Al�m disto e dos m�todos usuais, tem tamb�m m�todos adicionais:
 * 
 * peekCount()
 *   Devolve o n�mero de repeti��es do valor existente na frente da fila.
 * 
 * maxDiff()
 *   Indica qual o maior "salto" (em valor absoluto) entre elementos consecutivos da fila.
 * 
 * minDiff()
 *   Indica qual o menor "salto" (em valor absoluto) entre elementos consecutivos da fila.
 * 
 * toString()
 *   Devolve uma string com os elementos da fila (entre {}), por ordem, em cada elemento
 *   � descrito pelo par valor e repeti��es (entre []) e cada elemento � por
 *   v�rgulas.
 * 
 **/

public class CompressedQueue {
	
	CompressedQueue(){
		size = 0;
		pin = null;
		pout = null;
	}
	
	public void in(int e){
		
		if(size==0){
			Node n = new Node();
			n.n = 1;
			n.e = e;
			n.next = null;
			pout = pin = n;
		}
		
		else if(pin.e == e){
			pin.n++;
		}
		else{
			Node n = new Node();
			n.n = 1;
			n.e = e;
			pin.next = n;
			pin = n;
		}
		
		size++;
		
		assert !isEmpty();
	}
	
	public void out(){
		assert !isEmpty();
		
		if(pout.n>2){
			pout.n--;
		}
		else{
			pout = pout.next;
		}
		if(pout == null){
			pin = null;
		}
		
		size--;
	}
	
	public int peek(){
		return pout.e;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean isFull(){
		return false;
	}
	
	public int size(){
		return size;
	}
	
	public void clear(){
		size = 0;
		pin = pout = null;
	}
	
	public String toStringq(){

		String r;
		r = "{";
		Node search = pout;
		if (search == null) return "{}";
		while (search.next!=null){
			
			r+="["+search.e+":"+search.n+"],";
			search = search.next;
		}
		r+="["+search.e+":"+search.n+"]}";
		
		return r;
	}
	
	public int maxDiff(){
		assert !isEmpty();
		int max = 0;
		Node search = pout;
		while (search.next!=null){
			
			if(Math.abs(search.e-search.next.e)>max) max = Math.abs(search.e-search.next.e);
			search = search.next;
		}
		
		
		return max;
	}
	
	public int minDiff(){
		assert !isEmpty();
		int min = Integer.MAX_VALUE;
		Node search = pout;
		while (search.next!=null){
			
			if(Math.abs(search.e-search.next.e)<min) min = Math.abs(search.e-search.next.e);
			search = search.next;
		}
		
		
		return min;
		
	}
	
	public int peekCount(){
		assert !isEmpty();

		return pout.n;
	}
	
	
	private int size;
	private Node pin;
	private Node pout;
	
	class Node{
		int e;
		int n;
		Node next;
	}
}
