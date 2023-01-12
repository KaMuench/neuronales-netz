import entities.Perzeptron;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static int[][] xValuesForDisplay;
    static double[][] x; //Muster without BIAS
    static int[]      y; //Klasse
    static int n;        //Dimension, d.h. Anzahl der Merkmale bzw. Eingaenge in das Perzeptron without BIAS
    static int m;        //Anzahl der Muster bzw. Trainingsbeispiele bzw. Datens�tze

    public static void main(String[] args) {

        einlesenVorlesungsbeispiele(new File("data_1.txt"));

        Perzeptron perzeptron = new Perzeptron(x, y, new int[]{2});

        perzeptron.exercise(0.05, 200);

        perzeptron.evaluate();
    }

    public static void einlesenVorlesungsbeispiele(File file) {
        //Es wird angenommen, dass alle Eingabedaten im Intervall [0, 100] liegen
        m = 0;//Anzahl Muster
        n = 2;
        try{
            //1. Anzahl m der Muster bestimmen
            Scanner scanner      = new Scanner(file);
            while(scanner.hasNext()) {
                double x1 = Double.valueOf (scanner.next());
                double x2 = Double.valueOf (scanner.next());
                int     y = Integer.valueOf(scanner.next());
                //hier koennte man die minimalen und maximalen Eingabewerte ermitteln
                //um sie beim Einlesen auf den Bereich [0, 1] zu skalieren
                m++;
            }
            x = new double[m][n];//2 Merkmale + Bias
            xValuesForDisplay = new int[m][n];
            y = new int[m];
            scanner.close();

            //2. Muster einlesen
            scanner = new Scanner(file);
            int nr  = 0;
            while(scanner.hasNext()) {
                double x1 = Double.valueOf (scanner.next());
                double x2 = Double.valueOf (scanner.next());
                int    y0 = Integer.valueOf(scanner.next());
                x[nr][0] = x1/100.;
                x[nr][1] = x2/100.;
                xValuesForDisplay[nr][0] = (int) x1;
                xValuesForDisplay[nr][1] = (int) x2;
                y[nr]    = y0;
                nr++;
            }
            scanner.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

}
