import com.m.sort.*;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SortingTest {
    public static final int SMALL_ARRAY = 10;
    private static final int MAX_STRING_LENGTH = 10;
    public static final int ARRAY = 500;
    public static final int LARGE_ARRAY = 25_000;
    public static final int VERY_LARGE_ARRAY = 1_000_000;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    int[] arrayLengths = {SMALL_ARRAY, ARRAY, LARGE_ARRAY, VERY_LARGE_ARRAY};

    enum SortType {
        BUBBLESORT,
        SHELLSORT,
        SELECTIONSORT,
        INSERTIONSORT,
        MERGESORT,
        QUICKSORT;

       static void sort(SortType type, Comparable[] array) {
            int i = 0;
            stopLongSorting();
            switch (type) {
                case BUBBLESORT:
                    BubbleSort bubbleSort = new BubbleSort();
                    bubbleSort.sort(array);
                    break;
                case MERGESORT:
                    MergeSort mergeSort = new MergeSort();
                    mergeSort.sort(array);
                    break;
                case QUICKSORT:
                    QuickSort quickSort = new QuickSort();
                    quickSort.sort(array);
                    break;
                case SHELLSORT:
                    ShellSort shellSort = new ShellSort();
                    shellSort.sort(array);
                    break;
                case SELECTIONSORT:
                    SelectionSort selectSort = new SelectionSort();
                    selectSort.sort(array);
                case INSERTIONSORT:
                    InsertionSort insertSort = new InsertionSort();
                    insertSort.sort(array);
                    break;
            }
            System.out.println(type);
        }
    }

    public void genericSort(int length) {
        for (SortType type : SortType.values()) {
            String[] stringArray = fillStringArray(length);
            long start = System.nanoTime();
            SortType.sort(type, stringArray);
            long time = System.nanoTime() - start;
            System.out.println(df.format(time / 1_000_000.0) + " ms.");

        }
    }


    private static int[] fillIntArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000000);
        }
        return array;
    }

    private static double[] fillDoubleArray(int size) {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = Math.random();
        }
        return array;
    }

    private static String[] fillStringArray(int size) {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = fillCharArray();
        }
        return array;
    }

    private static String fillCharArray() {
        int size = (int) (Math.random() * 10) + 1;
        char[] array = new char[size];
        for (int i = 0; i < size; i++) {
            array[i] = (char) ((int) (Math.random() * 25) + 97);
        }
        return Arrays.toString(array);
    }


    public boolean isArraySorted(Comparable[] arr) {
        if (arr == null || arr.length <= 1) return true;
        return isArraySorted(arr, arr.length - 1);
    }

    public boolean isArraySorted(int[] array) {
        return isArraySorted(array, array.length - 1);
    }


    public boolean isArraySorted(Comparable[] array, int i) {
        //return true after get first or second element of array
        if (i <= 1)
            return true;

        //return false if previous element more than next
        if (array[i - 1].compareTo(array[i - 2]) < 0)
            return false;

        //continue checking until one of the previous two states is obtained
        return isArraySorted(array, i - 1);
    }

    public boolean isArraySorted(int[] array, int i) {
        //return true after get first or second element of array
        if (i <= 1)
            return true;

        //return false if previous element more than next
        if (array[i - 1] > array[i - 2])
            return false;

        return isArraySorted(array, i - 1);
    }

    public static void stopLongSorting() {
        Thread th = new Thread();
        try {
            th.wait(4000);
            Thread.yield();
        } catch (Exception e) {
            e.getMessage();
        }
    }


    @Test
    public void bubbleSortTest() {
        genericSort(2000000);

    }

    @Test
    public void shellSortTest() {
        Comparable[] array = fillStringArray(ARRAY);
        assertFalse(isArraySorted(array));
        SortType.sort(SortType.SHELLSORT, array);
        assertTrue(isArraySorted(array));
    }

    @Test
    public void selectionSortTest() {

    }

    @Test
    public void insertionSortTest() {
    }

    @Test
    public void mergeSortTest() {
        Comparable[] array = fillStringArray(ARRAY);
        assertFalse(isArraySorted(array));
        long start = System.nanoTime();
        SortType.sort(SortType.MERGESORT, array);
        long time = System.nanoTime() - start;
        System.out.println(df.format(time / 1_000_000.0) + " ms.");
        assertTrue(isArraySorted(array));
    }

    @Test
    public void quickSortTest() {
        Comparable[] array = fillStringArray(ARRAY);
        assertFalse(isArraySorted(array));
        long start = System.nanoTime();
        SortType.sort(SortType.QUICKSORT, array);
        long time = System.nanoTime() - start;
        System.out.println(df.format(time / 1_000_000.0) + " ms.");
        assertTrue(isArraySorted(array));
    }

    @Test
    public void arraySortedTest() {


    }


}
