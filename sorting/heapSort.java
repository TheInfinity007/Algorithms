import java.util.Scanner;

class Main
{
    public static  void main(String[] args) {
        // String input = "2\n5\n4 1 3 9 7\n10\n10 9 8 7 6 5 4 3 2 1";
        String input = "1\n7\n10 80 30 90 40 50 70";
        Scanner sc = new Scanner(input);
        // Scanner sc = new Scanner(System.in);
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

            heapSort(arr, arr.length);

            System.out.println("Array after sorting: ");
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
            tCase--;
        }
    }
    
    static void heapSort(int arr[], int n)
    {
        for(int i = (n-2)/2; i >= 0; i--)
            heapify(arr, n, i);
        //now the largest item is stored at the root of the heap.

        for(int i = n-1; i > 0; i--)
        {
            //move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //call maxheapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int i)
    {
        int child;
        child = 2*i+1;
        if(child+1 < n && arr[child+1] > arr[child])
            child++;
        if(child < n && arr[child] > arr[i])
        {
            //swap
            int temp = arr[child];
            arr[child] = arr[i];
            arr[i] = temp;

            heapify(arr, n, child);
        }
    }


}