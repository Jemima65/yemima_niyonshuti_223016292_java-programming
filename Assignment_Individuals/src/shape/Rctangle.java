package shape;

public class Rctangle {
	private double length;
	private double width;
	
	//constructor
	public Rctangle(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}
	
	public double calArea(){
		return this.length*this.width;
	}
	public double calPerimeter(){
		return (this.length+this.width)*2;
	}
	
	

	


}
