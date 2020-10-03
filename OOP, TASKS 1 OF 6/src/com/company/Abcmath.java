import java.util.Scanner;

public class Abcmath{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in); // Создание объекта класса Scanner для считывания чисел, которые будет вводить пользователь
        System.out.println("Enter A"); // Ввод A
        int A = in.nextInt();
        System.out.println("Enter B"); // Ввод B
        int B = in.nextInt();
        System.out.println("Enter C"); // Ввод C
        int C = in.nextInt();
        System.out.println("Result is "+ abcmath(A,B,C)); // Находится и выводится результат с помощью метода abcmath
    }

    public static boolean abcmath(int A, int B, int C){ // Метод, отвечающий за решение задачи
        for (int i = 0; i<B; i++){ // Цикл от 0 до B, в результате которого A прибавляется к себе B раз
            A += A; //
        }
        if (A%C==0) // Проверка, делится ли A на C
            return true;
        else
            return false;
    }
}