/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

/**
 * Uma estrutura de dados baseada numa fila, mas em que só ficam
 * armazenados os últimos N números inseridos. Quando a fila está
 * preenchida (N elementos) a inserção de um novo número implica
 * a saída do primeiro (que deixa de existir).
 */

public class LeakyQueue {
	
	LeakyQueue(int n){
		assert n>0;
		array = new double[n];
		head=tail=size=0;
	}
	
	public void in(double n){
		array[tail] = n;
		tail = nextPosition(tail);
		if (size!=3)
			size++;
			
	}
	
	public void out(){
		assert !isEmpty();
		size--;
		head = nextPosition(head);
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int size(){
		return size;
	}
	
	public double minimum(){
		assert !isEmpty();
		double min = array[tail];
		
		for(int i=size, j=tail; i>0; i--, j = nextPosition(j)){
			if(array[j]<min) min = array[j];
		}
		
		return min;
	}
	
	public void print(){
		assert !isEmpty();
		
		for(int i=size, j=tail; i>0; i--, j = nextPosition(j)){
			System.out.print(array[j]+"\t");
		}
	}
	
	private int nextPosition(int n){
		return (n+1)%array.length;
	}
	
	private int size;
	private int head, tail;
	private double array[];
}
