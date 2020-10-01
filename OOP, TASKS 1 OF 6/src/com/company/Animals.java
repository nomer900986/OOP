import java.util.Scanner;

public class Animals{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in); // Создание объекта класса Scanner для считывания чисел, которые будет вводить пользователь
        System.out.println("Farmer, enter the number of chickens"); // Ввод количества куриц
        int numChick = in.nextInt();
        System.out.println("Farmer, enter the number of cows"); // Ввод количества коров
        int numCow = in.nextInt();
        System.out.println("Farmer, enter the number of pigs"); // Ввод количества свиней
        int numPig = in.nextInt();
        System.out.println("Number of legs of all animals = "+ animals(numChick,numCow,numPig)); // Находится и выводится количество ног с помощью метода animals
    }

    public static int animals(int numChick, int numCow, int numPig){ // Метод, принимающий кол-во каждого животного и возвращающий кол-во всех ног
        int legChick = 2; // Задается кол-во ног куриц
        int legCow = 4; // Задается кол-во ног коров
        int legPig = 4; // Задается кол-во ног свиней
        int animals = numChick*legChick + numCow*legCow + numPig*legPig; // Вычисляется количество ног всех животных
        return animals;
    }
}