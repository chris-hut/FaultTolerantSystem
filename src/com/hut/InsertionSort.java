package com.hut;

public class InsertionSort extends Sort {

    static{
        System.loadLibrary("insertionsort");
    }

    public static void main(String[] args){
        //InsertionSort a = new InsertionSort();
        //a.sort(new int[] {});
    }

    /***
     *
     * Provides an insertion sort in C
     * @param values values to sort
     */
    @Override
    public native void sort(int[] values);

}
