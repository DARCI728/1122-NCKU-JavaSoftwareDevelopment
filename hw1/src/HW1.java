import java.math.BigDecimal;
import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) throws Exception {
        Scanner str = new Scanner(System.in);
        String x = str.next();
        String y = str.next();
        BigDecimal bigDecimal_x = new BigDecimal(x);
        BigDecimal bigDecimal_y = new BigDecimal(y);
        System.out.println(bigDecimal_x.add(bigDecimal_y));
        str.close();
    }
}
