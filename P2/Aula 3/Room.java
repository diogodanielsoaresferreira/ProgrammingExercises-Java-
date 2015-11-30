/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class Room {
	
	private String division;
	Coordenadas topRight = new Coordenadas();
	Coordenadas bottomLeft = new Coordenadas();
	
	Room(String division, double topRightx, double topRighty, double bottomLeftx, double bottomLefty){
		assert topRightx>=bottomLeftx :"Coordenadas x inválidas!";
		assert topRighty>bottomLefty:"Coordenadas y inválidas!";
		this.division = division;
		topRight.x=topRightx;
		topRight.y=topRighty;
		bottomLeft.x=bottomLeftx;
		bottomLeft.y=bottomLefty;
	}
	
	public String roomType(){
		return this.division;
	}
	
	public Coordenadas bottomLeft(){
		return bottomLeft;
	}
	
	public Coordenadas topRight(){
		return topRight;
	}
	
	public Coordenadas geomCenter(){
		Coordenadas geomCent = new Coordenadas();
		
		geomCent.x=(topRight.x+bottomLeft.x)/2;
		geomCent.y=(topRight.y+bottomLeft.y)/2;
		
		return geomCent;
		
	}
	
	public double area(){
		double area;
		
		area=Math.abs((topRight.y-bottomLeft.y))*Math.abs((topRight.x-bottomLeft.x));
		
		return area;
	}
	
}

