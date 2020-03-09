#include <iostream>
#include <stdlib.h>
#include <algorithm>
using namespace std;

int main()
{
	int n;
	int arr[1000];
	int sum = 0;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
	sort(arr,arr+5);
	for (int i = 0; i < n; i++) // 3 1 4 3 2, 4 1 3 3 2
	{
		for(int j =0; j < n; j++)
		{
			if (arr[i] < arr[j]) // 3 < 4, 1 < 4
			{
				int tmp = arr[j]; // 
				arr[j] = arr[i]; // arr[2] = 3, arr[0] = 1
				arr[i] = tmp; // arr[0] = 4, arr[1] = 4
			}
		}
	}
	
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j <= i; j++)
		{
			sum += arr[j]; // 
		}
	}

	cout << sum;

	system("pause");
	return 0;
	
}