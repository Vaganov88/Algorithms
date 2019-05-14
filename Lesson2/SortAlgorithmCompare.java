import java.util.Random;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;

public class SortAlgorithmCompare {
    private static int N = 100000;
    private static int M = 10;
    private static int A = -100000;
    private static int B = 100000;

    public static void main(String[] args) {
        long[] selectionSortTimers = new long[M];
        long[] insertionSortTimers = new long[M];
        long selectionSortTotalTime = 0;
        long insertionSortTotalTime = 0;

        for (int i = 0; i < M; i++) {
            MyArrayList<Integer> myArrayList1 = new MyArrayList<>();
            listRandomFill(myArrayList1, N, A, B);
            MyArrayList<Integer> myArrayList2 = new MyArrayList<>(myArrayList1);

            long start = System.currentTimeMillis();
            myArrayList1.selectionSort(Integer::compareTo);
            long end = System.currentTimeMillis();
            selectionSortTimers[i] = end - start;
            selectionSortTotalTime += selectionSortTimers[i];

            start = System.currentTimeMillis();
            myArrayList2.insertionSort(Integer::compareTo);
            end = System.currentTimeMillis();
            insertionSortTimers[i] = end - start;
            insertionSortTotalTime += insertionSortTimers[i];

        }

        System.out.println("|  #  | selection | insertion |");
        System.out.println("_______________________________");

        for (int i = 0; i < M; i++) {
            System.out.printf("|%5d|%11.2f|%11.2f|%n", i + 1, selectionSortTimers[i]/1000.0, insertionSortTimers[i]/1000.0);

        }
        System.out.printf("| avg |%11.2f|%11.2f|%n", selectionSortTotalTime / 1000.0 /M, insertionSortTotalTime / 1000.0 /M);
    }
    public static void listRandomFill (MyArrayList<Integer> myArrayList, int count, int a, int b ) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            myArrayList.add(random.nextInt(b - a + 1) + a);
            
        }
    }
}
