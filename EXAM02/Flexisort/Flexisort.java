import java.util.Arrays;

abstract class Sorter {
    private int[] array;

    public int[] getArray() {
        return this.array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public abstract void sort();
}

class BubbleSort extends Sorter {
    @Override
    public void sort() {
        int[] array = getArray();
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

class InsertionSort extends Sorter {
    @Override
    public void sort() {
        int[] array = getArray();
        int n = getArray().length;

        for(int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
