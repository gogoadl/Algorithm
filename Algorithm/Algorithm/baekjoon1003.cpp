#include <iostream>
#include <stdlib.h>
using namespace std;

int fibonacci(int n);

int zero, one;
int main()
{
	int testcase;
	int N[40];

	cin >> testcase;

	for (int i = 0; i < testcase; i++)
	{
		cin >> N[i];

		fibonacci(N[i]);

		cout << zero << " " << one << endl;
		zero = 0;
		one = 0;
	}

	system("pause");

	return 0;
}

int fibonacci(int n)
{
	if (n == 0) {
		zero++;
		return 0;
	}
	else if (n == 1) {
		one++;
		return 1;
	}
	else {
		return fibonacci(n-1) + fibonacci(n-2);
	}
}