#include "InsertionSort.h"
int main() {
    LinkedList l;
    InsertionSort s;
    l.addNode(23);
    l.addNode(13);
    l.addNode(33);
    l.addNode(43);
    l.addNode(53);
    l.addNode(3);
    s.sort(l);
    l.display();
    return 0;
}