/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class ExHouse {

	public static void main(String[] args) {
		
		House a= new House("Diogo");
		Room c=new Room ("Quarto", 10, 10, 0, 0);
		Room d=new Room ("Escritorio", 10, 10, 5, 5);
		
		a.addRoom(c);
		a.addRoom(d);
		System.out.println(a.size());
		System.out.println(a.maxSize());
		System.out.println(a.room(0));
		System.out.println(a.area());
		System.out.println(a.averageRoomDistance());
		
	}

}
