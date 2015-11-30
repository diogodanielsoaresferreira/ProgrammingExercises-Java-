package p2;


import static java.lang.System.*;

public class ExameHouse {

   public ExameHouse(String houseType,int maxSize,int extensionSize) {
      this.houseType = houseType;
      this.extensionSize = extensionSize;
      rooms = new ExameRoom[maxSize];
      size = 0;
      doors = new ExameDoor[maxSize];
      numDoors = 0;
   }

   public ExameHouse(String houseType) {
      this(houseType,8,4);
   } 

   public int size() {
      return size;
   }

   public int maxSize() {
      return rooms.length;
   }

   public ExameRoom room(int i) {
      return rooms[i];
   }

   public int addRoom(ExameRoom r) {
      if (size == rooms.length) extendHouse();
      rooms[size] = r;
      size++;
      return size-1;
   }
   
   public int roomClosestToRoomType(String roomType){
	   int[] id = new int[0];
	   
	   for(int i=0;i<size;i++){
		   if(rooms[i].roomType().equals(roomType)){
			   id = addElement(id, i);
		   }
	   }
	   
	   int idclosest = 0;
	   double min = Double.MAX_VALUE;
	   
	   for(int i=0;i<id.length;i++){
		   for(int j=0;j<size;j++){
			   if(rooms[j].geomCenter().distTo(rooms[i].geomCenter())<min && rooms[j].geomCenter().distTo(rooms[i].geomCenter())>0 ){
				   idclosest = j;
				   min = rooms[j].geomCenter().distTo(rooms[i].geomCenter());
			   }
		   }
	   }
	   
	   return idclosest;
	   
   }
   
   private int[] addElement(int[] array, int a){
	   int[] array2 = new int[array.length+1];
	   
	   System.arraycopy(array,0, array2, 0, array.length);
	   array2[array.length] = a;
	   return array2;
   }

   private void extendHouse() {
	  ExameRoom [] newRooms = new ExameRoom[rooms.length+extensionSize];
      arraycopy(rooms, 0, newRooms, 0, rooms.length);
      rooms = newRooms;
   } 

   private String houseType;
   private int extensionSize;
   private ExameRoom [] rooms;
   private int size;
   private ExameDoor [] doors;
   private int numDoors;

   public void addDoor(ExameDoor d) {
	   if (numDoors == doors.length) extendDoors();
      doors[numDoors] = d;
      numDoors++;
   }

   public int numDoors() {
      return numDoors;
   }

   public int maxNumDoors() {
      return doors.length;
   }
   
   public int maxDoorsInAnyRoom(){
	   int []doorsbyroom = new int[numDoors];
	   
	   for(int i=0;i<numDoors;i++){
		   doorsbyroom[doors[i].id1]++;
		   doorsbyroom[doors[i].id2]++;
	   }
	   
	   int max=0;
	   for(int i=0;i<numDoors;i++){
		   if(max<doorsbyroom[i]){
			   max = doorsbyroom[i];
		   }
	   }
	   
	   return max;
   }
   
   private void extendDoors() {
	  ExameDoor [] newDoors = new ExameDoor[doors.length+extensionSize];
      arraycopy(doors, 0, newDoors, 0, doors.length);
      doors = newDoors;
   } 

}

