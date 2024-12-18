import java.util.Scanner;
import java.io.PrintStream;
public class Taste{
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        out.print("Введите количество чисел: ");
        int n = in.nextInt();
        out.print("Введите первое число: ");
        double number = in.nextDouble();

        RandomVariable rv = new RandomVariable(n, number);

        // Ввод чисел и вероятностей
        for (int i = 0; i < n - 1; i++) {
            out.print("Введите число: ");
            double number1 = in.nextDouble();
            out.print("Введите вероятность: ");
            double probability = in.nextDouble();
            rv.add(number1, probability);
        }

        // Вывод значений и вероятностей
        out.println("Случайная величина:");
        rv.print();

        // Математическое ожидание
        out.println("Математическое ожидание: " + StatisticsManager.getExpectedValue());

        // Дисперсия
        out.println("Дисперсия: " + StatisticsManager.getDisperce());

        // Медиана
        out.println("Медиана: " + StatisticsManager.getMedian());

        // Наиболее вероятное число
        out.println("Наиболее вероятное число: " + rv.getProbableValue());

        // Преобразование случайной величины (умножение на 2)
        StatisticsManager.mult(2);
        out.println("После умножения на 2:");
        rv.print();
        // Преобразование случайной величины (возведение в квадрат)
        StatisticsManager.square();
        out.println("После возведения в квадрат:");
        rv.print();
        // Преобразование случайной величины (прибавить число)
        StatisticsManager.addNum(3);
        out.println("После добавления числа:");
        rv.print();
        // Удаление элементов с вероятностью < p
        rv.delete(0.2);
        out.println("После удаления элементов, вероятность которых меньше указанной:");
        rv.print();
        // Новые вероятности с учетом частоты повторения
        rv.NewProbabilities();
        out.println("Числа и их вероятности после пересчета:");
        rv.print();
    }
}
