package com.hut;

/***
 * Magic Sort Class that will eventually extend Thread so that the HeapSort
 * and C sort will be able to extend this class.
 */
public abstract class Sort {
    // TODO: Hopefully I do this

    protected int[] sortedValues;
    protected boolean complete = false;

    public int[] getSortedValues(){
        return sortedValues;
    }

    public boolean isComplete(){
        return complete;
    }

    public abstract void sort(int[] values);
}
