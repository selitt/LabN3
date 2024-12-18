import java.io.PrintStream;
public class RandomVariable {
    public static PrintStream out = System.out;
    public static double[] numbers; // Массив чисел
    public static double[] probabilities; // Массив вероятностей
    public static int size; // Количество чисел
    public RandomVariable(int n, double initialNumber) {
        numbers = new double[n]; // Размер массива
        probabilities = new double[n];
        size = 0; // количество чисел изначально равно 0

        // Инициализация первого элемента
        numbers[size] = initialNumber;
        probabilities[size] = 1.0; // Вероятность первого элемента равна 1
        size++;
    }
    // Добавление элементов
    public void add(double number, double probability) {
        if (probability < 1 && probability > 0) { //проверка корректности введенных данных, если данные некоректные, нельзя добавить элемент в массив
            // Умножаем все вероятности на (1 - вероятность данного числа), чтобы их сумма была равна 1
            for (int i = 0; i < size; i++)
                probabilities[i] *= (1 - probability);
            // Добавление нового значения и его вероятности
            numbers[size] = number;
            probabilities[size] = probability;
            size++;
        }
    }

    // Вывод чисел и их вероятностей
    public void print() {
        for (int i = 0; i < size; i++) {
            out.println(numbers[i] + " - " + probabilities[i]);
        }
    }

    // Сортировка чисел по возрастанию
    public static void sortNum() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numbers[i] > numbers[j]) {
                    // Меняем местами числа
                    double num = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = num;

                    // Меняем местами вероятности
                    double prob = probabilities[i];
                    probabilities[i] = probabilities[j];
                    probabilities[j] = prob;
                }
            }
        }
    }
    // Наиболее вероятное число
    public double getProbableValue() {
        double max_prob = probabilities[0];
        int max_index = 0;
        // Находим самое вероятное число
        for (int i = 1; i < size; i++) {
            if (probabilities[i] > max_prob) {
                max_prob = probabilities[i];
                max_index = i;
            }
        }
        return numbers[max_index];
    }
    // Метод для генерации вероятностей на основе частот чисел
    public void NewProbabilities() {
        // Массив для подсчета частоты каждого числа
        int[] frequency = new int[size];

        // Подсчитываем частоту каждого числа
        for (int i = 0; i < size; i++) {
            frequency[i] = 0;  // Инициализируем частоту каждого числа на 0
            for (int j = 0; j < size; j++) {
                if (numbers[i] == numbers[j]) {
                    frequency[i]++; // Увеличиваем частоту числа
                }
            }
        }

        // Теперь вычислим сумму всех частот
        int frequency1 = 0;
        for (int i = 0; i < size; i++) {
            frequency1 += frequency[i]; // Суммируем частоты всех чисел
        }

        // Теперь генерируем вероятности для каждого числа
        for (int i = 0; i < size; i++) {
            // Вероятность числа - это его частота, деленная на общую сумму частот
            probabilities[i] = (double) frequency[i] / frequency1;
        }
    }
    // Метод для удаления чисел с вероятностью меньше p
    public void delete(double p) {
        int newSize = 0; // Новый размер массива после удаления элементов

        // Теперь пересоздаем массивы, исключая числа с вероятностью меньше p
        double[] newNumbers = new double[size];
        double[] newProbabilities = new double[size];

        // Заполняем новые массивы
        for (int i = 0; i < size; i++) {
            if (probabilities[i] >= p) {
                newNumbers[newSize] = numbers[i];
                newProbabilities[newSize] = probabilities[i];
                newSize++;
            }
        }

        // Обновляем массивы
        numbers = newNumbers;
        probabilities = newProbabilities;
        size = newSize;
    }


}
