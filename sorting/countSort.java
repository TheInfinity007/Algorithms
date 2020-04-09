import java.util.*;
class CountSort
{
    public static  void main(String[] args) {
        String input = "2\n5\nedsab\n13\ngeeksforgeeks";
        Scanner sc = new Scanner(input);
        // Scanner sc = new Scanner(System.in);
        System.out.println("No of test Case: ");
        int tCase = sc.nextInt();
        System.out.println(tCase);
        while(tCase > 0){
            System.out.println("Enter the length of string:");
            int n = sc.nextInt();
            System.out.println(n);

            char seq[] = new char[n+1];
            String str = "";

            System.out.println("Enter String to sort: ");
            str = sc.next();
            System.out.println(str);

            seq = str.toCharArray();

            countSort(seq);

            System.out.println("Array after sorting: ");
            System.out.println(seq);
            tCase--;
        }
    }

    static void countSort(char seq[])
    {
        int n = seq.length;
        char output[] = new char[n];
        int count[] = new int[256];

        for(int i = 0; i < 256; i++)
            count[i] = 0;

        for(int i = 0; i < n; i++)
        {
            count[seq[i]] += 1;
        }

        for(int i = 1; i < 256; i++)
            count[i] += count[i-1];

        for(int i = n-1; i >= 0; i--)
        {
            output[count[seq[i]]-1] = seq[i];
            --count[seq[i]];
        }
        for(int i = 0; i < n; i++)
            seq[i] = output[i];
    }
}
    
    
