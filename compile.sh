cd src
cd com/hut
rm *.class
javac *.java
cd ../../

: ${JAVA_HOME:?"Need to set JAVA_HOME, on lab machines this is /usr/lib/jvm/java-1.7.0"}
rm -f *.so
javah -jni com.hut.InsertionSort
gcc -o libinsertionsort.so -lc -shared -I $JAVA_HOME/include -I $JAVA_HOME/include/linux -fPIC com/hut/insertion_sort.c
export LD_LIBRARY_PATH=.

