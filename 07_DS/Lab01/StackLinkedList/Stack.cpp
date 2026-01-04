#include "Stack.h"
void Stack::push(int element) {
    linkedList.addNode(element);
}
void Stack::pop() {
    if(linkedList.isEmpty()) return;
    int lastValue = linkedList.getDataByIndex(linkedList.getCount() - 1);
    linkedList.removeNode(lastValue);  
}
int Stack::peek() {
    return linkedList.getDataByIndex(linkedList.getCount() - 1);
}
void Stack::display() {
    if(linkedList.isEmpty()) return;
    Node *curr = linkedList.getNodeByIndex(0);
    while(curr!=nullptr) {
        cout << curr->val << " ";
        curr = curr->next;
    }
    cout << "\n";
}