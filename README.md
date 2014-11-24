Chris Hut 1268574
ECE 422 Reliable and Secure Systems Design

Project 1: Fault Tolerant Systems

Running Program:

To compile both DataGenerator and Driver:
$ ./compile.sh
* If you get a warning about JAVA_HOME not being set, please set this to allow JNI to work

DataGenerator:
* Compile with ./compile.sh
* java com.hut.DataGenerator outfile.txt 1000
** will populate outfile.txt with 1000 integers in src/

Driver:
* Compile with ./compile.sh
* java com.hut.Driver outfile.txt sorted.txt 0.05 0.05 1000
** will try and sort the values in outfile.txt, output the sorted values into sorted.txt
    with a timeout of 1000s, primary probability failure of 0.05 and secondary probability
    failure of 0.05

Notes:
* A commented example of compiling both files, creating outfile.txt with 10000 numbers in it
    and then trying to sort that into sorted.txt with failure probabilities of 0.5 and 0.01 and a timeout of 1000
    is located in ./build.sh
