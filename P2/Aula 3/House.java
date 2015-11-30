/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class House {
	private String type;
	private Room[] houser;
	int newd;
	
	House(String type){
		assert !type.isEmpty();
		this.type=type;
		houser = new Room[8];
		this.newd=3;
	}
	
	House(String type, int div, int addiv){
		assert !type.isEmpty();
		assert div > 0;
		assert addiv > 0;
		
		this.type=type;
		houser = new Room[div];
		this.newd=addiv;
	}
	
	public void addRoom(Room a){
		
		boolean isspace=false;
		int i;
		
		for(i=0;i<houser.length;i++){
			if(houser[i]==null){
				isspace=true;
				break;
			}
		}
		
		if(isspace){
			houser[i] = a;
		}
		else{
			Room[] houser2 = new Room[houser.length+newd];
			int j;
			for(j=0;j<houser.length;j++){
				houser2[j]=houser[j];
			}
			houser2[j]=a;
			houser=houser2;
		}
		
	}
	
	public int size(){
		int j;
		
		for(j=0;j<houser.length;j++){
			if(houser[j]==null) break;
		}
		
		return j;
	}
	
	public int maxSize(){
		return houser.length;
	}
	
	public String room(int r){
		return houser[r].roomType();
	}
	
	public double area(){
		double area=0;
		
		for(int j=0;j<houser.length;j++){
			if(houser[j]== null) break;
			else{
				area+=houser[j].area();
			}
		}
		return area;
	}
	
	public RoomTypeCount[] getRoomTypeCounts(){
		int i;
		for(i=0;i<houser.length;i++){
			if(houser[i]==null) break;
		}

		RoomTypeCount []a = new RoomTypeCount[0];
		
		for(int j=0;j<i;j++){
			if(pertence(a, houser[j].roomType())){
				addct(a, houser[j].roomType());
			}
			else{
				RoomTypeCount z = new RoomTypeCount();
				z.count=0;
				z.roomType=houser[j].roomType();
				addtp(a, z);
			}
		}
		
		return a;
	}
	
	public void addtp (RoomTypeCount [] a, RoomTypeCount b){
		RoomTypeCount [] c= new RoomTypeCount [a.length+1];
		
		for(int i=0;i<a.length;i++){
			c[i]=a[i];
		}
		c[c.length-1]=b;
		
		c=a;
	}
	
	public boolean pertence (RoomTypeCount [] a, String b){
		
		for(int i=0;i<a.length;i++){
			if(a[i].roomType==b) return true;
		}
		return false;
	}
	
	public void addct (RoomTypeCount [] a, String b){
		
		for(int i=0;i<a.length;i++){
			if(a[i].roomType==b){
				a[i].count++;
				return;
			}
		}
	}

	public double averageRoomDistance(){
			
		double media=0;
		int c=0;
		for(int i=0;i<houser.length;i++){
			if(houser[i]==null) break;
			else{
				media+=houser[i].area();
				c++;
			}
		}
			
		return media/c;
	}
	
}