/**
 * @file main.cpp
 * @brief Entry point for the DoubleEndedQueue application.
 *
 * This file tests the functionality of the Dequeue class.
 */
#include "Dequeue.h"
#include <iostream>
using namespace std;

int main() {
    Dequeue dq;
    
    cout << "=== Testing Double-Ended Queue ===" << endl;
    
    // Test isEmpty on empty deque
    cout << "\n1. Is empty (should be 1): " << dq.isEmpty() << endl;
    
    // Test enqueueFront
    cout << "\n2. Enqueue front: 10, 20, 30" << endl;
    dq.enqueueFront(10);
    dq.enqueueFront(20);
    dq.enqueueFront(30);
    cout << "   Contents: ";
    dq.display();
    
    // Test enqueueRear
    cout << "\n3. Enqueue rear: 40, 50" << endl;
    dq.enqueueRear(40);
    dq.enqueueRear(50);
    cout << "   Contents (expected 30 20 10 40 50): ";
    dq.display();
    
    // Test dequeueFront
    cout << "\n4. Dequeue front (removes 30)" << endl;
    dq.dequeueFront();
    cout << "   Contents: ";
    dq.display();
    
    // Test dequeueRear
    cout << "\n5. Dequeue rear (removes 50)" << endl;
    dq.dequeueRear();
    cout << "   Contents (expected 20 10 40): ";
    dq.display();
    
    // Empty the deque
    cout << "\n6. Emptying deque..." << endl;
    dq.dequeueFront();
    dq.dequeueFront();
    dq.dequeueFront();
    cout << "   Is empty (should be 1): " << dq.isEmpty() << endl;
    
    // Test dequeue on empty
    cout << "\n7. Dequeue on empty (should not crash)" << endl;
    dq.dequeueFront();
    dq.dequeueRear();
    cout << "   Passed!" << endl;
    
    cout << "\n=== All tests completed! ===" << endl;
    
    return 0;
}
