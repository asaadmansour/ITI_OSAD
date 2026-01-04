/**
 * @file Node.h
 * @brief Declaration of the Node class.
 *
 * This file contains the definition of the Node class used in the LinkedList.
 * Each node stores an integer value and pointers to the next and previous nodes.
 */
#ifndef NODE_H
#define NODE_H

#include <iostream>
using namespace std;
class Node {
    public:
    int val;
    Node *next;
    Node *prev;
    Node();
    Node(int val);
};

#endif