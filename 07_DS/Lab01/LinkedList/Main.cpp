/**
 * @file Main.cpp
 * @brief Entry point for the LinkedList application.
 *
 * This file tests the functionality of the LinkedList class.
 */
#include "LinkedList.h"
int main() {
    LinkedList l;
    l.addNode(5);
    l.addNode(15);
    l.addNode(15);
    l.addNode(15);
    l.addNode(15);
    l.addNode(25);
    l.addNode(35);
    l.addNode(45);
    l.insertAfter(20,15);
    l.insertBefore(40,45);
    l.display();
    cout <<"Count: " <<  l.getCount() << endl;
    cout <<"Data at index " << INDEX << ": " <<  l.getDataByIndex(INDEX) << endl;
    l.removeAll(15);
    l.display();
    return 0;
}