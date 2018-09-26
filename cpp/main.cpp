#include <iostream>

using namespace std;

int main() {
    int a = 5;
    int b = 1;
    int result;
    string hello = "Hello, World!";
    string program = "I'm a C++ program";

    result = a + b;
    cout << result << result << result << endl;

    result = a % 19;
    cout << result << endl;

    result = a > b ? a : b;
    cout << result << endl;

    cout << hello << endl;
    cout << program << endl;


    cout << hello.size() << endl;

    return 0;
}