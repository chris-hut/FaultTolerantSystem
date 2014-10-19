cd src/com/hut
rm *.so *.class
javac *.java
cd ../../
javah com.hut.InsertionSort
gcc -o libinsertionsort.so -lc -shared -I $JAVA_HOME/include -I $JAVA_HOME/include/linux com_hut_InsertionSort.h
chmod +x libinsertionsort.so
cp libinsertionsort.so com/hut/
export LD_LIBRARY_PATH=.:./com/hut/
java com.hut.InsertionSort