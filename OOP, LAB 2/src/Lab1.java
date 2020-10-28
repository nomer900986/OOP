import java.util.Scanner;

public class Lab1{

    public static void main(String[]args){
        System.out.println("Enter the coordinates (x,y,z) of the FIRST point separated by a space");
        Scanner in = new Scanner(System.in);
        String [] xyz1 = (in.nextLine().split(" "));
        Point3d point1 = new Point3d(Double.parseDouble(xyz1[0]),Double.parseDouble(xyz1[1]),Double.parseDouble(xyz1[2]));
        System.out.println();
        System.out.println("Enter the coordinates (x,y,z) of the SECOND point separated by a space");
        String [] xyz2 = (in.nextLine().split(" "));
        Point3d point2 = new Point3d(Double.parseDouble(xyz2[0]),Double.parseDouble(xyz2[1]),Double.parseDouble(xyz2[2]));
        System.out.println();
        System.out.println("Enter the coordinates (x,y,z) of the THIRD point separated by a space");
        String [] xyz3 = in.nextLine().split(" ");
        Point3d point3 = new Point3d(Double.parseDouble(xyz3[0]),Double.parseDouble(xyz3[1]),Double.parseDouble(xyz3[2]));
        if (point1.compareVal(point2) || point2.compareVal(point3) || point3.compareVal(point1)) {
            System.out.println();
            System.out.println("Two or three points are equal");
        }
        else {
            System.out.println();
            System.out.println("Area of the triangle based on the entered points = " + computeArea(point1, point2, point3));
        }
    }

    public static double computeArea(Point3d obj1, Point3d obj2, Point3d obj3){
        double a = obj1.distanceTo(obj2);
        double b = obj2.distanceTo(obj3);
        double c = obj1.distanceTo(obj3);
        double p = (a + b + c) / 2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

}


