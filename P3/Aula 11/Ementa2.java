/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula11;

import static java.lang.System.*;
import java.util.*;
import java.io.*;
import aula6.*;

public class Ementa2 {

	final static Scanner sc = new Scanner(System.in);
	
	private static List<Alimento> al = new ArrayList<Alimento>();
	private static List<Prato> pr = new ArrayList<Prato>();
	private static Ementa e = new Ementa("Ementa");
	
	public static void main(String[] args) {
		int o;
		do {
			do{
				out.println("\n******EMENTA*********");
				out.println("1 - Adicionar ingrediente");
				out.println("2 - Alterar prato");
				out.println("3 - Alterar Ementa");
				out.println("4 - Guardar/Carregar ementa");
				out.print("Opção -> ");
				o = sc.nextInt();
				sc.nextLine();
			}while(o<1 || o>4);

			if(o==1){
				do {
					out.println("\n1 - Adicionar Carne");
					out.println("2 - Adicionar Peixe");
					out.println("3 - Adicionar Cereal");
					out.println("4 - Adicionar Legume");
					out.print("Opção -> ");
					o = sc.nextInt();
					sc.nextLine();
				} while (o<1 || o>4);
				if(o==1)
					addCarne();
				else if(o==2)
					addPeixe();
				else if(o==3)
					addCereal();
				else
					addLegume();
			}
			else if(o==2){
				do {
					out.println("\n1 - Cria prato");
					out.println("2 - Apaga prato");
					out.println("3 - Adiciona ingrediente");
					out.println("4 - Remove ingrediente");
					out.print("Opção -> ");
					o = sc.nextInt();
					sc.nextLine();
				} while (o<1 || o>4);
				if(o==1)
					criaPrato();
				else if(o==2)
					apagaPrato();
				else if(o==3)
					addIng();
				else
					remIng();
			}
			else if (o==3){
				do {
					out.println("\n1 - Adiciona prato");
					out.println("2 - Remove prato");
					out.println("3 - Imprime ementa");
					out.print("Opção -> ");
					o = sc.nextInt();
					sc.nextLine();
				} while (o<1 || o>3);
				if(o==1)
					addPrato();
				if(o==2)
					remPrato();
				else
					System.out.print(e.toString());
			}
			else{
				do{
					out.print("\n1 - Guardar ementa");
					out.print("\n2 - Carregar ementa");
					out.print("\nOpção -> ");
					o = sc.nextInt();
					sc.nextLine();
				}while(o<1 || o>2);
				if(o==1)
					guardarEmenta();
				else
					carregarEmenta();
			}
		} while (1==1);	
		
	}
	
	public static void addCarne(){
		int n;
		do{
			out.print("\nEscolha a variedade de carne: ");
			out.print("\n1 - Vaca");
			out.print("\n2 - Porco");
			out.print("\n3 - Perú");
			out.print("\n4 - Frango");
			out.print("\n5 - Outra");
			out.print("\nOpção -> ");
			n=sc.nextInt();
			sc.nextLine();
		}while(n<1 || n>5);
		out.print("\nProteínas: ");
		double pro=sc.nextDouble();
		sc.nextLine();
		out.print("\nCalorias: ");
		double cal=sc.nextDouble();
		sc.nextLine();
		out.print("\nPeso: ");
		double pes=sc.nextDouble();
		sc.nextLine();
		
		al.add((new Carne(Carne.VariedadeCarne.getVar(n),pro,cal,pes)));
	}
	
	public static void addPeixe(){
		int n;
		do{
			out.print("\nEscolha o tipo de peixe: ");
			out.print("\n1 - Congelado");
			out.print("\n2 - Fresco");
			out.print("\nOpção -> ");
			n=sc.nextInt();
			sc.nextLine();
		}while(n<1 || n>2);
		out.print("\nProteínas: ");
		double pro=sc.nextDouble();
		sc.nextLine();
		out.print("\nCalorias: ");
		double cal=sc.nextDouble();
		sc.nextLine();
		out.print("\nPeso: ");
		double pes=sc.nextDouble();
		sc.nextLine();
		
		al.add((new Peixe(Peixe.TipoPeixe.getTipo(n),pro,cal,pes)));
	}
	
