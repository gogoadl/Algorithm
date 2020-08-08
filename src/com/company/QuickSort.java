package com.company;

public class QuickSort {
    public static void quick_sort(int[] arr, int left, int right)
    {
        if(left < right)
        {
            int pi = partition(arr, left, right);

            quick_sort(arr, left, pi - 1);
            quick_sort(arr, pi + 1, right);
        }
    }
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int partition(int[] arr, int left, int right)
    {
        int pivot = arr[left];
        int i = left, j = right;

        while (i < j)
        {
            while (pivot < arr[j])
            {
                j--;
            }
            while (i < j && pivot >= arr[i])
            {
                i++;
            }
            swap(arr, i ,j);
        }
        arr[left] = arr[i];
        arr[i] = pivot;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{30,70,40,20,10,50,80};
//        for (int i = 0; i < arr.length; i++)
//        { arr[i] = (int)Math.random() * 100; }

        quick_sort(arr, 0, arr.length - 1);
    }
}
