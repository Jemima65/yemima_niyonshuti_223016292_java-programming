package shape;

public class Square {

	private double side;

	public Square(double side) {
		super();
		this.side = side;
	}
	public double calArea(){
		return side*side;
	}
	public double calPerimeter(){
		return side*4;
	}

}
