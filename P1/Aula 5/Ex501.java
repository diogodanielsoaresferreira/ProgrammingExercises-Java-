package p1;  
import p1.Funcoes;

public class Ex501 {

	public static void main(String[] args) {
		
		int a;
		
		System.out.println(Funcoes.sqr(2.0));
		System.out.println(Funcoes.divisao(2));
		System.out.println(Funcoes.max(2, 3));
		System.out.println(Funcoes.poly3(1, 1, 1, 1));
		System.out.println(Funcoes.fact(3));
		a = Funcoes.getintpos();
		Funcoes.getIntRange(5,0);
		System.out.println(Funcoes.max(3, 2));
		System.out.println(a);
		Funcoes.printntimes();
		
	}

}
