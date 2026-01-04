/**
 * @file Queue.cpp
 * @brief Implementation of the Queue class.
 *
 * This file implements the methods of the Queue class defined in Queue.h.
 */
#include "Queue.h"
void Queue::enqueue(int element) {
    linkedList.addNode(element);
}
void Queue::dequeue() {
    if(linkedList.isEmpty()) return;
    linkedList.removeNode(linkedList.getDataByIndex(0));
}
int Queue::peek() {
    return linkedList.getDataByIndex(0);
}
void Queue::display() {
    if(linkedList.isEmpty()) return;
    Node *curr = linkedList.getNodeByIndex(0);
    while(curr!=nullptr) {
        cout << curr->val << " ";
        curr = curr->next;
    }
    cout << "\n";
}