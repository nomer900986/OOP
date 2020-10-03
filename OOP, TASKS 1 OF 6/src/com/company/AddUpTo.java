import java.util.Scanner;

public class AddUpTo{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in); // Создание объекта класса Scanner для считывания чисел, которые будет вводить пользователь
        System.out.println("Enter a number"); // Ввод числа, для которого будет вычисляться сумма всех чисел до него, включая его.
        int N = in.nextInt();
        System.out.println("Sum of the arithmetic progression - " + addUpTo(N)); // Находится и выводится сумма всех чисел до N с помощью метода addUpTo
    }

    public static int addUpTo(int N){ // Метод, вычисляющий сумму чисел до N
        int sum = 0; // Описывается переменная, которая будет отвечать за сумму
        for (int i = 1; i<=N;i++) // Цикл от 1 до N
            sum += i; // К sum прибавляется каждое значение i до N
        return sum;
    }
}