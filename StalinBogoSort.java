import java.util.Arrays;
import java.util.Random;

public class ArrayProcessor {

    public static void main(String[] args) {
        int arraySize = 100;
        int numIterations = 10;

        int[] startingArray = generateRandomArray(arraySize);
        int[] resultArray = new int[0];
        int maxLength = 0;

        for (int i = 0; i < numIterations; i++) {
            shuffleArray(startingArray);
            int[] processedArray = stalinSort(startingArray);

            if (processedArray.length > maxLength) {
                maxLength = processedArray.length;
                resultArray = processedArray;
            }
        }

        System.out.println("Result Array: " + Arrays.toString(resultArray));
        System.out.println("Max Length: " + maxLength);
    }

    private static int[] generateRandomArray(int size) {
        int[] randomArray = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(100); // Generate random integers between 0 and 99
        }

        return randomArray;
    }

    private static void shuffleArray(int[] array) {
        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    private static int[] stalinSort(int[] array) {
        int[] processedArray = new int[array.length];
        int length = 0;

        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] >= processedArray[length - 1]) {
                processedArray[length] = array[i];
                length++;
            }
        }

        return Arrays.copyOf(processedArray, length);
    }
}
