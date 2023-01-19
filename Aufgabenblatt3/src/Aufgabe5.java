/*
    Aufgabe 5) Kreismuster => Rekursiv vs. Iterativ
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import java.awt.*;


public class Aufgabe5 {


    private static void drawCirclePatternRecursively(CodeDraw myDrawObj, int x, int y, int r) {
        if(r<=2) {return;}
        drawCirclePatternRecursively(myDrawObj, x-r,y-r,r/2);
        drawCirclePatternRecursively(myDrawObj, x+r,y-r,r/2);
        drawCirclePatternRecursively(myDrawObj, x+r,y+r,r/2);
        drawCirclePatternRecursively(myDrawObj, x-r,y+r,r/2);
        myDrawObj.setColor(Palette.RED);
        myDrawObj.drawCircle(x,y,r);
        myDrawObj.setColor(Palette.ORANGE);
        myDrawObj.fillCircle(x,y,r);

    }

    private static void drawCirclePatternIteratively(CodeDraw myDrawObj, int maxRadius) {

        for(int minRadius=4;minRadius<=maxRadius;minRadius*=2)
        {
            myDrawObj.setColor(Palette.RED);
            myDrawObj.drawCircle(2*minRadius, 2*minRadius, minRadius);
            myDrawObj.setColor(Palette.ORANGE);
            myDrawObj.fillCircle(2*minRadius, 2*minRadius, minRadius);

            for(int k=1; k<=(maxRadius/minRadius);k++)
            {
                for(int j=1; j<=(maxRadius/minRadius);j++)
                {
                    myDrawObj.setColor(Palette.RED);
                    myDrawObj.drawCircle(2*minRadius+(4*k*minRadius), 2*minRadius+j*4*minRadius, minRadius);
                    myDrawObj.drawCircle(2*minRadius, 2*minRadius+j*4*minRadius, minRadius);
                    myDrawObj.drawCircle(2*minRadius+(4*k*minRadius), 2*minRadius, minRadius);
                    myDrawObj.setColor(Palette.ORANGE);
                    myDrawObj.fillCircle(2*minRadius+(4*k*minRadius), 2*minRadius+j*4*minRadius, minRadius);
                    myDrawObj.fillCircle(2*minRadius, 2*minRadius+j*4*minRadius, minRadius);
                    myDrawObj.fillCircle(2*minRadius+(4*k*minRadius), 2*minRadius, minRadius);
                }
            }
        }
    }

    public static void main(String[] args) {
        CodeDraw myDrawObjR=new CodeDraw(512,512);
        drawCirclePatternRecursively(myDrawObjR, 256, 256, 128);
        myDrawObjR.show();

        CodeDraw myDrawObjI=new CodeDraw(512,512);
        drawCirclePatternIteratively(myDrawObjI, 128);
        myDrawObjI.show();

        //Anzahl der Aufrufe: 1365
        //Anzahl Kreise (16*16)4=1024
        //x+r,y-r Quadranten auskommentieren
    }
}


