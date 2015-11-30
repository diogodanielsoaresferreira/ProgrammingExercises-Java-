/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula8;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Ex2 extends JFrame {
	
	
	private static final long serialVersionUID = 1L;

	public Ex2() throws FileNotFoundException{
		super("Quem Quer Ser Milionário");
		
		QuemQuerSerMilionario jogo = new QuemQuerSerMilionario();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,600);
		JPanel content = new JPanel();
		content.setLayout(null);
		
		JTextArea money = new JTextArea();
		money.setBackground(content.getBackground());
		money.setFont(new Font("Arial", Font.PLAIN, 20));
		money.setBounds(900, 20, 100, 50);
		money.setEditable(false);
		
		JLabel image = new JLabel();
		image.setBounds(10, 5, 500, 390);
		
		JTextArea question = new JTextArea();
		question.setBackground(content.getBackground());
		question.setBounds(600, 90, 300, 300);
		question.setFont(new Font("Arial", Font.PLAIN, 30));
		question.setEditable(false);
		question.setWrapStyleWord(true);
		question.setLineWrap(true);
		
		JButton publico = new JButton("Ajuda público");
		publico.setBounds(10, 400, 150, 50);
		
		
		JButton telefone = new JButton("Telefone...");
		telefone.setBounds(190, 400, 150, 50);
		
		
		JButton cinquenta = new JButton("50 - 50");
		cinquenta.setBounds(370, 400, 150, 50);
		
		
		JButton desistir = new JButton("Desistir");
		desistir.setBounds(630, 500, 150, 50);
		desistir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getContentPane(), "Ganhou "+String.valueOf(jogo.getMoney())+"€!");
				System.exit(0);
			}
			
		});
		
		ButtonGroup perguntas = new ButtonGroup();
		
		JRadioButton p1=new JRadioButton();
		JRadioButton p2=new JRadioButton();
		JRadioButton p3=new JRadioButton();
		JRadioButton p4=new JRadioButton();

		perguntas.add(p1);
		perguntas.add(p2);
		perguntas.add(p3);
		perguntas.add(p4);
		
		JButton confirmar = new JButton("Confirmar");
		confirmar.setBounds(800, 500, 150, 50);
		confirmar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				jogo.play(getContentPane(), money, image, question, p1, p2, p3, p4);
				perguntas.clearSelection();
				p1.setEnabled(true);
				p2.setEnabled(true);
				p3.setEnabled(true);
				p4.setEnabled(true);
				jogo.getQuestion(money, image, question, p1, p2, p3, p4);
			}
			
		});
		
		cinquenta.addActionListener(e ->
			jogo.cinquentacinquenta(cinquenta, p1,p2,p3,p4)
		);
		
		publico.addActionListener(e ->
			jogo.ajudaPublico(getContentPane(), publico, p1,p2,p3,p4)
		);
		
		telefone.addActionListener(e ->
			jogo.telefone(getContentPane(), telefone, p1,p2,p3,p4)
		);
		
		p1.setBounds(30,450,200,50);
		p2.setBounds(30,500,200,50);
		p3.setBounds(300,450,200,50);
		p4.setBounds(300,500,200,50);
		
		content.add(money);
		content.add(image);
		content.add(question);
		content.add(publico);
		content.add(telefone);
		content.add(cinquenta);
		content.add(p1);
		content.add(p2);
		content.add(p3);
		content.add(p4);
		content.add(desistir);
		content.add(confirmar);
		jogo.getQuestion(money, image, question, p1, p2, p3, p4);
		add(content);
		setVisible(true);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		new Ex2();
		
	}


}
