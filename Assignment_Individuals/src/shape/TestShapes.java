package shape;

import java.util.Scanner;

public class TestShapes {

	
	public static void main(String[] args) {
		Scanner scn=new Scanner (System.in);
		char choice;
		do{
			System.out.println(" ====the shapes===");
			System.out.println(" 1.Rectangle");
			System.out.println(" 2.Circle");
			System.out.println(" 3.Square");
			System.out.println(" 4.Triangle");
			System.out.print(" select shape:");
			
			int choose=scn.nextInt();
			
			switch(choose){
			case 1:
				System.out.println(" enter length");
				double len=scn.nextDouble();
				System.out.println(" enter width");
				double wid=scn.nextDouble();
				Rctangle nn=new Rctangle (len,wid);
				System.out.println(" what would you like to calculate");
				System.out.println(" 1.Area");
				System.out.println(" 2.Perimeter");
				System.out.println(" your choice:");
				int  ent=scn.nextInt();
				if(ent==1){
					System.out.println("area of rectangle:"+nn.calArea());
					
				}
				else if(ent==2){
					System.out.println("Perimeter of rectangle:"+nn.calPerimeter());
				}
				else{
					System.out.println("invalid selection");
				}
				
				break;
			case 2:
				System.out.println(" enter Radius");
				double rr=scn.nextDouble();
				Circle yy=new Circle(rr);
				
				System.out.println(" what would you like to calculate");
				System.out.println(" 1.Area");
				System.out.println(" 2.Perimeter");
				System.out.println(" your choice:");
				int ent2=scn.nextInt();
				if(ent2==1){
					System.out.println("area of circle:"+yy.calArea());
					
				}
				else if(ent2==2){
					System.out.println("Perimeter of circle:"+yy.calPerimeter());
				}
				else{
					System.out.println("invalid selection");
				}
				
				
				break;
			case 3:
				System.out.println(" enter the Side");
				double sd=scn.nextDouble();
				Square jj=new Square(sd);
				System.out.println(" what would you like to calculate");
				System.out.println(" 1.Area");
				System.out.println(" 2.Perimeter");
				System.out.println(" your choice:");
				
				int ent3=scn.nextInt();
				if(ent3==1){
					System.out.println("area of square:"+jj.calArea());
					
				}
				else if(ent3==2){
					System.out.println("Perimeter of square:"+jj.calPerimeter());
				}
				else{
					System.out.println("invalid selection");
				}
				
				break;
			case 4:
				System.out.println("enter Base");
				double bs=scn.nextDouble();
				System.out.println("enter Height");
				double ht=scn.nextDouble();
				
				Triangle ny=new Triangle(bs,ht);
				System.out.println(" what would you like to calculate");
				System.out.println(" 1.Area");
				System.out.println(" 2.Perimeter");
				System.out.println(" your choice:");
				
				int ent4=scn.nextInt();
				if(ent4==1){
					System.out.println("area of triangle:"+ny.calArea());
					
				}
				else if(ent4==2){
					System.out.println("Perimeter of Triangle:"+ny.calPerimeter());
				}
				else{
					System.out.println("invalid selection");
				}
				break;
			default:
				
				System.out.println("invalid selection");
				break;
			}
			System.out.print("would you like to continue? (y/n)");
			
			choice=scn.next().charAt(0);
		}
			
			while(choice=='y');
		scn.close();
		
		}

	

}
