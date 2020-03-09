#include <iostream>
#include <stdlib.h>
using namespace std;

int main()
{
	int H, M;

	cin >> H >> M;

	if (H == 0)
	{
		H = 24;
	}

	if(H<=24 && H>=0 && M<=59 && M>=0)
	{ 
	if (M < 45)
	{
		H--;
		M += 60;
	}
	M -= 45;
	
	}
	cout << H << " " << M;
	system("pause");
	
	return 0;
}