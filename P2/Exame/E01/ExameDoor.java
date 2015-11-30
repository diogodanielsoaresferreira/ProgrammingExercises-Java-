/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class ExameDoor {

	public ExameDoor(int r1, int r2, double w, double h){
		this.id1 = r1;
		this.id2 = r2;
		this.w = w;
		this.h = h;
	}
	
	public double area(){
		return w*h;
	}
	
	int id1, id2;
	double w,h;
}
