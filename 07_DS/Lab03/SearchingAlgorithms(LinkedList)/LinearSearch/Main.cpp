#include "LinearSearch.h"
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
    LinearSearch linearSearch;
    linkedList.addNode(10);
    linkedList.addNode(20);
    linkedList.addNode(30);
    linkedList.addNode(50);
    linkedList.addNode(5);
    int result1 = linearSearch.indexOf(linkedList,5);
    int result2 = linearSearch.indexOf(linkedList,12);
    int result3 = linearSearch.indexOf(linkedList,20);
    displayResult(result1);
    displayResult(result2);
    displayResult(result3);
    return 0;
}