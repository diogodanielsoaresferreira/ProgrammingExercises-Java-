package p1;

import java.io.*;
import static java.lang.System.out;
import java.util.Scanner;

public class Ex1101 {
	static final Scanner sc = new Scanner (System.in);

	public static void main(String[] args) throws IOException {
		
		int a;
		int []b = new int [50];
		
		for (int z=0; z<49; z++){
			b[z]=0;
		}
		
		do{
			out.print("\nAn�lise de uma sequ�ncia de n�meros inteiros:");
			out.print("\n 1 - Escrever a sequ�ncia");
			out.print("\n 2 - Ler a sequ�ncia");
			out.print("\n 3 - Calcular o m�ximo da sequ�ncia");
			out.print("\n 4 - Calcular o m�nimo da sequ�ncia");
			out.print("\n 5 - Calcular a m�dia da sequ�ncia");
			out.print("\n 6 - Detetar se � uma sequ�ncia s� constitu�da por n�meros pares");
			out.print("\n 7 - Ler uma sequ�ncia de n�meros de um ficheiro de texto");
			out.print("\n 8 - Adicionar n�meros � sequ�ncia existente");
			out.print("\n 9 - Gravar a sequ�ncia atual de n�meros num ficheiro");
			out.print("\n10 - Ordenar a sequ�ncia por orderm crescente utilizando ordena��o sequencial");
			out.print("\n11 - Ordenar a sequ�ncia por orderm decrescente utilizando ordena��o por flutua��o");
			out.print("\n12 - Pesquisa de valor na sequ�ncia");
			out.print("\n13 - Terminar o programa");
			out.print("\nOp��o -> ");
			
			a = sc.nextInt();
			
			switch (a){
				case 1:
					b=lerSeq();
					break;
				case 2:
					printSeq(b);
					break;
				case 3:
					maxSeq(b);
					break;
				case 4:
					minSeq(b);
					break;
				case 5:
					mediaSeq(b);
					break;
				case 6:
					pares(b);
					break;
				case 7:
					b=ler();
					break;
				case 8:
					b=adic(b);
					break;
				case 9:
					gravar(b);
					break;
				case 10:
					b=crescente(b);
					break;
				case 11:
					b=decrescente(b);
					break;
				case 12:
					pesValor(b);
					break;
				case 13:
					break;
				default:
					out.println("\nEntrada inv�lida!");
					break;
			}
		}while(a!=13);
		
	}
		
	public static int[] lerSeq(){
		int[] seq = new int[50];
		int a;
			
		for(int n=0; n<49; n++){
			out.print("\nInsira o n�mero inteiro: "); 
			a = sc.nextInt();
			if(a==0) break;
			seq[n] = a;	
		}
		
		return seq;
	}
	
	public static void printSeq(int[] a){
		
		out.println();
		
		for(int i=0; i<a.length; i++){
			if(a[i]==0) break;
			out.println(a[i]);
		}
		
	}
	
	public static void maxSeq(int[] a){
		
		int max=0;
		
		for(int i=0; i<a.length; i++){
			if(max<a[i]) max = a[i];
			
		}
		
		out.println("\nO valor m�ximo da sequ�ncia � " + max + ".");
		
	}
	
	public static void minSeq(int [] a){
		int min=a[0];
		
		for(int i=0; i<a.length; i++){
			if(a[i]==0) break;
			if(min>a[i]) min = a[i];
			
		}
		
		out.println("\nO valor m�nimo da sequ�ncia � " + min + ".");
		
	}
	
	public static void mediaSeq(int [] a){
		int soma=0;
		double media=0;
		int j=0;
		
		for(int i=0; i<a.length; i++){
			if(a[i]==0) break;
			j++;
			soma+=a[i];
		}
		
		media = soma/(j-1);
		out.println("\nA m�dia da sequ�ncia � " + media + ".");
	}
	
	public static void pares(int [] a){
		boolean par=true;
		
		for(int i=0; i<a.length; i++){
			if(a[i]%2!=0) par=false;
		}
		if(par) out.print("\nTodos os n�meros introduzidos s�o pares");
		else out.print("\nNem todos os n�meros introduzidos s�o pares.");
		
	}
	
	public static int[] ler() throws IOException{
		int b[] = new int[50];
		int i=0;
		String a;
		File ficheiro;
		
		do{
			out.print("\nInsira o nome de um ficheiro v�lido: ");
			while(!sc.hasNext());
			a = sc.nextLine();
			ficheiro = new File(a);
		}while(!ficheiro.isFile() || !ficheiro.canRead());
		
		Scanner lerFich = new Scanner (ficheiro);
		
		while(lerFich.hasNext()){
			out.print("\n" + lerFich.next() + " ");
			if (!lerFich.hasNext()) break;
			b[i] = Integer.parseInt(lerFich.next());
			i++;
		}
		
		lerFich.close();
		return b;
	}
	
	public static int[] adic(int []b) throws IOException{
		int c=1;
		int i=0;
		File temp = new File ("chegada.java");
		PrintWriter write = new PrintWriter(temp);
		
		for(int j=0; j<b.length; j++){
			if(b[j]==0) break;
			write.println(b[j]);
		}
		
		while (c!=0){
			out.print("\nQuais s�o os n�meros que deseja adicionar (para parar insira 0)? ");
			c = sc.nextInt();
			if (c==0) break;
			write.println(c);
		}
		
		write.close();
		Scanner read = new Scanner (temp);
		
		while(read.hasNext()){
			b[i]=Integer.parseInt(read.next());
			i++;
		}
		
		read.close();
		
		return b;
	}
	
	public static void gravar (int []b) throws IOException{
		String a;
		File ficheiro;
		

		do{
			out.print("\nInsira o nome de um ficheiro v�lido: ");
			while(!sc.hasNext());
			a = sc.nextLine();
			ficheiro = new File(a);
		}while(!ficheiro.isFile() || !ficheiro.canRead());
		
		PrintWriter pw = new PrintWriter (ficheiro);
		
		for(int i=0;i<b.length;i++){
			if (b[i]==0) break;
			pw.println(b[i]);
		}
		out.print("\nLista de valores gravado na pasta desejada com sucesso!");
		
		pw.close();
	}
	
	public static int[] crescente (int []b){
		int temp;
		int n=0;
		
		for(int k=0; k<b.length; k++){
			if(b[k]==0) break;
			else n++;
		}
		
		for(int i=0; i<n-1; i++){
			for(int j=i+1; j<n; j++){
				if(b[j]<b[i]){
					temp = b[j];
					b[j] = b[i];
					b[i] = temp;
				}
			}
		}
		
		return b;
	}
	
	public static int[] decrescente (int []b){
		boolean troca = false;
		int n=0;
		int temp;
		
		for(int k=0; k<b.length; k++){
			if(b[k]==0) break;
			else n++;
		}
		
		do{
			troca = false;
			
			for(int i=0; i<n; i++){
				if(b[i+1]>b[i]){
					if (b[i+1]==0) continue;
					temp = b[i];
					b[i] = b[i+1];
					b[i+1] = temp;
					troca = true;
				}
			}
			
		}while(troca);
		
		return b;
	}
	
	public static void pesValor (int []b){
		int a;
		int pos=-1;
		
		out.print("\nIntroduza o valor que pretende procurar: ");
		a=sc.nextInt();
		
		for(int i=0; i<b.length; i++){
			if(b[i]==a) pos=i+1;
		}
		if(pos==-1) out.print("\nO valor n�o existe nos dados inseridos.");
		else out.print("O valor inserido est� na posi��o " + pos + ".");
	}

		
}