// Name: Andrew Taylor
// Class: CS 3305/Section#04
// Term: Fall 2023
// Instructor: Umama Tasnim
// Assignment: 3



public class insertionSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};

        System.out.print("Unsorted Array: ["); //prints unsorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");

        InsertionSort(arr); //uses the insertion sort to rearrange the array

        System.out.print("Sorted Array: ["); //prints out sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void InsertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key; // checks to make sure array isnt empty while comparing the elements
        }
    }
}