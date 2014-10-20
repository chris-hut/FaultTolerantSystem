package com.hut;

/**
 * Performs a heapsort on an array of ints
 */
public class HeapSort extends Sort{

    private int heapSize;

    @Override
    public void sort(){
        if(values.length == 1) return;                                  memoryAccesses++;

        if (values == null) return;                                     memoryAccesses++;

        // build heap and sort it
        buildHeap();
        for (int i = values.length-1; i>=1; i--){                       memoryAccesses+=2;
            swapElements(0, i);
            heapSize--;                                                 memoryAccesses++;
            maxHeapify(0);
        }
        complete = noFailure();
    }

    private void buildHeap(){
        heapSize = values.length;                                       memoryAccesses+=2;
        int halfway = (values.length-1)/2;                              memoryAccesses+=2;
        for (int i = halfway; i >= 0; i--){                             memoryAccesses+=2;
            maxHeapify(i);
        }
    }

    private void swapElements(int i, int j){
        if(i<0 || i >= values.length){                                  memoryAccesses+=3;
            return;
        }

        if(j<0 || j >= values.length){                                  memoryAccesses+=3;
            return;
        }

        // Was going to swap in place, but we care more about memory hits than temp vars
        int temperino = values[i];                                      memoryAccesses++;
        values[i] = values[j];                                          memoryAccesses++;
        values[j] = temperino;                                          memoryAccesses++;
    }

    private void maxHeapify(int root){
        int lc = leftChild(root);                                       memoryAccesses++;
        int rc = rightChild(root);                                      memoryAccesses++;

        int big = root;                                                 memoryAccesses++;
        if(lc < heapSize && values[lc] > values[root]){                 memoryAccesses+=4;
            big = lc;                                                   memoryAccesses++;
        }
        if(rc < heapSize && values[rc] > values[big]){                  memoryAccesses+=4;
            big = rc;                                                   memoryAccesses++;
        }
        if(big != root){                                                memoryAccesses+=2;
            swapElements(root, big);
            maxHeapify(big);
        }
    }

    private int leftChild(int i){
                                                                        memoryAccesses++;
        return i*2;
    }

    private int rightChild(int i){
                                                                        memoryAccesses++;
        return i*2+1;
    }
}