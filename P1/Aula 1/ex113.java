import java.util.Scanner;

public class ex113 {

    public static void main (String args[]){
        
    Scanner sc = new Scanner (System.in);
    
    double x1, x2, y1, y2, dist;
    
    System.out.println("Insira as coordenadas ordenadas dos seu ponto A.");
    x1 = sc.nextDouble();
    System.out.println();
    y1 = sc.nextDouble();
    System.out.println();
    System.out.println("Insira as coordenadas ordenadas dos seu ponto b.");
    x2 = sc.nextDouble();
    System.out.println();
    y2 = sc.nextDouble();
    System.out.println();

    dist = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
    
    System.out.println("A sua distancia e " + dist + ".");
    
    }

}
