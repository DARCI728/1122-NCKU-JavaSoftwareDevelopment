public class Point {
    private int horizontal = 0;
    private int vertical = 0;

    void Set(int x, int y) {
        horizontal = x;
        vertical = y;
    }

    void Move(int x, int y) {
        horizontal += x;
        vertical += y;
    }

    void Rotate() {
        int temp = horizontal;
        horizontal = vertical;
        vertical = -temp;
    }

    int RetrieveHorizontal() {
        return horizontal;
    }

    int RetrieveVertical() {
        return vertical;
    }

    int calculateManhattanDistance(Point other) {
        return Math.abs(horizontal - other.horizontal) + Math.abs(vertical - other.vertical);
    }

    double ChebyshevDistance(Point other) {
        if (Math.abs(horizontal - other.horizontal) >= Math.abs(vertical - other.vertical)) {
            return Math.abs(horizontal - other.horizontal);
        } else {
            return Math.abs(vertical - other.vertical);
        }
    }
}