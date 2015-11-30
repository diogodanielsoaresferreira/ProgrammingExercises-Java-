/**
 * Diogo Daniel Soares Ferreira, 2014
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mec. 76504
 */
package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex1206 {

	final static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int a=0;

		aluno [] b= new aluno[150];
		
		do{
			out.print("\nGestão de uma Turma:");
			out.print("\n1 - Inserir informação da turma");
			out.print("\n2 - Mostrar informação de um aluno");
			out.print("\n3 - Alterar informação de um aluno");
			out.print("\n4 - Listar os alunos ordenados por nº mec.");
			out.print("\n5 - Listar os alunos ordenados por nota final");
			out.print("\n6 - Média das notas finais");
			out.print("\n7 - Melhor aluno");
			out.print("\n0 - Terminar o programa");
			out.print("\nOpção ->");
			a=sc.nextInt();
			
			switch(a){
			
			case 1:
				introtur(b);
				break;
			case 2:
				showAlu(b);	
				break;
			case 3:
				b=chanAlu(b);
				break;
			case 4:
				listMec(b);
				break;
			case 5:
				listNot(b);
				break;
			case 6:
				fazerMed(b);
				break;
			case 7:
				melhorAl(b);
				break;
			}
		}while(a!=0);

	}
	
	public static void introtur(aluno []b){

		for(int i=0;i<b.length;i++){
			aluno a= new aluno();
			out.print("\n\nAluno " + (i+1));
			out.print("\nNº Mecanográfico: ");
			a.nmec=sc.nextInt();
			while(sc.nextLine().length()!=0);
			if(a.nmec==0)break;
			out.print("\nNome:");
			a.name=sc.nextLine();
			out.print("\nPrimeira Nota: ");
			a.notas[0]=sc.nextDouble();
			out.print("\nSegunda Nota: ");
			a.notas[1]=sc.nextDouble();
			out.print("\nTerceira Nota: ");
			a.notas[2]=sc.nextDouble();
			out.print("\nQuarta Nota: ");
			a.notas[3]=sc.nextDouble();
			a.notaf=((0.1*a.notas[0])+0.3*a.notas[1]+(0.1*a.notas[2])+(0.5*a.notas[3]));
			b[i]=a;
		}
		
	}

	public static void showAlu(aluno []b){
		int mec;
		int pos=-1;
		int j;
		
		for(j=0;j<b.length;j++){
			aluno a=b[j];
			if(a==null) break;
		}
		
		out.print("\nInsira o nº Mecanográfico a pesquisar: ");
		mec=sc.nextInt();
		
		for(int i=0;i<j;i++){
			aluno a=b[i];
			if(a.nmec==mec){
				pos=i;
				break;
			}
		}
		
		if(pos==-1) out.print("\nO aluno não existe na base de dados.");
		else{
			aluno a=b[pos];
			
			out.print("\nNome: "+a.name+"\nNotas:\n1º Teste: "+a.notas[0]+"\n2º Teste: "+a.notas[1]+"\n3º Teste: "+a.notas[2]+"\n4º Teste: "+a.notas[3]+"\nNota final: "+a.notaf+"\n\n\n");
		}
	}

	public static aluno[] chanAlu(aluno []b){
		
		int j;
		int mec;
		boolean find=false;

		
		for(j=0;j<b.length;j++){
			aluno a=b[j];
			if(a==null) break;
		}
		aluno []c=new aluno[j+1];
		
		out.print("\n\nInsira o nº Mecanográfico que deseja ver alterado as notas: ");
		mec=sc.nextInt();
		
		for(int i=0;i<j;i++){
			aluno a=b[i];
			if(a.nmec==mec){
				find=true;
				out.print("\n\nVamos alterar as notas de " + a.name+":");
				out.print("\n1ª Nota: ");
				a.notas[0]=sc.nextInt();
				out.print("\n2ª Nota: ");
				a.notas[1]=sc.nextInt();
				out.print("\n3ª Nota: ");
				a.notas[2]=sc.nextInt();
				out.print("\n4ª Nota: ");
				a.notas[3]=sc.nextInt();
				a.notaf=((0.1*a.notas[0])+0.3*a.notas[1]+(0.1*a.notas[2])+(0.5*a.notas[3]));
				out.print("\n\nA nota final é de "+a.notaf+".");
			}
		}
		if(!find){
			for(int k=0;k<j;k++){
				c[k]=b[k];
			}
			aluno a=new aluno();
			a.nmec=mec;
			out.print("\n\nO aluno não existe. Insira o seu nome: ");
			while(sc.nextLine().length()!=0);
			a.name=sc.nextLine();
			out.print("\n1ª Nota: ");
			a.notas[0]=sc.nextInt();
			out.print("\n2ª Nota: ");
			a.notas[1]=sc.nextInt();
			out.print("\n3ª Nota: ");
			a.notas[2]=sc.nextInt();
			out.print("\n4ª Nota: ");
			a.notas[3]=sc.nextInt();
			a.notaf=((0.1*a.notas[0])+0.3*a.notas[1]+(0.1*a.notas[2])+(0.5*a.notas[3]));
			out.print("\n\nA nota final é de "+a.notaf+".\n\n\n");
			c[j]=a;
		}
		return c;
	}

	public static void listMec(aluno []b){
		int j;
		boolean troca;
		
		for(j=0;j<b.length;j++){
			aluno a=b[j];
			if(a==null) break;
		}
		
		do{
			troca=false;
			for(int i=0;i<j-1;i++){
				aluno a=b[i];
				aluno c=b[i+1];
				if(a.nmec>c.nmec){
					troca=true;
					aluno []tmp=new aluno[1];
					tmp[0]=b[i];
					b[i]=b[i+1];
					b[i+1]=tmp[0];
				}
			}
		}while(troca);
		
		for(int k=0;k<j;k++){
			aluno a=b[k];
			out.print("\nNº Mecanográfico: "+a.nmec+"\nNome: "+a.name+"\nNotas:\n1º Teste: "+a.notas[0]+"\n2º Teste: "+a.notas[1]+"\n3º Teste: "+a.notas[2]+"\n4º Teste: "+a.notas[3]+"\nNota final: "+a.notaf+"\n\n\n");
		}
	}

	public static void listNot(aluno []b){
		int j;
		boolean troca;
		
		for(j=0;j<b.length;j++){
			aluno a=b[j];
			if(a==null) break;
		}
		
		do{
			troca=false;
			for(int i=0;i<j-1;i++){
				aluno a=b[i];
				aluno c=b[i+1];
				if(a.notaf<c.notaf){
					troca=true;
					aluno []tmp=new aluno[1];
					tmp[0]=b[i];
					b[i]=b[i+1];
					b[i+1]=tmp[0];
				}
			}
		}while(troca);
		
		
		for(int k=0;k<j;k++){
			aluno a=b[k];
			out.print("\n\nNº Mecanográfico: "+a.nmec+"\nNome: "+a.name+"\nNotas:\n1º Teste: "+a.notas[0]+"\n2º Teste: "+a.notas[1]+"\n3º Teste: "+a.notas[2]+"\n4º Teste: "+a.notas[3]+"\nNota final: "+a.notaf+"\n\n\n");
		}
	}

	public static void fazerMed(aluno []b){
		int j;
		int soma=0;
		
		for(j=0;j<b.length;j++){
			aluno a=b[j];
			if(a==null) break;
		}
		
		for(int i=0;i<j;i++){
			aluno a=b[i];
			soma+=a.notaf;
		}
		
		double media=(soma/j);
		
		out.print("\n\nA média das notas é de "+media+".\n\n\n");
	}

	public static void melhorAl(aluno []b){
		int j;
		int pos=0;
		double max=0;
		
		for(j=0;j<b.length;j++){
			aluno a=b[j];
			if(a==null) break;
		}
		
		for(int i=0;i<j;i++){
			aluno a=b[i];
			if(a.notaf>max){
				max=a.notaf;
				pos=i;
			}
		}
		
		aluno best=b[pos];
		
		out.print("\n\nO melhor aluno foi: \nNome: "+best.name+"\nNº Mecanográfico: "+best.nmec+"\nNotas:\n1º Teste: "+best.notas[0]+"\n2º Teste: "+best.notas[1]+"\n3º Teste: "+best.notas[2]+"\n4º Teste: "+best.notas[3]+"\nNota final: "+best.notaf+"\n\n\n");

	}
}

class aluno{
	int nmec;
	String name;
	double []notas=new double[4];
	double notaf;
}
