package com.hut;

import java.io.IOException;
import java.util.Timer;

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
        int[] valuesForPrimary = valuesToSort.clone();
        Sort primary = new HeapSort();
        runSort(primary, valuesForPrimary, timeout, primaryFailure);
        if(primary.isComplete() && AcceptanceTest.isSorted(valuesForPrimary)){
            System.out.println("Primary sort completed");
            // This sorted everything properly, we can go home now
            try{
                FileUtil.writeFile(out, valuesForPrimary);
            }catch(IOException e){
                // Fuck we were so close
                System.err.println("We were so close, but error writing to file");
                System.exit(1);
            }
        }else{
            System.out.println("Primary sort failed");
            Sort secondary = new InsertionSort();
            runSort(secondary, valuesToSort, timeout, secondaryFailure);

            if(secondary.isComplete() && AcceptanceTest.isSorted(valuesToSort)){
                System.out.println("Secondary sort completed");
                try{
                    FileUtil.writeFile(out, valuesToSort);
                }catch(IOException e){
                    // Great effort boys but today just wasn't our day
                    System.err.println("Damn that was the kind of effort we like to see from you guys out there");
                    System.exit(1);
                }
            } else{
                System.out.println("Both sorts failed");
            }
        }

    }

    private static void runSort(Sort s, int[] values, int timeout, double failure){
        WatchDoge watchDoge = new WatchDoge(s);
        Timer t = new Timer();
        s.setValues(values);
        s.setFailure(failure);
        t.schedule(watchDoge, timeout);
        s.start();
        try{
            s.join();
            t.cancel();
        } catch(InterruptedException e){
            System.out.println("k");
            // Can't those doges learn their manners
        }
    }

    private static int[] getValuesToSort(String fileName) throws IOException{
        String values[] = FileUtil.readFile(fileName);
        int intValues[] = new int[values.length];
        try{
            for(int i = 0; i < values.length; i++){
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
        sb.append("java com.hut.Driver <in_file> <out_file> <primary_fail> <secondary_fail> <timeout>\n")
            .append("\tin_file is the input file containing integer values to sort\n")
            .append("\tout_file is the output file where sorted values will be written too\n")
            .append("\tprimary_fail is the noFailure probability of the primary sorting algorithm\n")
            .append("\tsecondary_fail is the noFailure probability of the secondary sorting algorithm\n")
            .append("\ttimeout is number of seconds to wait for each sort");
        System.out.println(sb.toString());
        System.exit(1);
    }
    /**
     * Used for debugging, prints array to console*/
    private static void debugPrint(int[] a){
        StringBuilder sb = new StringBuilder();
        for (int anA : a) {
            sb.append(anA).append(" ");
        }
        System.out.println(sb.toString());
    }
}
