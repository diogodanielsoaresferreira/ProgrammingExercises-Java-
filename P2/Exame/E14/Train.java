/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

/**
Um objecto da classe Train representa um comboio composto de vários vagões
de mercadorias a granel.
Quando se cria um comboio, é necessário especificar a capacidade de cada
vagão e a capacidade total que o comboio suporta, ambas em toneladas.
Pode acrescentar-se um vagão com certa carga à cauda de um comboio
(addWagon) ou pode retirar-se um vagão da cauda (removeWagon), segundo uma
política LIFO (último a entrar é o primeiro a sair).
Naturalmente, a carga de um vagão não pode superar a sua capacidade e só
se pode acrescentar um vagão que não faça ultrapassar a carga total máxima do
comboio.
Também é possível pedir para descarregar (unload) uma dada quantidade, o que
será feito pela descarga completa e retirada de zero ou mais vagões da cauda
e pela descarga parcial de outro vagão para completar a quantidade pedida.
Em qualquer altura é possível obter uma lista da carga nos vagões do
comboio (list); saber o número de vagões (size) ou a carga total
transportada (totalCargo).

Métodos principais:
addWagon     Acrescenta um vagão com uma certa carga ao fim do comboio.
removeWagon  Retira o vagão do fim do comboio e devolve a sua carga.
unload       Descarrega uma certa quantidade, retirando os vagões que ficarem
             vazios.  Devolve o número de vagões retirados.
acceptsCargo Verifica se o comboio pode aceitar uma carga adicional,
             sem ultrapassar o limite de carga total.
list         Devolve um array com as cargas de cada vagão, do primeiro ao último.
             Não altera nada no comboio.
size         Tamanho (número de vagões) do comboio.
totalCargo   Carga total transportada no comboio.
**/

public class Train {

	Train(double wc, double tc){
		wagonCapacity = wc;
		trainCapacity = tc;
		size = 0;
	}
	
	public boolean acceptsCargo(double c){
		if (totalCargo()+c >= trainCapacity || wagonCapacity<c) return false;
		
		return true;
	}
	
	public void addWagon(double c){
		assert acceptsCargo(c);
		
		Node n = new Node();
		n.ton = c;
		if(top!=null){
			n.next = top;
		}
		top = n;
		size++;
	}
	
	public double removeWagon(){
		assert !isEmpty();
		
		double c;
		c = top.ton;
		top = top.next;
		size--;
		return c;
	}
	
	public double totalCargo(){
		Node search = top;
		double c = 0;
		if(search==null) return 0;
		while(search.next != null){
			c += search.ton;
			search = search.next;
		}
		return c+search.ton;
	}
	
	public double[] list(){
		Node search = top;
		double wag[] = new double[0];
		
		while(search.next != null){
			wag = addEl(wag, search.ton);
			search = search.next;
		}
		wag = addEl(wag, search.ton);
		return wag;
	}
	
	public int unload(double c){
		assert !(c > totalCargo());

		double car = 0;
		int wag = 0;
		
		while(c>car){
			if(car+top.ton<=c){
				wag++;
				car += top.ton;
				top = top.next;
				size--;
			}
			else{
				top.ton -= (c-car);
				break;
			}
			
		}
		
		return wag;
	}
	
	
	private double[] addEl(double[] a, double c){
		double[]b = new double[a.length+1];
		System.arraycopy(a, 0, b, 0, a.length);
		b[a.length] = c;
		return b;
	}
	
	
	public boolean isEmpty(){
		return size==0;
	}

	public int size(){
		return size;
	}
	
	
	private Node top;
	private int size;
	private double wagonCapacity;
	private double trainCapacity;
	class Node{
		Node next;
		double ton;
	}
}
