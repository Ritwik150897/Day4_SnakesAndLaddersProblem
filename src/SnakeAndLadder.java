public class SnakeAndLadder {
    static int[][] snakePosition = new int[8][2];
    static int[][] ladderPosition = new int[7][2];
    public static void main(String[] args) {
        int[][] array = new int[10][10];

        int positionleft = 100;
        int positionRight = 100;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                positionRight = positionleft;
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = positionRight--;
                }
            } else {
                positionleft = positionRight;
                for (int j = array[i].length - 1; j >= 0; j--) {
                    array[i][j] = positionleft--;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        snakePosition[0] = new int[]{40, 3};
        snakePosition[1] = new int[]{27, 5};
        snakePosition[2] = new int[]{43, 18};
        snakePosition[3] = new int[]{54, 31};
        snakePosition[4] = new int[]{66, 45};
        snakePosition[5] = new int[]{76, 58};
        snakePosition[6] = new int[]{89, 53};
        snakePosition[7] = new int[]{99, 41};

        ladderPosition[0] = new int[]{25, 4};
        ladderPosition[1] = new int[]{46, 13};
        ladderPosition[2] = new int[]{49, 33};
        ladderPosition[3] = new int[]{63, 42};
        ladderPosition[4] = new int[]{69, 50};
        ladderPosition[5] = new int[]{81, 62};
        ladderPosition[6] = new int[]{92, 47};

        int playerPosition = 0;
        boolean isGameRunning = true;

        System.out.println("Snake And Ladder Game");
        System.out.println("---------------------");
        System.out.println("Player Starting Position: " + playerPosition);

        while (isGameRunning) {
            int diceValue = (((int) (Math.random() * 10)) % 6) + 1;
            System.out.println("Dice Roll Value Obtained: " + diceValue);

            playerPosition = playerPosition + diceValue;

            if (playerPosition > 100) {
                playerPosition = playerPosition - diceValue;
            }

            playerPosition = checkForSnake(playerPosition);
            playerPosition = checkForladder(playerPosition);

            System.out.println("Player New Position: " + playerPosition);


            if (playerPosition == 100) {
                System.out.println("Player Wins!");
                isGameRunning = false;
            }
            System.out.println("------------------------");
        }
    }
    private static Integer checkForSnake(int playerPosition) {
        for (int i = 0; i < snakePosition.length; i++) {
            if (playerPosition == snakePosition[i][0]) {
                System.out.println("Snake Encountered at: " + snakePosition[i][0]);
                return snakePosition[i][1];
            }
        }
        return playerPosition;
    }

    private static Integer checkForladder(int playerPosition) {
        for (int i = 0; i < ladderPosition.length; i++) {
            if (playerPosition == ladderPosition[i][1]) {
                System.out.println("Ladder encountered at: " + ladderPosition[i][1]);
                return ladderPosition[i][0];
            }
        }
        return playerPosition;
    }
}
