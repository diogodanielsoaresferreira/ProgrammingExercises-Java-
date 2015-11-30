package aula5;

import java.io.*;
import java.util.*;

public class ConNokia implements ReadWriteCont {
	
	private String file;
	
	public ConNokia(String file){
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
			if (!formatname.equals("Nokia")) throw new FileNotFoundException();
			while (sc.hasNextLine()){
				String name = sc.nextLine();
				String s = sc.nextLine();
				int cc = Integer.parseInt(s);
				s = sc.nextLine();
				String sp[] = s.split("/");
				Data date = new Data(Integer.parseInt(sp[0]),Integer.parseInt(sp[1]),Integer.parseInt(sp[2]));
				d.addAluno(new Estudante(name,cc,date));
				if(sc.hasNextLine())
					sc.nextLine();

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
			pw.println("Nokia");
			for(Estudante al: d.getAlunos()){
				pw.println(al.getName());
				pw.println(al.getCC());
				pw.println(al.getDate().getDay()+"/"+al.getDate().getMonth()+"/"+al.getDate().getYear());
				pw.println();
			}
			
			pw.close();
		} 
		
		catch (FileNotFoundException e) {
			System.out.println("Erro na escrita do ficheiro.");
			System.exit(1);
		}
	}
	
}
