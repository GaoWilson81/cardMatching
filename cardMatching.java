import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Random;

public class cardMatching {
    protected static String difficulty;
    protected static int row = 0;
    protected static int column = 0;
    public static String[][] board = new String[9][9]; //creates a board with maximum of 9x9
    public static String[][] card = new String[9][9];

    public static void printWelcome() {
        boolean valid = true;
        Scanner input = new Scanner(System.in); //This will be used for user input's row and columns for the board
        System.out.println("Welcome to cardGame.");
        System.out.println("====================");
        while (valid) {
            System.out.print("Please enter the difficulty you would like (easy, medium, hard): ");
            difficulty = input.nextLine().toLowerCase();
            System.out.println(difficulty);
            if (!difficulty.equals("easy") && !difficulty.equals("medium") && !difficulty.equals("hard")) {
                System.out.println("Invalid, please try again...");
                continue;
            }
        break;
        }
    }
    public static void difficulty() {
        if (difficulty.equals("easy")) {
            row = 4;
            column = 4;
        }
        if (difficulty.equals("medium")) {
            row = 6;
            column = 6;
        }
        if (difficulty.equals("hard")) {
            row = 8;
            column = 8;
        }
    }
    public static void showBoard() {
        difficulty();
        for(int i = 0; i < row; i++) {
            System.out.print("|");
            for(int j = 0; j < column; j++) {
                System.out.print(board[i][j]); //prints value in between |-|
                System.out.print("|");
            }
            System.out.println();
        }
    }
    public static void randomCards(){
        difficulty();
        System.out.println(row);
        char[] lowerCaseLetters = "abcdefghijklmnopqrstuvuwyz".toCharArray();
        char[] upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Random random = new Random(); //random default is 0-1
        int shuffle;
        int a = 0;
        int b = 0;
        int c = 0;
        ArrayList<String> newCard = new ArrayList<>(); 
        if (difficulty.equals("easy")) {
            while (a < 2) {
                for (int i = 0; i < row * column / 2; i++) {
                    newCard.add(lowerCaseLetters[i] + "");
                }
                a++;
            }
        }
        if (difficulty.equals("medium")) {
            while (b < 2) {
                for (int i = 0; i < row * column / 2; i++) {
                    newCard.add(lowerCaseLetters[i] + "");
                }
                b++;
            }
        }
        if (difficulty.equals("hard")) {
            while (c < 2) {
                for (int i = 0; i < row * column / 2 / 2; i++) {
                    newCard.add(lowerCaseLetters[i] + "");
                    newCard.add(upperCaseLetters[i] + "");
                }
                c++;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                shuffle = random.nextInt(newCard.size()); //randomizes card
                card[i][j] = newCard.get(shuffle);
                newCard.remove(shuffle); //removes shuffle value since it's added to card
            }

        }
    }
    public static boolean gameOver() {
        difficulty();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j].equals(" - ")) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void match(String[][] newCard) { //takes in card to set board to the value of card
        difficulty();
        Scanner input = new Scanner(System.in);
        boolean looping = true;
        while(looping) {
            if (!gameOver()) {
                System.out.println("Which row?");
                int newRow = 0;
                if (input.hasNextInt()) {
                    newRow = input.nextInt();
                } else {
                    System.out.println("Leaving...");
                    break;
                }
                System.out.println("Which column?");
                int newColumn = 0;
                if (input.hasNextInt()) {
                    newColumn = input.nextInt();
                } else {
                    System.out.println("Leaving...");
                    break;
                }

                if (newRow <= 0 || newColumn <= 0) {
                    System.out.println("Make sure the row/column is at least one or greater");
                    continue;
                } else if (newRow > row || newColumn > column) {
                    System.out.printf("Make sure the row/column is lesser than/equal to %d\n", row);
                    continue;
                }
                //if not equal to " - ", that means the user already entered something
                if (!board[newRow - 1][newColumn - 1].equals(" - ")) {
                    System.out.println("Spot taken... try somewhere different\n");
                    showBoard();
                    continue; //restart loop and continues...
                } else {
                    board[newRow - 1][newColumn - 1] = " " + newCard[newRow - 1][newColumn - 1] + " "; //changes " - " to newCard value
                    showBoard();
                }
                //repeats which row/column input because you need two input to match
                System.out.println("Once again, I shall ask, which row?");
                int newRow2 = 0;
                if (input.hasNextInt()) {
                    newRow2 = input.nextInt();
                } else {
                    System.out.println("Leaving...");
                    break;
                }
                System.out.println("And... column?");
                int newColumn2 = 0;
                if (input.hasNextInt()) {
                    newColumn2 = input.nextInt();
                } else {
                    System.out.println("Leaving...");
                    break;
                }

                if (newRow2 <= 0 || newColumn2 <= 0) {
                    System.out.println("Make sure the row/column is at least one or greater");
                    continue;
                } else if (newRow2 > row || newColumn2 > column) {
                    System.out.printf("Make sure the row/column is lesser than/equal to %d\n", row);
                    continue;
                }
                if (!board[newRow2 - 1][newColumn2 - 1].equals(" - ")) {
                    System.out.println("This place is taken...try somewhere different");
                    board[newRow - 1][newColumn - 1] = " - "; //sets first input to " - " because second input is already entered but the first was not
                    System.out.println();
                    showBoard();
                    continue;
                } else {
                    board[newRow2 - 1][newColumn2 - 1] = " " + newCard[newRow2 - 1][newColumn2 - 1] + " ";
                    if (board[newRow - 1][newColumn - 1].equals(board[newRow2 - 1][newColumn2 - 1])) {
                        showBoard();
                        System.out.println("Not bad, you got it right");
                    } else {
                        showBoard();
                        System.out.println("Incorrect...");
                        board[newRow - 1][newColumn - 1] = " - ";
                        board[newRow2 - 1][newColumn2 - 1] = " - ";
                        showBoard();
                    }
                }
            } else if (row != 0 && column != 0) {
                System.out.println(".-.-.GGEZ.-.-.");
                break;
            }
        }
    }
    public static void createGame() {
        Scanner input = new Scanner(System.in);
        boolean looping = true;

        while(looping) {
            System.out.println("Type \"new\" for new game, or \"quit\" to quit game.");
            System.out.println("While in game, you may quit by entering anything that's not a number. For example: q.");
            String create = input.nextLine();

            if (create.equals("quit")) {
                System.out.println("Leaving...");
                break;
            } else if (create.equals("new")) {
                printWelcome();
                randomCards();
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        board[i][j] = " - "; //makes | - |
                    }
                }
                showBoard();
                match(card);
                break;
            } else {
                System.out.println("Please try again.");
                continue;
            }
        }
    }

    public static void main(String[] args) {
        createGame();
    }
}
