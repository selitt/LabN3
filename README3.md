## Отчет по лабораторной работе № 3

#### № группы: `ПМ-2402`

#### Выполнил: `Забирохин Всеволод Сергеевич`

#### Вариант: `9`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Алгоритм](#3-алгоритм)
- [Программа](#4-программа)
- [Анализ правильности решения](#5-анализ-правильности-решения)

### 1. Постановка задачи

> Краткое описание
Разработать программу для работы со случайными величинами, представленными чис- лами и их вероятностями. Реализовать функции вычисления статистических показате- лей, преобразования данных и анализа распределений.
Описание функционала
>1. Создание случайной величины
   Создаем объект в который передаем 2 числа 1) -  максимальное количество чисел, с вероятностями которых работаем 2) - первое хранимое число
   . Проверяются следующие условия:
   • Все вероятности неотрицательны;
   • Сумма вероятностей равна 1 (с учётом погрешности);
   • Каждая вероятность не превышает 1. При нарушении условий ввод корректи- руется: отрицательные вероятности становятся равными 0, а все вероятности умножаются на коэффициент для приведения их суммы к 1.
>2. добавить еще одно вероятное число с двумя параметрами(1 - добавляемое число, 2 - его вероятность) если вероятность <= 0 || >= 1 мы его не добавляем, а если нормальная, то вероятность добавляем в список величин, вероятность у этого числа p, сумма вероятностей должнна равняться и умноженное вероятность списка на (1-p), чтобы была общая вероятность (1-p)
>3. Вывод случайной величины
   Отображение списка чисел и их вероятностей в столбик в формате: «число - ве- роятность».
>4. Сортировка случайной величины
   Ранжирование случайной величины: сортировка чисел по возрастанию значений.
>5. Математическое ожидание
   Вычисление математического ожидания случайной величины.
>6. Дисперсия
   Вычисление дисперсии случайной величины.
>7. Арифметические операции над числами случайной величины Преобразование чисел случайной величины: возведение в квадрат, умножение на константу, добавление значения. Вероятности остаются неизменными.
>8. Нахождение медианы
   Определение медианы случайной величины: - Если количество чисел нечётное, медиана — это центральное число; - Если количество чисел чётное, медиана равна среднему арифметическому двух центральных чисел.
>9. Наиболее вероятное число
   Определение числа с наибольшей вероятностью.
>10. Генерация вероятностей из массива
    Вычисление вероятностей чисел на основе их частот в заданном массиве.
>11. Удалить наименее вероятное число, можно без сохранения порядка, удалить все числа, вероятность которых меньше, чем p

Задачу необходимо разбивать на несколько подзадач, используя ООП

Список подзадач:
- Создание класса случайных величин
- Добавление чисел, с учетом сохранения единицы, как суммы всех вероятностей
- Написание метода, который выводит значения элементов и вероятностей с сохранением вида(элемент - вероятность)
- Сортировка массивов вероятностей и элементов по возрастанию элементов
- Написания метода, который рассчитывает математическое ожидание случайной величины
- Написания метода, высчитывающего дисперсию случайной величины
- Написания метода для нахождения медианы случайной величины
- Вывод самого вероятного числа 
- Написания метода для генерации вероятностей из массива
- Написание метода, удаляющего наименее вероятное число.


### 3. Алгоритм

#### Алгоритм выполнения программы:

1. add(double number, double probability)  
   Добавляет число с указанной вероятностью в массив:
   - Проверяет, что вероятность лежит в пределах от 0 до 1.
   - Корректирует текущие вероятности так, чтобы их сумма оставалась равной 1.
   - Добавляет новое число и его вероятность в массивы numbers и probabilities.
2. print()  
   Выводит все числа и их вероятности в формате число - вероятность.
3. sortNum()  
      Сортирует массив чисел numbers по возрастанию:
   - Одновременно меняет местами значения вероятностей (probabilities), чтобы сохранить соответствие между массивами.
4. getExpectedValue()  
   Вычисляет математическое ожидание по формуле
5. getDisperce()  
   Вычисляет дисперсию случайной величины
6. getMedian()  
   Находит медиану (центральное значение):
   - Сортирует числа вызовом sortNum().
   - Если количество чисел нечетное — возвращает центральное число.
   - Если четное — возвращает среднее арифметическое двух центральных чисел.
