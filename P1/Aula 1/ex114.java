import java.util.Scanner;

public class ex114 {
    
    public static void main (String Args[] ){

        Scanner sc = new Scanner (System.in);
        
        double a, b, hipo, ang;
        
        System.out.print("Insira aqui a medida dos dois catetos: ");
        a = sc.nextDouble();
        System.out.println();
        b = sc.nextDouble();
        
        hipo = Math.sqrt(Math.pow(a, 2) + Math.pow(b,2));
        System.out.println("A hipotenusa do triangulo e: " + hipo + ".");
        
        ang = Math.toDegrees(Math.atan(b/a));
        System.out.println("O angulo de um dos lados do triangulo e: " + ang + ".");
    }
}
