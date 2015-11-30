/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;

public class ContainerTerminal {
	ContainerStack[] sa;    // the stacks of containers
	int num;  // number of parallel stacks of containers
	int max;  // maximum height of each stack of containers
	int numcontainers;  // number of containers on the terminal
	
	public ContainerTerminal(int num, int max) {
	  sa = new ContainerStack[num];
	  for (int k = 0; k < num; k++) {
	    sa[k] = new ContainerStack(max);
	  }
	  this.num = num;
	  this.max = max;
	  numcontainers = 0;
	}
	
	/**
	 * Is the terminal full?
	 * A full terminal must still have enough free space to enable
	 * retrieving any given container.
	 */
	public boolean isFull() {
	  return numcontainers >= num*max - max;
	}
	
	/**
	 * Checks if a container of a certain type exists
	 */
	public boolean containerTypeExists(String type) {
	  return findStackContaining(type) >= 0;
	}
	
	
	/**
	 * Find first stack with free space, other than the stackToAvoid.
	 * @return the index of the found stack
	 */
	private int findOtherStack(int stackToAvoid) {
	  assert !isFull();
	  int k = 0;
	  while (k==stackToAvoid || sa[k].isFull()) {
	    k++;
	  }
	  return k;
	}
	
	/**
	 * Find a stack that includes a container with a given type of cargo
	 * @return the index of the found stack, or -1 if no such cargo exists.
	 */
	private int findStackContaining(String type) {
	  int k = 0;
	  while (k < num) {
	    if (sa[k].search(type) >= 0) return k;
	    k++;
	  }
	  return -1;
	}
	
	public void print() {
	  out.printf("Terminal numcontainers=%d isFull=%s\n",
	                    numcontainers, isFull());
	  for (int k = 0; k < num; k++) {
	    out.printf("%2d: %s\n", k, sa[k].toString());
	  }
	}
	
	// Log: historical log of retrieved containers: it's a linked list
	HistoryNode log;
	
	private void logContainerInfo(Container c) {
	  HistoryNode n = new HistoryNode();
	  //n.type = c.type();
	  n.numops = c.numops();
	  n.next = log;
	  log = n;
	}
	
	public void store(Container a, int t){
		assert isFull()==false;
		int st = findOtherStack(t);
		sa[st].push(a);
	}
	
	public void store(Container a){
		assert isFull()==false;
		int st = findOtherStack(-1);
		sa[st].push(a);
	}
	
	public Container retrieve(String type){
		int t = findStackContaining(type);
		if(t==-1) return null;
		else{
			Container c = null;
			while(sa[t].search(type)!=0){
				c = sa[t].top();
				sa[t].pop();
				store(c, t);
			}
			c = sa[t].top();
			sa[t].pop();
			logContainerInfo(c);
			return c;
		}
	}
	
	public int averageOpsPerContainer(){
		
		HistoryNode a = log;
		int max = recAv(a, 0);
		a = log;
		int num = num (a, 0);
		return max/num;
		
	}
	
	private int num (HistoryNode a, int max){
		max++;
		if(a.next==null) return max-1;
		max = num(a.next, max);
		return max;
	}
	
	private int recAv(HistoryNode a, int max){
		
		max += a.numops;
		if(a.next==null) return max;
		else max += recAv(a.next, max);
		return max;
		
	}

}
