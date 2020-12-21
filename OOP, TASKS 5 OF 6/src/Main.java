import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{

    public static void main(String [] args) throws NoSuchAlgorithmException{
        enDecMain("Hello", "72 33 -73 84 -12 -3 13 -13 -68");
        canMoveMain("Rook", "A8", "H8");
        canCompleteMain("butl", "beautiful");
        sumDigProdMain("1 2 3 4 5 6");
        sameVowelGroupMain("hoops chuff bot bottom");
        validateCardMain("4276380164144474");
        numToEngMain(126);
        getSha256HashMain("Fluffy@home");
        correctTitleMain("jOn SnoW, kINg IN thE noRth.");
        haxLatticeMain(19);
    }

    public static void enDecMain(String str, String sArr){
        System.out.println();
        System.out.println("@Task 1@");
        System.out.println("For string '" + str + "' result is: " + Arrays.toString(encrypt(str)));
        String a = decrypt(sArr);
        System.out.println("For array [" + sArr + "] string is: " + a);
    }

    public static int[] encrypt(String str) {
        int[] result = new int[str.length()];
        result[0] = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            result[i] = str.charAt(i) - str.charAt(i - 1);
        }
            return result;
    }

    public static String decrypt(String sArr) {
        String [] arrS = sArr.split(" ");
        int [] arr = new int[arrS.length];
        for (int i = 0; i < arrS.length; i++){
            arr[i] = Integer.parseInt(arrS[i]);
        }
        int[] encoded = new int[arr.length];
        System.arraycopy(arr, 0, encoded, 0, arr.length);
        char[] result = new char[arr.length];
        result[0] = (char) arr[0];
        for (int i = 1; i < arr.length; i++) {
            result[i] = (char) (encoded[i] + encoded[i - 1]);
            encoded[i] = encoded[i] + encoded[i - 1];
        }
        return new String(result);
    }

    public static void canMoveMain(String name, String start, String end){
        System.out.println();
        System.out.println("@Task 2@");
        System.out.println("For name - " + name + ", start - " + start + ", end - " + end + "\nResult - " + canMove(name, start, end));
    }

    public static boolean canMove(String name, String start, String end) {
        char startLetter = start.charAt(0);
        int startNumber = Integer.parseInt(String.valueOf(start.charAt(1)));
        char endLetter = end.charAt(0);
        int endNumber = Integer.parseInt(String.valueOf(end.charAt(1)));
        if (startLetter == endLetter && startNumber == endNumber) return false;
        switch (name) {
            case "Pawn": {
                if (startLetter == endLetter && startNumber == 2 && endNumber == 4)
                    return true;
                return startLetter == endLetter && endNumber == (startNumber + 1);
            }
            case "Knight": {
                return (Math.abs(startLetter - endLetter) == 2 && Math.abs(startNumber - endNumber) == 1) || (Math.abs(startLetter - endLetter) == 1 && Math.abs(startNumber - endNumber) == 2);
            }
            case "Bishop": {
                return Math.abs(startLetter - endLetter) == Math.abs(startNumber - endNumber);
            }
            case "Rook": {
                return (startLetter == endLetter && startNumber != endNumber) || (startLetter != endLetter && startNumber == endNumber);
            }
            case "Queen": {
                if ((startLetter == endLetter && startNumber != endNumber) || (startLetter != endLetter && startNumber == endNumber))
                    return true;
                if (Math.abs(startLetter - endLetter) == Math.abs(startNumber - endNumber))
                    return true;
                break;
            }
            case "King": {
                return Math.abs(startLetter - endLetter) < 2 && Math.abs(startNumber - endNumber) < 2;
            }
            default:
                return false;
        }
        return false;
    }

    public static void canCompleteMain(String str1, String str2){
        System.out.println();
        System.out.println("@Task 3@");
        System.out.println("For str1 - " + str1 + ", str2 - " + str2 + "\nResult - " + canComplete(str1,str2));
    }

    public static boolean canComplete(String str1, String str2) {
        char[] chars = str1.toCharArray();
        int startOfSearch = 0;
        for (char c : chars) {
            if (str2.indexOf(String.valueOf(c), startOfSearch) != -1)
                startOfSearch = str2.indexOf(String.valueOf(c), startOfSearch) + 1;
            else
                return false;
        }
        return true;
    }


    public static void sumDigProdMain(String sMass){
        System.out.println();
        System.out.println("@Task 4@");
        System.out.println("For sMass - " + sMass +  "\nResult - " + sumDigProd(sMass));
    }

    public static int sumDigProd(String sMass) {
        String [] massS = sMass.split(" ");
        int [] mass = new int[massS.length];
        for (int i = 0; i < mass.length; i++){
            mass[i] = Integer.parseInt(massS[i]);
        }
        int sum = 0;
        for (int value : mass) {
            sum += value;
        }
        while (sum > 9) {
            int mult = 1;
            while (sum > 0) {
                mult *= sum % 10;
                sum /= 10;
            }

            sum = mult;
        }
        return sum;
    }


    public static void sameVowelGroupMain(String str){
        System.out.println();
        System.out.println("@Task 5@");
        System.out.println("For str - " + str +  "\nResult - " + sameVowelGroup(str).toString());
    }

    public static ArrayList<String> sameVowelGroup(String str) {
        String[] strs = str.split(" ");
        String[] allVowels = new String[]{"a", "e", "y", "u", "i", "o"};
        String vowels = "";
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < allVowels.length; i++) {
            if (strs[0].contains(allVowels[i]) && !vowels.contains(allVowels[i])) {
                vowels += allVowels[i];
            }
        }
        if (vowels.length() > 0) {
            result.add(strs[0]);
        } else {
            return result;
        }
        for (int i = 1; i < strs.length; i++) {
            boolean pass = true;
            for (int j = 0; j < vowels.length(); j++) {
                if (!strs[i].contains(String.valueOf(vowels.charAt(j)))) {
                    pass = false;
                    break;
                }
            }
            if (pass) result.add(strs[i]);
        }
        return result;
    }

    public static void validateCardMain(String cardNum){
        System.out.println();
        System.out.println("@Task 6@");
        System.out.println("For cardNum - " + cardNum +  "\nResult - " + validateCard(cardNum));
    }

    public static boolean validateCard(String cardNum) {
        StringBuilder str = new StringBuilder();
        if (cardNum.length() >= 14 && cardNum.length() <= 19) {
            // step 1
            char lastNum = cardNum.charAt(cardNum.length()-1);
            StringBuilder cardNumStr = new StringBuilder(cardNum.substring(0,cardNum.length()-1));
            // step 2
            cardNumStr.reverse();
            // step 3
            for (int i = 0; i < cardNumStr.length(); i++) {
                if (i % 2 != 0) {
                    int c = Character.getNumericValue(cardNumStr.charAt(i)) * 2;

                    if (c > 9) {
                        String buf = Integer.toString(c);

                        str.append(Character.getNumericValue(buf.charAt(0)) + Character.getNumericValue(buf.charAt(1)));
                    } else {
                        str.append(c);
                    }
                } else {
                    str.append(cardNumStr.charAt(i));
                }
            }
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += Character.getNumericValue(str.charAt(i));
            }
            return Character.getNumericValue(lastNum) == ((10 - (sum % 10)) / 2);
        }
        else
            return false;
    }

    public static void numToEngMain(int num){
        System.out.println();
        System.out.println("@Task 7@");
        System.out.println("Num - " + num +  " in English - " + numToEng(num));
        System.out.println("Num - " + num +  " in Russian - " + numToRus(num));
    }

    public static String numToEng(int num) {
        String str = "";
        if (num == 0) return "zero";
        switch (num / 100) {
            case 1: {
                str += "one hundred ";
                break;
            }
            case 2: {
                str += "two hundred ";
                break;
            }
            case 3: {
                str += "three hundred ";
                break;
            }
            case 4: {
                str += "four hundred ";
                break;
            }
            case 5: {
                str += "five hundred ";
                break;
            }
            case 6: {
                str += "six hundred ";
                break;
            }
            case 7: {
                str += "seven hundred ";
                break;
            }
            case 8: {
                str += "eight hundred ";
                break;
            }
            case 9: {
                str += "nine hundred ";
                break;
            }
        }
        switch (num / 10 % 10) {
            case 1: {
                switch (num % 10) {
                    case 0: {
                        str += "ten";
                        return str;
                    }
                    case 1: {
                        str += "eleven";
                        return str;
                    }
                    case 2: {
                        str += "twelve";
                        return str;
                    }
                    case 3: {
                        str += "thirteen";
                        return str;
                    }
                    case 4: {
                        str += "fourteen";
                        return str;
                    }
                    case 5: {
                        str += "fifteen";
                        return str;
                    }
                    case 6: {
                        str += "sixteen";
                        return str;
                    }
                    case 7: {
                        str += "seventeen";
                        return str;
                    }
                    case 8: {
                        str += "eighteen";
                        return str;
                    }
                    case 9: {
                        str += "nineteen";
                        return str;
                    }
                }
            }
            case 2: {
                str += "twenty ";
                break;
            }
            case 3: {
                str += "thirty ";
                break;
            }
            case 4: {
                str += "forty ";
                break;
            }
            case 5: {
                str += "fifty ";
                break;
            }
            case 6: {
                str += "sixty ";
                break;
            }
            case 7: {
                str += "seventy ";
                break;
            }
            case 8: {
                str += "eighty ";
                break;
            }
            case 9: {
                str += "ninety ";
                break;
            }
        }
        switch (num % 10) {
            case 1: {
                str += "one";
                break;
            }
            case 2: {
                str += "two";
                break;
            }
            case 3: {
                str += "three";
                break;
            }
            case 4: {
                str += "four";
                break;
            }
            case 5: {
                str += "five";
                break;
            }
            case 6: {
                str += "six";
                break;
            }
            case 7: {
                str += "seven";
                break;
            }
            case 8: {
                str += "eight";
                break;
            }
            case 9: {
                str += "nine";
                break;
            }
        }
        return str;
    }

    public static String numToRus(int num) {
        String str = "";
        if (num == 0) return "ноль";
        switch (num / 100) {
            case 1: {
                str += "сто ";
                break;
            }
            case 2: {
                str += "двести ";
                break;
            }
            case 3: {
                str += "триста ";
                break;
            }
            case 4: {
                str += "четыреста ";
                break;
            }
            case 5: {
                str += "пятьсот ";
                break;
            }
            case 6: {
                str += "шестьсот ";
                break;
            }
            case 7: {
                str += "семьсот ";
                break;
            }
            case 8: {
                str += "восемьсот ";
                break;
            }
            case 9: {
                str += "девятьсот ";
                break;
            }
        }
        switch (num / 10 % 10) {
            case 1: {
                switch (num % 10) {
                    case 0: {
                        str += "десять";
                        return str;
                    }
                    case 1: {
                        str += "одиннадцать";
                        return str;
                    }
                    case 2: {
                        str += "двенадцать";
                        return str;
                    }
                    case 3: {
                        str += "тринадцать";
                        return str;
                    }
                    case 4: {
                        str += "четырнадцать";
                        return str;
                    }
                    case 5: {
                        str += "пятнадцать";
                        return str;
                    }
                    case 6: {
                        str += "шестнадцать";
                        return str;
                    }
                    case 7: {
                        str += "семнадцать";
                        return str;
                    }
                    case 8: {
                        str += "восемьнадцать";
                        return str;
                    }
                    case 9: {
                        str += "двадцать";
                        return str;
                    }
                }
            }
            case 2: {
                str += "двадцать ";
                break;
            }
            case 3: {
                str += "тридцать ";
                break;
            }
            case 4: {
                str += "сорок ";
                break;
            }
            case 5: {
                str += "пятьдесят ";
                break;
            }
            case 6: {
                str += "шестьдесят ";
                break;
            }
            case 7: {
                str += "семьдесят ";
                break;
            }
            case 8: {
                str += "восемьдесят ";
                break;
            }
            case 9: {
                str += "девяносто ";
                break;
            }
        }

        switch (num % 10) {
            case 1: {
                str += "один";
                break;
            }
            case 2: {
                str += "два";
                break;
            }
            case 3: {
                str += "три";
                break;
            }
            case 4: {
                str += "четыре";
                break;
            }
            case 5: {
                str += "пять";
                break;
            }
            case 6: {
                str += "шесть";
                break;
            }
            case 7: {
                str += "семь";
                break;
            }
            case 8: {
                str += "восемь";
                break;
            }
            case 9: {
                str += "девять";
                break;
            }
        }
        return str;

    }

    public static void getSha256HashMain(String str) throws  NoSuchAlgorithmException{
        System.out.println();
        System.out.println("@Task 8@");
        System.out.println("For - " + str +  "\nhash code - " + getSha256Hash(str));

    }

    public static String getSha256Hash(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256"); // Создание экземпляра класса с кодировкой SHA-256
        byte[] text = digest.digest(str.getBytes(StandardCharsets.UTF_8)); // Шифрование с помощью метода digest
        return HexBin.encode(text).toLowerCase(); // Перевод из byte в шестнадцатиричную систему
    }

    public static void  correctTitleMain(String str){
        System.out.println();
        System.out.println("@Task 9@");
        System.out.println("For str - " + str +  "\nResult is - " + correctTitle(str));
    }

    public static String correctTitle(String str) {
        String[] tokens = str.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equalsIgnoreCase("of") && !tokens[i].equalsIgnoreCase("and") && !tokens[i].equalsIgnoreCase("the") && !tokens[i].equalsIgnoreCase("in")) {
                tokens[i] = String.valueOf(tokens[i].charAt(0)).toUpperCase() + tokens[i].substring(1).toLowerCase();
            } else {
                tokens[i] = tokens[i].toLowerCase();
            }
        }

        return String.join(" ", tokens);
    }

    public static void  haxLatticeMain(int n){
        System.out.println();
        System.out.println("@Task 10@");
        System.out.println("For num - " + n +  "\n" + haxLattice(n));
    }

    public static String haxLattice(int n) {
        int num = 1;
        int i = 1;
        String res = "";
        String str2 = "";
        while (n > num) {
            i++;
            num = 3 * i * (i - 1) + 1;
        }
        int l = i;
        if (n != num)
            res = "invalid";
        else {
            while (l < i * 2 - 1) {
                for (int a = 0; a < i * 2 - 1 - l; a++)
                    res += "  ";

                for (int b = 0; b < l; b++)
                    res += " o  ";

                res += "\n";
                l++;
            }
            while (l >= i) {

                for (int a = 0; a < i * 2 - 1 - l; a++)
                    res += "  ";

                for (int b = l; b > 0; b--)
                    res += " o  ";

                res += "\n";
                l--;
            }
        }
        return res;
    }
}