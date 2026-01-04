/**
 * @file Queue.h
 * @brief Declaration of the Queue class using Linked List.
 *
 * This file contains the definition of the Queue class, which implements
 * a queue data structure using the LinkedList class.
 */
#include "../LinkedList/LinkedList.h"
#include <iostream>
using namespace std;
class Queue {
    private:
        LinkedList linkedList;
    public:
        void enqueue(int element);
        void dequeue();
        int peek();
        void display();
};