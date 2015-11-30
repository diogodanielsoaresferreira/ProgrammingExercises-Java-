/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula4;

public class Videos {
	
	private static long num=0;
	private long id;
	private int ncheckin=0;
	private double rat=0;
	private String title;
	private String category;
	private String idade;
	private boolean loan=false;
	private Clientes[] cl=new Clientes[0];
	
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
	
	
	public void checkout(Clientes c){
		addLoanName(c);
		loan = true;
		c.addVid(this);
	}
	
	private void addLoanName(Clientes c){
		Clientes[] copy=new Clientes[cl.length+1];
		
		for(int i=0;i<cl.length;i++){
			copy[i]=cl[i];
		}
		copy[cl.length]=c;
		cl=copy;
	}
	
	public Clientes[] getLoanHist(){
		return cl;
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
