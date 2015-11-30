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

public class ConCSV implements ReadWriteCont {

	private String file;
	
	public ConCSV(String file){
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
			if (!formatname.equals("CSV")) throw new FileNotFoundException();
			while (sc.hasNextLine()){
				String line = sc.nextLine();
				System.out.println(line);
				String spl[]=line.split("\t");
				String name = spl[0];
				String s = spl[1];
				int cc = Integer.parseInt(s);
				s = spl[2];
				String sp[] = s.split("/");
				Data date = new Data(Integer.parseInt(sp[0]),Integer.parseInt(sp[1]),Integer.parseInt(sp[2]));
				d.addAluno(new Estudante(name,cc,date));
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
			pw.println("CSV");
			for(Estudante al: d.getAlunos()){
				pw.print(al.getName()+"\t");
				pw.print(al.getCC()+"\t");
				pw.println(al.getDate().getDay()+"/"+al.getDate().getMonth()+"/"+al.getDate().getYear());
				pw.print("\n");
			}
			
			pw.close();
		} 
		
		catch (FileNotFoundException e) {
			System.out.println("Erro na escrita do ficheiro.");
			System.exit(1);
		}
	}
	
}
