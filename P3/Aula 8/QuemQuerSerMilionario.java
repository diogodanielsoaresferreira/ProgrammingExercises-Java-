/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula8;

import java.awt.Container;
import java.io.*;
import java.util.*;
import javax.swing.*;



public class QuemQuerSerMilionario {

	ArrayList<String> facil = new ArrayList<String>();
	ArrayList<String> medio = new ArrayList<String>();
	ArrayList<String> dificil = new ArrayList<String>();
	Premio atual=Premio.VINTE_CINCO;
	JToggleButton certo;
	
	QuemQuerSerMilionario() throws FileNotFoundException{
		File file = new File("F:\\Universidade\\2º ano\\1º Semestre\\Programação III\\Práticas\\Aula 8\\QQSM\\betterquestions.txt");
		Scanner readf = new Scanner(file);
		
		while(readf.hasNextLine()){
			String line = readf.nextLine();
			if(line.split("&&")[6].equals("0"))
				facil.add(line);
			else if(line.split("&&")[6].equals("1"))
				medio.add(line);
			else if(line.split("&&")[6].equals("2"))
				dificil.add(line);
			else{
				System.err.println("Erro ao ler perguntas.");
				System.exit(1);
			}
			
		}
		
		readf.close();
	}
	
	public void getQuestion(JTextArea money, JLabel image, JTextArea question, JRadioButton p1, JRadioButton p2, JRadioButton p3, JRadioButton p4){
		String q;
		int rand;
		
		if(chooseDif()==0){
			rand=getRanToN(facil.size());
			q = facil.get(rand);
		}
		else if(chooseDif()==1){
			rand=getRanToN(medio.size());
			q = medio.get(rand);
		}
		else{
			rand=getRanToN(dificil.size());
			q = dificil.get(rand);
		}
		
		money.setText(String.valueOf(getMoney())+"€");
		image.setIcon(new ImageIcon("F:\\Universidade\\2º ano\\1º Semestre\\Programação III\\Práticas\\Aula 8\\QQSM\\"+q.split("&&")[0]));
		question.setText(q.split("&&")[1]);
		
		int[] arr = ranArrayn(4);
		p1.setText(q.split("&&")[arr[0]+2]);
		p2.setText(q.split("&&")[arr[1]+2]);
		p3.setText(q.split("&&")[arr[2]+2]);
		p4.setText(q.split("&&")[arr[3]+2]);
		int j=0;
		for(int i=0;i<4;i++){
			if(arr[i]==0) j=i;
		}
		
		switch(j){
			case 0:
				certo=p1;
				break;
			case 1:
				certo=p2;
				break;
			case 2:
				certo=p3;
				break;
			case 3:
				certo=p4;
				break;
		}
		
		if(chooseDif()==0){
			facil.remove(rand);
		}
		else if(chooseDif()==1){
			medio.remove(rand);
		}
		else{
			dificil.remove(rand);
		}
	}
	
	public void play( Container contentPane, JTextArea money, JLabel image, JTextArea question, JToggleButton p1, JToggleButton p2, JToggleButton p3, JToggleButton p4){
		
		JToggleButton selected=null;
		
		if(p1.isSelected())
			selected=p1;
		else if(p2.isSelected())
			selected=p2;
		else if(p3.isSelected())
			selected=p3;
		else if(p4.isSelected())
			selected=p4;
		
		if(selected==null || selected!=certo || atual.getNum()==250000){
			JOptionPane.showMessageDialog(contentPane, "Ganhou "+String.valueOf(getMoney())+"€!");
			System.exit(0);
		}
		
		atual=Premio.next(atual);
	}
	
	public int getMoney(){
		return atual.getNum();
	}

	public void cinquentacinquenta(JButton c, JToggleButton p1, JToggleButton p2, JToggleButton p3, JToggleButton p4){
		int except;
		if(certo==p1)
			except=0;
		else if(certo==p2)
			except=1;
		else if(certo==p3)
			except=2;
		else
			except=3;
		
		int[] ran = ranArrayn(4);
		
		int j=0;
		for(int i=0;i<3;i++){
			if(ran[i]==0 && except!=0){
				p1.setEnabled(false);
				j++;
			}
			else if(ran[i]==1 && except!=1){
				p2.setEnabled(false);
				j++;
			}
			else if(ran[i]==2 && except!=2){
				p3.setEnabled(false);
				j++;
			}
			else if(ran[i]==3 && except!=3){
				p4.setEnabled(false);
				j++;
			}
			
			if(j==2) break;
		}
		c.setEnabled(false);
	}

