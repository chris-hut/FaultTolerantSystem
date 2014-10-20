#include "com_hut_InsertionSort.h"

JNIEXPORT jint JNICALL Java_com_hut_InsertionSort_cSort
  (JNIEnv *env, jobject ojb, jintArray array){

    int memoryAccesses = 0;
    jsize len = (*env)->GetArrayLength(env, array);
    jint *localArray;
    localArray  = (jint *) (*env)->GetIntArrayElements(env, array, 0);

    int i, j, k;
    for(i = 1; i < len; i++){
        j = i;
        while (j > 0 && localArray[j] < localArray[j-1]){
            memoryAccesses += 3;
            k = localArray[j];
            memoryAccesses++;
            localArray[j] = localArray[j-1];
            memoryAccesses += 2;
            localArray[j-1] = k;
            memoryAccesses++;
            j--;
            memoryAccesses++;
        }
    }

    (*env)->ReleaseIntArrayElements(env, array, localArray, 0);
    return memoryAccesses;
}