import java.util.ArrayList;
import java.util.Scanner;

public class  Main {

    public static void main(String[] args) {
        bessieMain();
        splitMain();
        casesMain();
        overTimeMain();
        bmiMain();
        buggerMain();
        toStarShorthandMain();
        doesRhymeMain();
        troubleMain();
        countUniqueBooksMain();
    }

    public static void bessieMain() {
        Scanner sc = new Scanner(System.in);
        Scanner scS = new Scanner(System.in);
        System.out.println("@Task 1@");
        System.out.println("Enter the number of words");
        int numWords = sc.nextInt();
        System.out.println("Enter the number of characters");
        int numChars = sc.nextInt();
        System.out.println("Enter the string");
        String s = scS.nextLine();
        System.out.println(bessie(numWords, numChars, s));
    }

    public static String bessie(int numWords, int numChars, String s) {
        String[] arrS = s.split(" ");
        s = "";
        String resS = "";
        for (int i = 0; i < numWords; i++) {
            if (s.length() + arrS[i].length() > numChars) {
                resS = resS.trim() + "\r\n" + arrS[i] + " ";
                s = arrS[i];
            } else {
                resS += arrS[i] + " ";
                s += arrS[i];
            }
        }
        return resS;
    }

    public static void splitMain(){
        System.out.println();
        System.out.println("@Task 2@");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = sc.nextLine();
        System.out.println(split(s));
    }