	public static void addCereal(){
		
		out.print("\nNome: ");
		String cer=sc.nextLine();
		out.print("\nProteínas: ");
		double pro=sc.nextDouble();
		sc.nextLine();
		out.print("\nCalorias: ");
		double cal=sc.nextDouble();
		sc.nextLine();
		out.print("\nPeso: ");
		double pes=sc.nextDouble();
		sc.nextLine();
		
		al.add((new Cereal(cer,pro,cal,pes)));
	}
	
	public static void addLegume(){
		
		out.print("\nNome: ");
		String leg=sc.nextLine();
		out.print("\nProteínas: ");
		double pro=sc.nextDouble();
		sc.nextLine();
		out.print("\nCalorias: ");
		double cal=sc.nextDouble();
		sc.nextLine();
		out.print("\nPeso: ");
		double pes=sc.nextDouble();
		sc.nextLine();
		
		al.add((new Legume(leg,pro,cal,pes)));
	}
	
	public static void criaPrato(){
		int n;
		do{
			out.print("\nDeseja criar um prato:");
			out.print("\n1 - Normal");
			out.print("\n2 - Dieta");
			out.print("\n3 - Vegetariano");
			out.print("\nEscolha -> ");
			n = sc.nextInt();
			sc.nextLine();
		}while(n<1 || n>3);
		out.print("\nEscreva o nome do prato:");
		String name = sc.nextLine();
		if (n==1){
			pr.add((new Prato(name)));
		}
		else if(n==2){
			out.print("\nEscreva o número máximo de calorias no prato: ");
			int cal = sc.nextInt();
			sc.nextLine();
			pr.add((new PratoDieta(name, cal)));
		}
		else{
			pr.add((new PratoVegetariano(name)));
		}
	}
	
	public static void apagaPrato(){
		int n;
		if(pr.size()<1){
			out.print("\nNão existem pratos atualmente!");
			return;
		}
		do{
			out.print("Escreva o número do prato que deseja apagar:");
			System.out.print(listPrat());
			out.print("\nOpção -> ");
			n=sc.nextInt();
			sc.nextLine();
		}while(n<1 || n>pr.size());
		n--;
		pr.remove(n);
		
	}

	public static void addIng(){
		int n;
		int j;
		if(pr.size()<1){
			out.print("\nNão existem pratos atualmente!");
			return;
		}
		do{
			out.print("Escreva o número do prato que deseja alterar:");
			System.out.print(listPrat());
			out.print("\nOpção -> ");
			n=sc.nextInt();
			sc.nextLine();
		}while(n<1 || n>pr.size());
		n--;
		do{
			out.print("Escreva o número do ingrediente que deseja adicionar:");
			System.out.print(listIng());
			out.print("\nOpção -> ");
			j=sc.nextInt();
			sc.nextLine();
		}while(j<1 || j>al.size());
		j--;
		if(pr.get(n).addAl(al.get(j)))
			out.print("\nElemento Adicionado.");
		else
			out.print("\nElemento não pode ser adicionado.");
		
	}
	
	public static void remIng(){
		int n;
		int j;
		if(pr.size()<1){
			out.print("\nNão existem pratos atualmente!");
			return;
		}
		do{
			out.print("Escreva o número do prato que deseja alterar:");
			System.out.print(listPrat());
			out.print("\nOpção -> ");
			n=sc.nextInt();
			sc.nextLine();
		}while(n<1 || n>pr.size());
		n--;
		do{
			out.print("Escreva o número do ingrediente que deseja retirar:");
			System.out.print(listIng());
			out.print("\nOpção -> ");
			j=sc.nextInt();
			sc.nextLine();
		}while(j<1 || j>al.size());
		j--;
		if(!pr.get(n).exists((al.get(j))))
			out.print("\nO ingrediente não existe atualmente no prato.");
		else{
			pr.get(n).del(al.get(j));
			out.print("\nO ingrediente foi apagado do prato com sucesso.");
		}
	}
	
