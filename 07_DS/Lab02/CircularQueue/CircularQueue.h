/**
 * @file CircularQueue.h
 * @brief Declaration of the CircularQueue class.
 *
 * This file contains the definition of the CircularQueue class.
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