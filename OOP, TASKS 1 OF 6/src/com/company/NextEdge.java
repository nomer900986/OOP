import java.util.Scanner;

public class NextEdge{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in); // Создание объекта класса Scanner для считывания чисел, которые будет вводить пользователь
        System.out.println("Enter the first side of the triangle"); // Ввод первой стороны треугольника
        int s1 = in.nextInt();
        System.out.println("Enter the second side of the triangle"); // Ввод второй стороны треугольника
        int s2 = in.nextInt();
        System.out.println("The maximum value of the third side " + nextEdge(s1,s2)); // Находится и выводится максимальное значение третьей стороны с помощью метода nextEdge
    }

    public static int nextEdge(int s1, int s2){ // Метод, вычисляющий максимальное значение третьей стороны треугольника
        int s3 = s1 + s2 - 1; // Вычисляется макс. знач. третьей стороны по формуле
        return s3;
    }
}