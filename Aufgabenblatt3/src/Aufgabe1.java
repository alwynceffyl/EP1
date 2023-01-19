/*
    Aufgabe 1) Codeanalyse, Codingstyle und Methoden
*/
public class Aufgabe1 {
    //TODO zu Punkt a): Beschreiben Sie hier in wenigen Sätzen was der Spaghetticode macht
    // Gibt ein Muster in der Console
    // mittels  qualitativ schlechten Code aus
    // bestehend aus meheren ASCII-Zeichen
    //
    //

    //TODO zu Punkt b): Beschreiben Sie in wenigen Sätzen was Sie ändern würden und warum
    // Code formatieren durch Intellj-Funktion
    // Eine Methode für den Anfag/Ende erstellen - Reduntanzen vermeiden
    // Danach ruft die Methode eine andere Methode auf die Körper des Muster erstellt
    // Am Ende wird die Start/Ende Methode aufgerufen - Reduntanzen vermeiden.

    //TODO zu Punkt c): Implementieren Sie hier die Methoden Ihrer Lösung

    public static void startEnde(int breite){

        System.out.print("#");
        for (int i = 1; i <= breite; i++) {
            System.out.print("|");
        }
        System.out.println("#");
    }

    public static void createBody(int breite){

        int k=1,anzahlMusterWiederholungen=2;
        int anfang=2, ende=breite-anfang;
        while(k<=anzahlMusterWiederholungen)
        {
            for (int i = 1; i <= (breite / 2); i++)
            {
                for (int j = 1; j <= i; j++)
                {
                    System.out.print("+");
                }
                System.out.print("\\");
                for (int j = 1; j <= (breite - 2 * i); j++)
                {
                    System.out.print("*");
                }
                System.out.print("/");
                for (int j = 1; j <= i; j++)
                {
                    System.out.print("+");
                }
                System.out.println();

            }

            for (int i = 1; i <= breite/2; i++)
            {
                for (int j = 1; j <= (breite / 2 - i + 1); j++)
                {
                    System.out.print("+");
                }
                System.out.print("/");
                for (int j = 1; j <= 2 * (i - 1); j++)
                {
                    System.out.print("*");
                }
                System.out.print("\\");
                for (int j = 1; j <= (breite / 2 - i + 1); j++)
                {
                    System.out.print("+");
                }
                System.out.println();
            }
            k++;
        }

        startEnde(breite);

    }

    public static void main(String args[]) {
        //********************************************************
        //TODO zu Punkt d): Implementieren Sie hier Ihre Lösung für die Angabe
        System.out.println("Ihre Ausgabe:");

        startEnde(10);
        createBody(10);
        //********************************************************

        System.out.println();
        System.out.println("Ausgabe Spaghetticode:");
        System.out.print("#");
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
        }
        System.out.println("#");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 - 2 * i); j++) {
                System.out.print("*");
            }
            System.out.print("/");
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.print("/");
            for (int j = 1; j <= 2 * (i - 1); j++) {
                System.out.print("*");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 - 2 * i); j++) {
                System.out.print("*");
            }
            System.out.print("/");
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.print("/");
            for (int j = 1; j <= 2 * (i - 1); j++) {
                System.out.print("*");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        System.out.print("#");
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
        }
        System.out.println("#");
    }
}


