package com.hut;

import java.io.IOException;
import java.util.Random;

public class DataGenerator {

    public static void main(String[] args){
        if(args.length != 2){
            // Invalid args print usage message
            usageMessage();
        }

        int thisMany;

        try{
            thisMany = Integer.parseInt(args[1]);
            FileUtil.writeFile(args[0], generateNumbers(thisMany));
            System.out.println("Data successfully generated in: " + args[0]);
        }catch(NumberFormatException e){
            usageMessage();
        }catch(IOException e){
            System.err.println(String.format("Unable to write to file: %s", args[0]));
        }


    }

    private static void usageMessage(){
        StringBuilder sb = new StringBuilder();
        sb.append("java com.hut.DataGenerator <outfile> <num_values>\n")
            .append("\toutfile is the file to output the numbers too\n")
            .append("\tnum_files is the number of integers to put in the file\n");
        System.out.println(sb.toString());
        System.exit(1);
    }

    public static int[] generateNumbers(int thisMany){
        int[] rands = new int[thisMany];
        Random gen = new Random();

        for(int i = 0; i < thisMany; i++){
            rands[i] = gen.nextInt(100);
        }
        return rands;
    }
}
