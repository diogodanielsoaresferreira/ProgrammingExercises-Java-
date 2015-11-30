/**
 * Diogo Daniel Soares Ferreira, 2014
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mec. 76504
 */
package p1;

import static java.lang.System.*;
import java.util.Scanner;

public class Ex1208 {

	final static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		int opcao;
		liv a[]=new liv[200];
		
		do{
			out.print("\nGestão de uma biblioteca\n");
			out.print("\n1 - Introduzir livro\n");
			out.print("\n2 - Remover um livro\n");
			out.print("\n3 - Apagar a base da dados\n");
			out.print("\n4 - Verificação de cotas repetidas\n");
			out.print("\n5 - Alterar o estado de um livro\n");
			out.print("\n6 - Listar os livros requisitados\n");
			out.print("\n7 - Listar os livros ordenados pela cota\n");
			out.print("\n8 - Listar os livros ordenados pela data\n");
			out.print("\n9 - Terminar o programa\n");
			out.print("\nOpção -> ");
			opcao=sc.nextInt();
			
			switch(opcao){
			case 1:
				introLiv(a);
				break;
			case 2:
				rmvLiv(a);
				break;
			case 3:
				clean(a);
				break;
			case 4:
				verCot(a);
				break;
			case 5:
				changeSt(a);
				break;
			case 6:
				showReq(a);
				break;
			case 7:
				ordCot(a);
				break;
			case 8:
				ordDat(a);
				break;
			default:
				out.print("\nOperação inválida!\n");
				break;
			}
		}while(opcao!=9);

		
	}
	
	public static void introLiv(liv[]b){
		String lcota, lautor,ltitulo,ldata;
		boolean data=false;
		int n=contLiv(b);
		char lestado=' ';
		
		
		while(sc.nextLine().length()!=0);
		out.print("\nVamos introduzir um novo livro!\nCota:");
		lcota=sc.nextLine();
		while(!lcota.matches("[A-Za-z0-9]*") || lcota.length()>20){
			out.print("\nCota inválida! Insira outra vez: ");
			lcota=sc.nextLine();
		}
		
		out.print("\nAutor do livro: ");
		lautor=sc.nextLine();
		while(lautor.length()>40){
			out.print("\nAutor extremamente longo! Tente novamente: ");
			lautor=sc.nextLine();
		}
		
		out.print("\nTítulo do livro: ");
		ltitulo=sc.nextLine();
		while(ltitulo.length()>60){
			out.print("\nTítulo demasiado longo! Insira um título mais pequeno: ");
			ltitulo=sc.nextLine();
		}
		do{
			do{
				out.print("\nData do livro (formato dd/mm/aa): ");
				ldata=sc.nextLine();
				data=true;
				if(ldata.length()!=8){
					out.print("\nFormato inválido!");
					data=false;
				}
			}while(data!=true);
				
			if(((Character.isDigit(ldata.charAt(0))&&Character.isDigit(ldata.charAt(1))&&ldata.charAt(2)=='/'&&Character.isDigit(ldata.charAt(3))&&Character.isDigit(ldata.charAt(4))&&ldata.charAt(5)=='/'&&Character.isDigit(ldata.charAt(6))&&Character.isDigit(ldata.charAt(7)))==false)
					||Character.getNumericValue(ldata.charAt(0))>3||Character.getNumericValue(ldata.charAt(3))>1){
				out.print("\nFormato inválido!");
				data=false;
			}
		}while(!data);
		
		do{
			out.print("\nQual o estado atual do livro (requisitado 'R', livre 'L' e condicionado 'C')? ");
			String estadol=sc.nextLine();
			if(estadol.charAt(0)=='r'||estadol.charAt(0)=='R')lestado='R';
			else if(estadol.charAt(0)=='l'||estadol.charAt(0)=='L')lestado='L';
			else if(estadol.charAt(0)=='c'||estadol.charAt(0)=='C')lestado='C';
			else out.print("\nCaracter inválido!");
			
		}while(lestado!='R' && lestado!='L' && lestado!='C');
		
		liv a=new liv();
		b[n]=a;
		a.autor=lautor;
		a.cota=lcota;
		a.data=ldata;
		a.estado=lestado;
		a.titulo=ltitulo;

		
	}
	
	public static void rmvLiv(liv[]b){
		String lcota;
		int n=contLiv(b);
		int liv=-1,k=0;
		liv a=new liv();
		int i;

		
		out.print("\n\nInsira a cota do livro que deseja remover: ");
		lcota=sc.next();
		
		for(i=0;i<n;i++){
			a=b[i];
			if(lcota.equals(a.cota)){
				liv=i;
				break;
			}
		}
		
		if(liv==-1) out.print("\n\nLivro não encontrado!\n\n");
		else{
			out.print("\n\nRemovido o livro "+a.titulo+".\n\n");
			liv[]c=b;
			for(k=0;k<b.length;k++){
				a=c[k];
				if(a==null){
					b[k]=null;
					break;
				}
				if(k==liv)b[k]=null;
				if(k>liv)b[k-1]=c[k];
			}
			b[k-1]=null;
		}

	}

	public static void clean(liv[]b){
		int n=contLiv(b);
		
		for(int i=0;i<n;i++){
			b[i]=null;
		}
		
		out.print("\n\nA sua base de dados foi apagada com sucesso!\n\n");
	}
	
	public static void verCot(liv[]b){
		String []cotas=new String[200];
		int n=contLiv(b),i;
		liv a=new liv();
		String cotan;
		boolean troca;
		
		for(i=0;i<n;i++){
			if(b[i]==null)break;
			a=b[i];
			cotas[i]=a.cota;
		}
		while(sc.nextLine().length()!=0);
		do{
			troca=false;
			for(i=0;i<n;i++){
				a=b[i];
				for(int j=0;j<n;j++)
					if(j!=i && a.cota.equals(cotas[j])){
						liv z=b[j];
						out.print("\n\nCota repetida para o título "+a.titulo+" e "+z.titulo+"! Insira novas cotas: ");
						out.print("\nCota de "+a.titulo+":");
						cotan=sc.nextLine();
						while(!cotan.matches("[A-Za-z0-9]*") || cotan.length()>20){
							out.print("\nCota inválida! Insira outra vez: ");
							cotan=sc.nextLine();
						}
						a.cota=cotan;
						cotas[i]=cotan;
						out.print("Cota de "+z.titulo+":");
						cotan=sc.nextLine();
						while(!cotan.matches("[A-Za-z0-9]*") || cotan.length()>20){
							out.print("\nCota inválida! Insira outra vez: ");
							cotan=sc.nextLine();
						}
						z.cota=cotan;
						cotas[j]=cotan;
						troca=true;
					}
			}
		}while(troca);
		
		out.print("\n\nVerificação completa!\n\n\n");
	}
	
	public static void changeSt(liv[]b){
		String cotat,estadoa=null;
		liv a=new liv();
		int pos=-1;
		boolean valido=true;
		char estadof;
		
		out.print("\n\nInsira a cota do livro que deseja alterar o estado: ");
		cotat=sc.next();
		
		for(int i=0;i<contLiv(b);i++){
			a=b[i];
			if(a.cota.equals(cotat)){
				pos=i;
				break;
			}
		}
		if(pos==-1) out.print("\n\nO livro não existe na base de dados!\n\n\n");
		else {
			switch(a.estado){
			case 'L':
				estadoa="Livre(L)";
				break;
			case 'R':
				estadoa="Requisitado(R)";
				break;
			case 'C':
				estadoa="Condicionado(C)";
				break;
			}
			do{
				if(!valido)out.print("\nEstado inválido!");
				valido=false;
				out.print("\nVamos alterar o estado de "+a.titulo+": ");
				out.print("\nEstado atual: "+estadoa);
				out.print("\nDeseja alterar para que estado(R,L,C)? ");
				estadof=sc.next().charAt(0);
				out.print(a.estado);
				
				switch(a.estado){

				case 'R':
					if(estadof=='L')valido=true;
					break;
				case 'L':
					if(estadof=='R'||estadof=='C')valido=true;
					break;				
				case 'C':
					if(estadof=='L')valido=true;
					break;
				
				}
				
			}while(!valido);
			a.estado=estadof;
			out.print("\n\nO estado foi alterado com sucesso!\n\n\n");
		}
		
	}

	public static void showReq(liv[]b){
		int n=contLiv(b);
		liv a=new liv();
		
		out.print("\n\nOs livros requisitados são: ");
		
		for(int i=0;i<n;i++){
			a=b[i];
			if(a.estado=='R'){
				out.print("\n"+a.titulo);
			}
		}
		out.print("\n\n\n");
	}
	
	public static void ordCot(liv[]b){
		int n=contLiv(b);
		boolean troca;
		liv a=new liv();
		liv z=new liv();
		liv []x=new liv[1];
		
		do{
			troca=false;
			for(int i=0;i<n-1;i++){
				a=b[i];
				z=b[i+1];
				if(Integer.parseInt(a.cota)>Integer.parseInt(z.cota)){
					x[0]=b[i];
					b[i]=b[i+1];
					b[i+1]=x[0];
					troca=true;
				}
			}
			
		}while(troca);
		
		out.print("\n\nLivros:");
		
		for(int i=0;i<n;i++){
			a=b[i];
			out.print("\n\t"+a.titulo);
		}
		
		out.print("\n\n\n");
		
	}
	
	public static void ordDat(liv[]b){
		int n=contLiv(b);
		liv a=new liv();
		liv z=new liv();
		liv[]tmp=new liv[1];
		boolean troca;
		
		do{
			troca=false;
			for(int i=0;i<n-1;i++){
				a=b[i];
				z=b[i+1];
				if((a.data.charAt(6)>z.data.charAt(6))||((a.data.charAt(6)==z.data.charAt(6))&&(a.data.charAt(7)>z.data.charAt(7)))||
						((a.data.charAt(6)==z.data.charAt(6))&&(a.data.charAt(7)==z.data.charAt(7))&&(a.data.charAt(3)>z.data.charAt(3)))||
						((a.data.charAt(6)==z.data.charAt(6))&&(a.data.charAt(7)==z.data.charAt(7))&&(a.data.charAt(3)==z.data.charAt(3))&&(a.data.charAt(4)>z.data.charAt(4)))||
						((a.data.charAt(6)==z.data.charAt(6))&&(a.data.charAt(7)==z.data.charAt(7))&&(a.data.charAt(3)==z.data.charAt(3))&&(a.data.charAt(4)==z.data.charAt(4))&&(a.data.charAt(0)>z.data.charAt(0)))||
						((a.data.charAt(6)==z.data.charAt(6))&&(a.data.charAt(7)==z.data.charAt(7))&&(a.data.charAt(3)==z.data.charAt(3))&&(a.data.charAt(4)==z.data.charAt(4))&&(a.data.charAt(0)==z.data.charAt(0))&&(a.data.charAt(1)>z.data.charAt(1)))){
					tmp[0]=b[i];
					b[i]=b[i+1];
					b[i+1]=tmp[0];
					troca=true;
				}
			}
		}while(troca);
		
		out.print("\n\nLivros:");
		
		for(int i=0;i<n;i++){
			a=b[i];
			out.print("\n\t"+a.titulo);
		}
		
		out.print("\n\n\n");
		
	}
	
	public static int contLiv(liv[]b){
		int i;
		
		for(i=0;i<b.length;i++){
			liv a=b[i];
			if(a==null)break;
		}
		
		return i;
	}

}

class liv{
	String cota;
	String autor;
	String titulo;
	String data;
	char estado;
}
