cd src
# Remove any existing files that we've created
rm -f outfile.txt sorted.txt
cd com/hut
# Remove old class files
rm *.class
# Compile
javac *.java
cd ../../
# Generate new Data file
java com.hut.DataGenerator outfile.txt 10000


# Ensure JAVA_HOME is set
: ${JAVA_HOME:?"Need to set JAVA_HOME, on lab machines this is /usr/lib/jvm/java-1.7.0"}
# Remove any existing libraries
rm -f *.so
# Perform JNI Magic
javah -jni com.hut.InsertionSort
gcc -o libinsertionsort.so -lc -shared -I $JAVA_HOME/include -I $JAVA_HOME/include/linux -fPIC com/hut/insertion_sort.c
export LD_LIBRARY_PATH=.
# Run driver program
java com.hut.Driver outfile.txt sorted.txt 0.5 0.01 1000
