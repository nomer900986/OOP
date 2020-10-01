import java.util.Scanner;

public class TriArea{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in); // Создание объекта класса Scanner для считывания чисел, которые будет вводить пользователь
        System.out.println("Enter the base of the triangle"); // Ввод основания треугольника
        double a = in.nextDouble();
        System.out.println("Enter the height of the triangle"); // Ввод высоты треугольника
        double h = in.nextDouble();
        System.out.println("Area of the triangle = "+ triArea(a,h)); // Находится и выводится площадь с помощью метода triArea
    }

    public static double triArea(double a, double h){ // Метод, принимающий основание и высоту треугольника и возвращающий его площадь
        double s = a*h*1/2; // Вычисление площади по формуле
        return s;
    }

}