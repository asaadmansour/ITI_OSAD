/**
 * @file Main.cpp
 * @brief Entry point for the StackLinkedList application.
 *
 * This file tests the functionality of the Stack class.
 */
#include "Stack.h"
int main() {
    Stack s;
    s.push(10);
    s.push(20);
    s.push(30);
    s.push(40);
    s.display();
    s.peek();
    s.pop();
    s.pop();
    s.display();
    s.pop();
    s.pop();
    s.pop();
    s.display();
    return 0;
}