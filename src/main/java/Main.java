import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run(new Scanner(System.in));
    }

    public void run(Scanner scanner) {
//        List<Integer> numbers = getListOfNumbersFromUser(scanner);

        List<Integer> numbers = getListOfStringsFromUser(scanner);

        printReverseNumbers(numbers);
        printSumOfAllElementsFromList(numbers);

        int minNumber = getMinNumber(numbers);
        int maxNumber = getMaxNumber(numbers);
        if (minNumber != 0 && maxNumber != 0) {
            System.out.println("Najmniejsza liczba w liście to " + minNumber);
            System.out.println("Nawiększa liczba w liście to " + maxNumber);
        }
    }

    private static List<Integer> getListOfStringsFromUser(Scanner scanner) {
        List<Integer> numbers = new ArrayList<>();
        String lineOfNumbers = scanner.nextLine();
        String[] split = lineOfNumbers.split(",");
        for (String numberText : split) {
            if (numberText.isEmpty()) {
                break;
            } else {
                Integer number = Integer.valueOf(numberText.trim());
                if (number >= 0) {
                    numbers.add(number);
                }
            }
        }
        return numbers;
    }

//    private static List<Integer> getListOfNumbersFromUser(Scanner scanner) {
//        List<Integer> numbers = new ArrayList<>();
//        int number;
//        while ((number = scanner.nextInt()) >= 0) {
//            numbers.add(number);
//        }
//        return numbers;
//    }

    private static void printReverseNumbers(List<Integer> numbers) {
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

    private static void printSumOfAllElementsFromList(List<Integer> numbers) {
        Collections.reverse(numbers);
        StringBuilder resultSum = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.size() == 1) {
                resultSum.append(numbers.get(i));
                break;
            }
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
        if (numbers.size() == 0) {
            return 0;
        }
        int nextNumber = numbers.get(0);
        for (Integer number : numbers) {
            if (nextNumber > number) {
                nextNumber = number;
            }
        }
        return nextNumber;
    }

    private static int getMaxNumber(List<Integer> numbers) {
        if (numbers.size() == 0) {
            return 0;
        }
        int nextNumber = numbers.get(0);
        for (Integer number : numbers) {
            if (nextNumber < number) {
                nextNumber = number;
            }
        }
        return nextNumber;
    }
}
