import java.util.Scanner;

public class ex112 {
    
    public static void main (String args[]){
        
        Scanner sc = new Scanner (System.in);
        
        int seg, min, hor;
        
        System.out.print("Insira aqui o numero de segundos: ");
        seg = sc.nextInt();
        System.out.println();
        
        hor = seg/3600;
        min = (seg % 60);
        seg = seg % 60;

        System.out.println(hor + ":" + min + ":" + seg);
    }
    
}
