#include <stdio.h>
int main()
{
    int n;
	//Write code here
	scanf("%d", &n);
	long int arr[n];
	long int arr2[n];
	for(int i = 0; i < n; i++)
		scanf("%ld", &arr[i]);
	for(int i = 0; i < n; i++)
		scanf("%ld", &arr2[i]);
	long int min = arr2[0]/arr[0];
	for(int i = 1; i< n; i++)
	{
		int temp = arr2[i]/arr[i];
		if(temp < min)
			min = temp;
	}
	printf("%ld\n", min);
    return 0;
}