	public static void addPrato(){
		int n;
		if(pr.size()<1){
			out.print("\nNão existem pratos atualmente!");
			return;
		}
		do{
			out.print("Escreva o número do prato que deseja adicionar:");
			System.out.print(listPrat());
			out.print("\nOpção -> ");
			n=sc.nextInt();
			sc.nextLine();
		}while(n<1 || n>pr.size());
		n--;
		int k;
		do{
			out.print("\nEscolha o dia do prato na ementa:");
			out.print("\n1 - Segunda");
			out.print("\n2 - Terça");
			out.print("\n3 - Quarta");
			out.print("\n4 - Quinta");
			out.print("\n5 - Sexta");
			out.print("\n6 - Sábado");
			out.print("\n7 - Domingo");
			out.print("\nOpção ->");
			k=sc.nextInt();
			sc.nextLine();
		}while(k<1 || k>6);
		k--;
		e.addPrato(pr.get(n), Ementa.DiaSemana.enumDay(k));
		out.print("\nO prato foi adicionado à ementa.");
		
	}

	public static void remPrato(){
		int n;
		if(pr.size()<1){
			out.print("\nNão existem pratos atualmente!");
			return;
		}
		do{
			out.print("Escreva o número do prato que deseja remover:");
			System.out.print(listPrat());
			out.print("\nOpção -> ");
			n=sc.nextInt();
			sc.nextLine();
		}while(n<1 || n>pr.size());
		n--;
		int k;
		do{
			out.print("\nInsira o dia do prato na ementa:");
			out.print("\n1 - Segunda");
			out.print("\n2 - Terça");
			out.print("\n3 - Quarta");
			out.print("\n4 - Quinta");
			out.print("\n5 - Sexta");
			out.print("\n6 - Sábado");
			out.print("\n7 - Domingo");
			out.print("\nOpção ->");
			k=sc.nextInt();
			sc.nextLine();
		}while(k<1 || k>6);
		k--;
		
		e.remPrato(pr.get(n), k);
		
	}
	
	private static String listIng(){
		String ret="";
		for(int i=0;i<al.size();i++){
			ret+="\n"+(i+1)+" - "+al.get(i).toString();
		}
		return ret;
	}
	
	private static String listPrat(){
		String ret="";
		for(int i=0;i<pr.size();i++){
			ret+="\n"+(i+1)+" - "+pr.get(i).toString();
		}
		return ret;
	}
	
