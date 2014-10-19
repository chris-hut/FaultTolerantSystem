package com.hut;

public class InsertionSort extends Sort {

    static{
        //System.loadLibrary("libinsertionsort");
    }

    public static void main(String[] args){
        
    }

    /***
     *
     * Provides an insertion sort in C
     * @param values values to sort
     */
    @Override
    public native void sort(int[] values);

}
