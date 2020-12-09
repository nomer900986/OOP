import java.time.chrono.IsoChronology;
import java.util.Arrays;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        repeatMain();
        differenceMaxMinMain();
        isAvgWholeMain();
        cumulativeSumMain();
        getDecimalPlacesMain();
        fibonacciMain();
        isValidMain();
        isStrangePairMain();
        isSuffixPrefixMain();
        boxSeqMain();
    }

    //public static Scanner in = new Scanner(System.in); // Создание объекта класса Scanner для считывания чисел, которые будет вводить пользователь

    public static void repeatMain(){ // Метод, отвечающий за ввод/вывод для первого задания
        System.out.println("@Task 1@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string"); // Ввод s
        String s = in.next();
        System.out.println("Enter n"); // Ввод n
        int n = in.nextInt();
        System.out.println("Changed string: " + repeat(s,n)); // С помощью метода repeat производятся действия над строкой, а после производится вывод
    }

    public static String repeat(String s, int n){ // Метод, отвечающий за вычисления для первого задания
        String newS = new String(); // Описывается результирующая строка
        for (int i = 0; i<s.length();i++) // Цикл от 0 до кол-ва эл-ов в исходной строке
            for (int j = 0; j<n; j++) // Цикл от 0 до кол-ва повторений символа в строке
            newS += s.charAt(i); // В новую строку n раз записывается i-ый символ
        return newS;
    }

    public static void differenceMaxMinMain(){
        System.out.println();
        System.out.println("@Task 2@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the array elements separated by a space");
        String s = in.nextLine();
        System.out.println("The difference between the maximum and minimum elements = "+ differenceMaxMin(s));
    }

    public static int differenceMaxMin(String s){
        String [] arr = (s.split(" ")); // С помощью метода split разбиваем строку s на элементы, которые разделены друг от друга пробелами и их записываем в массив arr
        int[] arrInt = new int[arr.length]; // Описывается массив типа int, длиной равной кол-ву элементов arr, для последующей записи в него преобразованного массива arr
        for (int i = 0; i<arr.length;i++){ // Цикл для преобразования элементов массива в int
           arrInt[i] = Integer.parseInt(arr[i]); // Преобразование массива arr в int и запись в arrInt
        }
        int min = arrInt[0]; // Задаётся начальное значение минимума
        int max = arrInt[0]; // Задаётся начальное значение максимума
        for (int i = 1; i<arrInt.length;i++){ // Цикл для поиска максимума и минимума
            if (arrInt[i]>max) // Если текущий элемент больше максимума
                max = arrInt[i]; // Максимум равен текущему элементу
            if (arrInt[i]<min) // Если текущий элемент меньше минимума
                min = arrInt[i]; // Минимум равен текущему элементу
        }
        System.out.println("//Smallest number is " + min + ", biggest is " + max); // Вывод сообщения с максимальным и минимальным значением
        return (max - min); // Вывод разности максимального и минимального эл-та
    }

    public static void isAvgWholeMain(){
        System.out.println();
        System.out.println("@Task 3@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the array elements separated by a space");
        String s = in.nextLine();
        System.out.println("The average value of all array elements is an integer? Result: " + isAvgWhole(s));
    }

    public static boolean isAvgWhole(String s){
        int sum = 0;
        String [] arr = (s.split(" ")); // С помощью метода split разбиваем строку s на элементы, которые разделены друг от друга пробелами и их записываем в массив arr
        int[] arrInt = new int[arr.length]; // Описывается массив типа int, длиной равной кол-ву элементов arr, для последующей записи в него преобразованного массива arr
        for (int i = 0; i<arr.length;i++){ // Цикл для преобразования элементов массива в int
            arrInt[i] = Integer.parseInt(arr[i]); // Преобразование массива arr в int и запись в arrInt
        }
        for (int i = 0; i<arrInt.length;i++){ // Цикл для нахождения суммы элементов
            sum += arrInt[i]; // Прибавление к sum значение текущего элемента
        }
        if (sum % arrInt.length == 0) // Проверка, делится ли нацело сумма на кол-во элементов
            return true;
        else
            return false;

    }

    public static void cumulativeSumMain(){
        System.out.println();
        System.out.println("@Task 4@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the array elements separated by a space");
        String s = in.nextLine();
        System.out.println("Resulting array: "+cumulativeSum(s));
    }

    public static String cumulativeSum(String s){
        String [] arr = (s.split(" ")); // С помощью метода split разбиваем строку s на элементы, которые разделены друг от друга пробелами и их записываем в массив arr
        int[] arrInt = new int[arr.length]; // Описывается массив типа int, длиной равной кол-ву элементов arr, для последующей записи в него преобразованного массива arr
        for (int i = 0; i<arr.length;i++){ // Цикл для преобразования элементов массива в int
            arrInt[i] = Integer.parseInt(arr[i]); // Преобразование массива arr в int и запись в arrInt
        }
        for (int i = arrInt.length-1; i>0;i--) // Убывающий цикл от последнего элемента до второго
            for (int j = 0; j<i;j++){ // Цикл от 0 до текущего элемента во внешнем цикле
                arrInt[i] += arrInt[j]; // В текущий элемент по i прибавляются элементы с индексами от 0 до j
            }
        return Arrays.toString(arrInt);
    }

    public static void getDecimalPlacesMain(){
        System.out.println();
        System.out.println("@Task 5@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number");
        String s = in.nextLine();
        System.out.println("Number of decimal places: " + getDecimalPlaces(s));
    }

    public static int getDecimalPlaces(String s){
        int count = 0; // Описываем переменную-счётчик
        for (int i = s.indexOf(",")+1; i<s.length();i++) // Цикл от индекса запятой + 1 до кол-ва эл-тов массива
            count += 1;
        return count;
    }

    public static void fibonacciMain(){
        System.out.println();
        System.out.println("@Task 6@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the index of the number in the Fibonacci sequence");
        int index = in.nextInt();
        System.out.println("Element with index " + index + " = " + fibonacci(index));
    }

    public static int fibonacci(int index){
        int[] fibArr = new int[index+1]; // Описываем целочисленный массив с кол-вом элементов, равным введенному индексу
        fibArr[0] = 1; // Описывается нулевой эл-т последовательности
        fibArr[1] = 1; // Описывается первый элемент последовательности
        for (int i = 2; i<=index; i++) // Цикло от 2 до введенного индекса
            fibArr[i] = fibArr[i-1] + fibArr[i-2]; // К i-ому прибавляются два предыдущих числа
        return fibArr[index];
    }

    public static void isValidMain(){
        System.out.println();
        System.out.println("@Task 7@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your zip code");
        String s = in.nextLine();
        System.out.println("Is the number a zip code? " + isValid(s));
    }

    public static boolean isValid(String s){
        boolean z = true; // Описываем переменную, которая будет отвечать за результат
        if ((s.length()!=5) || (s.indexOf(" ") != -1)) // Если кол-во не равно 5 и в строке имеется пробел
            z = false; // Результат false
        for (int i = 0; i<5; i++) { // Цикл от нуля до 5 для проверки каждого символа строки
            if (Character.isDigit(s.charAt(i)) == false) // Если i-ый символ не является числом
                z = false; // Результат false
        }
        return z;
    }

    public static void isStrangePairMain(){
        System.out.println();
        System.out.println("@Task 8@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two lines separated by commas");
        String s = in.nextLine();
        System.out.println("Are the lines strange lines? "+isStrangePair(s));
    }

    public static boolean isStrangePair(String s){
        String [] arr = (s.split(", ")); // С помощью метода split разбиваем строку s на элементы, которые разделены друг от друга запятой с пробелом и их записываем в массив arr
        if (arr[0] == "" && arr[1] == "")
            return true;
        else if ((arr[0].charAt(0)==arr[1].charAt(arr[1].length()-1)) && (arr[0].charAt(arr[0].length()-1)==arr[1].charAt(0))) // Проверка условия странности строки
            return true;
        else if ((arr[0].length()==0) || (arr[1].length()==0))
            return false;
        else
            return false;
    }

    public static void isSuffixPrefixMain(){
        System.out.println();
        System.out.println("@Task 9@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the word and prefix separated by space");
        String s = in.nextLine();
        System.out.println(isPrefix(s));
        System.out.println("Enter the word and suffix separated by space");
        s = in.nextLine();
        System.out.println(isSuffix(s));
    }

    public static boolean isPrefix(String s){
        String [] arr = (s.split(", ")); // С помощью метода split разбиваем строку s на элементы, которые разделены друг от друга запятой с пробелом и их записываем в массив arr
        arr[1] = arr[1].replaceAll("-",""); // Убираем из второй строки знак -
        if (arr[0].indexOf(arr[1])==0) // Если индекс вхождения второй строки в первую равен нулю
            return true; // Возвращаем true
        else
            return false; // В любом другом случае - false
    }

    public static boolean isSuffix(String s){
        String [] arr = (s.split(", ")); // С помощью метода split разбиваем строку s на элементы, которые разделены друг от друга запятой с пробелом и их записываем в массив arr
        arr[1] = arr[1].replaceAll("-","");
        if (arr[0].indexOf(arr[1])==(arr[0].length() - arr[1].length())) // Если индекс вхождения второй строки в первую равен разности длин этих строк (т.е первая строка заканчивается второй)
            return true; // Возвращаем true
        else
            return false; // В любом другом случае - false
    }

    public static void boxSeqMain(){
        System.out.println();
        System.out.println("@Task 10@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the step number");
        int step = in.nextInt();
        System.out.println("Number of fields in step "+step+" = "+ boxSeq(step));
    }

    public static int boxSeq(int step){
        int sum = 0; // Описываем переменную, отвечающую за сумму
        for (int i = 0; i<step; i++){ // Цикл от 0 до полученного шага, если шаг = 0, то цикл не запускается
            if (i%2==0) // Если i четное (шаг при этом нечетный)
                sum+= 3; // Прибавляем 3
            else
                sum-=1;
        }
        return sum;

    }






}