import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run(new Scanner(System.in));
    }

    public void run(Scanner scanner) {
        List<Integer> numbers = new ArrayList<>();
        int number;
        while ((number = scanner.nextInt()) >= 0) {
            numbers.add(number);
        }

        getReverseNumbers(numbers);

        getSumOfAllElementsFromList(numbers);

        int minNumber = getMinNumber(numbers);
        System.out.println("Najmniejsza liczba na liście to " + minNumber);

        int maxNumber = getMaxNumber(numbers);
        System.out.println("Nawiększa liczba na liście to " + maxNumber);

    }

    private static void getReverseNumbers(List<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        Collections.reverse(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            stringBuilder.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                stringBuilder.append(", ");
            }
        }

        String reverseResult = stringBuilder.toString();
        System.out.println(reverseResult);
    }

    private static void getSumOfAllElementsFromList(List<Integer> numbers) {
        Collections.reverse(numbers);
        StringBuilder resultSum = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            Integer numberText = numbers.get(i);
            resultSum.append(numberText);
            sum += numbers.get(i);
            if (i == numbers.size() - 1) {
                resultSum.append(" = ");
                resultSum.append(sum);
            } else {
                resultSum.append(" + ");
            }
        }
        String sumResult = resultSum.toString();
        System.out.println(sumResult);
    }

    private static int getMinNumber(List<Integer> numbers) {
        int nextNumber = numbers.get(0);
        for (Integer number : numbers) {
            if (nextNumber > number) {
                nextNumber = number;
            }
        }
        return nextNumber;

    }

    private static int getMaxNumber(List<Integer> numbers) {
        int nextNumber = numbers.get(0);
        for (Integer number : numbers) {
            if (nextNumber < number) {
                nextNumber = number;
            }
        }
        return nextNumber;
    }
}
