package com.hut;

import java.io.*;

/**
 * Util class for writing to files
 *
 * Created by chris on 17/10/14.
 */
public class FileUtil {

    public static String[] readFile(String name) throws IOException{
        BufferedReader reader = null;
        String[] values;

        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
            values = reader.readLine().split(" ");
        }finally{
            if(reader != null){
                reader.close();
            }
        }
        return values;
    }

    public static void writeFile(String name, int[] values) throws IOException{
        PrintWriter writer = null;

        try{
            writer = new PrintWriter(name);
            for(int value: values){
                writer.write(value + " ");
            }
        }finally {
            // Even if we raise an IOException we'll still hit this before propagating
            if(writer != null){
                writer.close();
            }
        }

    }
}
