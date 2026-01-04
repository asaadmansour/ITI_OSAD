#include "InsertionSort.h"

void InsertionSort::sort(LinkedList& linkedList) {
    if (linkedList.isEmpty() || linkedList.getHead()->next == nullptr)
        return;
    Node* curr = linkedList.getHead()->next;
    while (curr != nullptr) {
        Node* key = curr;
        Node* prev = curr->prev;
        Node* nextCurrent = curr->next;
        while (prev != nullptr && prev->val > key->val) {
            Node* A = prev->prev;
            Node* B = key->next;
            if (A) A->next = key;
            key->prev = A;
            key->next = prev;
            prev->prev = key;
            prev->next = B;
            if (B) B->prev = prev;
            if (A == nullptr) linkedList.setHead(key);
            prev = key->prev;
        }
        curr = nextCurrent;
    }
}

/*
////////////////// Value-Based Array Like Implementation //////////////////
void InsertionSort::sort(LinkedList& linkedList) {
    int n = linkedList.getCount();
    for (int i = 1; i < n; i++) {
        int keyVal = linkedList.getNodeByIndex(i)->val;
        int j = i - 1;
        
        while (j >= 0 && linkedList.getNodeByIndex(j)->val > keyVal) {
            linkedList.getNodeByIndex(j + 1)->val =
            linkedList.getNodeByIndex(j)->val;
            j--;
        }
        linkedList.getNodeByIndex(j + 1)->val = keyVal;
    }
}
*/
