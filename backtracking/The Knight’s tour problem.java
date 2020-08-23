class TheKnightTourProblem {
    static int N = 8;
    public static void main(String[] args) {
        solveKnightTour();        
    }
    
    public static void solveKnightTour(){
        int sol[][] = new int[N][N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                sol[i][j] = -1;

        int movesX[] = {2, 2, 1, -1, -2, -2, -1, 1};
        int movesY[] = {1, -1, 2, 2, 1, -1, -2, -2};

        sol[0][0] = 0;

        if(!solveTour(0, 0, 1, sol, movesX, movesY)){
            System.out.println("Solution does not exist");
            return;
        }

        printKnightTour(sol);
    }

    public static boolean solveTour(int x, int y, int moveNo, int sol[][], int movesX[], int movesY[]){
        if(moveNo == N*N)
            return true;

        for(int i = 0; i < N; i++){
            int nextX = x + movesX[i];
            int nextY = y + movesY[i];
            if(isSafe(nextX, nextY, sol)){
                sol[nextX][nextY] = moveNo;
                // printKnightTour(sol);
                System.out.println(moveNo);
                if(solveTour(nextX, nextY, moveNo+1, sol, movesX, movesY))
                    return true;
                else
                    sol[nextX][nextY] = -1;     //Backtracking
            }
        }
        return false;
    }

    public static boolean isSafe(int x, int y, int sol[][]){
        return (x < N && y < N && x >= 0 && y >= 0 && sol[x][y] == -1);
    }

    public static void printKnightTour(int arr[][]){
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
    }
}