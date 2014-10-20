package com.hut;


/***
 * Magic Sort Class that will eventually extend Thread so that the HeapSort
 * and C sort will be able to extend this class.
 */
public abstract class Sort extends Thread{

    protected boolean complete = false;

    protected int[] values;

    private double failure = 0;

    /**
     * The number of memory accesses that are made during a sort. This will be incremented by the
     * sort itself.*/
    protected int memoryAccesses = 0;

    public boolean isComplete(){
        return complete;
    }

    public abstract void sort();

    public void setValues(int[] values){
        this.values = values;
    }

    public void setFailure(double failure){this.failure = failure;}

    @Override
    public void run(){
        try{
            this.sort();
        } catch (ThreadDeath td){
            // The watchdoge strikes again!
            System.out.println("Sort timed out");
            throw new ThreadDeath();
        }
    }

    protected boolean noFailure(){
        if(failure == 0) return true;

        double hazard = memoryAccesses*failure;
        double random = Math.random();
        if(random >= 0.5 && random <=0.5+hazard){
            System.out.println("Hardware noFailure");
            return false;
        }
        return true;
    }
}
