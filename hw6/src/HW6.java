import java.util.Scanner;

public class HW6 {
    static String board = new String();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        board = sc.next();
        sc.close();

        int num_O = 0, num_X = 0;
        for (int i = 0; i < 9; i++) {
            if (board.charAt(i) == 'O') {
                num_O++;
            } else if (board.charAt(i) == 'X') {
                num_X++;
            }
        }

        if (num_O > num_X || num_X - num_O > 1) {
            System.out.println("invalid");
            return;
        }

        if (isWin('O') && num_X != num_O) {
            System.out.println("invalid");
            return;
        }

        if (isWin('X') && num_X - num_O != 1) {
            System.out.println("invalid");
            return;
        }

        System.out.println("valid");
    }

    public static boolean isWin(char c) {
        if ((board.charAt(0) == c && board.charAt(1) == c && board.charAt(2) == c) ||
                (board.charAt(3) == c && board.charAt(4) == c && board.charAt(5) == c) ||
                (board.charAt(6) == c && board.charAt(7) == c && board.charAt(8) == c) ||
                (board.charAt(0) == c && board.charAt(3) == c && board.charAt(6) == c) ||
                (board.charAt(1) == c && board.charAt(4) == c && board.charAt(7) == c) ||
                (board.charAt(2) == c && board.charAt(5) == c && board.charAt(8) == c) ||
                (board.charAt(0) == c && board.charAt(4) == c && board.charAt(8) == c) ||
                (board.charAt(2) == c && board.charAt(4) == c && board.charAt(6) == c)) {
            return true;
        } else {
            return false;
        }
    }
}