/**
 * @file BubbleSort.cpp
 * @brief Implementation of Bubble Sort on a Linked List.
 */
#include "BubbleSort.h"
void BubbleSort::sort(LinkedList& linkedList){
    int length = linkedList.getCount();
    for(int i = 0; i < length - 1; i++) {
        for(int j = 0; j < length - i - 1; j++) {
            if(linkedList.getDataByIndex(j)>linkedList.getDataByIndex(j+1)) {
                linkedList.swapNodes(linkedList.getNodeByIndex(j),linkedList.getNodeByIndex(j+1));
            }
        }
    }
}