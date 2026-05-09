/**
 * @file LinkedList.cpp
 * @brief Implementation of the LinkedList class.
 *
 * This file implements the methods of the LinkedList class defined in LinkedList.h.
 */
#include "LinkedList.h"
LinkedList::LinkedList() {
    head = tail = nullptr;
    count = 0;
}
LinkedList::LinkedList(const LinkedList& other) {
    head = tail = nullptr;
    count = 0;
    Node* curr = other.head;
    while(curr != nullptr) {
        addNode(curr->val);
        curr = curr->next;
    }
}
void LinkedList::addNode(int val) {
    Node *newNode = new Node(val);
     if(head == nullptr) {
        head = tail = newNode;
     } else {
        tail->next = newNode;
        newNode->prev = tail;
        tail = newNode;
     }
     count++;
}
void LinkedList::insertAfter(int val,int target) {
    Node *newNode = new Node(val);
    Node *curr = head;
    while(curr->val != target && curr!=nullptr) {
        curr = curr->next;
    }
    if (curr == nullptr) {
        std::cout << "Target not found\n";
        delete newNode;
        return;
    }
    newNode->next = curr->next;
    newNode->prev = curr;
    if(curr->next != nullptr) {
        curr->next->prev = newNode;
    } else {
        tail = newNode;
    }
    curr->next = newNode;
    count++;
}
void LinkedList::insertBefore(int val,int target) {
    Node *newNode = new Node(val);
    Node *curr = head;
    while(curr->next->val != target && curr!=nullptr) {
        curr = curr->next;
    }
    if (curr == nullptr) {
        std::cout << "Target not found\n";
        delete newNode;
        return;
    }
    newNode->next = curr->next;
    newNode->prev = curr;
    if(curr->next != nullptr) {
        curr->next->prev = newNode;
    } else {
        tail = newNode;
    }
    curr->next = newNode;
    count++;
}
void LinkedList::display() {
    Node *curr = head;
    while(curr != nullptr) {
        cout << curr->val << endl;
        curr = curr->next;
    }
}
int LinkedList::getCount() const {
    return count;
}
bool LinkedList::isEmpty() const {
    return count == 0;
}
int LinkedList::getDataByIndex(int index) const {
    Node *curr = head;
    for(int i = 0; i < index; i++) {
        curr = curr->next;
    }
    return curr->val;
}
Node* LinkedList::getNodeByIndex(int index) const {
    Node *curr = head;
    for(int i = 0; i < index; i++) {
        curr = curr->next;
    }
    return curr;
}
void LinkedList::removeNode(int val) {
    Node* curr = head;

    while (curr != nullptr) {
        if (curr->val == val) {
            if (curr == head && curr == tail) {
                head = tail = nullptr;
            } else if (curr == head) {
                head = head->next;
                head->prev = nullptr;
            } else if (curr == tail) {
                tail = tail->prev;
                tail->next = nullptr;
            } else {
                curr->prev->next = curr->next;
                curr->next->prev = curr->prev;
            }
            delete curr;
            count--;
            return;
        }
        curr = curr->next;
    }

}
void LinkedList::removeAll(int val) {
    Node* curr = head;

    while(curr != nullptr) {
        Node* nextNode = curr->next; 
        if(curr->val == val) {
            if(curr == head && curr == tail) {
                head = tail = nullptr;
            } else if(curr == head) {
                head = head->next;
                head->prev = nullptr;
            } else if(curr == tail) {
                tail = tail->prev;
                tail->next = nullptr;
            } else {
                curr->prev->next = curr->next;
                curr->next->prev = curr->prev;
            }
            delete curr;
        }
        curr = nextNode; 
    }
}
LinkedList::~LinkedList() {
    Node* curr = head;
    while (curr != nullptr) {
        Node* nextNode = curr->next; 
        delete curr;                 
        curr = nextNode;             
    }
    head = tail = nullptr;
    count = 0;
}
void LinkedList::swapNodes(Node* one,Node* two) {
    Node *temp = new Node(one->val);
    one->val = two->val;
    two->val = temp->val;
}
Node* LinkedList::getHead(){
    return head;
};
void LinkedList::setHead(Node* node) {
    head = node;
}
void LinkedList::insertAtHead(int val) {
    Node *newNode = new Node(val);
    if (head == nullptr) {
        head = tail = newNode;
    } else {
        newNode->next = head;
        head->prev = newNode;
        head = newNode;
    }
    count++;
}