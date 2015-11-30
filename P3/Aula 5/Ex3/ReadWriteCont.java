/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula5;

import java.io.File;

public interface ReadWriteCont {
	
	public void readCont(Disciplina d);
	
	public void writeCont(Disciplina d);
	
	public static boolean checkFile(String file){
		File f=new File(file);
		return f.exists() && f.isFile() && f.canRead() && f.canWrite();
	}
	
}
