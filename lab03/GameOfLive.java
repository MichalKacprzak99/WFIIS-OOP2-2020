import java.util.Random;

public class GameOfLive {
    public int [][] board;
    int x;
    int y;
    public GameOfLive(String size_x, String size_y, String preset){
        x = Integer.parseInt(size_x);
        y = Integer.parseInt(size_y);
        board = new int[y+2][x+2];
        LoadPreset(Integer.parseInt(preset));
    }
    public void LoadPreset(int p_set){

        int x_center = (x+2) / 2;
        int y_center = (y+2) / 2;
        
        if(p_set == 0){
            Default();
        }
        if(p_set == 1){
            Boat(x_center, y_center);
        }
        if(p_set == 2){
            Blinker(x_center, y_center);
        }
        if(p_set == 3){
            Spaceship(x_center, y_center);
        }
    }
    public void Default(){
        Random rand = new Random();
        for (int i = 1; i <= y; i++){
            for (int j = 1; j <= x; j++) {
                board[i][j] = rand.nextInt(2);
            }
        }
    }
    public void Boat(int x_center,int y_center){
        board[y_center-1][x_center] = 1;
        board[y_center+1][x_center] = 1;
        board[y_center][x_center+1] = 1;
        board[y_center][x_center-1] = 1;
        board[y_center-1][x_center-1] = 1;

    }
    public void Blinker(int x_center,int y_center){
        board[y_center-1][x_center] = 1;
        board[y_center+1][x_center] = 1;
        board[y_center][x_center] = 1;
    }
    public void Spaceship(int x_center,int y_center){
        board[y_center-1][x_center] = 1;
        board[y_center-1][x_center-1] = 1;
        board[y_center-1][x_center+1] = 1;
        board[y_center+1][x_center] = 1;
        board[y_center][x_center-1] = 1;
    }
    public void Print(int num)
    {
        String prefix = "-".repeat((x-1)/2);
        String postfix = "-".repeat(x/2);
        System.out.println(prefix+num+postfix);
        for (int i = 1; i <= y; i++){
            for (int j = 1; j <= x; j++) {
                if(board[i][j] == 1){
                    System.out.print("X");
                }
                else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    public void Simulate(String str){
        int steps = Integer.parseInt(str);
        for (int i = 1; i <= steps; i++) {
            Print(i);
            ChangeState();
        }
    }
    private void ChangeState(){
        int[][] nextBoard = new int[y + 2][x + 2];
        for (int i = 1; i <= y; i++){
            for (int j = 1; j <= x; j++) {
                nextBoard[i][j] = NextState(i, j, board[i][j]);
            }
        }
        board = nextBoard;
    }
    private int NextState(int i, int j, int state){
        int aliveCells = 0;
        int nextState = 0;
        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                aliveCells += board[i+k][l+j];
            }
        }
        aliveCells -= board[i][j];

        if ((state == 0) && (aliveCells == 3))
            nextState = 1;

        else if ((state == 1) && (aliveCells > 1 && aliveCells < 4))
            nextState = 1;

        return nextState;
    }
}
