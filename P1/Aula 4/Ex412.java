package p1;

import java.util.Scanner;
import static java.lang.System.*;

public class Ex412 {

	public static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		

		int mes, ano, dia, i=0;
		String m="";
		
		do{
			out.print("Dia em que começa o mês: ");
			dia = sc.nextInt();
			out.println();
		}while(dia<1 || dia >31);
		do{
			out.print("Mês: ");
			mes = sc.nextInt();
			out.println();
		}while(mes<1 || mes>12);
		
		do{
			out.print("Ano: ");
			ano = sc.nextInt();
			out.println();
		}while(ano<1 && ano>1000);

		switch (mes){
		
		case 1: m=" Janeiro "; i=31; break;
		case 2: m="Fevereiro"; 
			if(((ano%4==0) && (ano%400==0)) || ((ano%4==0) && (ano%100!=0))){ 
				i=29; 
			}
			else i=28;
			break;
		case 3: m="  Março  "; i=31; break;
		case 4: m="  Abril  "; i=30; break;
		case 5: m="  Maio   "; i=31; break;
		case 6: m="  Junho  "; i=30; break;
		case 7: m="  Julho  "; i=31; break;
		case 8: m=" Agosto  "; i=31; break;
		case 9: m="Setembro "; i=30; break;
		case 10: m=" Outubro ";i=31; break;
		case 11: m="Novembro ";i=30; break;
		case 12: m="Dezembro ";i=31; break;
		
		}
		
		
		
	out.println("------------------------------------");
	out.println("|	" + m + "      " + ano + "	   |");
	out.println("------------------------------------");
	
	
	out.println("------------------------------------");
	out.println("|Seg  Ter  Qua  Qui  Sex  Sab  Dom |");
	out.println("------------------------------------");
	