	public static void guardarEmenta(){
		String file;
		File f;
		out.print("\nEscreva o nome do ficheiro: ");
		file = sc.nextLine();
		f = new File(file);
		
		PrintWriter fwriter;
		try {
			fwriter = new PrintWriter(f);
			
			fwriter.println("Ingredientes");
			int i=0;
			for(Alimento a: al){
				fwriter.print(i+"#"+a.getClass().getSimpleName()+"#"+a.getCalorias()+"#"+a.getPeso()+"#"+a.getProteinas());
				if(a instanceof Carne){
					fwriter.println("#"+((Carne)a).getVariedade().ordinal()+"#");
				}
				if(a instanceof Peixe){
					fwriter.println("#"+((Peixe)a).getTipoPeixe().ordinal()+"#");
				}
				if(a instanceof Cereal){
					fwriter.println("#"+((Cereal)a).getNome()+"#");
				}
				if(a instanceof Legume){
					fwriter.println("#"+((Legume)a).getNome()+"#");
				}
				i++;
			}
			
			i=0;
			fwriter.println();
			fwriter.println("Pratos");
			for(Prato p: pr){
				if(p instanceof PratoDieta){
					p = (PratoDieta)p;
					fwriter.println("p"+i+"#PratoDieta#"+((PratoDieta) p).getLimCal()+"#"+((PratoDieta) p).getNome()+"#");
					int j=0;
					for(Alimento a: p.getAlimentos()){
						fwriter.print(j+"#"+a.getClass().getSimpleName()+"#"+a.getCalorias()+"#"+a.getPeso()+"#"+a.getProteinas());
						if(a instanceof Carne){
							fwriter.println("#"+((Carne)a).getVariedade().ordinal()+"#");
						}
						if(a instanceof Peixe){
							fwriter.println("#"+((Peixe)a).getTipoPeixe().ordinal()+"#");
						}
						if(a instanceof Cereal){
							fwriter.println("#"+((Cereal)a).getNome()+"#");
						}
						if(a instanceof Legume){
							fwriter.println("#"+((Legume)a).getNome()+"#");
						}
						j++;
					}
				}
				else if(p instanceof PratoVegetariano){
					p = (PratoVegetariano)p;
					fwriter.println("p"+i+"#PratoVegetariano#"+((PratoVegetariano) p).getNome()+"#");
					int j=0;
					for(Alimento a: p.getAlimentos()){
						fwriter.print(j+"#"+a.getClass().getSimpleName()+"#"+a.getCalorias()+"#"+a.getPeso()+"#"+a.getProteinas());
						if(a instanceof Carne){
							fwriter.println("#"+((Carne)a).getVariedade().ordinal()+"#");
						}
						if(a instanceof Peixe){
							fwriter.println("#"+((Peixe)a).getTipoPeixe().ordinal()+"#");
						}
						if(a instanceof Cereal){
							fwriter.println("#"+((Cereal)a).getNome()+"#");
						}
						if(a instanceof Legume){
							fwriter.println("#"+((Legume)a).getNome()+"#");
						}
						j++;
					}
				}
				else{
					fwriter.println("p"+i+"#PratoNormal#"+p.getNome()+"#");
					int j=0;
					for(Alimento a: p.getAlimentos()){
						fwriter.print(j+"#"+a.getClass().getSimpleName()+"#"+a.getCalorias()+"#"+a.getPeso()+"#"+a.getProteinas());
						if(a instanceof Carne){
							fwriter.println("#"+((Carne)a).getVariedade().ordinal()+"#");
						}
						if(a instanceof Peixe){
							fwriter.println("#"+((Peixe)a).getTipoPeixe().ordinal()+"#");
						}
						if(a instanceof Cereal){
							fwriter.println("#"+((Cereal)a).getNome()+"#");
						}
						if(a instanceof Legume){
							fwriter.println("#"+((Legume)a).getNome()+"#");
						}
						j++;
					}
				}
				i++;
			}
			fwriter.println();
			fwriter.println("Ementa");
			for(int k=0;k<7;k++){
				fwriter.println("d"+k);
				i=0;
				fwriter.println("Pratos");
				for(Prato p: e.getPratPorDia(k)){
					if(p instanceof PratoDieta){
						p = (PratoDieta)p;
						fwriter.println("p"+i+"#PratoDieta#"+((PratoDieta) p).getLimCal()+"#"+((PratoDieta) p).getNome()+"#");
						int j=0;
						for(Alimento a: p.getAlimentos()){
							fwriter.print(j+"#"+a.getClass().getSimpleName()+"#"+a.getCalorias()+"#"+a.getPeso()+"#"+a.getProteinas());
							if(a instanceof Carne){
								fwriter.println("#"+((Carne)a).getVariedade().ordinal()+"#");
							}
							if(a instanceof Peixe){
								fwriter.println("#"+((Peixe)a).getTipoPeixe().ordinal()+"#");
							}
							if(a instanceof Cereal){
								fwriter.println("#"+((Cereal)a).getNome()+"#");
							}
							if(a instanceof Legume){
								fwriter.println("#"+((Legume)a).getNome()+"#");
							}
							j++;
						}
					}
					else if(p instanceof PratoVegetariano){
						p = (PratoVegetariano)p;
						fwriter.println("p"+i+"#PratoVegetariano#"+((PratoVegetariano) p).getNome()+"#");
						int j=0;
						for(Alimento a: p.getAlimentos()){
							fwriter.print(j+"#"+a.getClass().getSimpleName()+"#"+a.getCalorias()+"#"+a.getPeso()+"#"+a.getProteinas());
							if(a instanceof Carne){
								fwriter.println("#"+((Carne)a).getVariedade().ordinal()+"#");
							}
							if(a instanceof Peixe){
								fwriter.println("#"+((Peixe)a).getTipoPeixe().ordinal()+"#");
							}
							if(a instanceof Cereal){
								fwriter.println("#"+((Cereal)a).getNome()+"#");
							}
							if(a instanceof Legume){
								fwriter.println("#"+((Legume)a).getNome()+"#");
							}
							j++;
						}
					}
					else{
						fwriter.println("p"+i+"#PratoNormal#"+p.getNome()+"#");
						int j=0;
						for(Alimento a: p.getAlimentos()){
							fwriter.print(j+"#"+a.getClass().getSimpleName()+"#"+a.getCalorias()+"#"+a.getPeso()+"#"+a.getProteinas());
							if(a instanceof Carne){
								fwriter.println("#"+((Carne)a).getVariedade().ordinal()+"#");
							}
							if(a instanceof Peixe){
								fwriter.println("#"+((Peixe)a).getTipoPeixe().ordinal()+"#");
							}
							if(a instanceof Cereal){
								fwriter.println("#"+((Cereal)a).getNome()+"#");
							}
							if(a instanceof Legume){
								fwriter.println("#"+((Legume)a).getNome()+"#");
							}
							j++;
						}
					}
					i++;
				}
			}

			fwriter.close();
		} catch (FileNotFoundException e) {
			System.exit(1);
		}
		
		
	}
	
