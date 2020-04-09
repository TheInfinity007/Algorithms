import java.util.Scanner;

class Main
{
    public static  void main(String[] args) {
        String input = "2\n5\n4 1 3 9 7\n10\n10 9 8 7 6 5 4 3 2 1";
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

            radixSort(arr);

            System.out.println("Array after sorting: ");
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
            tCase--;
        }
    }

    static void radixSort(int arr[])
    {
        int max = getMax(arr);
        for(int exp = 1; max/exp > 0; exp *= 10)
        {
            countSort(arr, arr.length, exp);
        }
    }

    static void countSort(int arr[], int n, int exp)
    {
        int count[] = new int[10];
        int result[] = new int[n];

        for(int i = 0; i < n; i++)
        {
            ++count[(arr[i]/exp)%10];
        }

        for(int i = 1; i < 10; i++)
            count[i] += count[i-1];

        for(int i = n-1; i >= 0; i--)
        {
            result[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        for(int i = 0; i < n; i++)
            arr[i] = result[i];

    }
    static int getMax(int arr[])
    {
        int max = arr[0];
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    

}