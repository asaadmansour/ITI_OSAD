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