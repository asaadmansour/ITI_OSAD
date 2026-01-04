#include "BinarySearch.h"
int BinarySearch::indexOf(const LinkedList& linkedList, int target) {  
    if(linkedList.isEmpty()) __throw_length_error;
    int left = 0, right = linkedList.getCount() - 1;
    while(left <= right) {
        int mid = left + (right - left) / 2;
        Node *curr = linkedList.getNodeByIndex(0);
        for(int i = 0; i < mid; i++) {
            curr = curr->next;
        }
        if(curr->val == target) 
            return mid;
        else if(target < curr->val) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
}