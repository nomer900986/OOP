import java.util.Scanner;

public class Operation{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in); // Создание объекта класса Scanner для считывания чисел, которые будет вводить пользователь
        System.out.println("Enter N"); // Ввод N
        int N = in.nextInt();
        System.out.println("Enter a"); // Ввод a
        int a = in.nextInt();
        System.out.println("Enter b"); // Ввод b
        int b = in.nextInt();
        System.out.println(operation(N,a,b)); // Находится и выводится необходимое действие над a и b для получения N с помощью метода operation
    }

    public static String operation(int N, int a, int b){ // Метод, который принимает N, a и b и выводит действие, которая нужно сделать с a и b для получения N
        String res = new String(); // Описывается строка, которая будет отвечать за ответ
        if (a+b==N) // Проверка, является ли сумма a и b числом N
            res = "added"; // Если да, то это действие записывается в переменную res
        else if (a-b==N) // Далее аналогично
            res = "subtracted";
        else if (a*b==N)
            res = "multiplied";
        else if (a/b==N)
            res = "divided";
        else
            res = "none";
        return res;
    }
}