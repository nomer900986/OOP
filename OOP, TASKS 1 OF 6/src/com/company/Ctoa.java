import java.util.Scanner;

public class Ctoa{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in); // Создание объекта класса Scanner для считывания чисел, которые будет вводить пользователь
        System.out.println("Enter symbol"); // Ввод символа
        String symb = in.next();
        System.out.println("Index in ASCII - " + ctoa(symb)); // Находится и выводится индекс введенного символа в таблице ASCII с помощью метода ctoa
    }

    public static int ctoa(String symb){ // Метод, который находит индекс введенного символа в таблице ASCII
        int ascii = (int) (symb.charAt(0)); // Явно преобразовывается символ строки в int, тем самым мы получаем индекс в таблице ASCII
        return ascii;
    }
}