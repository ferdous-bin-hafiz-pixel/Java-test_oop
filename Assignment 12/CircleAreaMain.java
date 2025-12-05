import java.util.Scanner;

public class CircleAreaMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius of the circle: ");
        double r = sc.nextDouble();

   
        Circle circle = new Circle(r);


        System.out.println("Radius: " + circle.getRadius());


        System.out.println("Area of Circle = " + circle.computeArea());
    }
}
