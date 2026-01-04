#include "Queue.h"
int main() {
    Queue q;
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    q.enqueue(40);
    cout << q.peek() << endl;
    q.display();
    q.dequeue();
    q.display();
    cout << q.peek() << endl;
    return 0;
}