	switch(dia){										//Não era preciso. Pode-se simplificar(Usando o loop for())!
	case 1:
		if(i==30){
			out.println("| 1    2    3    4    5    6    7  |");
			out.println("| 8    9   10   11   12   13   14  |");
			out.println("|15   16   17   18   19   20   21  |");
			out.println("|22   23   24   25   26   27   28  |");
			out.println("|29   30                           |");
			out.println("------------------------------------");
		}
		else if (i==31){
			out.println("| 1    2    3    4    5    6    7  |");
			out.println("| 8    9   10   11   12   13   14  |");
			out.println("|15   16   17   18   19   20   21  |");
			out.println("|22   23   24   25   26   27   28  |");
			out.println("|29   30   31                      |");
			out.println("------------------------------------");
			
		}
		else if(i==29){
			out.println("| 1    2    3    4    5    6    7  |");
			out.println("| 8    9   10   11   12   13   14  |");
			out.println("|15   16   17   18   19   20   21  |");
			out.println("|22   23   24   25   26   27   28  |");
			out.println("|29                                |");
			out.println("------------------------------------");
		}
		else if(i==28){
			out.println("| 1    2    3    4    5    6    7  |");
			out.println("| 8    9   10   11   12   13   14  |");
			out.println("|15   16   17   18   19   20   21  |");
			out.println("|22   23   24   25   26   27   28  |");
			out.println("------------------------------------");
		}
		break;
	case 2:
		if(i==30){
			out.println("|      1    2    3    4    5    6  |");
			out.println("| 7    8    9   10   11   12   13  |");
			out.println("|14   15   16   17   18   19   20  |");
			out.println("|21   22   23   24   25   26   27  |");
			out.println("|28   29   30                      |");
			out.println("------------------------------------");
		}
		else if (i==31){
			out.println("|      1    2    3    4    5    6  |");
			out.println("| 7    8    9   10   11   12   13  |");
			out.println("|14   15   16   17   18   19   20  |");
			out.println("|21   22   23   24   25   26   27  |");
			out.println("|28   29   30   31                 |");
			out.println("------------------------------------");
			
		}
		else if(i==29){
			out.println("|      1    2    3    4    5    6  |");
			out.println("| 7    8    9   10   11   12   13  |");
			out.println("|14   15   16   17   18   19   20  |");
			out.println("|21   22   23   24   25   26   27  |");
			out.println("|28   29                           |");
			out.println("------------------------------------");
		}
		else if(i==28){
			out.println("|      1    2    3    4    5    6  |");
			out.println("| 7    8    9   10   11   12   13  |");
			out.println("|14   15   16   17   18   19   20  |");
			out.println("|21   22   23   24   25   26   27  |");
			out.println("|28                                |");
			out.println("------------------------------------");
		}
		break;
	case 3:
		
		if(i==30){
			out.println("|           1    2    3    4    5  |");
			out.println("| 6    7    8    9   10   11   12  |");
			out.println("|13   14   15   16   17   18   19  |");
			out.println("|20   21   22   23   24   25   26  |");
			out.println("|27   28   29   30                 |");
			out.println("------------------------------------");
		}
		else if (i==31){
			out.println("|           1    2    3    4    5  |");
			out.println("| 6    7    8    9   10   11   12  |");
			out.println("|13   14   15   16   17   18   19  |");
			out.println("|20   21   22   23   24   25   26  |");
			out.println("|27   28   30   31                 |");
			out.println("------------------------------------");
			
		}
		else if(i==29){
			out.println("|           1    2    3    4    5  |");
			out.println("| 6    7    8    9   10   11   12  |");
			out.println("|13   14   15   16   17   18   19  |");
			out.println("|20   21   22   23   24   25   26  |");
			out.println("|27   28   29                      |");
			out.println("------------------------------------");
		}
		else if(i==28){
			out.println("|           1    2    3    4    5  |");
			out.println("| 6    7    8    9   10   11   12  |");
			out.println("|13   14   15   16   17   18   19  |");
			out.println("|20   21   22   23   24   25   26  |");
			out.println("|27   28                           |");
			out.println("------------------------------------");
		}
		break;
	case 4:
		if(i==30){
			out.println("|                1    2    3    4  |");
			out.println("| 5    6    7    8    9   10   11  |");
			out.println("|12   13   14   15   16   17   18  |");
			out.println("|19   20   21   22   23   24   25  |");
			out.println("|26   27   28   29   30            |");
			out.println("------------------------------------");
		}
		else if (i==31){
			out.println("|                1    2    3    4  |");
			out.println("| 5    6    7    8    9   10   11  |");
			out.println("|12   13   14   15   16   17   18  |");
			out.println("|19   20   21   22   23   24   25  |");
			out.println("|26   27   28   29   30   31       |");
			out.println("------------------------------------");
			
		}
		else if(i==29){
			out.println("|                1    2    3    4  |");
			out.println("| 5    6    7    8    9   10   11  |");
			out.println("|12   13   14   15   16   17   18  |");
			out.println("|19   20   21   22   23   24   25  |");
			out.println("|26   27   28   29                 |");
			out.println("------------------------------------");
		}
		else if(i==28){
			out.println("|                1    2    3    4  |");
			out.println("| 5    6    7    8    9   10   11  |");
			out.println("|12   13   14   15   16   17   18  |");
			out.println("|19   20   21   22   23   24   25  |");
			out.println("|26   27   28                      |");
			out.println("------------------------------------");
		}
		break;
	case 5:
		if(i==30){
			out.println("|                     1    2    3  |");
			out.println("| 4    5    6    7    8    9   10  |");
			out.println("|11   12   13   14   15   16   17  |");
			out.println("|18   19   20   21   22   23   24  |");
			out.println("|25   26   27   28   29   30       |");
			out.println("------------------------------------");
		}
		else if (i==31){
			out.println("|                     1    2    3  |");
			out.println("| 4    5    6    7    8    9   10  |");
			out.println("|11   12   13   14   15   16   17  |");
			out.println("|18   19   20   21   22   23   24  |");
			out.println("|25   26   27   28   29   30   31  |");
			out.println("------------------------------------");
		}
		else if(i==29){
			out.println("|                     1    2    3  |");
			out.println("| 4    5    6    7    8    9   10  |");
			out.println("|11   12   13   14   15   16   17  |");
			out.println("|18   19   20   21   22   23   24  |");
			out.println("|25   26   27   28   29            |");
			out.println("------------------------------------");
		}
		else if(i==28){
			out.println("|                     1    2    3  |");
			out.println("| 4    5    6    7    8    9   10  |");
			out.println("|11   12   13   14   15   16   17  |");
			out.println("|18   19   20   21   22   23   24  |");
			out.println("|25   26   27   28                 |");
			out.println("------------------------------------");
		}
		break;
	case 6:
		if(i==30){
			out.println("|                          1    2  |");
			out.println("| 3    4    5    6    7    8    9  |");
			out.println("|10   11   12   13   14   15   16  |");
			out.println("|17   18   19   20   21   22   23  |");
			out.println("|24   25   26   27   28   29   30  |");
			out.println("------------------------------------");
		}
		else if (i==31){
			out.println("|                          1    2  |");
			out.println("| 3    4    5    6    7    8    9  |");
			out.println("|10   11   12   13   14   15   16  |");
			out.println("|17   18   19   20   21   22   23  |");
			out.println("|24   25   26   27   28   29   30  |");
			out.println("|31                                |");
			out.println("------------------------------------");
		}
		else if(i==29){
			out.println("|                          1    2  |");
			out.println("| 3    4    5    6    7    8    9  |");
			out.println("|10   11   12   13   14   15   16  |");
			out.println("|17   18   19   20   21   22   23  |");
			out.println("|24   25   26   27   28   29       |");
			out.println("------------------------------------");
		}
		else if(i==28){
			out.println("|                          1    2  |");
			out.println("| 3    4    5    6    7    8    9  |");
			out.println("|10   11   12   13   14   15   16  |");
			out.println("|17   18   19   20   21   22   23  |");
			out.println("|24   25   26   27   28            |");
			out.println("------------------------------------");
		}
		break;
	case 7:
		if(i==30){
			out.println("|                               1  |");
			out.println("| 2    3    4    5    6    7    8  |");
			out.println("| 9   10   11   12   13   14   15  |");
			out.println("|16   17   18   19   20   21   22  |");
			out.println("|23   24   25   26   27   28   29  |");
			out.println("|30                                |");
			out.println("------------------------------------");
		}
		else if (i==31){
			out.println("|                               1  |");
			out.println("| 2    3    4    5    6    7    8  |");
			out.println("| 9   10   11   12   13   14   15  |");
			out.println("|16   17   18   19   20   21   22  |");
			out.println("|23   24   25   26   27   28   29  |");
			out.println("|30   31                           |");
			out.println("------------------------------------");
		}
		else if(i==29){
			out.println("|                               1  |");
			out.println("| 2    3    4    5    6    7    8  |");
			out.println("| 9   10   11   12   13   14   15  |");
			out.println("|16   17   18   19   20   21   22  |");
			out.println("|23   24   25   26   27   28   29  |");
			out.println("------------------------------------");
		}
		else if(i==28){
			out.println("|                               1  |");
			out.println("| 2    3    4    5    6    7    8  |");
			out.println("| 9   10   11   12   13   14   15  |");
			out.println("|16   17   18   19   20   21   22  |");
			out.println("|23   24   25   26   27   28       |");
			out.println("------------------------------------");
		}
		break;
	
	}

	}
}
