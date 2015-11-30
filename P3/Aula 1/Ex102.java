/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº Mec. 76504
 * 
 */

package aula1;


import static java.lang.System.*;
import java.util.Scanner;

public class Ex102 {

	final static Scanner sc = new Scanner (System.in);

	
	public static void main(String[] args) {
		Pessoa[] lista = new Pessoa[0];
		int x = 0;
		do{
			x = menu();
			switch(x){
			case 1:
				lista = addPessoa(lista);
				break;
			case 2:
				lista = delPessoa(lista);
				break;
			case 3:
				showP(lista);
				break;
			case 4:
				lista = sortByName(lista);
				break;
			case 5:
				lista = sortByCC(lista);
				break;
			case 6:
				lista = sortByDate(lista);
				break;
			case 7:
				out.println("\nPrograma encerrado.");
				break;
			default:
				err.println("Ocorreu um erro no processamento interno do programa. O programa irá encerrar.");
				exit(1);
			}
		}while(x!=7);
	}
	
	private static int menu(){
		out.println("\n\n---Menu Principal--");
		out.println("1 - Adicionar Pessoa");
		out.println("2 - Apagar Pessoa");
		out.println("3 - Mostrar lista completa");
		out.println("4 - Ordenar a lista por Nome");
		out.println("5 - Ordenar a lista por CC");
		out.println("6 - Ordenar a lista por Data de Nascimento");
		out.println("7 - Sair do Programa");
		out.print("Faça a sua escolha: ");
		int a = sc.nextInt();
		sc.nextLine();
		while(a<1 || a>7){
			out.print("\nEscolha inválida! Escolha novamente: ");
			a = sc.nextInt();
		}
		assert a<8 && a>0;
		return a;
	}

	private static Pessoa[] addPessoa(Pessoa[] lista){
		String nome;
		String cc;
		int ano, mes, dia;
		
		
		out.print("\nEscreva o seu nome: ");
		nome = sc.nextLine();
		out.print("\nInsira o seu número de CC: ");
		cc = sc.next();
		while(!cc.matches("[0-9]+")){
			out.print("\n\nCC inválido! Insira o seu número de CC: ");
			cc = sc.next();
		}
		if(search(lista, cc)!=-1){
			out.println("\nJá existe alguém com esse número de CC. Pode introduzir uma pessoa com um CC diferente ou apagar o antigo CC para atualizar com o novo.");
			return lista;
		}
		out.println("\nInsira o ano em que nasceu (de 0 a 2015): ");
		ano = sc.nextInt();
		out.println("\nInsira o mês em que nasceu (de 1 a 12): ");
		mes = sc.nextInt();
		out.println("\nInsira o dia em que nasceu: ");
		dia = sc.nextInt();
		
		Data d = new Data(dia, mes, ano);
		if(!d.validarData()){
			out.println("\nA data inserida não é válida!\nPessoa não inserida.");
		}
		else{
			Pessoa a = new Pessoa(nome, cc, d);
			lista = addArray(lista,a);
			out.println("\nPessoa adicionada com sucesso.");
		}
		
		return lista;
	}
	
	private static Pessoa[] delPessoa(Pessoa[] lista){
		out.print("\nIntroduza o número de CC da pessoa que deseja eliminar: ");
		String cc = sc.next();
		int s = search(lista, cc);
		if(s==-1){
			out.println("\nO CC inserido não corresponde a nenhuma pessoa.");
		}
		else{
			out.print("\nDeseja eliminar a pessoa "+lista[s].getName()+", com o CC "+lista[s].getCC()+" e a data de Nascimento "+lista[s].getDate().getDate()+" ?(s/n) ");
			String r = sc.next().toLowerCase();
			while(!(r.equals("s") || r.equals("n"))){
				out.print("\nEscolha inválida! Deseja eliminar a pessoa? ");
				r = sc.next().toLowerCase();
			}
			if(r.equals("n"))
				out.print("\nPessoa não eliminada.");
			else{
				lista[s] = null;
				out.print("\nPessoa eliminada com sucesso!");
			}
		}
		return lista;
	}
	
	private static void showP(Pessoa[] lista){
		for(int i=0;i<lista.length;i++){
			if(lista[i]!= null){
				out.println("\nNome: "+lista[i].getName()+"\tCC: "+lista[i].getCC()+"\t\tData de Nascimento: "+lista[i].getDate().getDate());
			}
		}
		
	}
	
	private static Pessoa[] addArray(Pessoa[] lista, Pessoa a){
		Pessoa[] copy = new Pessoa[lista.length+1];
		int i=0;
		for(;i<lista.length;i++){
			copy[i] = lista[i];
		}
		copy[lista.length] = a;
		
		return copy;
	}
	
	private static int search(Pessoa []lista, String cc){
		for(int i=0;i<lista.length;i++){
			if(lista[i] != null && lista[i].getCC().equals(cc))
				return i;
		}
		
		return -1;
	}
	
	private static Pessoa[] sortByName(Pessoa[] lista){
		
		Pessoa temp;
		boolean troca = false;
		int f = lista.length-1;
		do{
			troca = false;
			for(int i=0;i<f;i++){
				if(lista[i] != null && lista[i].getName().compareToIgnoreCase(lista[i+1].getName())>0){
					temp = lista[i];
					lista[i] = lista[i+1];
					lista[i+1] = temp;
					troca = true;
				}
			}
			f--;
		}while(troca);
		
		return lista;
	}
	
	private static Pessoa[] sortByCC(Pessoa[] lista){
		Pessoa temp;
		boolean troca = false;
		int f = lista.length-1;
		try{
			do{
				troca = false;
				for(int i=0;i<f;i++){
					if(lista[i] != null && Integer.parseInt(lista[i].getCC())>Integer.parseInt(lista[i+1].getCC())){
						temp = lista[i];
						lista[i] = lista[i+1];
						lista[i+1] = temp;
						troca = true;
					}
				}
				f--;
			}while(troca);
		}
		catch (NumberFormatException e){
			do{
				troca = false;
				for(int i=0;i<f;i++){
					if(lista[i] != null && lista[i].getCC().compareToIgnoreCase(lista[i+1].getCC())>0){
						temp = lista[i];
						lista[i] = lista[i+1];
						lista[i+1] = temp;
						troca = true;
					}
				}
				f--;
			}while(troca);
		}
		
		return lista;
	}
	
	private static Pessoa[] sortByDate(Pessoa[] lista){
		Pessoa temp;
		boolean troca = false;
		int f = lista.length-1;
		do{
			troca = false;
			for(int i=0;i<f;i++){
				if(lista[i] != null && lista[i].getDate().isBiggerThan(lista[i+1].getDate())){
					temp = lista[i];
					lista[i] = lista[i+1];
					lista[i+1] = temp;
					troca = true;
				}
			}
			f--;
		}while(troca);
		
		return lista;
	}
	
}