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