	public static void carregarEmenta(){
		String file;
		File f;
		do{
			out.print("\nEscreva o nome do ficheiro: ");
			file = sc.nextLine();
			f = new File(file);
		}while(!f.exists() || f.isDirectory() || !f.canRead());
		
		try{
			Scanner fread = new Scanner (f);
			
			String line=fread.nextLine();
			String ing="";
			int i=0;
			line = fread.nextLine();
			while(!line.equals("")){
				i++;
				ing+=line;
				line=fread.nextLine();
			}
			
			// Adiciona alimentos
			al = new ArrayList<Alimento>();
			String[]a = ing.split("#");
			i=0;
			for(int j=0;j<a.length;j+=5){
				j++;
				if(a[j].equals("Carne")){
					al.add(new Carne(Carne.VariedadeCarne.getVar(Integer.parseInt(a[j+4])) , Double.parseDouble(a[j+1]), Double.parseDouble(a[j+2]),Double.parseDouble(a[j+3])));
				}
				else if(a[j].equals("Peixe")){
					al.add(new Peixe(Peixe.TipoPeixe.getTipo(Integer.parseInt(a[j+4])) , Double.parseDouble(a[j+1]), Double.parseDouble(a[j+2]),Double.parseDouble(a[j+3])));
				}
				else if(a[j].equals("Legume")){
					al.add(new Legume(a[j+4] , Double.parseDouble(a[j+1]), Double.parseDouble(a[j+2]),Double.parseDouble(a[j+3])));
				}
				else{
					al.add(new Cereal(a[j+4] , Double.parseDouble(a[j+1]), Double.parseDouble(a[j+2]),Double.parseDouble(a[j+3])));
				}
					
			}
			
			// Adiciona pratos
			line = fread.nextLine();
			line = fread.nextLine();
			String pratos = "";
			int p = 0;
			while(!line.equals("")){
				pratos += line;
				if(line.charAt(0)=='p') p++;
				line = fread.nextLine();
			}
			
			pr = new ArrayList<Prato>();
			String[] pdiv = pratos.split("#");
			int b=1;
			int k=0;
			while(b<pdiv.length){
				if(pdiv[b].equals("PratoNormal")){
					b++;
					pr.add(new Prato(pdiv[b++]));
					k++;
					while(b<pdiv.length && pdiv[b].charAt(0)!='p'){
						b++;
						if(pdiv[b].equals("Carne")){
							pr.get(k-1).addAl(new Carne(Carne.VariedadeCarne.getVar(Integer.parseInt(pdiv[b+4])) , Double.parseDouble(pdiv[b+1]), Double.parseDouble(pdiv[b+2]),Double.parseDouble(pdiv[b+3])));
						}
						else if(pdiv[b].equals("Peixe")){
							pr.get(k-1).addAl(new Peixe(Peixe.TipoPeixe.getTipo(Integer.parseInt(pdiv[b+4])) , Double.parseDouble(pdiv[b+1]), Double.parseDouble(pdiv[b+2]),Double.parseDouble(pdiv[b+3])));
						}
						else if(pdiv[b].equals("Legume")){
							pr.get(k-1).addAl(new Legume(pdiv[b+4] , Double.parseDouble(pdiv[b+1]), Double.parseDouble(pdiv[b+2]),Double.parseDouble(pdiv[b+3])));
						}
						else{
							pr.get(k-1).addAl(new Cereal(pdiv[b+4] , Double.parseDouble(pdiv[b+1]), Double.parseDouble(pdiv[b+2]),Double.parseDouble(pdiv[b+3])));
						}
						b+=5;
					}
					b++;
				}
				else if(pdiv[b].equals("PratoVegetariano")){
					b++;
					pr.add(new PratoVegetariano(pdiv[b++]));
					k++;
					while(b<pdiv.length && pdiv[b].charAt(0)!='p'){
						b++;
						if(pdiv[b].equals("Carne")){
							pr.get(k-1).addAl(new Carne(Carne.VariedadeCarne.getVar(Integer.parseInt(pdiv[b+4])) , Double.parseDouble(pdiv[b+1]), Double.parseDouble(pdiv[b+2]),Double.parseDouble(pdiv[b+3])));
						}
						else if(pdiv[b].equals("Peixe")){
							pr.get(k-1).addAl(new Peixe(Peixe.TipoPeixe.getTipo(Integer.parseInt(pdiv[b+4])) , Double.parseDouble(pdiv[b+1]), Double.parseDouble(pdiv[b+2]),Double.parseDouble(pdiv[b+3])));
						}
						else if(pdiv[b].equals("Legume")){
							pr.get(k-1).addAl(new Legume(pdiv[b+4] , Double.parseDouble(pdiv[b+1]), Double.parseDouble(pdiv[b+2]),Double.parseDouble(pdiv[b+3])));
						}
						else{
							pr.get(k-1).addAl(new Cereal(pdiv[b+4] , Double.parseDouble(pdiv[b+1]), Double.parseDouble(pdiv[b+2]),Double.parseDouble(pdiv[b+3])));
						}
						b+=5;
					}
					b++;
				}
				else{
					b++;
					pr.add(new PratoDieta(pdiv[b+1] ,Double.parseDouble(pdiv[b++])));
					k++;
					b++;
					while(b<pdiv.length && pdiv[b].charAt(0)!='p'){
						b++;
						if(pdiv[b].equals("Carne")){
							pr.get(k-1).addAl(new Carne(Carne.VariedadeCarne.getVar(Integer.parseInt(pdiv[b+4])) , Double.parseDouble(pdiv[b+1]), Double.parseDouble(pdiv[b+2]),Double.parseDouble(pdiv[b+3])));
						}
						else if(pdiv[b].equals("Peixe")){
							pr.get(k-1).addAl(new Peixe(Peixe.TipoPeixe.getTipo(Integer.parseInt(pdiv[b+4])) , Double.parseDouble(pdiv[b+1]), Double.parseDouble(pdiv[b+2]),Double.parseDouble(pdiv[b+3])));
						}
						else if(pdiv[b].equals("Legume")){
							pr.get(k-1).addAl(new Legume(pdiv[b+4] , Double.parseDouble(pdiv[b+1]), Double.parseDouble(pdiv[b+2]),Double.parseDouble(pdiv[b+3])));
						}
						else{
							pr.get(k-1).addAl(new Cereal(pdiv[b+4] , Double.parseDouble(pdiv[b+1]), Double.parseDouble(pdiv[b+2]),Double.parseDouble(pdiv[b+3])));
						}
						b+=5;
					}
					b++;
				}
				
			}
			e = new Ementa("Ementa");
			fread.nextLine(); //"Ementa"
			for(int d=0;d<7;d++){

				line = fread.nextLine(); //"dia"
				if(!line.equals("Pratos"))
					line = fread.nextLine(); //"Prato"
				if(!fread.hasNextLine())
					break;
				line = fread.nextLine();
				while(line.charAt(0)=='p'){
					pdiv = line.split("#");
					if(pdiv[1].equals("PratoNormal")){
						Prato pra = new Prato(pdiv[2]);
						line = fread.nextLine();
						pdiv = line.split("#");
						while(pdiv[0].charAt(0)!='p' && pdiv[0].charAt(0)!='d'){
							if(pdiv[1].equals("Carne")){
								pra.addAl(new Carne(Carne.VariedadeCarne.getVar(Integer.parseInt(pdiv[5])) , Double.parseDouble(pdiv[2]), Double.parseDouble(pdiv[3]),Double.parseDouble(pdiv[4])));
							}
							else if(pdiv[1].equals("Peixe")){
								pra.addAl(new Peixe(Peixe.TipoPeixe.getTipo(Integer.parseInt(pdiv[5])) , Double.parseDouble(pdiv[2]), Double.parseDouble(pdiv[3]),Double.parseDouble(pdiv[4])));
							}
							else if(pdiv[1].equals("Legume")){
								pra.addAl(new Legume(pdiv[5] , Double.parseDouble(pdiv[2]), Double.parseDouble(pdiv[3]),Double.parseDouble(pdiv[4])));
							}
							else{
								pra.addAl(new Cereal(pdiv[5] , Double.parseDouble(pdiv[2]), Double.parseDouble(pdiv[3]),Double.parseDouble(pdiv[4])));
							}
							line = fread.nextLine();
							pdiv = line.split("#");
						}
						e.addPrato(pra, Ementa.DiaSemana.enumDay(d));
					}
					else if(pdiv[1].equals("PratoVegetariano")){
						Prato pra = new PratoVegetariano(pdiv[2]);
						line = fread.nextLine();
						pdiv = line.split("#");
						while(pdiv[0].charAt(0)!='p' && pdiv[0].charAt(0)!='d'){
							if(pdiv[1].equals("Carne")){
								pra.addAl(new Carne(Carne.VariedadeCarne.getVar(Integer.parseInt(pdiv[5])) , Double.parseDouble(pdiv[2]), Double.parseDouble(pdiv[3]),Double.parseDouble(pdiv[4])));
							}
							else if(pdiv[1].equals("Peixe")){
								pra.addAl(new Peixe(Peixe.TipoPeixe.getTipo(Integer.parseInt(pdiv[5])) , Double.parseDouble(pdiv[2]), Double.parseDouble(pdiv[3]),Double.parseDouble(pdiv[4])));
							}
							else if(pdiv[1].equals("Legume")){
								pra.addAl(new Legume(pdiv[5] , Double.parseDouble(pdiv[2]), Double.parseDouble(pdiv[3]),Double.parseDouble(pdiv[4])));
							}
							else{
								pra.addAl(new Cereal(pdiv[5] , Double.parseDouble(pdiv[2]), Double.parseDouble(pdiv[3]),Double.parseDouble(pdiv[4])));
							}
							line = fread.nextLine();
							pdiv = line.split("#");
						}
						e.addPrato(pra, Ementa.DiaSemana.enumDay(d));
					}
					else{
						Prato pra = new PratoDieta(pdiv[1] ,Double.parseDouble(pdiv[2]));
						line = fread.nextLine();
						pdiv = line.split("#");
						while(pdiv[0].charAt(0)!='p' && pdiv[0].charAt(0)!='d'){
							if(pdiv[1].equals("Carne")){
								pra.addAl(new Carne(Carne.VariedadeCarne.getVar(Integer.parseInt(pdiv[5])) , Double.parseDouble(pdiv[2]), Double.parseDouble(pdiv[3]),Double.parseDouble(pdiv[4])));
							}
							else if(pdiv[1].equals("Peixe")){
								pra.addAl(new Peixe(Peixe.TipoPeixe.getTipo(Integer.parseInt(pdiv[5])) , Double.parseDouble(pdiv[2]), Double.parseDouble(pdiv[3]),Double.parseDouble(pdiv[4])));
							}
							else if(pdiv[1].equals("Legume")){
								pra.addAl(new Legume(pdiv[5] , Double.parseDouble(pdiv[2]), Double.parseDouble(pdiv[3]),Double.parseDouble(pdiv[4])));
							}
							else{
								pra.addAl(new Cereal(pdiv[5] , Double.parseDouble(pdiv[2]), Double.parseDouble(pdiv[3]),Double.parseDouble(pdiv[4])));
							}
							line = fread.nextLine();
							pdiv = line.split("#");
						}
						e.addPrato(pra, Ementa.DiaSemana.enumDay(d));
					}
				}
			}
			
			fread.close();
		}
		catch(FileNotFoundException e){
			err.println("\nFicheiro não encontrado!");
			return;
		}
		
		
	}
	

}
