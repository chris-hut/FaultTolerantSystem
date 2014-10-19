package com.hut;

public class InsertionSort extends Sort {

    static{
        System.loadLibrary("insertionsort");
    }

    public static void main(String[] args){
        InsertionSort a = new InsertionSort();
        int[] arr = {3, 2, 1};
        a.sort(arr);
    }

    /***
     *
     * Provides an insertion sort in C
     * @param values values to sort
     */
    @Override
    public void sort(int[] values){
        // TODO: Check return value of cSort
        cSort(values);
     }

    private native int cSort(int[] values);
}
