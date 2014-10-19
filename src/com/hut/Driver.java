package com.hut;

import java.io.File;
import java.io.IOException;

/**
 * Drives the whole program!
 */
public class Driver {

    public static void main(String[] args){
        if(args.length != 5|| args[0].equals("--help") || args[0].equals("-h")){
            // Someone doesn't know how to use this
            invalidInput();
        }

        String in = args[0];
        String out = args[1];
        double primaryFailure = -1.0f;
        double secondaryFailure = -1.0f;
        int timeout = -1;
        try{
            primaryFailure = Double.parseDouble(args[2]);
            secondaryFailure = Double.parseDouble(args[3]);
            timeout = Integer.parseInt(args[4]);
        } catch(NumberFormatException e){
            // Some of the arguments weren't numbers
            invalidInput();
        }

        int[] valuesToSort = null;
        try{
            valuesToSort = getValuesToSort(in);
        }catch(IOException e){
            // Something messed up reading from the file
            System.err.println("Error reading file");
            e.printStackTrace();
            System.exit(1);
        }

        // If we're here we have a good array to sort!
        int[] valuesForPrimary = valuesToSort;
        runSort(new HeapSort(), valuesForPrimary, timeout, primaryFailure);
        // TODO: Check if sort failed or if watchdoge expired
        if(AcceptanceTest.isSorted(valuesForPrimary)){
            // This sorted everything properly, we can go home now
            try{
                FileUtil.writeFile(out, valuesForPrimary);
            }catch(IOException e){
                // Fuck we were so close
                System.err.println("We were so close, but error writing to file");
                System.exit(1);
            }
        }else{
            // TODO: Gotta run the secondary sort
        }

    }

    private static void runSort(Sort s, int[] values, int timeout, double failure){
        // TODO: Watchdog shit it in here

        s.sort(values);
    }

    private static int[] getValuesToSort(String fileName) throws IOException{
        String values[] = FileUtil.readFile(fileName);
        int intValues[] = new int[values.length];
        try{
            for(int i = 0; i < values.length-1; i++){
                intValues[i] = Integer.parseInt(values[i]);
            }
        }catch(NumberFormatException e){
            System.err.println(String.format("File: %s contained non integer values", fileName));
            System.exit(1);
        }
        return intValues;
    }

    private static void invalidInput(){
        System.out.println("DataSorter is a fault tolerant sorting system.");
        StringBuilder sb = new StringBuilder();
        sb.append("java sorter <in_file> <out_file> <primary_fail> <secondary_fail> <timeout>\n")
                .append("<in_file> is the input file containing integer values to sort\n")
                .append("<out_file> is the output file where sorted values will be written too\n")
                .append("<primary_fail> is the failure probability of the primary sorting algorithm")
                .append("<secondary_fail> is the failure probability of the secondary sorting algorithm")
                .append("<timeout> is number of seconds to wait for each sort");
        System.out.println(sb.toString());
        System.exit(1);
    }
}
