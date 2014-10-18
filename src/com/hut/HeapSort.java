package com.hut;

/**
 * Performs a heapsort on an array of ints
 */
public class HeapSort extends Sort{

    private int heapSize;

    @Override
    public void sort(int[] values){
        // If only one value it's already sorted
        if(values.length == 1) sortedValues = values;
        // If value was null let someone else deal with this
        if (sortedValues == null) return;

        // build heap and sort it
        buildHeap();
        for (int i = sortedValues.length-1; i>=1; i--){
            swapElements(0, i);
            heapSize--;
            maxHeapify(0);
        }

        complete = true;
    }

    private void buildHeap(){
        heapSize = sortedValues.length;
        int halfway = (sortedValues.length-1)/2;
        for (int i = halfway; i >= 0; i--){
            maxHeapify(i);
        }
    }

    private void swapElements(int i, int j){
        if(i<0 || i >= sortedValues.length){
            return;
        }

        if(j<0 || j >= sortedValues.length){
            return;
        }

        // Was going to swap in place, but we care more about memory hits than temp vars
        int temperino = sortedValues[i];
        sortedValues[i] = sortedValues[j];
        sortedValues[j] = temperino;
    }

    private void maxHeapify(int root){
        int lc = leftChild(root);
        int rc = rightChild(root);

        int big = root;
        if(lc < heapSize && sortedValues[lc] > sortedValues[root]){
            big = lc;
        }
        if(rc < heapSize && sortedValues[rc] > sortedValues[big]){
            big = rc;
        }
        if(big != root){
            swapElements(root, big);
            maxHeapify(big);
        }
    }

    private int leftChild(int i){
        return i*2;
    }

    private int rightChild(int i){
        return i*2+1;
    }
}