/**
 * @file Dequeue.h
 * @brief Declaration of the Dequeue (Double Ended Queue) class.
 *
 * This file contains the definition of the Dequeue class.
 */
#include "../LinkedList/LinkedList.h"
using namespace std;
class Dequeue {
private:
  LinkedList linkedList;

public:
  void enqueueFront(int val);
  void dequeueFront();
  void enqueueRear(int val);
  void dequeueRear();
  bool isEmpty();
  void display();
};