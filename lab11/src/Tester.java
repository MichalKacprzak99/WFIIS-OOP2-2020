import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Tester {
    private int numberOfComponents;
    ArrayList<ArrayList<Integer>> tests = new ArrayList<>();
    ArrayList<Set<Integer>> TestedComponents = new ArrayList<>();
    void getInfo(ArrayList<String> userInput){

        Scanner scannerForVariables = new Scanner(userInput.get(0));
        numberOfComponents = scannerForVariables.nextInt();
        int numberOfTests = scannerForVariables.nextInt();

        for (int i = 1; i <= numberOfTests; i++) {
            Scanner scanner = new Scanner(userInput.get(i));

            ArrayList<Integer> test = new ArrayList<>();
            while( scanner.hasNext() ) {
                test.add(scanner.nextInt());
            }
            tests.add(test);

        }
        createArrayForValidTestedComponents();
    }

    void createArrayForValidTestedComponents(){
        for (int i = 0; i < numberOfComponents; i++) {
            TestedComponents.add(new HashSet<>());

        }

    }

    public void validateSetOfTests(){

        for (ArrayList<Integer> test: tests) {
            for (int i = 0; i < numberOfComponents/2; i++) {
                for (int j = numberOfComponents/2; j < numberOfComponents; j++) {
                    TestedComponents.get(i).add(test.get(j));
                    TestedComponents.get(j).add(test.get(i));

                }
            }
        }

        for (Set<Integer> testedComponent: TestedComponents) {
            if (testedComponent.size() != numberOfComponents - 1) {
                System.out.println("NIE");
                break;
            }
        }

        System.out.println("TAK");
    }
}
