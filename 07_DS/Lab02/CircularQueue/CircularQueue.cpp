#include "CircularQueue.h"
void Queue::enqueue(int element) {
  linkedList.addNode(element);
  Node *tail = linkedList.getNodeByIndex(linkedList.getCount() - 1);
  Node *head = linkedList.getHead();
  if (head && tail) {
    head->prev = tail;
    tail->next = head;
  }
}
void Queue::dequeue() {
  if (linkedList.isEmpty())
    return;
  Node *oldHead = linkedList.getHead();
  Node *newHead = oldHead->next;
  linkedList.removeNode(oldHead->val);
  if (!linkedList.isEmpty()) {
    Node *tail = linkedList.getNodeByIndex(linkedList.getCount() - 1);
    Node *head = linkedList.getHead();

    tail->next = head;
    head->prev = tail;
  }
}
int Queue::peek() { return linkedList.getDataByIndex(0); }
void Queue::display() {
  if (linkedList.isEmpty())
    return;

  Node *curr = linkedList.getHead();
  int count = linkedList.getCount();

  for (int i = 0; i < count; i++) {
    cout << curr->val << " ";
    curr = curr->next;
  }
  cout << "\n";
}