    public static String split(String s){
        String resS = "";
        ArrayList<String> listS = new ArrayList<String>();
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                counter++;
            else
                counter--;
            resS += s.charAt(i);
            if (counter == 0) {
                listS.add(resS);
                resS = "";
            }
        }
        return listS.toString();
    }

    public static void casesMain(){
        System.out.println();
        System.out.println("@Task 3@");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the snake_case string");
        String camelS = sc.nextLine();
        System.out.println("Enter the camelCase string");
        String snakeS = sc.nextLine();
        System.out.println("Result of function toCamelCase: " + toCamelCase(camelS));
        System.out.println("Result of function toSnakeCase: " +toSnakeCase(snakeS));
    }

    public static String toCamelCase(String camelS){
        String [] arrS = camelS.split("_");
        camelS = arrS[0];
        for (int i = 1; i < arrS.length; i++)
            camelS += Character.toUpperCase(arrS[i].charAt(0)) + arrS[i].substring(1,arrS[i].length());
        return camelS;
    }

    public static String toSnakeCase(String snakeS){
        int prevIndex = 0;
        String resS = "";
        for (int i = 0; i < snakeS.length(); i++){
            if (Character.isUpperCase(snakeS.charAt(i))) {
                resS = snakeS.substring(prevIndex, i) + "_" + snakeS.charAt(i);
                prevIndex = i;
            }
            else
                resS += snakeS.charAt(i);
        }
        return resS.toLowerCase();
    }

    public static void overTimeMain(){
        System.out.println();
        System.out.println("@Task 4@");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data in the line separated by a space");
        String s = sc.nextLine();
        System.out.println("$"+String.format("%.2f",overTime(s)));
    }

    public static double overTime(String s){
        String [] arrS = s.split(" ");
        double [] sDouble = new double[arrS.length];
        double sum = 0;
        for (int i = 0; i < arrS.length; i++)
            sDouble[i] = Double.parseDouble(arrS[i]);
        if (sDouble[1] <=17)
            sum = (sDouble[1] - sDouble[0])*sDouble[2];
        else
            sum = (sDouble[1] - 17)*sDouble[2]*sDouble[3] + (17 - sDouble[0])*sDouble[2];
        return sum;
    }

    public static void bmiMain(){
        System.out.println();
        System.out.println("@Task 5@");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the weight");
        String weight = sc.nextLine();
        System.out.println("Enter the height");
        String height = sc.nextLine();
        System.out.println(bmi(weight, height));
    }

    public static String bmi(String weight, String height){
        double weightD = Double.parseDouble(weight.split(" ")[0]);
        double heightD = Double.parseDouble(height.split(" ")[0]);
        String res = "";
        if (weight.contains("pounds"))
            weightD *= 0.45;
        if (height.contains("inches"))
            heightD *= 0.0254;
        double bmi = Math.round((weightD / (heightD * heightD)) * 10.0) / 10.0;
        if (bmi < 18.5)
            res = bmi + " Underweight";
        if (bmi >= 18.5 && bmi <= 24.9)
            res = bmi + " Normal weight";
        if (bmi > 25)
            res = bmi + " Overweight";
        return res;
    }

    public static void buggerMain(){
        System.out.println();
        System.out.println("@Task 6@");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = sc.nextInt();
        System.out.println(bugger(num));
    }

    public static int bugger(int num){
        int count = 0;
        int number = num;
        while (number > 9) {
            int chnum = 1;
            while (number > 0) {
                chnum *= number % 10;
                number /= 10;
            }
            number = chnum;
            count++;
        }
        return count;
    }

    public static void toStarShorthandMain(){
        System.out.println();
        System.out.println("@Task 7@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string"); // Ввод s
        String s = in.nextLine();
        System.out.println(toStarShorthand(s));
    }

    public static String toStarShorthand(String s){
        String res_s = "";
        int counter = 0;
        s += "0";
        while (counter + 1 != s.length()){
            int count = 1;
            for (int j = counter + 1; j<s.length(); j++){
                if (s.charAt(counter) == s.charAt(j)){
                    count++;
                    if (s.charAt(j+1) != '0') {
                        if (s.charAt(j) != s.charAt(j + 1)) {
                            res_s += s.charAt(counter) + "*" + count;
                            counter += count;
                            break;
                        }
                    }
                    else {
                            res_s += s.charAt(counter) + "*" + count;
                            counter += count;
                            break;
                        }
                }
                else {
                    res_s += s.charAt(counter);
                    counter++;
                    break;
                }
            }
        }
        return res_s;
    }

    public static void doesRhymeMain(){
        System.out.println();
        System.out.println("@Task 8@");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string");
        String s1 = sc.nextLine();
        System.out.println("Enter the second string");
        String s2 = sc.nextLine();
        System.out.println(doesRhyme(s1,s2));
    }

    public static boolean doesRhyme(String s1, String s2){
        s1 = s1.substring(s1.lastIndexOf(" ") + 1).toLowerCase();
        s2 = s2.substring(s2.lastIndexOf(" ") + 1).toLowerCase();
        String let = "aeiouy";
        String res1 = "", res2 = "";
        for (int i = 0; i < s1.length(); i++) {
            if (let.indexOf(s1.charAt(i)) != -1)
                res1 += s1.charAt(i);
        }
        for (int i = 0; i < s2.length(); i++) {
            if (let.indexOf(s2.charAt(i)) != -1)
                res2 += s2.charAt(i);
        }
        return res1.equals(res2);
    }

    public static void troubleMain(){
        System.out.println();
        System.out.println("@Task 9@");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number");
        String num1 = sc.nextLine();
        System.out.println("Enter the second number");
        String num2 = sc.nextLine();
        System.out.println(trouble(num1,num2));
    }

    public static boolean trouble(String num1, String num2){
        int num = 0;
        for (int i = 2; i < num1.length(); i++) {
            if (num1.charAt(i) == num1.charAt(i - 1) && num1.charAt(i) == num1.charAt(i - 2))
                num = num1.charAt(i);
        }
        for (int i = 0; i < num2.length(); i++) {
            if (num2.charAt(i) == num && num2.charAt(i + 1) == num)
                return true;
        }
        return false;
    }

    public static void countUniqueBooksMain(){
        System.out.println();
        System.out.println("@Task 10@");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the stringSequence"); // Ввод s
        String s = in.nextLine();
        System.out.println();
        System.out.println("Enter the bookEnd"); // Ввод s
        String ch = in.nextLine();
        System.out.println();
        System.out.println(countUniqueBooks(s,ch));

    }

    public static int countUniqueBooks(String s, String ch){
        String new_s = "";
        int counter = 0;
        int index = 0;
        for (int i = 0; i<s.length(); i++)
            if (s.charAt(i) == ch.charAt(0))
                counter++;
        for (int i = 0; i<counter/2; i++) {
                index = s.indexOf(ch, index);
                int nextIndex = s.indexOf(ch, index + 1);
                new_s += s.substring(index+1, nextIndex);
                index = s.indexOf(ch, nextIndex + 1);
        }
        counter = 0;
        boolean[] isItThere = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < new_s.length(); i++) {
            isItThere[new_s.charAt(i)] = true;
        }
        for (int i = 0; i < isItThere.length; i++) {
            if (isItThere[i]){
                counter++;
            }
        }
        return counter;
    }
}