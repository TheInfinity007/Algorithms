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

            quickSort(arr, 0, arr.length-1);

            System.out.println("Array after sorting: ");
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
            tCase--;
        }
    }

    static void quickSort(int arr[], int l, int r )
    {
        if(l < r)
        {
            int pivot = partition(arr, l, r);
            quickSort(arr, l, pivot-1);
            quickSort(arr, pivot+1, r);
        }
    }

    static int partition(int arr[], int l, int r)
    {
        int pivot = arr[r];
        int i, j, temp;

        i = l-1;
        for(j = l; j < r; j++)
        {
            if(arr[j] <= pivot){
                i++;
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        temp = arr[i+1];
        arr[i+1] = pivot;
        arr[r] = temp;

        return i+1;
    }

}