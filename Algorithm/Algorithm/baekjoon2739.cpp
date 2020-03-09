#include <iostream>
#include <stdlib.h>
using namespace std;

int main()
{
	int N;
	cin >> N;
	for (int i = 1; i < 10; i++)
	{
		cout << N << " * " << i << " = " << N * i << endl;
	}


	system("pause");
	return 0;
}