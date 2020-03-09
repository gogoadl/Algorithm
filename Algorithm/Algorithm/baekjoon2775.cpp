#include <iostream>
#include <stdlib.h>
using namespace std;

int main()
{
	int t;
	int a[15][15] = {0};
	int k, n;

	for (int i = 1; i < 15; i++)
		a[0][i] = i;
	
	for (int i = 1; i < 15; i++)
	{
		for (int j = 1; j < 15; j++)
		{
			a[i][j] = a[i - 1][j] + a[i][j - 1];
		}
	}
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		cin >> k >> n;
		cout << a[k][n] << endl;
	}


	system("pause");
	return 0;
}