#include <iostream>
#include <string>
#include <sstream>

using namespace std;

void printstring() {
    string hello = "Hello, World!";
    string program = "I'm a C++ program";

    cout << hello << endl;
    cout << program << endl;

    cout << hello.size() << endl;
}

void printint() {
    int a = 5;
    int b = 1;
    int result;
    string mystr;

    result = a + b;
    cout << result << result << result << endl;

    result = a % 19;
    cout << result << endl;

    result = a > b ? a : b;
    cout << result << endl;


    if (a < b) {
        cout << "Please enter an integer value: ";
        cin >> result;
        cout << result;

        cout << "Enter price: ";
        getline(cin, mystr);
        stringstream(mystr) >> result;
        cout << result;
    }

    while (b < a) {
        cout << b << endl;
        b++;
    }
}

int addFunc(int a, int b) {

}

int main() {
    printstring();
    printint();
    return 0;
}
