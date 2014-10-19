package com.hut;

/***
 * Magic Sort Class that will eventually extend Thread so that the HeapSort
 * and C sort will be able to extend this class.
 */
public abstract class Sort extends Thread{

    protected int[] sortedValues;
    protected boolean complete = false;

    protected int[] values;

    public int[] getSortedValues(){
        return sortedValues;
    }

    public boolean isComplete(){
        return complete;
    }

    public abstract void sort();

    public void setValues(int[] values){
        this.values = values;
    }

    @Override
    public void run(){
        try{
            this.sort();
        } catch (ThreadDeath td){
            // The watchdoge strikes again!
            System.out.println("Sort timed out");
        }
    }
}
