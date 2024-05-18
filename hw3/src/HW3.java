import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(sc.next());
        }

        Point main = new Point();
        Point other = new Point();

        main.Set(arr[0], arr[1]);
        other.Set(arr[2], arr[3]);

        System.out.println(main.RetrieveHorizontal() + " " + main.RetrieveVertical());

        main.Move(arr[4], arr[5]);
        System.out.println(main.RetrieveHorizontal() + " " + main.RetrieveVertical());

        for (int i = 0; i < 4; i++) {
            main.Rotate();
            System.out.println(main.RetrieveHorizontal() + " " + main.RetrieveVertical());
        }

        System.out.println(main.calculateManhattanDistance(other));
        System.out.println(main.ChebyshevDistance(other));
        sc.close();
    }
}
