import java.util.*;
public class MultiArrEx1 {
    public static void main(String[] agrs){
        final int SIZE = 10;
        int x = 0;
        int y = 0;
        char[][] board = new char[SIZE][SIZE];
        byte[][] shipboard = {
            {0,0,0,0,0,0,1,0,0},
            {1,1,1,1,0,0,1,0,0},
            {0,0,0,0,0,0,1,0,0},
            {0,1,0,1,1,0,0,0,0},
            {1,0,0,0,1,1,1,1,0},
            {0,0,0,0,0,0,1,0,0},
            {1,1,1,1,0,0,1,0,0},
            {0,0,0,0,0,0,1,0,0},
            {0,1,0,1,1,0,0,0,0},
        };

        for(int i = 1; i < SIZE; i++){
            board[0][i] = board[i][0] = (char)(i+'0');
        }
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.printf("좌표를 입력하세요. (종료는 00)>");
            String input = scanner.nextLine();

            if(input.length() == 2){
                x = input.charAt(0) - '0';
                y = input.charAt(1) - '0';
                
                if(x == 0 && y == 0){
                    break;
                }
            }
            if(input.length()!= 2 || x<=0 || x >= SIZE || y <=0){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                continue;
            }
            if(shipboard[x-1][y-1] == 1){
                board[x][y] = 'O';

            }
            else if(shipboard[x-1][y-1] == 0){
                board[x][y] = 'X';

            }

            String src = new String(board[0]);
            System.out.println(" " + src);
            
            for(int i = 1; i < SIZE; i++){
                for(int j = 0; j < SIZE; j++){
                    if(board[i][j] == 0){
                        System.out.print(' ');
                    }
                    System.out.print(board[i][j]);    
                }
                System.out.println();
            }
            System.out.println();
        }
        scanner.close();
    }
}
