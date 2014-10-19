cd src/com/hut
rm *.class
javac *.java
cd ../../
# Generate new Data file
java com.hut.DataGenerator outfile.txt 10


: ${JAVA_HOME:?"Need to set JAVA_HOME, on lab machines this is /usr/lib/jvm/java-1.7.0"}
rm *.so
javah -jni com.hut.InsertionSort
gcc -o libinsertionsort.so -lc -shared -I $JAVA_HOME/include -I $JAVA_HOME/include/linux -fPIC com/hut/insertion_sort.c
export LD_LIBRARY_PATH=.
java com.hut.Driver outfile.txt sorted.txt 1 1 1
