/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

import static java.lang.System.*;
import java.util.Scanner;

public class Menu {

	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		int n;
		do{
			out.print("\nInsira o número máximo de quotas de empréstimo: ");
			n =sc.nextInt();
			sc.nextLine();
			if(n<0) out.print("\nNúmero tem de ser maior que zero.");
		}while(n<0);

		Funcionarios []fun = new Funcionarios[0];
		Estudantes []est = new Estudantes[0];
		Videos []vid = new Videos[0];
		int a;

		do{
			out.print("\n\n*****Video-clube da associação de estudantes*****");
			out.print("\n1 - Adicionar utilizadores");
			out.print("\n2 - Listar todos os utilizadores");
			out.print("\n3 - Remover utilizadores");
			out.print("\n4 - Pesquisar vídeos");
			out.print("\n5 - Listar vídeos disponíveis por utilizador");
			out.print("\n6 - Introduzir vídeo");
			out.print("\n7 - Remover vídeo");
			out.print("\n8 - Verificar disponibilidade de vídeo");
			out.print("\n9 - Efetuar empréstimo");
			out.print("\n10 - Devolução de vídeos");
			out.print("\n11 - Listar histórico de utilizadores por vídeo");
			out.print("\n12 - Listar todos os vídeos por rating");
			out.print("\n13 - Listar todos os vídeos emprestados por utilizador");
			out.print("\n14 - Terminar o programa");
			out.print("\nEscolha: ");
			a = sc.nextInt();
			sc.nextLine();
			while(a<1 || a>14){
				out.print("\nEscolha inválida!");
				out.print("\nEscolha novamente: ");
				a = sc.nextInt();
			}
			
			switch(a){
			
			case 1:
				if(addCl()==1) fun=addF(fun, n);
				else est=addE(est, n);
				break;
			case 2:
				lisUt(fun,est);
				break;
			case 3:
				if(addCl()==1) fun=delF(fun);
				else est=delE(est);
				break;
			case 4:
				pesVid(vid);
				break;
			case 5:
				vidByUs(vid,est,fun);
				break;
			case 6:
				vid = addVid(vid);
				break;
			case 7:
				vid = delVid(vid);
				break;
			case 8:
				checkLoan(vid);
				break;
			case 9:
				vid = loan(vid,fun,est);
				break;
			case 10:
				vid = devVid(vid);
				break;
			case 11:
				vid = userReq(vid);
				break;
			case 12:
				listRat(vid);
				break;
			case 13:
				if(addCl()==1) lisVidByFun(fun);
				else lisVidByEs(est);
				break;
			case 14:
				break;
			default:
				out.print("\nEscolha inválida!");
				break;
			}
		}while(a!=14);
	}
	
	private static int addCl(){
		int a;
		out.print("\n\nO utilizador é:");
		out.print("\n1 - Funcionário");
		out.print("\n2 - Estudante");
		out.print("\nEscolha: ");
		a = sc.nextInt();
		sc.nextLine();
		while(a<1 || a>2){
			out.print("\nEscolha inválida!");
			out.print("\nEscolha novamente: ");
			a = sc.nextInt();
		}
		return a;
	}

	private static Funcionarios[] addF(Funcionarios []fun, int n){
		Funcionarios []c = new Funcionarios[fun.length+1];
		for(int i=0;i<fun.length;i++){
			c[i] = fun[i];
		}
		
		out.print("\n\nEscreva o nome do funcionário: ");
		String name = sc.nextLine();
		int ano=0, mes=0, dia=0;
		do{
			out.print("\nInsira o seu ano de inscrição de sócio: ");
			ano = sc.nextInt();
			sc.nextLine();
			out.print("\nInsira o seu mês de inscrição de sócio: ");
			mes = sc.nextInt();
			sc.nextLine();
			out.print("\nInsira o seu dia de inscrição de sócio: ");
			dia = sc.nextInt();
			if(!Data.validarData(ano, mes, dia)) out.print("\nData inválida!");
		}while(!Data.validarData(ano, mes, dia));
		
		Data ins = new Data(dia, mes, ano);
		
		do{
			out.print("\nInsira o seu ano de nascimento: ");
			ano = sc.nextInt();
			sc.nextLine();
			out.print("\nInsira o seu mês de nascimento: ");
			mes = sc.nextInt();
			sc.nextLine();
			out.print("\nInsira o seu dia de nascimento: ");
			dia = sc.nextInt();
			if(!Data.validarData(ano, mes, dia)) out.print("\nData inválida!");
		}while(!Data.validarData(ano, mes, dia));
		
		Data nasc = new Data(dia, mes, ano);
		
		long cc;
		
		do{
			out.print("\nInsira o seu número de CC: ");
			cc = sc.nextLong();
			sc.nextLine();
			if(cc<0) out.print("\nNúmero de CC inválido!");
		}while(cc<0);
		
		long func, fisc;
		
		do{
			out.print("\nInsira o seu número de funcionário: ");
			func = sc.nextLong();
			sc.nextLine();
			if(func<0) out.print("\nNúmero de funcionário inválido!");
		}while(func<0);
		
		do{
			out.print("\nInsira o seu número fiscal: ");
			fisc = sc.nextLong();
			sc.nextLine();
			if(fisc<0) out.print("\nNúmero fiscal inválido!");
		}while(fisc<0);
		
		c[fun.length] = new Funcionarios(ins, name, cc, nasc, func, fisc, n);
		
		out.println("\nFuncionário criado com sucesso com o número de sócio "+c[fun.length].getSocio()+"!");
		return c;
	}
	
	private static Estudantes[] addE(Estudantes []e, int n){
		Estudantes []c = new Estudantes[e.length+1];
		for(int i=0;i<e.length;i++){
			c[i] = e[i];
		}
		
		out.print("\n\nEscreva o nome do estudante: ");
		String name = sc.nextLine();
		int ano=0, mes=0, dia=0;
		do{
			out.print("\nInsira o seu ano de inscrição de sócio: ");
			ano = sc.nextInt();
			sc.nextLine();
			out.print("\nInsira o seu mês de inscrição de sócio: ");
			mes = sc.nextInt();
			sc.nextLine();
			out.print("\nInsira o seu dia de inscrição de sócio: ");
			dia = sc.nextInt();
			if(!Data.validarData(ano, mes, dia)) out.print("\nData inválida!");
		}while(!Data.validarData(ano, mes, dia));
		
		Data ins = new Data(dia, mes, ano);
		
		do{
			out.print("\nInsira o seu ano de nascimento: ");
			ano = sc.nextInt();
			sc.nextLine();
			out.print("\nInsira o seu mês de nascimento: ");
			mes = sc.nextInt();
			sc.nextLine();
			out.print("\nInsira o seu dia de nascimento: ");
			dia = sc.nextInt();
			if(!Data.validarData(ano, mes, dia)) out.print("\nData inválida!");
		}while(!Data.validarData(ano, mes, dia));
		
		Data nasc = new Data(dia, mes, ano);
		
		long cc;
		
		do{
			out.print("\nInsira o seu número de CC: ");
			cc = sc.nextLong();
			sc.nextLine();
			if(cc<0) out.print("\nNúmero de CC inválido!");
		}while(cc<0);
		
		long mec;
		
		do{
			out.print("\nInsira o seu número mecanográfico: ");
			mec = sc.nextLong();
			sc.nextLine();
			if(mec<0) out.print("\nNúmero mecanográfico inválido!");
		}while(mec<0);
		
		out.print("\nInsira o nome do seu curso: ");
		String curso = sc.nextLine();
		
		c[e.length] = new Estudantes(ins, name, cc, nasc, mec, curso, n);
		
		out.println("\nFuncionário criado com sucesso com o número de sócio "+c[e.length].getSocio()+" !");
		
		return c;
	}
	
	private static void lisUt(Funcionarios []fun, Estudantes[]e){
		out.print("\n\nLista de clientes");
		out.print("\n\nFuncionários:");
		out.print("\nNome\t\tCC\t\tNúmero de sócio");
		for(Funcionarios a:fun){
			if(a!=null)
				out.print("\n"+a.getNome()+"\t\t"+a.getCC()+"\t\t"+a.getSocio()+"\n");
		}
		out.print("\n\nEstudantes:");
		out.print("\nNome\t\tCC\t\tNúmero de sócio");
		for(Estudantes a:e){
			if(a!=null)
				out.print("\n"+a.getNome()+"\t\t"+a.getCC()+"\t\t"+a.getSocio()+"\n");
		}
		
	}
	
	private static Estudantes[] delE(Estudantes []e){
		
		out.print("\nInsira o numero de sócio do estudante: ");
		long id = sc.nextLong();
		sc.nextLine();
		int p = searchEst(e, id);
		if(p==-1) out.print("\nO cliente não existe na base de dados!");
		else{
			e[p] = null;
			out.print("\nO cliente foi apagado com sucesso!");
		}
		return e;
	}
	
	private static Funcionarios[] delF(Funcionarios []f){
		
		out.print("\nInsira o numero de sócio do funcionário: ");
		long id = sc.nextLong();
		sc.nextLine();
		int p = searchFun(f, id);
		if(p==-1) out.print("\nO cliente não existe na base de dados!");
		else{
			f[p] = null;
			out.print("\nO cliente foi apagado com sucesso!");
		}
		return f;
	}
	
	private static Videos[] addVid(Videos[] vid){
		
		Videos []c = new Videos[vid.length+1];
		for(int i=0;i<vid.length;i++){
			c[i] = vid[i];
		}
		
		
		out.print("\n\nInsira o nome do vídeo que deseja adicionar: ");
		String name = sc.nextLine();
		out.print("\nInsira a categoria do vídeo: ");
		String cat = sc.nextLine();
		String idade;
		do{
			out.print("\nInsira a idade mínima para o vídeo (ALL, M6, M12, M16, M18): ");
			idade = sc.nextLine();
			if(!idade.equals("ALL") && !idade.equals("M6") && !idade.equals("M12") && !idade.equals("M16") && !idade.equals("M18"))
				out.print("\nIdade mínima inválida!");
		}while(!idade.equals("ALL") && !idade.equals("M6") && !idade.equals("M12") && !idade.equals("M16") && !idade.equals("M18"));
		
		Videos v = new Videos(name, cat, idade);
		c[vid.length]=v;
		
		out.print("\nFoi criado com sucesso um vídeo com o ID "+c[vid.length].getId()+".");
		
		return c;
	}
	
	private static Videos[] delVid(Videos []vid){
		
		out.print("\nInsira o ID do vídeo que deseja apagar: ");
		long id = sc.nextLong();
		sc.nextLine();
		int p = searchVid(vid, id);
		if(p==-1) out.print("\nO vídeo não existe na base de dados!");
		else{
			vid[p]=null;
			out.print("\nO vídeo foi apagado com sucesso!");
		}
		return vid;
	}
	
	private static void pesVid(Videos []vid){
		out.print("\nInsira o nome do vídeo que deseja procurar: ");
		String name = sc.nextLine();
		out.print("\nVídeos encontrados: ");
		out.print("\nId\t\tTítulo\t\tCategoria\t\tIdade mínima\t\tRating médio");
		for( Videos a : vid)
			if(a!= null && a.getTitle().contains(name))
				out.print("\n"+a.getId()+"\t\t"+a.getTitle()+"\t\t"+a.getCat()+"\t\t"+a.getIda()+"\t\t"+a.ratMed());
		
	}
	
	private static void vidByUs(Videos []vid, Estudantes[] e, Funcionarios []f){

		out.print("\n\nInsira o número de sócio do cliente: ");
		long soc = sc.nextLong();
		sc.nextLine();
		int idade=-1;
		
		int p = searchEst(e,soc);
		if(p==-1) p=searchFun(f, soc);
		else if(p!=-1){
			idade = e[p].getNasc().getIdade();
		}
		
		if(p==-1) out.print("\nNão existe ninguém com esse número de sócio.");
		else{
			if(idade==-1) idade = f[p].getNasc().getIdade();
			out.print("\nDos videos disponíveis, o cliente está autorizado a ver: ");
			for(Videos v : vid){
				if(v!=null){
					if(v.getIda().equals("ALL") && !v.isLoan())
						out.print("\n"+v.getId()+"\t\t"+v.getTitle()+"\t\t"+v.getCat()+"\t\t"+v.getIda()+"\t\t"+v.ratMed());
					else if(v.getIda().equals("M6") && idade>6 && !v.isLoan())
						out.print("\n"+v.getId()+"\t\t"+v.getTitle()+"\t\t"+v.getCat()+"\t\t"+v.getIda()+"\t\t"+v.ratMed());
					else if(v.getIda().equals("M12") && idade>12 && !v.isLoan())
						out.print("\n"+v.getId()+"\t\t"+v.getTitle()+"\t\t"+v.getCat()+"\t\t"+v.getIda()+"\t\t"+v.ratMed());
					else if(v.getIda().equals("M16") && idade>16 && !v.isLoan())
						out.print("\n"+v.getId()+"\t\t"+v.getTitle()+"\t\t"+v.getCat()+"\t\t"+v.getIda()+"\t\t"+v.ratMed());
					else if(v.getIda().equals("M18") && idade>18 && !v.isLoan())
						out.print("\n"+v.getId()+"\t\t"+v.getTitle()+"\t\t"+v.getCat()+"\t\t"+v.getIda()+"\t\t"+v.ratMed());
				}
			}
		}
	}
	
	private static void checkLoan(Videos []vid){
		out.print("\nInsira o ID do vídeo que deseja apagar: ");
		long id = sc.nextLong();
		sc.nextLine();
		int p = searchVid(vid, id);
		if(p==-1) out.print("\nO vídeo não existe na base de dados!");
		else{
			if(vid[p].isLoan()) out.print("\nO vídeo está atualmente emprestado.");
			else out.print("\nO video está atualmente livre para ser emprestado.");
		}
	}
	
	private static Videos[] loan(Videos[] vid, Funcionarios[]f, Estudantes[] e){
		out.print("\nInsira o ID do vídeo que deseja emprestar: ");
		long id = sc.nextLong();
		sc.nextLine();
		int p = searchVid(vid, id);
		if(p==-1) out.print("\nO vídeo não existe na base de dados!");
		else{
			if(vid[p].isLoan()){
				out.print("\nO vídeo está atualmente emprestado.");
				return vid;
			}
			else{
				
				int a = addCl();
				int p2;
				if(a==1){
					out.print("\nInsira o numero de sócio do funcionário: ");
					long id2 = sc.nextLong();
					sc.nextLine();
					p2 = searchFun(f, id2);
					if(p2==-1){
						out.print("\nO cliente não existe na base de dados!");
						return vid;
					}
					else if(f[p2].getNLeft()==0){
						out.print("\nO utilizador excedeu o limite máximo da quota para requisitar vídeos.");
						return vid;
					}
					else{
						int idade = f[p2].getNasc().getIdade();
						if(vid[p].getIda().equals("ALL") && !vid[p].isLoan())
							vid[p].checkout(f[p2]);
						else if(vid[p].getIda().equals("M6") && idade>6 && !vid[p].isLoan())
							vid[p].checkout(f[p2]);
						else if(vid[p].getIda().equals("M12") && idade>12 && !vid[p].isLoan())
							vid[p].checkout(f[p2]);
						else if(vid[p].getIda().equals("M16") && idade>16 && !vid[p].isLoan())
							vid[p].checkout(f[p2]);
						else if(vid[p].getIda().equals("M18") && idade>18 && !vid[p].isLoan())
							vid[p].checkout(f[p2]);
						else{
							out.print("O vídeo não pode atualmente ser emprestado ao cliente.");
							return vid;
						}
							
					}
				}
				else{
					out.print("\nInsira o numero de sócio do estudante: ");
					long id2 = sc.nextLong();
					sc.nextLine();
					p2 = searchEst(e, id2);
					if(p2==-1){
						out.print("\nO cliente não existe na base de dados!");
						return vid;
					}
					else if(e[p2].getNLeft()==0){
						out.print("\nO utilizador excedeu o limite máximo da quota para requisitar vídeos.");
						return vid;
					}
					else{
						int idade = e[p2].getNasc().getIdade();
						if(vid[p].getIda().equals("ALL") && !vid[p].isLoan())
							vid[p].checkout(e[p2]);
						else if(vid[p].getIda().equals("M6") && idade>6 && !vid[p].isLoan())
							vid[p].checkout(e[p2]);
						else if(vid[p].getIda().equals("M12") && idade>12 && !vid[p].isLoan())
							vid[p].checkout(e[p2]);
						else if(vid[p].getIda().equals("M16") && idade>16 && !vid[p].isLoan())
							vid[p].checkout(e[p2]);
						else if(vid[p].getIda().equals("M18") && idade>18 && !vid[p].isLoan())
							vid[p].checkout(e[p2]);
						else{
							out.print("O vídeo não pode atualmente ser emprestado ao cliente.");
							return vid;
						}
					}
				}
			}
		}
		
		out.print("\nO vídeo foi emprestado com sucesso!");
		return vid;
	}
	
	private static Videos[] userReq(Videos[] vid){
		
		out.print("\nInsira o ID do vídeo que deseja ver o histórico de utilizadores: ");
		long id = sc.nextLong();
		sc.nextLine();
		int p = searchVid(vid, id);
		if(p==-1) out.print("\nO vídeo não existe na base de dados!");
		else{
			out.print("\nNome\t\tNº de Sócio\t\tNº de CC");
			for(Funcionarios a : vid[p].getLoanFunHist()){
				if(a!=null)
					out.print("\n"+a.getNome()+"\t\t"+a.getSocio()+"\t\t"+a.getCC());
			}
			for(Estudantes a : vid[p].getLoanEstHist()){
				if(a!=null)
					out.print("\n"+a.getNome()+"\t\t"+a.getSocio()+"\t\t"+a.getCC());
			}
		}
		return vid;
	}
	
	private static Videos[] devVid(Videos[] vid){
		out.print("\nInsira o ID do vídeo que deseja devolver: ");
		long a = sc.nextLong();
		sc.nextLine();
		int p = searchVid(vid, a);
		
		if(p==-1){
			out.print("\nO vídeo não existe na base de dados.");
			return vid;
		}
		else if(!vid[p].isLoan()){
			out.print("O vídeo encontra-se atualmente na base de dados.");
			return vid;
		}
		else{
			double rat;
			do{
				out.print("\nInsira o rating que dá ao vídeo, de 1 a 10: ");
				rat = sc.nextDouble();
				if(rat<0 || rat>10){
					out.print("\nRating inválido! O rating terá de ser um valor entre 1 e 10.");
				}
			}while(rat<0 || rat>10);
			vid[p].checkin(rat);
			out.print("O vídeo foi devolvido com sucesso!");
		}
		return vid;
	}
	
	private static void listRat(Videos[] vid){
		
		boolean troca;
		int f = vid.length;
		do{
			troca = false;
			for(int i=0;i<f;i++){
				if(vid[i].ratMed()<vid[i+1].ratMed()){
					Videos t = vid[i];
					vid[i] = vid[i+1];
					vid[i+1] = t;
					troca = true;
				}
				f--;
			}
		}while(troca);
		
		out.print("\nId\t\tTítulo\t\tCategoria\t\tIdade mínima\t\tRating médio");
		for( Videos a : vid)
			if(a!= null)
				out.print("\n"+a.getId()+"\t\t"+a.getTitle()+"\t\t"+a.getCat()+"\t\t"+a.getIda()+"\t\t"+a.ratMed());

	}
	
	private static void lisVidByEs(Estudantes[] e){
		out.print("\n\nInsira o número de sócio do estudante: ");
		long soc = sc.nextLong();
		sc.nextLine();
		int p = searchEst(e, soc);
		if(p==-1){
			out.print("\nEste estudante não existe na base de dados");
			return;
		}
		else{
			Videos[] vid = e[p].getHist();
			out.print("\nO cliente está requisitou: ");
			for(Videos v : vid)
				if(v!=null)
					out.print("\n"+v.getId()+"\t\t"+v.getTitle()+"\t\t"+v.getCat()+"\t\t"+v.getIda()+"\t\t"+v.ratMed());
		}
	}
	
	private static void lisVidByFun(Funcionarios[] f){
		out.print("\n\nInsira o número de sócio do funcionario: ");
		long soc = sc.nextLong();
		sc.nextLine();
		int p = searchFun(f, soc);
		if(p==-1){
			out.print("\nEste funcionário não existe na base de dados");
			return;
		}
		else{
			Videos[] vid = f[p].getHist();
			out.print("\nO cliente está requisitou: ");
			for(Videos v : vid)
				if(v!=null)
					out.print("\n"+v.getId()+"\t\t"+v.getTitle()+"\t\t"+v.getCat()+"\t\t"+v.getIda()+"\t\t"+v.ratMed());
		}
	}
	
	private static int searchVid(Videos []vid, long v){
		for(int i=0;i<vid.length;i++){
			if(vid[i]!=null && vid[i].getId()==v){
				return i;
			}
		}
		
		return -1;
	}
	
	private static int searchEst(Estudantes[] e, long n){
		for(int i=0;i<e.length;i++){
			if(e[i]!=null && e[i].getSocio()==n){
				return i;
			}
		}
		return -1;
	}
	
	private static int searchFun(Funcionarios[] f, long n){
		for(int i=0;i<f.length;i++){
			if(f[i]!= null && f[i].getSocio()==n){
				return i;
			}
		}
		return -1;
	}
	
	
}
