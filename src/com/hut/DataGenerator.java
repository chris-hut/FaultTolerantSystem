package com.hut;

import java.io.IOException;
import java.util.Random;

/**
 * Created by chris on 10/17/14.
 */
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
        // TODO: Make actual usage message
        System.out.println("Learn to use the program");
        System.exit(1);
    }

    public static int[] generateNumbers(int thisMany){
        int[] rands = new int[thisMany];
        Random gen = new Random();

        for(int i = 0; i < thisMany; i++){
            rands[i] = gen.nextInt();
        }
        return rands;
    }
}
