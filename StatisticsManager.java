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
