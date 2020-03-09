#include <iostream>
#include <stdlib.h>
using namespace std;

int main()
{
	int N;
	
	int min = 100000;
	int max = -100000;

	int T = 0;
	cin >> N;
	if(N>0)
	{ 
	for (int i = 0; i < N; i++)
		{
		cin >> T;
		if (T > max)
			max = T;
		if (T < min)
			min = T;
		}
	}
	cout << max << " " << min << endl;

	system("pause");
	return 0;
}