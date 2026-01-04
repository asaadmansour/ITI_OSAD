/**
 * @file Main.cpp
 * @brief Test for Bubble Sort.
 */
#include "BubbleSort.h"
int main() {
    LinkedList l;
    BubbleSort b;
    l.addNode(23);
    l.addNode(13);
    l.addNode(33);
    l.addNode(43);
    l.addNode(53);
    l.addNode(3);
    b.sort(l);
    l.display();
    return 0;
}