import java.util.*;

class printDistinctPermutations{
    public static void main(String[] args) {
        System.out.println("Permutation of AAB");
        String input = "AAB";
        printAllpermutation(input);

        System.out.println("Permutation of ABC");
        input = "ABC";
        printAllpermutation(input);

        System.out.println("Permutation of ABCD");
        input = "ABCD";
        printAllpermutation(input);
    }

    public static void printAllpermutation(String str){
        char arr[] = str.toCharArray();
        Arrays.sort(arr);

        System.out.println(arr);

        int n = countPermutation(arr);
        for(int i = 1; i < n; i++){     //From 1 as we already print the first permutation
            printPermutaion(arr);
        }
    }

    public static void printPermutaion(char arr[]){
        // We have to swap i and the min;
        int i, min, j;
        for(i = arr.length-1; i > 0; i--){
            if(arr[i] > arr[i-1])
                break;
        }
        min = i;
        for(j = i+1; j < arr.length; j++){
            if((arr[min] > arr[j]) && (arr[j] > arr[i-1]))
                min = j;
        }

        char temp = arr[i-1];
        arr[i-1] = arr[min];
        arr[min] = temp;

        Arrays.sort(arr, i, arr.length);
        System.out.println(arr);

    }

    public static int countPermutation(char arr[]){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                int temp = map.get(arr[i])+1;
                map.replace(arr[i], temp);
            }else{
                map.put(arr[i], 1);
            }
        }
        
        int total = 1;
        for(int v: map.values()){
            total *= v;
        }
        int fact = getFactorial(arr.length);
        return fact/total;
    }

    public static int getFactorial(int n){
        if(n <= 0)
            return 1;
        return n*getFactorial(n-1);
    }
}