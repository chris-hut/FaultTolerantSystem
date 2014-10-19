#include "com_hut_InsertionSort.h"

JNIEXPORT jint JNICALL Java_com_hut_InsertionSort_cSort
  (JNIEnv *env, jobject ojb, jintArray array){
    printf("We have to go back\n");

    jsize len = (*env)->GetArrayLength(env, array);
    jint *localArray;
    localArray  = (jint *) (*env)->GetIntArrayElements(env, array, 0);

    int i, j, k;
    for(i = 1; i < len; i++){
        j = i;
        while (j > 0 && localArray[j] < localArray[j-1]){
            k = localArray[j];
            localArray[j] = localArray[j-1];
            localArray[j-1] = k;
            j--;
        }
    }

    // TODO: Check if we died here and return 0 if we did die

    (*env)->ReleaseIntArrayElements(env, array, localArray, 0);

    return 1;
}