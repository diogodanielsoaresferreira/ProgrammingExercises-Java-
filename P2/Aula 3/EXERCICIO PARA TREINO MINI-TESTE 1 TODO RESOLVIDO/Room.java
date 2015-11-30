package teste;
public class Room {

	private double x1,x2,y1,y2;
	private String texto;
	
	Room(Point p1, Point p2, String texto){
		this.x1=p1.x();
		this.y1=p1.y();
		this.x2=p2.x();
		this.y2=p2.y();
		this.texto=texto;
	}
	
	public String roomType(){
		return this.texto;
	}
	
	public double distToOrigin(double x1, double y1){
		double dist1;
		dist1=Math.sqrt(Math.pow(x1, 2)+Math.pow(y1,2));
		return dist1;
	}
	
	public Point bottomLeft(){
		double dist1, dist2;
		
		dist1=distToOrigin(x1, y1);
		dist2=distToOrigin(x2, y2);
		
		if(dist2>dist1){
			Point a = new Point (x1, y1);
			return a;
		}
		else{
			Point a = new Point (x2, y2);
			return a;
		}
		
	}
	
	public Point topRight(){
		double dist1, dist2;
		
		dist1=distToOrigin(x1, y1);
		dist2=distToOrigin(x2, y2);
		
		if(dist2<dist1){
			Point a = new Point (x1, y1);
			return a;
		}
		else{
			Point a = new Point (x2, y2);
			return a;
		}
	}
	
	public Point geomCenter(){
		Point a = topRight();
		Point b = bottomLeft();
		
		Point c = new Point(a.x()-b.x(), a.y()-b.y());
		
		return c;
	}
	
	public double area(){
		Point a = topRight();
		Point b = bottomLeft();
		
		double area=Math.abs(a.y()-b.y()) * Math.abs(a.x()-b.x());
		
		return area;
	}
}
