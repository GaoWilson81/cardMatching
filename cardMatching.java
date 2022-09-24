import java.util.Scanner; //need this to ask for how many rows and columns
import java.util.ArrayList; //
import java.util.Random; //need this to randomize the cards

public class cardMatching {

    //Since there will be rows and columns, 2D array will be used
    //It could be an int or String type since the cards can contain either one

    protected static int row;
    protected static int column;
    public static String[][] board = new String[9][9]; //creates a board with maximum of 9x9
    public static String[][] card = new String[9][9];

    public static void printWelcome() {
        Scanner input = new Scanner(System.in); //This will be used for user input's row and columns for the board
        System.out.println("Welcome to cardGame.");
        System.out.println("====================");
        System.out.println("Please enter the number of rows (1-9) you would like: ");
        row = input.nextInt();
        input.nextLine();
        System.out.println("Please enter the number of columns (1-9) you would like: ");
        column = input.nextInt();
        input.nextLine();
        System.out.println("Loading...");
        if (row <= 0 || column <= 0) {
            System.out.println("Invalid, please try again...");
        }
    }
    public static void showBoard() {
        for(int i = 0; i < row; i++) {
            if (row > 9) {
                System.out.println("Please make sure the number of rows doesn't exceed 9"); //breaks if row exceeds 9
                break;
            }
            System.out.print("|");
            for(int j = 0; j < column; j++) {
                if (column > 9) {
                    System.out.println("Please make sure the number of columns doesn't exceed 9");
                    break;
                }
                System.out.print(board[i][j]); //prints value in between |-|
                System.out.print("|");
            }
            System.out.println();
        }
    }
    public static void randomCards(){
        Random random = new Random(); //random default is 0-1
        int shuffle;
        ArrayList<String> newCard = new ArrayList<>(); //used String here since it'll provide more varieties for the cards
        newCard.add("a");
        newCard.add("b");
        newCard.add("c");
        newCard.add("d");
        newCard.add("e");
        newCard.add("f");
        newCard.add("g");
        newCard.add("h");
	newCard.add("i");
        newCard.add("j");
        newCard.add("k");
        newCard.add("l");
	newCard.add("m");
        newCard.add("n");
        newCard.add("o");
        newCard.add("p");
	newCard.add("q");
	newCard.add("r");
        newCard.add("s");
        newCard.add("t");
        newCard.add("u");
        newCard.add("v");
        newCard.add("w");
        newCard.add("x");
        newCard.add("y");
        newCard.add("z");

        newCard.add("a");
        newCard.add("b");
        newCard.add("c");
        newCard.add("d");
        newCard.add("e");
        newCard.add("f");
        newCard.add("g");
        newCard.add("h");
	newCard.add("i");
        newCard.add("j");
        newCard.add("k");
        newCard.add("l");
	newCard.add("m");
        newCard.add("n");
        newCard.add("o");
        newCard.add("p");
	newCard.add("q");
	newCard.add("r");
        newCard.add("s");
        newCard.add("t");
        newCard.add("u");
        newCard.add("v");
        newCard.add("w");
        newCard.add("x");
        newCard.add("y");
        newCard.add("z");

        newCard.add("A");
        newCard.add("B");
        newCard.add("C");
        newCard.add("D");
        newCard.add("E");
        newCard.add("F");
        newCard.add("G");
        newCard.add("H");
	newCard.add("I");
        newCard.add("J");
        newCard.add("K");
        newCard.add("L");
	newCard.add("M");
        newCard.add("N");
        newCard.add("O");
        newCard.add("P");
	newCard.add("Q");
	newCard.add("R");
        newCard.add("S");
        newCard.add("T");
        newCard.add("U");
        newCard.add("V");
        newCard.add("W");
        newCard.add("X");
        newCard.add("Y");
        newCard.add("Z");

        newCard.add("A");
        newCard.add("B");
        newCard.add("C");
        newCard.add("D");
        newCard.add("E");
        newCard.add("F");
        newCard.add("G");
        newCard.add("H");
	newCard.add("I");
        newCard.add("J");
        newCard.add("K");
        newCard.add("L");
	newCard.add("M");
        newCard.add("N");
        newCard.add("O");
        newCard.add("P");
	newCard.add("Q");
	newCard.add("R");
        newCard.add("S");
        newCard.add("T");
        newCard.add("U");
        newCard.add("V");
        newCard.add("W");
        newCard.add("X");
        newCard.add("Y");
        newCard.add("Z");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                shuffle = random.nextInt(newCard.size()); //randomizes card
                card[i][j] = newCard.get(shuffle);
                newCard.remove(shuffle); //removes shuffle value since it's added to card
            }

        }
    }
    public static boolean gameOver() {
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
        Scanner input = new Scanner(System.in);
        boolean looping = true;
        while(looping) {
            if (!gameOver()) {
                System.out.println("Which row? (1-9)");
                int newRow = input.nextInt();
                input.nextLine();
                System.out.println("Which column? (1-9)");
                int newColumn = input.nextInt();
                input.nextLine();

                if (newRow <= 0 || newColumn <= 0) {
                    System.out.println("Make sure the row/column is at least one or greater");
                    break;
                } else if (newRow > 9 || newColumn > 9) {
                    System.out.println("Make sure the row/column is lesser than/equal to 9");
                    break;
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
                System.out.println("Once again, I shall ask, which row? (1-9)");
                int newRow2 = input.nextInt();
                input.nextLine();
                System.out.println("And...which column? (1-9)");
                int newColumn2 = input.nextInt();
                input.nextLine();
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
                        System.out.println("Incorrect...noob");
                        board[newRow - 1][newColumn - 1] = " - ";
                        board[newRow2 - 1][newColumn2 - 1] = " - ";
                        showBoard();
                    }
                }
            } else {
                System.out.println(".-.-.Game Over.-.-.");
                break;
            }
        }
    }
    public static void createGame() {
        Scanner input = new Scanner(System.in);
        boolean looping = true;

        while(looping) {
            System.out.println("Type \"new\" for new game, or \"quit\" to quit game.");
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
