import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayElementsReplacerTest {

    @Test
    void replaceElements1() {
        int[] sourceArr = {1, 2, 2, 2, 3, 4, 5, 2, 3, 10, 1};
        int[] goalArr = {2, 3};
        int[] replaceArr = {0, 0, 0};

        ArrayElementsReplacer arrayElementsReplacer = new ArrayElementsReplacer();
        int[] resultArr = arrayElementsReplacer.replaceElements(sourceArr, goalArr, replaceArr);
        Assertions.assertArrayEquals(new int[]{1, 2, 2, 0, 0, 0, 4, 5, 0, 0, 0, 10, 1}, resultArr);
    }

    @Test
    void replaceElements2() {
        int[] sourceArr = {1, 2, 3, 4, 5};
        int[] goalArr = {2, 0};
        int[] replaceArr = {0, 0, 0};

        ArrayElementsReplacer arrayElementsReplacer = new ArrayElementsReplacer();
        int[] resultArr = arrayElementsReplacer.replaceElements(sourceArr, goalArr, replaceArr);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, resultArr);
    }


}