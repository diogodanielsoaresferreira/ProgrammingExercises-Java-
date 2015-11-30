/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import java.util.Calendar;
import java.util.Scanner;



public class Data {
	private int day;
	private int month;
	private int year;
	
	static final Scanner sc = new Scanner (System.in);
	
	public String printdate(){
		return (day+"-"+month+"-"+year);
	}
	
	public static boolean biss(int year){
		if(year%400==0) return true;
		else if (year%4==0 && year%100!=0) return true;
		else return false;
	}
	
	public static int daysofmonth(int month, int year){
		
		if(month==1 || month==3|| month==5|| month==7|| month==8|| month==10|| month== 12){
			return 31;
		}
		else if(month==2){
			if(biss(year)==true) return 29;
			else return 28;
		}
		else return 30;
			
	}
	
	public static boolean isvaliddate(Data x){
		if(x.day<0 || x.day>daysofmonth(x.month, x.year)){
			return false;
		}
		else if(x.month<0 || x.month>12){
			return false;
		}
		else if(x.year<0) return false;
		else return true;
		
	}
	
	public boolean isvaliddate(){
		if(day<0 || day>daysofmonth(month, year)){
			return false;
		}
		else if(month<0 || month>12){
			return false;
		}
		else if(year<0) return false;
		else return true;
		
	}
	
	public static void date(Data x){
		x.day=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		x.month=Calendar.getInstance().get(Calendar.MONTH);
		x.year=Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public void newdate(){
		System.out.print("\nDia: ");
		day = sc.nextInt();
		System.out.print("\nMês: ");
		month = sc.nextInt();
		System.out.print("\nAno: ");
		year = sc.nextInt();
	}
	
	public int getday(){
		return this.day;
	}
	
	public int getmonth(){
		return this.month;
	}
	
	public int getyear(){
		return this.year;
	}
	
	public String getnamemonth(){
		
		switch(month){
		case 1:
			return "Janeiro";
		case 2:
			return "Fevereiro";
		case 3:
			return "Março";
		case 4:
			return "Abril";
		case 5:
			return "Maio";
		case 6:
			return "Junho";
		case 7:
			return "Julho";
		case 8:
			return "Agosto";
		case 9:
			return "Setembro";
		case 10:
			return "Outubro";
		case 11:
			return "Novembro";
		case 12:
			return "Dezembro";
		default:
			return "Error";
		}
	}
	
	public void getextdate(){
		System.out.print(day+" de "+getnamemonth()+" de "+year);
	}
	
	public void vaiParaAmanha(){
		if (!isvaliddate()){
			System.out.println("A data não é válida!");
			return;
		}
		else{
			int i=daysofmonth(month, year);
			if (day==i){
				if(month==12){
					year++;
					month=1;
					day=1;
				}
				else{
					day=1;
					month++;
				}
			}
			else{
				day++;
			}
			System.out.println("Data atualizada!");
		}
	}
	public void vaiParaOntem(){
		if (!isvaliddate()){
			System.out.println("A data não é válida!");
			return;
		}
		else{
			int i=daysofmonth(month-1, year);
			if (day==1){
				if(month==1){
					year--;
					month=12;
					day=daysofmonth(12, year);
				}
				else{
					day=i;
					month--;
				}
			}
			else{
				day--;
			}
			System.out.println("Data atualizada!");
		}
	}
	
}
