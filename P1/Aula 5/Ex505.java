package p1;

import p1.Funcoes;
import java.util.*;
import static java.lang.System.*;

public class Ex505 {

	public static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		int a, b;
		
		out.print("Insira a altura: ");
		a = sc.nextInt();
		out.print("\nInsira agora a largura: ");
		b = sc.nextInt();
		
		Funcoes.retangulo(a, b);
	}

	
	
}
