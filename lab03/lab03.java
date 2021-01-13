public class lab03 {
    public static void main(String[] args)
    {
        GameOfLive gameOfLive = new GameOfLive(args[0], args[1], args[3]);
        gameOfLive.Simulate(args[2]);
    }
}
