import java.util.*;

class PalindromePermutations{
    public static void main(String[] args) {
        System.out.println("Permutation of bbaac");
        String input = "bbaac";
        printAllPalindromicPermutation(input);

        System.out.println("\nPermutation of aabbcadad");
        input = "aabbcadad";
        printAllPalindromicPermutation(input);

        System.out.println("\nPermutation of yyxx");
        input = "xxyy";
        printAllPalindromicPermutation(input);
    }    

    public static void printAllPalindromicPermutation(String str){
        HashMap <Character, Integer> map = new HashMap<Character, Integer>();
        char arr[] = str.toCharArray();
        for(Character ch : arr){
            if(map.containsKey(ch)){
                int temp = map.get(ch) + 1;
                map.replace(ch, temp);
            }else{
                map.put(ch, 1);
            }
        }

        String half = "";
        String oddChar = "";
        int total = 1;
        for(Map.Entry<Character, Integer> e: map.entrySet()){
            half += getString(e.getValue()/2, e.getKey());
            if(e.getValue()%2 == 1){
                if(str.length() % 2 == 0 || oddChar.length() > 0){
                    System.out.println("Permutation not possible");
                    return;
                }
                oddChar = e.getKey().toString();
            }
            if(e.getValue()/2 > 0)
                total = total * e.getValue()/2;
        }

        arr = half.toCharArray();
        Arrays.sort(arr);
        System.out.println(String.valueOf(arr) + oddChar + reverseString(String.valueOf(arr)));

        int fact = getFactorial(half.length());
        int n = fact/total;
        // If the length of inpput string is odd then the oddChar will be of length 0
        for(int i = 1; i < n; i++){
            printPermutation(arr, oddChar);
        }

    }

    public static void printPermutation(char arr[], String oddChar){
        int i, j, min;
        for(i = arr.length-1; i > 0; i--){
            if(arr[i] > arr[i-1])
                break;
        }
        min = i;
        for(j = i+1; j < arr.length; j++){
            if((arr[j] > arr[i-1]) && (arr[j] < arr[min]))
                min = j;
        }

        char temp = arr[i-1];
        arr[i-1] = arr[min];
        arr[min] = temp;

        Arrays.sort(arr, i, arr.length);
        System.out.println(String.valueOf(arr) + oddChar + reverseString(String.valueOf(arr)));
    }

    public static String getString(int n, Character ch){
        String str = "";
        for(int i = 0; i < n; i++){
            str += ch.toString();
        }
        return str;
    }

    public static String reverseString(String str){
        char arr[] = str.toCharArray();
        char temp;
        for(int i = 0 ; i < arr.length/2; i++){
            temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        return String.valueOf(arr);
    }

    public static int getFactorial(int n){
        if(n == 0 || n == 1)
            return 1;
        return n * getFactorial(n-1);
    }
}