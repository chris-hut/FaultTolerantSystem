package com.hut;

import java.util.Random;

public class InsertionSort extends Sort {

    static{
        System.loadLibrary("insertionsort");
    }

    public static void main(String[] args){
        // Uncomment this to perform basic sanity test
        //testInsertionSort();
    }

    /***
     *
     * Provides an insertion sort in C
     */
    @Override
    public void sort(){
        // TODO: Check return value of cSort
        cSort(values);
        for(;;);
     }

    private native int cSort(int[] values);

    /**
     * My shitty little test suite since I can't figure out how to get use
     * JNI with JUnit*/
    private static void testInsertionSort(){
        Random rand = new Random();
        int[] a = {0};
        InsertionSort is = new InsertionSort();
        is.setValues(a);
        is.sort();
        checkSorted(a);
        int[] b= {};
        is.setValues(b);
        is.sort();
        checkSorted(b);
        int[] c= {1,1,1,1,1};
        is.setValues(c);
        is.sort();
        checkSorted(c);
        int[] d = {4,8,15,16,23,42};
        is.setValues(d);
        is.sort();
        checkSorted(d);
        int[] e = {108,42,23,16,15,8,4};
        is.setValues(e);
        is.sort();
        checkSorted(e);
        int[] f = new int[100];
        for(int i = 0; i < 100; i++){
            f[i] = rand.nextInt();
        }
        is.setValues(f);
        is.sort();
        checkSorted(f);
        int[] g = new int[101];
        for(int i = 0; i < 100; i++){
            g[i] = rand.nextInt();
        }
        is.setValues(g);
        is.sort();
        checkSorted(g);

    }

    private static void checkSorted(int[] a){
        if(a.length == 0) return;
        int prev = a[0];
        for(int i = 1; i < a.length-1; i++){
            if(prev > a[i]){
                System.out.println(String.format("A[%d]: %d, A[%d]: %d", i, a[i], i - 1, a[i - 1]));
            }
            prev = a[i];
        }
    }
}
