import java.util.Scanner;

public class HW5 {
    static int n, m;
    static boolean finded = false;
    static char[][] board;
    static String word;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.next());
        m = Integer.parseInt(sc.next());
        board = new char[n][m];
        for (int i = 0; i < n * m; i++)
            board[i / 4][i % 4] = sc.next().charAt(0);
        word = sc.next();
        sc.close();

        for (int i = 0; i < n * m; i++) {
            if (board[i / 4][i % 4] == word.charAt(0)) {
                Search(i / 4, i % 4, 1);
            }
        }

        if (finded) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void Search(int i, int j, int index) {
        if (index == word.length()) {
            finded = true;
        } else {
            if (i + 1 < n && board[i + 1][j] == word.charAt(index)) {
                Search(i + 1, j, index + 1);
            }

            if (i - 1 >= 0 && board[i - 1][j] == word.charAt(index)) {
                Search(i - 1, j, index + 1);
            }

            if (j + 1 < m && board[i][j + 1] == word.charAt(index)) {
                Search(i, j + 1, index + 1);
            }

            if (j - 1 >= 0 && board[i][j - 1] == word.charAt(index)) {
                Search(i, j - 1, index + 1);
            }
        }
    }
}
