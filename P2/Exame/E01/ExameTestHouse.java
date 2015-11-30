/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;


import static java.lang.System.*;

public class ExameTestHouse
{
   public static void main(String[] args)
   {
	  ExameHouse h = new ExameHouse("apartment",7,4);

      ExamePoint p1  = new ExamePoint( 0.0, 2.0);
      ExamePoint p2  = new ExamePoint(22.0, 5.0);
      ExamePoint p3  = new ExamePoint( 8.0, 0.0);
      ExamePoint p4  = new ExamePoint( 8.0, 5.0);
      ExamePoint p5  = new ExamePoint( 0.0, 8.0);
      ExamePoint p6  = new ExamePoint(22.0, 8.0);
      ExamePoint p7  = new ExamePoint(11.0,14.0);
      ExamePoint p8  = new ExamePoint( 8.0, 8.0);
      ExamePoint p9  = new ExamePoint(11.0, 8.0);
      ExamePoint p10 = new ExamePoint(22.0,14.0);
      ExamePoint p11 = new ExamePoint(22.0, 0.0);
      ExamePoint p12 = new ExamePoint(28.0, 5.0);
      ExamePoint p13 = new ExamePoint(28.0,14.0);
      ExamePoint p14 = new ExamePoint(28.0,20.0);

      int hall = h.addRoom(new ExameRoom(p1,p8, "hall"));
      int sala = h.addRoom(new ExameRoom(p3,p2, "sala"));
      int corr = h.addRoom(new ExameRoom(p4,p6, "corredor"));
      int q1   = h.addRoom(new ExameRoom(p9,p10, "quarto"));
      int q2   = h.addRoom(new ExameRoom(p5,p7, "quarto"));
      int wc   = h.addRoom(new ExameRoom(p11,p12, "wc"));
      int coz  = h.addRoom(new ExameRoom(p2,p13, "cozinha"));
      int copa = h.addRoom(new ExameRoom(p10,p14, "copa"));

      out.println("\nAntes de introduzir portas: ");
      out.println("- Portas registadas: " + h.numDoors());
      out.println("- Capacidade actual para portas  : " + h.maxNumDoors());

      h.addDoor(new ExameDoor(hall,sala,0.8,2.0));
      h.addDoor(new ExameDoor(hall,corr,1.0,2.0));
      h.addDoor(new ExameDoor(sala,corr,1.0,2.0));
      h.addDoor(new ExameDoor(sala,wc,0.8,2.0));
      h.addDoor(new ExameDoor(corr,coz,0.8,2.0));
      h.addDoor(new ExameDoor(corr,q2,0.8,2.0));
      h.addDoor(new ExameDoor(corr,q1,0.8,2.0));
      h.addDoor(new ExameDoor(copa,coz,0.8,2.0));

      out.println("\nDepois de introduzir divisões: ");
      out.println("- Portas registadas: " + h.numDoors());
      out.println("- Capacidade actual para portas  : " + h.maxNumDoors());

      int n = h.maxDoorsInAnyRoom();
      out.println("\nNúmero máximo de portas numa divisão: "+n);

      
      int roomId = h.roomClosestToRoomType("wc");
      out.println("\nDivisão mais próxima de um WC: "+roomId + " ("+h.room(roomId).roomType()+")");
      roomId = h.roomClosestToRoomType("quarto");
      out.println("\nDivisão mais próxima de um quarto: "+roomId + " ("+h.room(roomId).roomType()+")");

      
   }
}


