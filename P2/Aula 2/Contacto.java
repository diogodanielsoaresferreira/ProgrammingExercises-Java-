/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package pt.ua.prog;

public class Contacto {
	private static int con;
	private String name;
	private String email;
	private String tel;
	
	public Contacto(String name, String tel){
		if (name.isEmpty()){
			System.out.println("Contacto inválido!");
			System.exit(1);
		}
		this.name=name;
		this.tel=tel;
		con++;
	}
	public Contacto(String name, String tel, String email){
		this.name=name;
		this.tel=tel;
		this.email=email;
		con++;
	}
	
	public String nome(){
		return name;
	}
	public String telefone(){
		if(tel==null) return "";
		return tel;
	}
	public String email(){
		if(email==null) return "";

		return email;
	}
	static{
		con=0;
	}
}
