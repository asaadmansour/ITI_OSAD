#include "SelectionSort.h"
void SelectionSort::sort(LinkedList& linkedList) {
    if(linkedList.isEmpty()) return;
    for(int i = 0; i < linkedList.getCount() - 1; i++) {
        Node* minNode = linkedList.getNodeByIndex(i);
        for(int j = i + 1; j < linkedList.getCount(); j++) {
            if(linkedList.getNodeByIndex(j)->val < minNode->val)
                minNode = linkedList.getNodeByIndex(j);
        }
        linkedList.swapNodes(linkedList.getNodeByIndex(i),minNode);
    }
}