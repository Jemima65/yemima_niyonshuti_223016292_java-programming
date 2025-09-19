package shape;

public class Triangle {
      private double base;
      private double height;
      private double hyp;
	public Triangle(double base, double height) {
		super();
		this.base = base;
		this.height = height;
		double result = (base * base) + (height * height);
		this.hyp = Math.sqrt(result);

	}
	public double calArea(){
		return (this.base*this.height)/2;
	}
      
	public double calPerimeter(){
		return this.base+this.height+ this.hyp;
	}
      

}
