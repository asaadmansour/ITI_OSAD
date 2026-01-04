/**
 * @file Stack.h
 * @brief Declaration of the Stack class.
 *
 * This file contains the definition of the Stack class, which implements
 * a stack data structure using the LinkedList class.
 */
#include "../LinkedList/LinkedList.h"
#include <iostream>
using namespace std;
class Stack {
    private:
        LinkedList linkedList;
    public:
        void push(int element);
        void pop();    
        int peek();
        void display();
};