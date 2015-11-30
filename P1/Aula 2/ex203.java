import java.util.Scanner;

public class ex203 {
    
    public static void main (String Args[]){
        
        int idade;
        
        Scanner sc = new Scanner (System.in);
        
        System.out.print("Qual e a sua idade? ");
        idade = sc.nextInt();
        
        if (idade<6){
            
            System.out.println("Esta isento de pagamento");
            
        }
        else if (idade >= 6 && idade <= 12){
        
            System.out.println("Ira pagar um bilhete de crianca.");
        
        }
        else if (idade >= 13 && idade <= 65){
                
            System.out.println("Ira pagar um bilhete de adulto");
                
        }
        
        else{
                
             System.out.println("Ira pagar um bilhete de terceira idade");
                
        }
        
    }
    
}
