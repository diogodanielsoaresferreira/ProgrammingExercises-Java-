/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class ExamePoint {

   ExamePoint(double x, double y) {
      this.x = x;
      this.y = y;
   }

   ExamePoint() {
      this.x = 0;
      this.y = 0;
   }

   public ExamePoint halfWayTo(ExamePoint p) {
	   ExamePoint hw = new ExamePoint();
      hw.x = (this.x+p.x)/2.0;
      hw.y = (this.y+p.y)/2.0;
      return hw;
   }

   public double distTo(ExamePoint p) {
      return Math.sqrt(Math.pow(this.x-p.x,2)+Math.pow(this.y-p.y,2));
   }

   public double x() {
      return x;
   }

   public double y() {
      return y;
   }

   private double x, y;
}
