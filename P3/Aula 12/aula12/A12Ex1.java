/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula12;

import java.lang.reflect.*;
import java.util.*;
import java.lang.System;

public class A12Ex1 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		
		List<Object> obj = new ArrayList<>();
		
		Class<?> c = Class.forName("aula11.Prato");
		System.out.println("Nome: "+c.getSimpleName());
		for(Class<?> cl : c.getInterfaces()){
			System.out.println("Interface: "+cl.getSimpleName());
		}
		System.out.println("Superclasse: "+c.getSuperclass());
		for(Constructor<?> cl : c.getConstructors()){
			System.out.println("Construtor: "+cl.getName());
		}
		for(Method cl : c.getMethods()){
			System.out.println("Métodos: "+cl.getName());
		}
		for(Field cl : c.getFields()){
			System.out.println("Atributos públicos: "+cl.getName());
		}
		for(Field cl : c.getDeclaredFields()){
			System.out.println("Atributos privados: "+cl.getName());
		}
		int s;
		boolean end=false;
		do{
			do{
				System.out.println("Qual o construtor que queres utilizar?");
				int i=1;
				for(Constructor<?> cl : c.getConstructors()){
					System.out.println("Construtor "+i+++": "+cl.getName());
				}
				System.out.println("Sair ("+i+")");
				System.out.print("Escolha -> ");
				s = sc.nextInt();
				sc.nextLine();
				if(s==i)
					end=true;
			}while(s<1 || s>c.getConstructors().length+1);
			if(!end){
				Constructor <?> c1 = c.getConstructors()[s-1];
				Class <?>[] paramT=c1.getParameterTypes();
				
				Object []arg=new Object[paramT.length];
				for(int i=0;i<arg.length;i++){
					System.out.print("Argumento "+(i+1)+": ");
					if(paramT[i].getSimpleName().equals("Integer")){
						arg[i]=sc.next();
						sc.nextLine();
					}
					else if(paramT[i].getSimpleName().equals("Double")){
						arg[i]=sc.nextDouble();
						sc.nextLine();
					}
					else if(paramT[i].getSimpleName().equals("String")){
						arg[i]=sc.nextLine();
					}
					else if(paramT[i].getSimpleName().equals("Boolean")){
						arg[i]=sc.nextBoolean();
						sc.nextLine();
					}
					else if(paramT[i].getSimpleName().equals("Short")){
						arg[i]=sc.nextShort();
						sc.nextLine();
					}
					else
						throw new Exception();
				}
				
				Object ins = c1.newInstance(arg);
				obj.add(ins);
			}
		}while(!end);
		obj.forEach(System.out::println);
		end=false;
		do{
			do{
				System.out.println("\n\nEscolha um objeto criado: ");
				Iterator<Object> itOb=obj.iterator();
				int i=1;
				while(itOb.hasNext()){
					System.out.println(String.valueOf(itOb.next())+" ("+i+")");
					i++;
				}
				System.out.println("Sair ("+i+")");
				System.out.println("Escolha -> ");
				s =sc.nextInt();
				sc.nextLine();
				if(s==i)
					end=true;
			}while(s<1 || s>1+obj.size());
			int s2;
			if(!end){
				System.out.println("\n\nEscolha um método: ");
				int i=1;
				for(Method m: c.getMethods()){
					System.out.println(m.getName()+" ("+i+")");
					i++;
				}
				System.out.println("Sair ("+i+")");
				System.out.println("Escolha -> ");
				s2 =sc.nextInt();
				sc.nextLine();
				
				Method m = c.getMethods()[s2-1];
				m.setAccessible(true);
				
				Class <?>[] paramT=m.getParameterTypes();
				Object []arg=new Object[paramT.length];
				for(i=0;i<arg.length;i++){
					System.out.print("Argumento "+(i+1)+": ");
					if(paramT[i].getSimpleName().equals("Integer")){
						arg[i]=sc.next();
						sc.nextLine();
					}
					else if(paramT[i].getSimpleName().equals("Double")){
						arg[i]=sc.nextDouble();
						sc.nextLine();
					}
					else if(paramT[i].getSimpleName().equals("String")){
						arg[i]=sc.nextLine();
					}
					else if(paramT[i].getSimpleName().equals("Boolean")){
						arg[i]=sc.nextBoolean();
						sc.nextLine();
					}
					else if(paramT[i].getSimpleName().equals("Short")){
						arg[i]=sc.nextShort();
						sc.nextLine();
					}
					else
						throw new Exception();
				}
				
				m.invoke(obj.get(s-1),arg);
			}
		}while(!end);
		
		
	}

}
