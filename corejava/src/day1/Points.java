package day1;

public class Points {
	
	public static double ORIGIN = 0;
	private double x;
	private double y;
	
	public Points() {}
	
	//public void Point(){}
	
	public Points(final double x, final double y) {
		this.x=x;
		this.y=y;
		
	}
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double distance() {
		return distance(0,0);
		
	}
	
	//public abstract void markMeOnScreen();
	
	/**public double distance() {
		return Math.sqrt(x*x + y*y); //distance(0,0)
		
	}**/
	
	public double distance(final double x1, final double y1) {
		double diffx=x1-x;
		double diffy=y1-y;
		return Math.sqrt(diffx * diffx + diffy* diffy );
	}
	
	public double distance(Points p) {
		return distance(p.x,p.y);
	}
	
	
	public static void main(String[] args) {
		Points p=new Points(10,20);
		System.out.println(p);
		System.out.println(p.distance());
		System.out.println(p.distance(100,200));
		System.out.println(p.distance(p));
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "X = " +x + " Y= " +y;
	}
	
	
	/**
	byte 8 bits 
	 **/
	

}
