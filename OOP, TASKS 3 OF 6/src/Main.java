import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        solutionsMain();
        findZipMain();
        checkPerfect();
        flipEndCharsMain();
        isValidHexCodeMain();
        sameMain();
        isKaprekarMain();
        longestZeroMain();
        nextPrimeMain();
        rightTriangleMain();




    }

    public static void solutionsMain(){
        System.out.println("@Task 1@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a,b,c separated by space"); // Ввод s
        String s = in.nextLine();
        System.out.println("The equation has " + solutions(s) + " solution/solutions");
    }

    public static int solutions(String s){
        String [] arr = (s.split(" ")); // С помощью метода split разбиваем строку s на элементы, которые разделены друг от друга пробелами и их записываем в массив arr
        double a = Integer.parseInt(arr[0]);
        double b = Integer.parseInt(arr[1]);
        double c = Integer.parseInt(arr[2]);
        double D = b*b - 4*a*c;
        if (D>0)
            return 2;
        else if (D == 0)
            return 1;
        else
            return 0;
    }

    public static void findZipMain(){
        System.out.println("@Task 2@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string"); // Ввод s
        String s = in.nextLine();
        System.out.println("position of the second occurrence of \"zip\" in the string - " + findZip(s));
    }

    public static int findZip(String s){
        int z = -1;
        int p = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            if (s.charAt(i) == 'z' && s.charAt(i + 1) == 'i' && s.charAt(i + 2) == 'p')
                p++;
            if (p == 2) {
                z = i;
                break;
            }
        }
        return z;
    }

    public static void checkPerfect(){
        System.out.println("@Task 3@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number"); // Ввод value
        int num = in.nextInt();
        System.out.println(checkPerfect(num));
    }

    public static boolean checkPerfect(int num){
        int sum = 0;
        for (int i = 1; i< num; i++){
            if (num%i == 0)
                sum += i;
        }
        if (sum == num)
            return true;
        else
            return false;
    }

    public static void flipEndCharsMain(){
        System.out.println("@Task 4@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string"); // Ввод s
        String s = in.nextLine();
        System.out.println(flipEndChars(s));
    }

    public static String flipEndChars(String s){
        char []charS = s.toCharArray();
        if (charS.length<3)
            return "Incompatible";
        else if (charS[0] == charS[charS.length - 1])
            return "Two's a pair";
        else{
            char firstChar = charS[0];
            charS[0] = charS[charS.length - 1];
            charS[charS.length - 1] = firstChar;
            return new String(charS);
        }
    }

    public static void isValidHexCodeMain(){
        System.out.println("@Task 5@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string"); // Ввод s
        String s = in.nextLine();
        System.out.println(isValidHexCode(s));
    }

    public static boolean isValidHexCode(String s){
        int count = 0;
        s = s.toUpperCase();
        if (s.charAt(0) == '#' && s.length() == 7) {
            for (int i = 1; i < s.length(); i++)
                if (!((int) s.charAt(i) < 48 || (int) s.charAt(i) > 70 || ((int) s.charAt(i) > 57 && (int) s.charAt(i) < 64)))
                    count++;
        }
        if (count==6)
            return true;
        else
            return false;
    }

    public static void sameMain(){
        System.out.println("@Task 6@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first array"); // Ввод
        String s1 = in.nextLine();
        System.out.println("Enter the second array"); // Ввод
        String s2 = in.nextLine();
        System.out.println(same(s1,s2));

    }

    public static boolean same(String s1, String s2){
        String [] arr1 = (s1.split(" ")); // С помощью метода split разбиваем строку s на элементы, которые разделены друг от друга пробелами и их записываем в массив arr
        String [] arr2 = (s2.split(" ")); // С помощью метода split разбиваем строку s на элементы, которые разделены друг от друга пробелами и их записываем в массив arr
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i<arr1.length; i++)
            for (int j = arr1.length - 1; j > i; j--) {
                if (arr1[i].equals(arr1[j])) {
                    sum1++;
                    break;
                }
            }
        for (int i = 0; i<arr2.length; i++)
            for (int j = arr2.length - 1; j > i; j--) {
                if (arr2[i].equals(arr2[j])) {
                    sum2++;
                    break;
                }
            }
        if ((arr1.length - sum1) == (arr2.length - sum2))
            return true;
        else
            return false;
    }

    public static void isKaprekarMain(){
        System.out.println("@Task 7@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number to check"); // Ввод
        int num = in.nextInt();
        System.out.println(isKaprekar(num));
    }

    public static boolean isKaprekar(int num){
        int num_length = 1;
        int num_square = num*num;
        String str_square = Integer.toString(num_square);
        String rst_half = "";
        String lst_half = "";
        while ((num_square /= 10) !=0) {
            num_length++;
        }
        System.out.println(num_length);
        if (num_length % 2 == 0){
            rst_half = str_square.substring(0,num_length/2);
            lst_half = str_square.substring(num_length/2);
        }
        else {
            rst_half = str_square.substring(0,num_length/2);
            lst_half = str_square.substring(num_length/2);
        }
        if (num == 1)
            return true;
        else if (num == 2 || num == 3)
            return false;
        else if (Integer.parseInt(rst_half) + Integer.parseInt(lst_half) == num)
            return true;
        else
            return false;
    }
    public static void longestZeroMain(){
        System.out.println("@Task 8@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number to check"); // Ввод
        String num = in.nextLine();
        System.out.println(longestZero(num));
    }
    public static String longestZero(String num) {
        int max = 0;
        int g = 0;
        String zero_str = "";
        for (int i = 0 ; i < num.length();i++) {
            if (num.charAt(i) == '0') {
                g++;
                if (g > max)
                    max = g;
            }
            else
                g = 0;
        }
        for (int i = 0; i < max; i++){
            zero_str += 0;
        }
        return zero_str;
    }

    public static void nextPrimeMain(){
        System.out.println("@Task 9@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number to check"); // Ввод
        int num = in.nextInt();
        System.out.println(nextPrime(num));
    }

    public static int nextPrime(int num){
        boolean k = true; // Описание переменной k. Если k = true, то число n является простым
        for (int i = 2; i< num;i++) { // Цикл от 2 до n
            if (num % i == 0) // Проверка, делится ли n нацело на какое-либо число от 2 до n-1.
                k = false; // При истинности условия k принимает значение false. Это значит, что число n НЕ является простым
        }
        if (k){
            return num;
        }
        else{
            while (!k){
                num++;
                k = true;
                for (int i = 2; i< num;i++)
                    if (num % i == 0) // Проверка, делится ли n нацело на какое-либо число от 2 до n-1.
                        k = false; // При истинности условия k принимает значение false. Это значит, что число n НЕ является простым
            }
            return num;
            }

        }

        public static void rightTriangleMain(){
            System.out.println("@Task 10@");
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the xyz coordinates separated by space"); // Ввод
            String xyz = in.nextLine();
            System.out.println(rightTriangle(xyz));
        }

        public static boolean rightTriangle(String xyz){
            String [] coord = (xyz.split(" "));
            int x = Integer.parseInt(coord[0]);
            int y = Integer.parseInt(coord[1]);
            int z = Integer.parseInt(coord[2]);
            if ((x*x+y*y == z*z) || (x*x+z*z == y*y) || (z*z+y*y == x*x))
                return true;
            else
                return false;
        }

}