import java.util.Random;

public class Rnd {
    double [] array;

    public Rnd(int N, int k){
        Random rand = new Random();
        array = new double[N];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < k; j++) {
                array[i] += rand.nextDouble();
            }
        }
    }

    public void Print()
    {
        for (int i = 0; i < array.length; i++)
            System.out.println("[" + i + "]=" + array[i]);
    }

    public double Min(){
        double minimum = array[0];
        for (double elem: array) {
            if (elem < minimum){
                minimum = elem;
            }
        }
        return minimum;
    }
    public double Max(){
        double maximum = array[0];
        for (double elem: array) {
            if (elem > maximum){
                maximum = elem;
            }
        }
        return maximum;
    }
    public double Average()
    {
        double mean = 0;
        double sum = 0;
        for (double elem : array)
            sum += elem;
        mean = sum / array.length;
        return mean;

    }
    public void Draw(){
        double diff = (Max() - Min()) / 50;

        for (int i = 0; i < array.length; i++)
        {
            int starNumber = (int) ((array[i] - Min()) /diff);
            System.out.println("[" + i + "]:" + "*".repeat(starNumber));
        }

    }
}
