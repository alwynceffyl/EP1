/*
    Aufgabe 3) Zweidimensionale Arrays und CodeDraw - Bildverarbeitung "Finding Waldo"
*/

import codedraw.CodeDraw;
import codedraw.Palette;
import codedraw.Image;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Aufgabe3 {

    // converts RGB image into a grayscale array
    private static int[][] convertImg2Array(Image img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int[][] imgArray = new int[height][width];
        Color tempColor;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                tempColor = img.getPixel(col, row);
                imgArray[row][col] = (int) (tempColor.getRed() * 0.3 + tempColor.getGreen() * 0.59 + tempColor.getBlue() * 0.11);
            }
        }
        return imgArray;
    }

    //detect waldo by template matching
    private static void detectWaldo(CodeDraw myDrawObj, Image img, Image template) {
        // Wandle die Bilder in Grauwerte-Arrays um
        int[][] imgArray = convertImg2Array(img);
        int[][] templateArray = convertImg2Array(template);

        // Bestimme die Größe des Bildes und des Templates
        int imgRows = imgArray.length;
        int imgCols = imgArray[0].length;
        int templateRows = templateArray.length;
        int templateCols = templateArray[0].length;

        // Initialisiere die minimale SAD und die aktuelle Position
        int minSAD = Integer.MAX_VALUE;
        int currentRow = 0;
        int currentCol = 0;

        // Iteriere über das Bild und das Template
        for (int row = 0; row <= imgRows - templateRows; row++) {
            for (int col = 0; col <= imgCols - templateCols; col++) {
                // Berechne die SAD für den aktuellen Bereich
                int SAD = 0;
                for (int i = 0; i < templateRows; i++) {
                    for (int j = 0; j < templateCols; j++) {
                        SAD += Math.abs(imgArray[row + i][col + j] - templateArray[i][j]);
                    }
                }

                // Wenn die SAD kleiner ist als bisher, aktualisiere die minimale SAD und die aktuelle Position
                if (SAD < minSAD) {
                    minSAD = SAD;
                    currentRow = row;
                    currentCol = col;
                }
            }
        }
        // Zeichne die Bounding Box für die aktuelle Position
        myDrawObj.setColor(Palette.DEEP_PINK);
        myDrawObj.setLineWidth(6);
        myDrawObj.drawRectangle(currentCol, currentRow, templateCols, templateRows);
        myDrawObj.show(300);
    }

    public static void main(String[] args) {

        //waldo1
        //String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/6NcsuQdriPbHcKN/download"; //waldo1.png
        //String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/AwlmIBqj2V1qGV7/download"; //template1.png

        //waldo2
        //String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/922nyXVsBkMKz6K/download"; //waldo2.png
        //String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/tqTFXxF2BkeKnhm/download"; //template2.png

        //waldo3
        String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/DR2u4Xf5muAZsWo/download"; //waldo3.png
        String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/xEMZlbdHJ4ZfLfz/download"; //template3.png

        // open image file
        Image img = Image.fromUrl(linkWaldo);

        // open template image file
        Image template = Image.fromUrl(linkTemplate);

        // set StdDraw window size based on the image size
        int width = img.getWidth();
        int height = img.getHeight();
        CodeDraw cd = new CodeDraw(width, height);

        //draw image
        cd.drawImage(0, 0, img);
        cd.show();

        //detect Waldo given in 'template' and show result in image 'img'
        detectWaldo(cd, img, template);
    }
}





