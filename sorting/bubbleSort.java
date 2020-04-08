//  Modified Bubble Sort

//if the array is already sorted then its complexity is O(n)


import java.util.Scanner;
class BubbleSort{
    public static void main(String[] args) {
        String input = "2\n5\n4 1 3 9 7\n10\n10 9 8 7 6 5 4 3 2 1";
        Scanner sc = new Scanner(input);
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

            bubbleSort(arr);

            System.out.println("Array after sorting: ");
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
            tCase--;
        }
    }

    static void bubbleSort(int arr[])
    {
        int i, j, count = 0,total = 0;
        for(i = 0; i < arr.length-1; i++)
        {
            count = 0;
            for(j = 0; j < arr.length-1; j++)
            {
                total++;
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }else{
                    count++;
                }
            }
            if(count == arr.length-1)
                break;
        }
        System.out.println("Total = " + total);
    }
    
}