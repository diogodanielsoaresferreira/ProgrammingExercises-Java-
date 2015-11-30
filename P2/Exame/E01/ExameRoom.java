/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class ExameRoom {

   public ExameRoom(ExamePoint bl, ExamePoint tr, String roomType) {
      this.bottomleft = bl;
      this.topright = tr;
      this.roomType = roomType;
   }

   public ExamePoint geomCenter() {
      return bottomleft.halfWayTo(topright);
   }

   public double width() {
      double dx = topright.x()-bottomleft.x();
      double dy = topright.y()-bottomleft.y();
      if (dx<dy) return dx;
      return dy;
   }

   public double length() {
      double dx = topright.x()-bottomleft.x();
      double dy = topright.y()-bottomleft.y();
      if (dx<dy) return dy;
      return dx;
   }

   public double area() {
      double dx = topright.x()-bottomleft.x();
      double dy = topright.y()-bottomleft.y();
      return dx*dy;
   }

   public String roomType() {
      return roomType;
   }

   private ExamePoint bottomleft;
   private ExamePoint topright;
   private String roomType;

}


