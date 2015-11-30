import java.util.Scanner;

public class ex201 {

    public static void main (String args[]) {
        
        Scanner sc = new Scanner (System.in);
        double TP1, TP2, API, EP, total;
        
        System.out.print("Introduza a sua nota de TP1: ");
        TP1 = sc.nextDouble();
        System.out.println();
        
        System.out.print("Introduza a sua nota de TP2: ");
        TP2 = sc.nextDouble();
        System.out.println();
        
        System.out.print("Introduza a sua nota de AP1: ");
        API = sc.nextDouble();
        System.out.println();
        
        System.out.print("Introduza a sua nota de EP: ");
        EP = sc.nextDouble();
        System.out.println();
        
        total = TP1*0.1 + TP2*0.1 + API*0.3 + EP*0.5;
        
        System.out.println("A sua nota final é de " + total + ".");
        
        if (total>=10){
            System.out.println("Parabens! Passaste.");
        }
        else{
            System.out.println("Chumbaste a disciplina.");
        }
    }
    
}