	public void ajudaPublico(Container c, JButton publico, JToggleButton p1, JToggleButton p2, JToggleButton p3, JToggleButton p4){
		// Dificuldade de 0 a 2
		int dif = chooseDif();
		int max=(int)(Math.random()*100);
		int per=0;
		for(int i=0;i<(3-dif)*2;i++){
			per =(int)(Math.random()*100);
			if(per>max)
				max=per;
		}
		
		JToggleButton errado1=new JToggleButton();
		JToggleButton errado2=new JToggleButton();
		JToggleButton errado3=new JToggleButton();
		
		if(certo==p1){
			errado2=p2;
			errado3=p3;
			errado1=p4;
		}
		if(certo==p2){
			errado2=p4;
			errado3=p3;
			errado1=p1;
		}
		if(certo==p3){
			errado2=p2;
			errado3=p1;
			errado1=p4;
		}
		if(certo==p4){
			errado2=p2;
			errado3=p3;
			errado1=p1;
		}
		
		int pr2=(100-max)/6;
		int pr3=2*(100-max)/6;
		int pr4=3*(100-max)/6;
		
		String s="Votação do público:\n";
		
		int rand[] = ranArrayn(4);
		
		for(int i=0;i<4;i++){
			if(rand[i]==0){
				s+=certo.getText()+": "+max+"%\n";
			}
			else if(rand[i]==1)
				s+=errado2.getText()+": "+(pr2+1)+"%\n";
			else if(rand[i]==2)
				s+=errado3.getText()+": "+pr3+"%\n";
			else 
				s+=errado1.getText()+": "+pr4+"%\n";
		}
		
		JOptionPane.showMessageDialog(c, s);
				
		publico.setEnabled(false);
		
	}
	
	public void telefone(Container content, JButton telefone, JToggleButton p1, JToggleButton p2, JToggleButton p3, JToggleButton p4){
		// Dificuldade de 0 a 2
		int dif = chooseDif();
		int botao1=-1;
		JToggleButton errado=null;
		
		if(certo==p1)
			botao1=0;
		else if(certo==p2)
			botao1=1;
		else if(certo==p3)
			botao1=2;
		else
			botao1=3;
		
		int randbotao=getRanToN(4);
		
		while(randbotao==botao1)
			randbotao=getRanToN(4);
		
		switch(randbotao){
			case 0:
				errado=p1;
				break;
			case 1:
				errado=p2;
				break;
			case 2:
				errado=p3;
				break;
			case 3:
				errado=p4;
				break;
		}
		
		int pererrada;
		int percerta;
		pererrada=(int)(((Math.random())/(3-dif))*100);
		percerta=100-pererrada;
		
		if(percerta>pererrada)
			JOptionPane.showMessageDialog(content, "O que eu acho:\n"+certo.getText()+": "+percerta+"%\n"+errado.getText()+": "+pererrada+"%");
		else
			JOptionPane.showMessageDialog(content, "O que eu acho:\n"+errado.getText()+": "+pererrada+"%\n"+certo.getText()+": "+percerta+"%");
		
		telefone.setEnabled(false);
	}
	
	private int chooseDif(){
		if (atual.getNum()<=500)
			return 0;
		else if(atual.getNum()<=10000)
			return 1;
		else
			return 2;
	}
	
	private int getRanToN(int n){
		return (int) (Math.random()*n);
	}

	private int[] ranArrayn(int n){
		int[] arr = new int[n];
		int i=0;
		while(i!=n){
			int ran = getRanToN(n);
			boolean exists=false;
			for(int j=i-1;j>=0;j--){
				if(ran==arr[j]) exists = true;
			}
			if(!exists){
				arr[i]=ran;
				i++;
			}
			
		}
		return arr;
	}
	
}
