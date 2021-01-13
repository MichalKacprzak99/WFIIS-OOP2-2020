import java.util.ArrayList;
import java.util.Scanner;

public class Garden {

    int gardenSizeX = 0, gardenSizeY = 0, numberOfWorkers;
    ArrayList<ArrayList<Integer>> areaCoveredByWorkers = new ArrayList<>();
    int[][] gardenArea;

    void getInfo(ArrayList<String> userInput){

        numberOfWorkers = Integer.parseInt(userInput.get(0));

        for (int i = 1; i <= numberOfWorkers ; i++) {

            Scanner scanner = new Scanner(userInput.get(i));

            ArrayList<Integer> areaSize = new ArrayList<>();
            while( scanner.hasNext() ) {
                areaSize.add(scanner.nextInt());
            }

            areaCoveredByWorkers.add(areaSize);

            gardenSizeX = Math.max(gardenSizeX, areaSize.get(2) );
            gardenSizeY = Math.max(gardenSizeY, areaSize.get(3) );

        }
    }

    void checkDoneGardenArea(){

        gardenArea = new int[gardenSizeX + 1][gardenSizeY + 1];

        for (ArrayList<Integer>workerArea: areaCoveredByWorkers ) {

            for (int i = workerArea.get(0); i <= workerArea.get(2); i++) {

                for (int j = workerArea.get(1); j <= workerArea.get(3); j++) {

                    gardenArea[i][j] += 1;
                }
            }
        }
    }
    
    void calculateNotDoneArea(){

        int notDoneArea = 0;

        for (int i = 0; i < gardenSizeX + 1; i++) {

            for (int j = 0; j < gardenSizeY + 1; j++) {

                if(gardenArea[i][j] < numberOfWorkers - 1){

                    notDoneArea += 1;

                }
            }
        }

        System.out.println(notDoneArea);

    }

}
