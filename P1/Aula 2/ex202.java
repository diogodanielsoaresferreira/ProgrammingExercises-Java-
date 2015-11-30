import java.util.Scanner;

public class ex202 {
    
    public static void main (String Args[]){
        
        Scanner sc = new Scanner (System.in);
        double a, b;
        
        System.out.print("Insira aqui o seu numero: ");
        a = sc.nextDouble();
        System.out.print("Agora insira o outro: ");
        b = sc.nextDouble();
        System.out.println();
        
        if (a==b){
            
            System.out.println("Os numeros inserios são iguais.");
            
        }
        else if (a>b){
        
            System.out.println(a+" e maior do que " + b + ".");
        }
        
        else{
            System.out.println(b + " e maior do que " + a ".");
                
        }        
    }
    
}
