// This can contain the duplicated permutation if the input string contains duplicates

class printAllPermutation{
    public static void main(String[] args) {

        System.out.println("Permutation of ABC");
        String input = "ABC";
        int n = input.length();
        permute(input, 0, n-1);        

        System.out.println("Permutation of AAB");
        input = "AAB";
        n = input.length();
        permute(input, 0, n-1);        
    }

    public static void permute(String str, int l, int r){
        if(l == r)
            System.out.println(str);
        else{
            for(int i = l; i <= r; i++){
                str = swap(str, l, i);
                permute(str, l+1, r);
                str = swap(str, l, i);
            }
        }
    }

    public static String swap(String str, int i, int j){
        char arr[] = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }
}