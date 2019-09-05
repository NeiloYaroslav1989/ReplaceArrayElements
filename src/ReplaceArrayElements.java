import java.util.Arrays;

public class ReplaceArrayElements {
    public static void main(String[] args) {
        int[] sourceArr = {1, 2, 2, 2, 3, 4, 5};
        int[] goalArr = {2, 3};
        int[] replaceArr = {0, 0, 0};

        print("Исходный массив:", sourceArr);
        int[] resultArr = replaceElements(sourceArr, goalArr, replaceArr);
        printResult(sourceArr, resultArr);
    }

    public static int[] replaceElements(int[] source, int[] goal, int[] replace) {
        int[] resultArray = new int[0];

        for (int i = 0; i < source.length; i++) {
            int coincidenceElementIndex = 0;
            int counter = 0;
            if (goal[0] == source[i]) {
                coincidenceElementIndex = i;
                counter++;
                for (int j = 1; j < goal.length; j++) {
                    if (goal[j] != source[++i]) {
                        break;
                    }
                    counter++;
                }

                if (counter == goal.length) {
                    int[] firstPart = getSection(0, coincidenceElementIndex - 1, source);
                    int[] lastPart = getSection((coincidenceElementIndex + goal.length), source.length - 1, source);
                    resultArray = merge(firstPart, merge(replace, lastPart));
                    source = resultArray;
                    resultArray = source;
                    i = (coincidenceElementIndex + replace.length - 1);
                } else {
                    resultArray = source;
                    i = coincidenceElementIndex;
                }
            }
        }
        return resultArray;
    }

    public static void print(String message, int[] array) {
        System.out.println(message);
        if (array != null) {
            printArray(array);
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printResult(int[] sourceArray, int[] resultArray) {
        if (Arrays.equals(sourceArray, resultArray)) {
            print("Исходный массив не был изменен.", null);
        } else {
            print("Исходный массив был изменен на:", resultArray);
        }
    }

    public static int[] getSection(int indexStart, int indexEnd, int[] array) {
        int lengthArray = indexEnd - indexStart + 1;
        int[] resultArray = new int[lengthArray];
        int indexResultArray = 0;

        for (int i = indexStart; i < indexEnd + 1; i++) {
            resultArray[indexResultArray++] = array[i];
        }

        return resultArray;
    }

    public static int[] merge(int[] firstArray, int[] lastArray) {
        int lengthArray = firstArray.length + lastArray.length;
        int[] resultArray = new int[lengthArray];

        for (int i = 0; i < firstArray.length; i++) {
            resultArray[i] = firstArray[i];
        }

        for (int i = firstArray.length; i < resultArray.length; i++) {
            resultArray[i] = lastArray[i - firstArray.length];
        }
        return resultArray;
    }
}
