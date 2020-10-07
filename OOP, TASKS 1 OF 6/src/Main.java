import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        remaindermain();
        triAreamain();
        animalsmain();
        profitableGamblemain();
        opereationmain();
        ctoamain();
        addUpTomain();
        nextEdgemain();
        sumOfCubesmain(args);
        abcmathmain();
    }

    public static void remaindermain() {
        System.out.println("Task 1");
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

    public static void triAreamain(){
        System.out.println("Task 2");
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

    public static void animalsmain(){
        System.out.println("Task 3");
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

    public static void profitableGamblemain(){
        System.out.println("Task 4");
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

    public static void opereationmain(){
        System.out.println("Task 5");
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

    public static void ctoamain(){
        System.out.println("Task 6");
        Scanner in = new Scanner(System.in); // Создание объекта класса Scanner для считывания чисел, которые будет вводить пользователь
        System.out.println("Enter symbol"); // Ввод символа
        String symb = in.next();
        System.out.println("Index in ASCII - " + ctoa(symb)); // Находится и выводится индекс введенного символа в таблице ASCII с помощью метода ctoa
    }

    public static int ctoa(String symb){ // Метод, который находит индекс введенного символа в таблице ASCII
        int ascii = (int) (symb.charAt(0)); // Явно преобразовывается символ строки в int, тем самым мы получаем индекс в таблице ASCII
        return ascii;
    }

    public static void addUpTomain(){
        System.out.println("Task 7");
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

    public static void nextEdgemain(){
        System.out.println("Task 8");
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

    public static void sumOfCubesmain(String[] stringMas) {
        System.out.println("Task 9");
        System.out.println("Sum of cubes of array elements - " + sumOfCubes(stringMas)); // Находится и выводится сумма кубов введенных элементов с помощью метода sumOfCubes
    }

    public static int sumOfCubes(String[] mas) { // Метод, который принимает введенный строковый массив и находит сумму кубов его элементов
        int sum = 0; // Описывается перменная, отвечающая за сумму
        for (int i = 0;i<mas.length;i++) { // Цикл от 0 до кол-ва введенных чисел
            sum += Math.pow(Integer.parseInt(mas[i]), 3); // Элемент с индексом i преобразовывается в int, возводится в 3 степень и добавляется к sum
        }
        return sum;
    }

    public static void abcmathmain(){
        System.out.println("Task 10");
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

