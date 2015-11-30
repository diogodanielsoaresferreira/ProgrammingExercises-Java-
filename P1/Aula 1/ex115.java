import java.util.Scanner;

public class ex115 {
    
    public static void main (String Args[]){
        
        Scanner sc = new Scanner(System.in);
        
        double TP1, TP2, API, EP, notaf;
        
        System.out.println("Insira aqui as suas notas a:\nTP1: ");
        TP1 = sc.nextDouble();
        System.out.println();
        System.out.println("TP2: ");
        TP2 = sc.nextDouble();
        System.out.println();
        System.out.println("API: ");
        API = sc.nextDouble();
        System.out.println();
        System.out.println("EP: ");
        EP = sc.nextDouble();
        System.out.println();
        
        notaf = (TP1*0.15) + (TP2*0.15) + (API*0.3) + (EP*0.4);
        
        System.out.println("A sua nota final é de " + notaf + ".");
    }
    
}