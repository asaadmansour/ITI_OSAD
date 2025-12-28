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