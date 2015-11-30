/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex1 extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JogoDoGalo jogo;
	JToggleButton[] but;
	
	public Ex1(String args[]){
		super("Jogo do Galo");
		jogo=JogoDoGalo.newJogoDoGalo(args[0].toCharArray()[0]);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		JPanel content = new JPanel();
		content.setBackground(Color.LIGHT_GRAY);
		content.setLayout(new GridLayout(3,3));
		content.setOpaque(true);
		but = new JToggleButton[9];
		for(int i=0;i<9;i++){
			but[i]=new JToggleButton();
			but[i].addActionListener(this);
			content.add(but[i]);
		}
		setContentPane(content);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Ex1(new String[]{"X"});
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int x,y;
		x=((JToggleButton)e.getSource()).getX();
		y=((JToggleButton)e.getSource()).getY();
		
		for(int i=0;i<but.length;i++){
			if(e.getSource()==but[i]){
				switch (i){
					case 0:
						x=0;
						y=0;
						break;
					case 1:
						x=0;
						y=1;
						break;
					case 2:
						x=0;
						y=2;
						break;
					case 3:
						x=1;
						y=0;
						break;
					case 4:
						x=1;
						y=1;
						break;
					case 5:
						x=1;
						y=2;
						break;
					case 6:
						x=2;
						y=0;
						break;
					case 7:
						x=2;
						y=1;
						break;
					case 8:
						x=2;
						y=2;
						break;
				}
				break;
			}
		}
		
		int n= jogo.jogada(x, y);
		((JToggleButton) e.getSource()).setText(String.valueOf(jogo.getChar(x, y)));
		((JToggleButton) e.getSource()).setFont(new Font("Arial", Font.PLAIN, 50));
		((JToggleButton) e.getSource()).setVerticalTextPosition(SwingConstants.CENTER);
		((JToggleButton) e.getSource()).setHorizontalTextPosition(SwingConstants.CENTER);
		((JToggleButton) e.getSource()).setEnabled(false);
		
		if(n==2){
			JOptionPane.showMessageDialog(this.getContentPane(),"Houve um empate!");
			System.exit(0);
		}
		else if(n==1){
			JOptionPane.showMessageDialog(this.getContentPane(),"Venceu o jogador 1!");
			System.exit(0);
		}
		else if(n==0){
			JOptionPane.showMessageDialog(this.getContentPane(),"Venceu o jogador 2!");
			System.exit(0);
		}
	}

}