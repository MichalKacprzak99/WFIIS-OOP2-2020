import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.lang.Math;
import java.util.Scanner;

public class Calculate {
    double mean;
    private List<Integer> dataFromFileIn;
    private File outFile;
    private File inFile;

    Calculate(String[] args){
        try{
            inFile = new File(args[0]);
            outFile = new File(args[1]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Uzytkowniku, podałeś za mało argumentów, musisz podac dwa,\n" +
                    " pierwszy to nazwa pliku w którym znajdują liczby\n" +
                    "oraz drugi to nazwa pliku do którego chcesz zapisać wynik");
            System.exit(-1);
        }
        catch (Exception e)
        {
            System.out.println("Wywołałeś nieznany błąd, który nie jest obsługiwany, wygoogluj go " + e);
            System.exit(-1);
        }
    }

    private void readFromFile()
    {
        dataFromFileIn = new ArrayList<>();
        int i = 0;
        try
        {
            Scanner myReader = new Scanner(inFile);

            while (myReader.hasNextLine()) {
                int data = myReader.nextInt();
                dataFromFileIn.add(data);
                i++;
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Wygląda na to, że w pliku wejściowym nie znajdują się same liczby całkowite");
            System.out.println("Element nr"+ (i+1) +" nie jest liczbą całkowitą");

            System.exit(-1);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Plik z liczbami nie istnieje");
            System.exit(-1);
        }
        catch (Exception e)
        {
            System.out.println("Wywołałeś nieznany błąd, który nie jest obsługiwany, wygoogluj go " + e);
            System.exit(-1);
        }
    }
    private void saveToFile()
    {
        try
        {

            FileWriter myWriter = new FileWriter(outFile);
            myWriter.write(String.valueOf(mean));
            myWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("Nie udało sie zapisac do pliku");
            System.exit(-1);
        }
        catch (Exception e)
        {
            System.out.println("Wywołałeś nieznany błąd, który nie jest obsługiwany, wygoogluj go " + e);
            System.exit(-1);
        }
    }


    public void calculateMean() {
        readFromFile();

        try{
            if(dataFromFileIn.size() == 0){
                throw new EmptyFileException();
            }
            int sum = 0;
            for (Integer num : dataFromFileIn) {
                sum = Math.addExact(sum, num);
            }
            mean =  (double)sum/dataFromFileIn.size();
        }
        catch ( EmptyFileException e){

            System.out.println("Nie można policzyć średniej, ponieważ plik jest pusty");
            System.exit(-1);
        }
        catch (ArithmeticException e) {

            System.out.println("Suma liczb znajdujących się w pliku wejściowym jest za duża");
            System.exit(-1);
        }
        catch (Exception e)
        {
            System.out.println("Wywołałeś nieznany błąd, który nie jest obsługiwany, wygoogluj go " + e);
            System.exit(-1);
        }
        saveToFile();
    }
}
