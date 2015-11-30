import java.util.Scanner

public class ex117 {
    

    
    public static void main (String Args[]){
        
        Scanner sc = new Scanner (System.in);
        
        double liq, des, iva, total;
        
        System.out.print("Qual foi o total líquido da fatura? ");
        liq = sc.nextDouble();
        System.out.println();
        
        System.out.print("Qual é o desconto em percentagem? ");
        des = sc.nextDouble()/100;
        System.out.println();
        
        System.out.print("Qual é o iva em percentagem? ");
        iva = sc.nextDouble()/100;
        System.out.println();
        
        total = (liq*(1-des))*(1+iva);
        
         System.out.println("O total é " + total + ".");
        
    }
    
}