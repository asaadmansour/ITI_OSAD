/**
 * @file BinarySearch.h
 * @brief Declaration of Binary Search on a Linked List.
 *
 * NOTE: Binary Search on a Linked List is inefficient O(n) unless specialized structures are used,
 * but this is for educational purposes.
 */
#include "../../LinkedList/LinkedList.h"
class BinarySearch {
    public:
        static int indexOf(const LinkedList& linkedList, int target);
};