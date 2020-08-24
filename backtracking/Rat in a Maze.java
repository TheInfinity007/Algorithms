class RatInAMaze {
    public static void main(String[] args) {
        int maze[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        System.out.println("Input Maze:");
        printTheMaze(maze);
        System.out.println("Solution: ");
        solveTheMaze(maze);

        int maze1[][] = {
            {1, 1, 1, 1, 1, 0, 0},
            {0, 1, 0, 1, 1, 0, 0},
            {0, 1, 0, 0, 1, 0, 0},
            {1, 1, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 1, 0},
            {1, 1, 1, 1, 0, 1, 0},
            {0, 0, 1, 0, 1, 1, 1},
            {1, 0, 1, 1, 0, 1, 1}
        };
        System.out.println("Input Maze:");
        printTheMaze(maze1);
        System.out.println("Solution: ");
        solveTheMaze(maze1);
    }

    public static void solveTheMaze(int maze[][]){
        // Checking the no of rows and columns
        int rows = maze.length;
        int cols = maze[0].length;
        System.out.println(rows +" "+ cols);
        int sol[][] = new int[rows][cols]; 
        for(int i = 0; i < rows; i++)           //setting the array values to 0
            for(int j = 0; j < cols; j++)
                sol[i][j] = 0;

        // Rat will start from the top left most position and it will reach to the bottom right most position to camplate the maze
        // Rat can move downwards and rightwards i.e. only two direction (for making this simple)

        int movesX[] = {0, 1};
        int movesY[] = {1, 0};

        // Rat will start from the top left most position
        sol[0][0] = 1;

        if(maze[0][0] != 1){
            System.out.println("Invalid Maze or No path from source to destination");
            return;
        }
        if(!solveMaze(maze, sol, 0, 0, rows, cols, movesX, movesY)){
            System.out.println("Invalid Maze or No path from source to destination");
            return;
        }

        printTheMaze(sol);
    }

    public static boolean solveMaze(int maze[][], int sol[][], int x, int y, int rows, int cols, int movesX[], int movesY[]){

        if(x == rows-1 && y == cols-1)
            return true;

        for(int i = 0; i < 2; i++){
            int nextX = x + movesX[i];
            int nextY = y + movesY[i];
            if(isSafe(maze, nextX, nextY, rows, cols)){
                sol[nextX][nextY] = 1;
                if(solveMaze(maze, sol, nextX, nextY, rows, cols, movesX, movesY))
                    return true;
                else
                    sol[nextX][nextY] = 0;      //Backtracking
                
            }
        }
        return false;
    }

    public static boolean isSafe(int maze[][], int nextX, int nextY, int rows, int cols){
        return (nextX < rows && nextY < cols && maze[nextX][nextY] == 1);
    }

    public static void printTheMaze(int arr[][]){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}