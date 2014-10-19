package com.hut;

/**
 * Acceptance Test for the sorters.
 * Checks if array is in sorted order
 */
public class AcceptanceTest {

    private AcceptanceTest(){
        // Private constructor will never get called
    }

    /***
     *
     * @param amISorted array to check if sorted
     * @return true if sorted
     */
    public static boolean isSorted(int[] amISorted){
        int length = amISorted.length;
        if(length == 0){
            return false;
        } else if(length == 1){
            // Array of size one is sorted
            return true;
        }

        for(int i = 1; i < length-1; i++){
            if(amISorted[i] < amISorted[i-1]){
                return false;
            }
        }

        return true;

    }
}
