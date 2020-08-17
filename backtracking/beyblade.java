import java.util.*;
class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt(), i;
            int arr[] = new int[n];
            int arr2[] = new int[n];

            for(i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            for(i = 0; i < n; i++)
                arr2[i] = sc.nextInt();

            Arrays.sort(arr);
            Arrays.sort(arr2);
            int count = 0, j = 0;
            for(i = 0; i < n; )
            {
                if(arr[i] > arr2[j])
                {
                    count++;
                    j++;
                }
                i++;
                    
            }
            System.out.println(count);
        }
    }
}