7. getProbableValue()  
   Вычисляет число с максимальной вероятностью.  
   Логика:
   - Ищет индекс максимальной вероятности.
   - Возвращает число, соответствующее этому индексу.
8. NewProbabilities()  
   Перерасчитывает вероятности чисел на основе их частоты:
   - Создает массив частот для каждого числа.
   - Пересчитывает вероятность как:
9. mult(double num)
   - умножение величин на num
10. square()
   - Возведение величин в квадрат
11. addNum(double num)
   - Прибавить к величине num
12. delete(double p)
   - Удаление элементов с вероятностью меньше заданной

# 4. Математическая модель
   1. Математическое ожидание
   - Σ (число * вероятность)
   2. Дисперсия
   - Σ ((число - математическое ожидание)^2 * вероятность)
   3. Вероятность по частоте
   - частота / число элементов
### 5. Программа

```java
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
class StatisticsManager{
   // Преобразование случайной величины: умножение на число
   public static void mult(double num) {
      for (int i = 0; i < RandomVariable.size; i++) {
         RandomVariable.numbers[i] *= num;
      }
   }
   // возведение в квадрат
   public static void square(){
      for(int i = 0; i < RandomVariable.size; i++){
         RandomVariable.numbers[i] *= RandomVariable.numbers[i];
      }
   }
   // Математическое ожидание
   public static double getExpectedValue() {
      double expectedValue = 0; // Cумма произведений
      for (int i = 0; i < RandomVariable.size; i++) {
         expectedValue += RandomVariable.numbers[i] * RandomVariable.probabilities[i]; // Добавление в сумму по формуле нахождения математического ожидания
      }
      return expectedValue;
   }

   // Дисперсия
   public static double getDisperce() {
      double mean = getExpectedValue(); // Переменная, хранящая математическое ожидание
      double variance = 0;
      for (int i = 0; i < RandomVariable.size; i++) {
         variance += Math.pow(RandomVariable.numbers[i] - mean, 2) * RandomVariable.probabilities[i];
      }
      return variance;
   }

   // Медиана
   public static double getMedian() {
      RandomVariable.sortNum();
      if (RandomVariable.size % 2 == 1) {
         return RandomVariable.numbers[RandomVariable.size / 2];
      } else {
         return (RandomVariable.numbers[RandomVariable.size / 2 - 1] + RandomVariable.numbers[RandomVariable.size / 2]) / 2;
      }
   }
   public static void addNum(double num){
      for (int i = 0; i < RandomVariable.size; i++){
         RandomVariable.numbers[i] += num;
      }
   }
}
```

### 6. Анализ правильности решения
``` Java
   import java.util.Scanner;
   import java.io.PrintStream;
   public class Main{
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
           out.println("Математическое ожидание: " + rv.getExpectedValue());
   
           // Дисперсия
           out.println("Дисперсия: " + rv.getDisperce());
   
           // Медиана
           out.println("Медиана: " + rv.getMedian());
   
           // Наиболее вероятное число
           out.println("Наиболее вероятное число: " + rv.getProbableValue());
   
           // Преобразование случайной величины (умножение на 2)
           rv.mult(2);
           out.println("После умножения на 2:");
           rv.print();
           // Преобразование случайной величины (возведение в квадрат)
           rv.square();
           out.println("После возведения в квадрат:");
           rv.print();
           // Преобразование случайной величины (прибавить число)
           rv.addNum(3);
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
```
### ввод:
```4 1 1 0,4 2 0,5 3 0,2```
### вывод:
``` 
Случайная величина:
1.0 - 0.24
1.0 - 0.16000000000000003
2.0 - 0.4
3.0 - 0.2
Математическое ожидание: 1.8000000000000003
Дисперсия: 0.56
Медиана: 1.5
Наиболее вероятное число: 2.0
После умножения на 2:
2.0 - 0.24
2.0 - 0.16000000000000003
4.0 - 0.4
6.0 - 0.2
После возведения в квадрат:
4.0 - 0.24
4.0 - 0.16000000000000003
16.0 - 0.4
36.0 - 0.2
После добавления числа:
7.0 - 0.24
7.0 - 0.16000000000000003
19.0 - 0.4
39.0 - 0.2
После удаления элементов, вероятность которых меньше указанной:
7.0 - 0.24
19.0 - 0.4
39.0 - 0.2
Числа и их вероятности после пересчета:
7.0 - 0.3333333333333333
19.0 - 0.3333333333333333
39.0 - 0.3333333333333333
```