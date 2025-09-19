package shape;

public class Circle {

	private double rad;

	public Circle(double r) {
		
		this.rad = r;
	}
	public double calArea(){
		return Math.PI*rad*rad;
	}
	public double calPerimeter(){
		return 2*Math.PI*rad;
	}

}
