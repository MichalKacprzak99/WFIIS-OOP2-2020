import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class lab09 {

    public static void main(String[] args){
        Garden garden = new Garden();
        garden.getInfo(handleData(args[0]));
        garden.checkDoneGardenArea();
        garden.calculateNotDoneArea();

    }
    public static ArrayList<String> handleData(String fileName){
        ArrayList<String> input = new ArrayList<>();
        Scanner s;
        try {
            s = new Scanner(new File(fileName));
            while (s.hasNextLine()){
                String read = s.nextLine();
                if(read == null || read.isEmpty()){
                    break;
                }
                input.add(read);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return  input;
    }
}
