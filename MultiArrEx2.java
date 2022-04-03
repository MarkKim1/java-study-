import java.util.*;
class MultiArrEx2 {
    public static void main(String[] args){
        final int SIZE = 5;
        int x = 0;
        int y = 0;
        int num = 0;

        int[][] bingo = new int[SIZE][SIZE];
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                bingo[i][j] = (i * SIZE) + j + 1;
                //System.out.println(bingo[i][j]);
            }
        }

        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                x = (int)(Math.random() * SIZE);
                y = (int)(Math.random() * SIZE);

                int tmp = bingo[i][j];
                bingo[i][j] = bingo[x][y];
                bingo[x][y] = tmp;
            }
        }

        do{
            for(int i = 0; i < SIZE; i++){
                for(int j = 0; j < SIZE; j++){
                    System.out.printf("%2d ", bingo[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            //입력받은 숫자와 같은 숫자가 저장된 요소를 찾아서 0을 저장
            System.out.printf("1~%d의 숫자를 입력하세요", SIZE*SIZE);
            String tmp = scanner.nextLine();
            num = Integer.parseInt(tmp);

            outer: for(int i = 0; i < SIZE; i++){
                for(int j = 0; j < SIZE; j++){
                    if(bingo[i][j] == num){
                        bingo[i][j] = 0;
                        break outer;
                    }
                }
            }
        }while(num != 0);

    }
}
