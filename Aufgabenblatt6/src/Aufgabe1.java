/*
    Aufgabe 1) Zweidimensionale Arrays und Methoden - Vier Gewinnt
*/

import codedraw.*;


public class Aufgabe1 {

    private static int[][] genGameBoard(int row, int col) {
        int[][] gameBoard = new int[row][col];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j] = 0;
            }
        }
        return gameBoard ;
    }

    private static void drawGameBoard(CodeDraw myDrawObj, int[][] currentGameBoard, int oneSquareSize) {
        int x=0,y=0;
        for(int i=0; i< currentGameBoard.length;i++){
            for (int j=0; j<currentGameBoard[i].length;j++){
                myDrawObj.setColor(Palette.BLUE);
                myDrawObj.drawRectangle(x, y,oneSquareSize,oneSquareSize);
                myDrawObj.fillRectangle(x, y,oneSquareSize,oneSquareSize);

                myDrawObj.setColor(Palette.GRAY);
                if (currentGameBoard[i][j]==1){
                    myDrawObj.setColor(Palette.RED);
                }
                if (currentGameBoard[i][j]==2){
                   myDrawObj.setColor(Palette.YELLOW);
                }
                myDrawObj.drawCircle(x+oneSquareSize/2,y+oneSquareSize/2,oneSquareSize/3);
                myDrawObj.fillCircle(x+oneSquareSize/2,y+oneSquareSize/2,oneSquareSize/3);
                x+=oneSquareSize;
            }
            y+=oneSquareSize;
            x=0;
        }
        myDrawObj.show();
    }

    private static boolean isMovePossible(int[][] currentGameBoard, int col) {

        for (int j=0; j<currentGameBoard.length;j++){
            if(currentGameBoard[j][col]==0){
                return true;
            }
        }
        return false;
    }

    private static void makeMove(int[][] currentGameBoard, int player, int col) {
        for (int j=currentGameBoard.length-1; j >= 0 ;j--){
            if(currentGameBoard[j][col]==0){
                currentGameBoard[j][col]=player;
                break;
            }
        }
    }

    private static boolean existsWinner(int[][] currentGameBoard, int player) {
        int ROWS= currentGameBoard.length;
        int COLS= currentGameBoard[0].length;

        // Check for a horizontal win
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (currentGameBoard[row][col]==player
                        && currentGameBoard[row][col+1] == player
                        && currentGameBoard[row][col+2] == player
                        && currentGameBoard[row][col+3]==player) {
                    return true;
                }
            }
        }

        // Check for a vertical win
        for (int col = 0; col < COLS; col++) {
            for (int row = 0; row < ROWS - 3; row++) {
                if (currentGameBoard[row][col]==player
                        && currentGameBoard[row+1][col] == player
                        && currentGameBoard[row+2][col] == player
                        && currentGameBoard[row+3][col]== player) {
                    return true;
                }
            }
        }

        // Check for a top-left to bottom-right diagonal win
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (currentGameBoard[row][col]==player
                        && currentGameBoard[row+1][col+1]==player
                        && currentGameBoard[row+2][col+2]==player
                        && currentGameBoard[row+3][col+3]==player) {
                    return true;
                }
            }
        }

        // Check for a top-right to bottom-left diagonal win
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (currentGameBoard[row][col]==player
                        && currentGameBoard[row-1][col+1]==player
                        && currentGameBoard[row-2][col+2]==player
                        && currentGameBoard[row-3][col+3]==player) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {

        // canvas settings
        int rowsGameBoard = 6;
        int colsGameBoard = 7;
        int oneSquareSize = 50;
        int width = oneSquareSize * colsGameBoard;
        int height = oneSquareSize * rowsGameBoard;

        CodeDraw myDrawObj = new CodeDraw(width, height);
        EventScanner myEventSC = myDrawObj.getEventScanner();

        // game variables
        int[][] myGameBoard = genGameBoard(rowsGameBoard, colsGameBoard);
        int player = 1;
        int fieldsUsed = 0;
        boolean gameActive = true;

        // set font for text
        TextFormat font = new TextFormat();
        font.setFontSize(28);
        font.setFontName("Arial");
        font.setTextOrigin(TextOrigin.CENTER);
        font.setBold(true);
        myDrawObj.setTextFormat(font);

        // initial draw of the game board
        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);

        // game play starts
        System.out.println("Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " has to make a move!");
        while (!myDrawObj.isClosed() && gameActive) {
            if(myEventSC.hasKeyPressEvent()){
                if(myEventSC.nextKeyPressEvent().getChar() == 'q'){
                    gameActive = false;
                }
            }
            else if (myEventSC.hasMouseClickEvent()) {
                MouseClickEvent currentClick = myEventSC.nextMouseClickEvent();
                int mouseX = currentClick.getX();
                int mouseY = currentClick.getY();

                int colXY=mouseX/oneSquareSize;
                if(isMovePossible(myGameBoard,colXY))
                {
                    fieldsUsed++;

                    if (fieldsUsed==(rowsGameBoard*colsGameBoard)){
                        for (int i = 0; i < myGameBoard.length; i++) {
                            for (int j = 0; j < myGameBoard[i].length; j++) {
                                myGameBoard[i][j] = 0;
                            }
                            drawGameBoard(myDrawObj,myGameBoard,oneSquareSize);
                            myDrawObj.show(1000);
                        }
                        myDrawObj.drawText(width/2,height/2,"Board full!");
                        myDrawObj.show(1000);
                    }

                    makeMove(myGameBoard, player, colXY);
                    drawGameBoard(myDrawObj,myGameBoard,oneSquareSize);
                    if(existsWinner(myGameBoard,player))
                    {
                        myDrawObj.drawText(width/2,height/2,"Player "+player + (player == 1 ? " (RED) won!" : " (YELLOW) won!"));
                        myDrawObj.show(1000);

                        //reset
                        myGameBoard=genGameBoard(rowsGameBoard,colsGameBoard);
                        drawGameBoard(myDrawObj,myGameBoard,oneSquareSize);

                    }
                    else {
                        player= (player==1) ? 2:1;
                        System.out.println("Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " has to make a move!");
                    }

                }
                else {
                    myDrawObj.drawText(width/2,height/2,"Colum already full!");
                    myDrawObj.show(1000);
                }

            }
            else {
                myEventSC.nextEvent();
            }

        }
        myDrawObj.close();
    }
}


