/*
    Aufgabe 4) Zweidimensionale Arrays und Rekursion - Labyrinth
*/
public class Aufgabe4 {

    public static void main(String[] args) {
        int mazeType = 1;
        //int[][] direction = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; //EAST,NORTH,WEST,SOUTH
        //int[][] direction = new int[][]{{-1,0},{0,-1},{1,0},{0,1}}; //NORTH,WEST,SOUTH,EAST
        int[][] direction = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};//WEST,SOUTH,EAST,NORTH
        //int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};//SOUTH,EAST,NORTH,WEST

        char[][] myMaze = null;
        if (mazeType == 0) {
            myMaze = new char[][]{
                    "***************".toCharArray(),
                    "*         *   E".toCharArray(),
                    "***** *    *  *".toCharArray(),
                    "*   * *********".toCharArray(),
                    "*             *".toCharArray(),
                    "***********   *".toCharArray(),
                    "*             *".toCharArray(),
                    "* ***  ****   *".toCharArray(),
                    "*   *     *   *".toCharArray(),
                    "***** *****   *".toCharArray(),
                    "*        *    *".toCharArray(),
                    "* ********** **".toCharArray(),
                    "*        *    *".toCharArray(),
                    "*  S *        *".toCharArray(),
                    "***************".toCharArray()
            };
        } else if (mazeType == 1) {
            myMaze = new char[][]{
                    "***************".toCharArray(),
                    "*         *   E".toCharArray(),
                    "***** *    *  *".toCharArray(),
                    "*   * ******* *".toCharArray(),
                    "*             *".toCharArray(),
                    "***********   *".toCharArray(),
                    "*             *".toCharArray(),
                    "* ***  ****   *".toCharArray(),
                    "*   *     *   *".toCharArray(),
                    "***** *****   *".toCharArray(),
                    "*        *    *".toCharArray(),
                    "* ********** **".toCharArray(),
                    "*        *    *".toCharArray(),
                    "*  S *        *".toCharArray(),
                    "***************".toCharArray()
            };
        } else if (mazeType == 2) {
            myMaze = new char[][]{
                    "***************".toCharArray(),
                    "*         *   *".toCharArray(),
                    "***** *   * * *".toCharArray(),
                    "*   * ******* *".toCharArray(),
                    "*   *         *".toCharArray(),
                    "* *********   *".toCharArray(),
                    "*   *         *".toCharArray(),
                    "* ***  ****   *".toCharArray(),
                    "E   *     *   *".toCharArray(),
                    "***** *****   *".toCharArray(),
                    "*        *    *".toCharArray(),
                    "* *************".toCharArray(),
                    "* *      *    *".toCharArray(),
                    "*    *       S*".toCharArray(),
                    "***************".toCharArray()
            };
        }

        // Dieser Teil darf (muss aber nicht) verändert werden!!****************
        printMaze(myMaze);
        int[] startPoint = getStartPoint(myMaze);
        if (startPoint[0] == 0 && startPoint[1] == 0) {
            System.out.println("STARTPOINT MISSING!");
        } else {
            if (existsPathToExit(myMaze, startPoint[0], startPoint[1], direction)) {
                System.out.println("EXIT FOUND!");
            } else {
                System.out.println("EXIT NOT FOUND!");
            }
        }
        myMaze[startPoint[0]][startPoint[1]] = 'S';
        printMaze(myMaze);
        //**********************************************************************
    }

    private static int[] getStartPoint(char[][] maze) {
        // Durchlaufe das Labyrinth und suche nach dem Startpunkt
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (maze[row][col] == 'S') {
                    // Wenn der Startpunkt gefunden wurde, gib die Koordinaten zurück
                    return new int[]{row, col};
                }
            }
        }
        // Wenn der Startpunkt nicht gefunden wurde, gib null zurück
        return null;
    }

    private static boolean existsPathToExit(char[][] maze, int row, int col, int[][] direction) {

        if (row < 0 || row >= maze.length || col < 0 || col >= maze[row].length || maze[row][col] == '*' || maze[row][col] == 'V') {
            return false;
        }

        if (maze[row][col] == 'E') {
            return true;
        }

        maze[row][col] = 'V';

        for (int i =0; i < direction.length; i++){
            if (existsPathToExit(maze, row + direction[i][0], col + direction[i][1], direction)) {
                maze[row][col] = 'U';
                return true;
            }
        }
        return false;
    }

    private static void printMaze(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                    System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

}


