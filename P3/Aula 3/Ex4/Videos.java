/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

public class Videos {
	
	private static long num=0;
	private long id;
	private int ncheckin=0;
	private double rat=0;
	private String title;
	private String category;
	private String idade;
	private boolean loan=false;
	private Estudantes[] est = new Estudantes[0];
	private Funcionarios[] fun = new Funcionarios[0];
	
	public Videos(String title, String category, String idade){
		assert idade.equals("ALL") || category.equals("M6") || category.equals("M12") || category.equals("M16") || category.equals("M18");
		num++;
		id = num;
		this.title = title;
		this.category = category;
		this.idade = idade;
	}
	
	public long getId(){
		return id;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getCat(){
		return category;
	}
	
	public String getIda(){
		return idade;
	}
	
	public boolean isLoan(){
		return loan;
	}
	
	public void checkout(Funcionarios f){
		addFunLoanName(f);
		loan = true;
		f.addVid(this);
	}
	
	public void checkout(Estudantes e){
		addEstLoanName(e);
		loan = true;
		e.addVid(this);
	}
	
	private void addEstLoanName(Estudantes e){
		Estudantes[]c = new Estudantes[est.length+1];
		for(int i=0;i<est.length;i++){
			c[i] = est[i];
		}
		c[est.length] = e;
		est=c;
	}
	
	private void addFunLoanName(Funcionarios f){
		Funcionarios[]c = new Funcionarios[fun.length+1];
		for(int i=0;i<fun.length;i++){
			c[i] = fun[i];
		}
		c[fun.length] = f;
		fun=c;
	}
	
	public Estudantes[] getLoanEstHist(){
		return est;
	}
	
	public Funcionarios[] getLoanFunHist(){
		return fun;
	}
	
	public void checkin(double rat){
		loan = false;
		ncheckin++;
		this.rat += rat;
	}
	
	public double ratMed(){
		if(ncheckin!=0)
			return rat/ncheckin;
		else return 0;
	}
	
	
}
