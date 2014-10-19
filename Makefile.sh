cd src/com/hut
rm *.so *.class
javac *.java
cd ../../
rm *.so
javah -jni com.hut.InsertionSort
cp com_hut_InsertionSort.h com/hut/
gcc -o libinsertionsort.so -lc -shared -I $JAVA_HOME/include -I $JAVA_HOME/include/linux -fPIC com/hut/insertion_sort.c
chmod +x libinsertionsort.so
cp libinsertionsort.so com/hut/
export LD_LIBRARY_PATH=.:./com/hut/
java com.hut.InsertionSort