import java.util.Scanner;

public class Remainder {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Создание объекта класса Scanner для считывания чисел, которые будет вводить пользователь
        System.out.println("Input the first number"); // Ввод n
        int n = in.nextInt();
        System.out.println("Input the second number"); // Ввод m
        int m = in.nextInt();
        System.out.println("Remainder of division = "+remainder(n,m)); // Находится и выводится остаток от деления с помощью метода remainder
    }

    public static int remainder(int n, int m){ // Метод, который принимает числа n и m и возвращается остаток от деления
        return n%m;
    }
}