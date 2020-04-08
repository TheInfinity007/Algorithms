import java.util.Scanner;

class Main
{
    public static void main(String[] args) {
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

            selectionSort(arr);

            System.out.println("Array after sorting: ");
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
            tCase--;
        }
    }

    static void selectionSort(int arr[])
    {
        int i, j, sml, index;
        for(i = 0; i < arr.length-1; i++)
        {
            sml = arr[i];
            index = i;
            for(j = i+1; j < arr.length; j++)
            {
                if(arr[j] < sml){
                    sml = arr[j];
                    index = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}