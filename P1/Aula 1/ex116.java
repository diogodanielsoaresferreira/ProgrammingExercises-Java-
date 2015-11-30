import java.util.Scanner;

public class ex116 {
    
    public static void main (String Args[]){
        
        Scanner sc = new Scanner (System.in);
        
        double des1, des2, des3, des4, media;
        int i=0;
        
        System.out.print("Qual foi a despesa do primeiro dia do turista? ");
        des1 = sc.nextDouble();
        System.out.println();
        
        des2=des1*1.2;
        des3=des2*1.2;
        des4=des3*1.2;
        
        media = ((des1+des2+des3+des4)/4);
        
        System.out.println("Ao fim de quatro dias, o turista gastou em media " + media + " euros por dia.");
        
    }
    
}