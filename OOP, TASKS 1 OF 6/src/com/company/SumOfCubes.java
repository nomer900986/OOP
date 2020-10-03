public class SumOfCubes {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) { // Цикл от 0 до кол-ва введенных чисел
            String mas = args[i]; // В mas записывается число с индексом i
        }
        System.out.println("Sum of cubes of array elements - " + sumOfCubes(args)); // Находится и выводится сумма кубов введенных элементов с помощью метода sumOfCubes
    }

    public static int sumOfCubes(String[] mas) { // Метод, который принимает введенный строковый массив и находит сумму кубов его элементов
        int sum = 0; // Описывается перменная, отвечающая за сумму
        for (int i = 0;i<mas.length;i++) { // Цикл от 0 до кол-ва введенных чисел
            sum += Math.pow(Integer.parseInt(mas[i]), 3); // Элемент с индексом i преобразовывается в int, возводится в 3 степень и добавляется к sum
        }
        return sum;
    }
}