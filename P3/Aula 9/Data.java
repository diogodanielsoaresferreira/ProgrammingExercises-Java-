/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº Mec. 76504
 * 
 */
package aula9;

import java.util.Calendar;

public class Data {
	
	private int day;
	private int month;
	private int year;
	
	Data(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getDay(){
		return day;
	}
	
	public int getMonth(){
		return month;
	}
	
	public int getYear(){
		return year;
	}
	
	@Override
	public String toString(){
		return day+"-"+month+"-"+year;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	public boolean isBiggerThan(Data d2){
		if(year>d2.year) return true;
		else if(year<d2.year) return false;
		
		if(month>d2.month) return true;
		else if(month<d2.month) return false;
		
		if(day>d2.day) return true;
		else if(day<d2.day) return false;
		
		return false;
	}
	
	public int getIdade(){
		Calendar now = Calendar.getInstance();
		int dyear = now.get(Calendar.YEAR)-this.year;
		if(now.get(Calendar.MONTH)<this.month) return dyear;
		else if(now.get(Calendar.MONTH)>this.month) return dyear-1;
		else{
			if(now.get(Calendar.DAY_OF_MONTH)<=this.day) return dyear;
			else return dyear-1;
		}
		
	}
	
	public static boolean validarData(int year, int month, int day){
		if(year<0 || year>2015) return false;
		if(month<1 || month>12) return false;
		
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
			if (day<1 || day>31) return false;
		}
		else if(month==4 || month==6 || month==6 || month==9 || month==11){
			if(day<1 || day>30) return false;
		}
		else if(year%400==0 || (!(year%100==0) && (year%4==0))){
			if(day<1 || day>29) return false;
		}
		else{
			if(day<1 || day>28) return false;
		}
		return true;
	}
	
	public static Data now(){
		Calendar now = Calendar.getInstance();
		Data n=new Data(now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH)+1, now.get(Calendar.YEAR));
		return n;
	}
	
}