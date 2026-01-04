/**
 * @file LinearSearch.cpp
 * @brief Implementation of Linear Search on a Linked List.
 */
#include "LinearSearch.h"
int LinearSearch::indexOf(const LinkedList& linkedList, int target) {
    Node *curr = linkedList.getNodeByIndex(0);
    for(int i = 0; i < linkedList.getCount(); i++) {
        if(curr->val == target)
            return i;
        curr = curr->next;
    }
    return -1;
}