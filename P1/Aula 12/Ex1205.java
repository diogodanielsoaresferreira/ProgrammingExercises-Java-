/**
 * Diogo Daniel Soares Ferreira, 2014
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mec. 76504
 */
package p1;

import static java.lang.System.*;

import java.util.Scanner;

public class Ex1205 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		char a;
		contacto b[]=new contacto [100];
		

		do{
			out.println("\nGestão de uma agenda: ");
			out.println("I - Inserir um contacto");
			out.println("P - Pesquisar contacto por nome");
			out.println("E - Eliminar um contacto");
			out.println("M - Mostrar os contactos");
			out.println("O - mostrar os contactos Ordenados pelo nome");
			out.println("V - Validar endereços de email");
			out.println("A - Apagar a agenda");
			out.println("T - Terminar o programa");
			out.print("Opção -> ");
			a=Character.toUpperCase((sc.nextLine()).charAt(0));
			
			switch(a){
			
			case 'I':
				insCont(b);
				break;
			case 'P':
				pesqNome(b);
				break;
			case 'E':
				elim(b);
				break;
			case 'M':
				showVal(b);
				break;
			case 'O':
				showValOrd(b);
				break;
			case 'V':
				valEmail(b);
				break;
			case 'A':
				clean(b);
				break;
			case 'T':
				out.println("Obrigado por usar esta agenda!");
				break;
			default:
				out.println("Entrada inválida!");
				break;
			
			}
		}while(a!='T');
		
	}
	
	public static void insCont(contacto []b){
		int i;
		
		for(i=0;i<b.length;i++){
			if(b[i]==null) break;
		}
		
		contacto a = new contacto();
		out.print("\nInsira o seu nome: ");
		a.name=sc.nextLine();
		out.print("\nInsira a sua morada: ");
		a.mor=sc.nextLine();
		out.print("\nInsira o seu número de telemóvel: ");
		a.tel=sc.nextInt();
		while(sc.nextLine().length()!=0);
		out.print("\nInsira o seu email: ");
		a.email=sc.nextLine();
		
		b[i]=a;
	}
	
	public static void pesqNome(contacto []b){
		String namepes;
		contacto a=null;
		int name=-1;
		int j, i;
		
		for(j=0;j<b.length;j++){
			if(b[j]==null) break;
		}
		
		out.print("Qual é o nome que deseja pesquisar? ");
		namepes=sc.nextLine();
		for(i=0; i<j; i++){
			a=b[i];
			name=(a.name).indexOf(namepes);
			if (name!=-1) break;
		}
		
		if(name==-1)out.print("\nO contacto pedido não existe!\n\n\n");
		
		else{
			out.print("\nNome: " + a.name);
			out.print("\nMorada: " + a.mor);
			out.print("\nNúmero de Telemóvel: " + a.tel);
			out.print("\nEmail: " + a.email + "\n\n\n");
		}
	}

	public static void elim(contacto []b){
		int tel,j,i, pos=-1;
		contacto a=null;;
		contacto []c=b;
		boolean p=false;
		
		out.print("\nIntroduza o número de telefone que deseja eliminar: ");
		tel=sc.nextInt();
		
		for(j=0;j<b.length;j++){
			if(b[j]==null) break;
		}
		
		for(i=0;i<j;i++){
			a=b[i];
			if (tel==a.tel){
				pos=i;
				break;
			}
		}
		
		if(pos==-1)out.print("\nNúmero não encontrado!");
		
		else{
			out.print("\nVamos eliminar o contacto " + a.name + "!");
			
			for(i=0;i<j;i++){
				a=b[i];
				if(a.tel==tel){
					out.print("\nNúmero eliminado com sucesso!");
					b[i]=null;
					p=true;
				}
				else{
					if(p)b[i-1]=c[i];
				}
			}
			b[i-1]=null;

		while(sc.nextLine().length()!=0);
		}
		out.print("\n\n\n");
		
	}
	
	public static void showVal(contacto []b){
		int i;
		
		for(i=0;i<b.length;i++){
			if(b[i]==null) break;
		}
		
		for(int j=0; j<i; j++){
			contacto a=b[j];
			out.print("\nNome: "+a.name+"\tMorada: "+a.mor+"\tNúmero de telemóvel: "+a.tel+"\tEmail: "+a.email);
		}
		out.print("\n\n\n");
	}

	public static void showValOrd(contacto []b){
		int j;
		
		//ou simplesmente Array.sort(b);
		
		for(j=0;j<b.length;j++){
			if(b[j]==null) break;
		}

		boolean troca=false;
		
		do{
			if(b[1]==null) break;
			troca=false;
			for(int i=0;i<j-1;i++){
				contacto a=b[i];
				contacto c=b[i+1];
				if(a.name.charAt(0)>c.name.charAt(0)){
					contacto temp;
					temp=b[i];
					b[i]=b[i+1];
					b[i+1]=temp;
					troca=true;
				}
			}
			
		}while(troca);
		
		for(int z=0; z<j; z++){
			contacto a=b[z];
			out.print("\nNome: "+a.name+"\tMorada: "+a.mor+"\tNúmero de telemóvel: "+a.tel+"\tEmail: "+a.email);
		}
		out.print("\n\n\n");
		
		out.print("\nA sequência está ordenada!\n\n\n");
	}
	
	public static void valEmail(contacto []b){
		int arroba=0;
		int j;
		
		for(j=0;j<b.length;j++){
			if(b[j]==null) break;
		}
		
		for(int i=0;i<j;i++){
			contacto a=b[i];
			for(int k=0;k<a.email.length();k++){
				if(a.email.charAt(k)=='@') arroba++;
			}
			while(!a.email.matches("[a-zA-Z0-9@_.]*") || arroba!=1){
				out.print("\nO email de "+a.name+" não é válido! Insira outro: ");
				a.email=sc.nextLine();
				arroba=0;
				for(int k=0;k<a.email.length();k++){
					if(a.email.charAt(k)=='@') arroba++;
				}
			}
				
		}
		
		out.print("\nOs seus endereços de email são válidos!\n\n\n");
	
	}

	public static void clean(contacto []b){
		int j;
		
		for(j=0;j<b.length;j++){
			b[j]=null;
			if(b[j]==null) break;
		}
		
		out.print("\nA agenda foi apagada com sucesso!\n\n\n");
	}

}

class contacto{
	
	String name;
	String mor;
	int tel;
	String email;
	
}