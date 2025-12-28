#include "BinarySearch.h"
#include <iostream>
using namespace std;
void displayResult(int result) {
    if(result == -1)
        cout << "Number not found!" << endl ;
    else 
        cout << "Number is at index " << result << endl;
}
int main() {
    LinkedList linkedList;
    BinarySearch bs;
    linkedList.addNode(5);
    linkedList.addNode(15);
    linkedList.addNode(25);
    linkedList.addNode(35);
    linkedList.addNode(45);
    linkedList.addNode(55);
    int result1 = bs.indexOf(linkedList,25);
    int result2 = bs.indexOf(linkedList,12);
    displayResult(result1);
    displayResult(result2);
    return 0;
}