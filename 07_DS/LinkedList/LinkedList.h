#ifndef LINKEDLIST_H
#define LINKEDLIST_H

#include "Node.h"
#define INDEX 0
class LinkedList {
    private:
    int count;
    Node *head;
    Node *tail;
    public:
    LinkedList();
    LinkedList(const LinkedList& other);
    void addNode(int val);
    void insertAfter(int val,int target);
    void insertBefore(int val,int target);
    Node* getHead();
    void setHead(Node* node);
    void display();
    int getCount() const;
    bool isEmpty() const;
    int getDataByIndex(int index) const;
    void swapNodes(Node* one, Node* two);
    Node* getNodeByIndex(int index) const;
    void removeAll(int data);
    void removeNode(int val);
    ~LinkedList();
};

#endif