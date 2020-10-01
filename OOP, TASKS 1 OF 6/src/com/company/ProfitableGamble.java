import java.util.Scanner;

public class ProfitableGamble{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in); // Создание объекта класса Scanner для считывания чисел, которые будет вводить пользователь
        System.out.println("Enter the prob"); // Ввод prob
        double prob = in.nextDouble();
        System.out.println("Enter the prize"); // Ввод prize
        double prize = in.nextDouble();
        System.out.println("Enter the pay"); // Ввод pay
        double pay = in.nextDouble();
        System.out.println("Result is " + profitableGamble(prob,prize,pay)); // Находится и выводится результат выполнения метода profitableGamble
    }

    public static boolean profitableGamble(double prob, double prize, double pay){ // Метод, принимающий три аргумента и возвращающий в зависимости от них ответ
        if (prob*prize>pay) // Проверка заданного условия
            return true;
        else
            return false;
    }
}