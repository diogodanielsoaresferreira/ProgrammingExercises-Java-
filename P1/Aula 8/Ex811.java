package p1;
import static java.lang.System.*;
import java.util.Scanner;

public class Ex811 {
	
	static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		Pessoa a = new Pessoa();
		
		lerdad(a);
		calcdad(a);
		saidad(a);
		
	}
	
	public static Pessoa lerdad(Pessoa a){
		
		out.print("Como se chama? ");
		a.nome = sc.nextLine();
		
		out.print("\nQual a modaildade a frequentar (1 para Iniciação "
				+ "e 2 para Aperfeiçoamento)? ");
		a.modalidade = sc.nextInt();
		while(a.modalidade != 1 && a.modalidade !=2){
			out.print("\nEntrada inválida. Qual a modalidade a frequentar "
					+ "(1 para Iniciação e 2 para Aperfeiçoamento)? ");
			a.modalidade = sc.nextInt();
		}
		
		out.print("\nQual o número de horas semanais de prática deseja ter (de 1 a 10)? ");
		a.horas = sc.nextInt();
		while(a.horas<=0 || a.horas>10){
			out.print("\nEntrada inválida. Qual o número de horas semanais de prática deseja ter (de 1 a 10)? ");
			a.horas = sc.nextInt();
		}
		
		out.print("\nTem quantos familiares a frequentar o clube? ");
		a.fam = sc.nextInt();
		while(a.fam<0){
			out.print("\nEntrada inválida. Tem quantos familiares a frequentar o clube? ");
			a.fam = sc.nextInt();
		}
		
		String n;
		out.print("\nÉ a primeira vez que se increve no clube (s/n)? ");
		n=sc.next();
		while(n.charAt(0)!='n' && n.charAt(0)!='s'){
			out.print("\nEntrada inválida. É a primeira vez que se inscreve no clube (s/n)? ");
			n=sc.next();
		}
		if(n.charAt(0)=='s') a.pri=true;
		else a.pri=false;
		
		out.print("\nPretende pagar quantas mensalidades? ");
		a.mens=sc.nextInt();
		while(a.mens<=0 || a.mens>12){
			out.print("\nEntrada inválida. Pretende pagar quantas mensalidades? ");
			a.mens = sc.nextInt();
		}
		
		return a;
	}
	
	public static Pessoa calcdad(Pessoa a){
		int i=0;
		
		switch(a.modalidade){
		case 1: i=4; break;
		case 2: i=6; break;
		}
		a.mensal = (i*(a.horas*4));
		a.mensal*=a.mens;
		
		if(a.pri) a.ins=50;
		else a.ins=30;
		
		if(a.fam==1) a.mensal*=.9;
		else if(a.fam>1) a.mensal*=.75;
		
		return a;
	}
	
	public static void saidad(Pessoa a){
		
		out.print("\nNova inscrição para o Clube de Natação");
		out.print("\nNome: " + a.nome);
		if(a.pri) out.print("\nPrimeira vez");
		else out.print("\nRe-inscrição");
		out.print("\n" + a.horas + " horas semanais de ");
		if(a.modalidade==1)out.print("iniciação.");
		else out.print("aperfeiçoamento.");
		out.print("\n" + a.fam + " familiar(es) inscritos.");
		out.println("\n---------------------------------------------------");
		out.println("Item               Quantidade                 Valor");
		out.printf("\nInscrição               1                     %.2f", a.ins);
		out.printf("\nMensalidade             %d                     %.2f", a.mens, a.mensal);
		out.printf("\n---------------------------------------------------");
		out.printf("\nTotal                                       %.2f", a.ins+a.mensal);
	}
	
	public static class Pessoa{
		
		String nome;
		int modalidade;
		int horas;
		int fam;
		boolean pri;
		int mens;
		double ins;
		double mensal;
		
	}

}
