package ru.alekseiadamov.lesson5;

class MyArr {
    private final int[] arr;
    private int size;

    public MyArr(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    public int binarySearch(int value) {
        return recursiveBinarySearch(value, 0, size - 1);
    }

    private int recursiveBinarySearch(int value, int low, int high) {
        int mid;
        mid = (low + high) / 2;
        if (arr[mid] == value)
            return mid;
        else if (low > high)
            return -1;
        else {
            if (arr[mid] < value)
                return recursiveBinarySearch(value, mid + 1, high);
            else
                return recursiveBinarySearch(value, low, mid - 1);
        }
    }

    public void insert(int value) {
        int i;
        for (i = 0; i < size; i++) {
            if (arr[i] > value)
                break;
        }
        if (size - i >= 0) {
            System.arraycopy(arr, i, arr, i + 1, size - i);
        }
        arr[i] = value;
        size++;
    }
}

public class MyArrDemo {
    public static void main(String[] args) {
        MyArr arr = new MyArr(10);
        arr.insert(-10);
        arr.insert(45);
        arr.insert(26);
        arr.insert(20);
        arr.insert(25);
        arr.insert(40);
        arr.insert(75);
        arr.insert(80);
        arr.insert(82);
        arr.insert(91);

        int search = -10;
        System.out.printf("Position of %d is %d.\n", search, arr.binarySearch(search));

        int search2 = 75;
        System.out.printf("Position of %d is %d.\n", search2, arr.binarySearch(search2));

        int search3 = 11;
        System.out.printf("Position of %d is %d.\n", search3, arr.binarySearch(search3));
    }
}

