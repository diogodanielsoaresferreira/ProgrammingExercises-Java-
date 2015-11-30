/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * N� Mecanogr�fico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

/**
Um objecto da classe Train representa um comboio composto de v�rios vag�es
de mercadorias a granel.
Quando se cria um comboio, � necess�rio especificar a capacidade de cada
vag�o e a capacidade total que o comboio suporta, ambas em toneladas.
Pode acrescentar-se um vag�o com certa carga � cauda de um comboio
(addWagon) ou pode retirar-se um vag�o da cauda (removeWagon), segundo uma
pol�tica LIFO (�ltimo a entrar � o primeiro a sair).
Naturalmente, a carga de um vag�o n�o pode superar a sua capacidade e s�
se pode acrescentar um vag�o que n�o fa�a ultrapassar a carga total m�xima do
comboio.
Tamb�m � poss�vel pedir para descarregar (unload) uma dada quantidade, o que
ser� feito pela descarga completa e retirada de zero ou mais vag�es da cauda
e pela descarga parcial de outro vag�o para completar a quantidade pedida.
Em qualquer altura � poss�vel obter uma lista da carga nos vag�es do
comboio (list); saber o n�mero de vag�es (size) ou a carga total
transportada (totalCargo).

M�todos principais:
addWagon     Acrescenta um vag�o com uma certa carga ao fim do comboio.
removeWagon  Retira o vag�o do fim do comboio e devolve a sua carga.
unload       Descarrega uma certa quantidade, retirando os vag�es que ficarem
             vazios.  Devolve o n�mero de vag�es retirados.
acceptsCargo Verifica se o comboio pode aceitar uma carga adicional,
             sem ultrapassar o limite de carga total.
list         Devolve um array com as cargas de cada vag�o, do primeiro ao �ltimo.
             N�o altera nada no comboio.
size         Tamanho (n�mero de vag�es) do comboio.
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
