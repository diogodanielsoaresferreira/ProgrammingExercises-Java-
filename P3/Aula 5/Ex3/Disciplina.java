/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula5;

import java.util.Arrays;

public class Disciplina {

	private String nomeDisc;
	private String areaC;
	private int ects;
	private Professor responsavel;
	private Estudante[] alunos = new Estudante[0];
	
	Disciplina(String nomeDisc, String areaC, int ects, Professor responsavel){
		this.nomeDisc = nomeDisc;
		this.areaC = areaC;
		this.ects = ects;
		this.responsavel = responsavel;
	}
	
	public void setResponsavel(Professor p){
		responsavel = p;
	}
	
	public void setEcts(int ects){
		this.ects = ects;
	}
	
	public boolean addAluno(Estudante esc){
		Estudante[] c = new Estudante[alunos.length+1];
		
		if(alunoInscrito(esc.getNmec())) return false;
		
		for(int i=0;i<alunos.length;i++){
			c[i] = alunos[i];
		}
		
		c[alunos.length] = esc;
		alunos = c;
		return true;
	}
	
	public boolean delAluno(int nmec){
		if(!alunoInscrito(nmec)) return false;
		
		Estudante[] c = new Estudante[alunos.length-1];
		int j=0;
		for(int i=0;i<alunos.length;i++){
			if(!(alunos[i].getNmec()==nmec))
				c[j++] = alunos[i];
		}
		
		alunos = c;
		
		return true;
	}
	
	public boolean alunoInscrito(int nmec){
		for(int i=0;i<alunos.length;i++)
			if(alunos[i].getNmec()==nmec)
				return true;
		return false;
	}
	
	public int numAlunos(){
		return alunos.length;
	}
	
	@Override
	public String toString(){
		return "Disciplina: "+nomeDisc+" ("+ects+" ECTS) da Área da "+areaC+"\nResponsável: "+responsavel.toString()+"\nExistem "+numAlunos()+" aluno(s) inscrito(s).";
	}
	
	public Estudante[] getAlunos(){
		return alunos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(alunos);
		result = prime * result + ((areaC == null) ? 0 : areaC.hashCode());
		result = prime * result + ects;
		result = prime * result + ((nomeDisc == null) ? 0 : nomeDisc.hashCode());
		result = prime * result + ((responsavel == null) ? 0 : responsavel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (!Arrays.equals(alunos, other.alunos))
			return false;
		if (areaC == null) {
			if (other.areaC != null)
				return false;
		} else if (!areaC.equals(other.areaC))
			return false;
		if (ects != other.ects)
			return false;
		if (nomeDisc == null) {
			if (other.nomeDisc != null)
				return false;
		} else if (!nomeDisc.equals(other.nomeDisc))
			return false;
		if (responsavel == null) {
			if (other.responsavel != null)
				return false;
		} else if (!responsavel.equals(other.responsavel))
			return false;
		return true;
	}

	public String getNomeDisc() {
		return nomeDisc;
	}

	public String getAreaC() {
		return areaC;
	}

	public int getEcts() {
		return ects;
	}

	public Professor getResponsavel() {
		return responsavel;
	}
	
	public Estudante[] getAlunos(String tipo){
		Estudante alutype[] = new Estudante[0];
		
		for(int i=0;i<alunos.length;i++){
			if(alunos[i].getClass().getSimpleName().equals(tipo)){
				alutype=addEst(alutype, alunos[i]);
			}
		}
		
		return alutype;
	}
	
	private Estudante[] addEst(Estudante[] al, Estudante novo){
		Estudante[] c=new Estudante[al.length+1];
		
		for(int i=0;i<al.length;i++){
			c[i]=al[i];
		}
		c[al.length] = novo;
		return c;
	}
	
	
}
