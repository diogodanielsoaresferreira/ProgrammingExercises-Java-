/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConVCard implements ReadWriteCont {
	
	private String file;
	
	public ConVCard(String file){
		if (!ReadWriteCont.checkFile(file)){
			System.exit(1);
		}
		this.file=file;
	}
	
	
	@Override
	public void readCont(Disciplina d){
		try {
			File a = new File(file);
			Scanner sc = new Scanner(a);
			String formatname = sc.nextLine();
			if (!formatname.equals("vCard")) throw new FileNotFoundException();
			while (sc.hasNextLine()){
				String line = sc.nextLine();
				String spl[]=line.split("#");
				int cc = Integer.parseInt(spl[2]);
				String spldate[] = spl[3].split("/");
				Data date = new Data(Integer.parseInt(spldate[0]),Integer.parseInt(spldate[1]),Integer.parseInt(spldate[2]));
				d.addAluno(new Estudante(spl[1],cc,date));

			}

			sc.close();
			
		} catch (FileNotFoundException|ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro na leitura do ficheiro.");
			System.exit(1);
		}
	}
	
	@Override
	public void writeCont(Disciplina d){
		try {
			File a = new File(file);
			PrintWriter pw = new PrintWriter(a);
			pw.println("VCard");
			for(Estudante al: d.getAlunos()){
				pw.print("#"+al.getName()+"#");
				pw.print(al.getCC()+"#");
				pw.print(al.getDate().getDay()+"/"+al.getDate().getMonth()+"/"+al.getDate().getYear());
				pw.println("\n");
			}
			
			pw.close();
		} 
		
		catch (FileNotFoundException e) {
			System.out.println("Erro na escrita do ficheiro.");
			System.exit(1);
		}
	}
}
