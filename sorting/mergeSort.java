import java.util.Scanner;

class Main
{
    public static  void main(String[] args) {
        String input = "2\n5\n4 1 3 9 7\n10\n10 9 8 7 6 5 4 3 2 1";
        // Scanner sc = new Scanner(input);
        Scanner sc = new Scanner(System.in);
        System.out.println("No of test Case: ");
        int tCase = sc.nextInt();
        System.out.println(tCase);
        while(tCase > 0){
            System.out.println("Enter the size of array: ");
            int n = sc.nextInt();
            System.out.println(n);
            int arr[] = new int[n];
            System.out.println("Enter Elements");
            for(int i = 0; i < n; i++)
            {
                arr[i] = sc.nextInt();
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            mergeSort(arr, 0, arr.length-1);

            System.out.println("Array after sorting: ");
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
            tCase--;
        }
    }

    static void mergeSort(int arr[], int l, int r)
    {
        if(l < r)
        {
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
    static void merge(int arr[], int l, int mid, int r)
    {
        int s1 = mid-l+1;
        int s2 = r-mid;
        int Left[] = new int[s1];
        int Right[] = new int[s2];

        int i, j = 0, k = 0;
        for(i = l; i <= mid; i++)
            Left[j++] = arr[i];
        
        for(i = mid+1; i <= r; i++)
            Right[k++] = arr[i];

        j = 0;
        k = 0;
        i = l;
        while(j < s1 && k < s2)
        {
            if(Left[j] < Right[k])
                arr[i++] = Left[j++];
            else
                arr[i++] = Right[k++];
        }
        while(j < s1)
            arr[i++] = Left[j++];
        while(k < s2)
            arr[i++] = Right[k++];
    }
}