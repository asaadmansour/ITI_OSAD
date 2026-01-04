#include "Dequeue.h"
void Dequeue::enqueueFront(int val) {
  if (linkedList.isEmpty()) {
    linkedList.addNode(val);
  } else {
    Node *head = linkedList.getHead();
    linkedList.insertAtHead(val);
  }
}
void Dequeue::enqueueRear(int val) { linkedList.addNode(val); }
void Dequeue::dequeueFront() {
  if (!linkedList.isEmpty()) {
    Node *head = linkedList.getHead();
    linkedList.removeNode(head->val);
  }
}
void Dequeue::dequeueRear() {
  if (!linkedList.isEmpty()) {
    Node* rear = linkedList.getNodeByIndex(linkedList.getCount() - 1);
    linkedList.removeNode(rear->val);
  }
}
bool Dequeue::isEmpty() {
  return linkedList.isEmpty();
}
void Dequeue::display() {
  linkedList.display();
}