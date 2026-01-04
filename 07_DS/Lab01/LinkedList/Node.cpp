#include "Node.h"
    Node::Node() {
        this->val = 0;
        this->next = nullptr;
        this->prev = nullptr;
    }
    Node::Node(int val) {
        this->val = val;
        this->next = nullptr;
        this->prev = nullptr;
    }