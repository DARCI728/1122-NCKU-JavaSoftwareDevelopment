import java.math.BigDecimal;
import java.util.Scanner;

public class HW2 {
    public static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    public static int lcm(int x, int y) {
        return Math.abs(x * y) / gcd(x, y);
    }

    public static int isCircularStr(String str) {
        int length = str.length();

        for (int i = 1; i <= length / 2; i++) {
            String substring = str.substring(0, i);
            int numRepeats = length / i;

            String repeatedSubstring = repeatString(substring, numRepeats);
            if (repeatedSubstring.equals(str)) {
                return i;
            }
        }

        return -1;
    }

    public static String repeatString(String str, int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        Scanner str = new Scanner(System.in);
        int n = str.nextInt();

        for (int i = 0; i < n; i++) {
            String x = str.next();
            String y = str.next();
            String int_x = new String();
            String int_y = new String();

            if (x.indexOf('.') != -1) {
                int_x = x.substring(0, x.indexOf('.'));
            }

            if (y.indexOf('.') != -1) {
                int_y = y.substring(0, y.indexOf('.'));
            }

            String float_x = x.substring(x.indexOf('.') + 1);
            String float_y = y.substring(y.indexOf('.') + 1);

            if (x.indexOf('.') == -1 || y.indexOf('.') == -1) {
                System.out.println(new BigDecimal(x).add(new BigDecimal(y)));
            } else {
                for (int j = 0; j < lcm(float_x.length(), float_y.length()) / float_x.length() - 1; j++) {
                    x += float_x;
                }

                for (int j = 0; j < lcm(float_x.length(), float_y.length()) / float_y.length() - 1; j++) {
                    y += float_y;
                }

                BigDecimal bigDecimal_x = new BigDecimal(x);
                BigDecimal bigDecimal_y = new BigDecimal(y);
                BigDecimal bigDecimal_sum = bigDecimal_x.add(bigDecimal_y);
                BigDecimal carry = BigDecimal.ONE;

                for (int j = 0; j < lcm(float_x.length(), float_y.length()); j++) {
                    carry = carry.divide(BigDecimal.TEN);
                }

                if (bigDecimal_sum.intValue() > new BigDecimal(int_x).add(new BigDecimal(int_y)).intValue()) {
                    bigDecimal_sum = bigDecimal_sum.add(carry);
                }

                String str_sum = bigDecimal_sum.toString();

                if (isCircularStr(str_sum.substring(str_sum.indexOf('.') + 1)) != -1) {
                    int index = isCircularStr(str_sum.substring(str_sum.indexOf('.') + 1));

                    if (index == 1 && str_sum.charAt(str_sum.indexOf('.') + 1) == '9') {
                        BigDecimal temp = new BigDecimal(bigDecimal_sum.intValue());
                        bigDecimal_sum = temp.add(BigDecimal.ONE);
                    } else {
                        bigDecimal_sum = new BigDecimal(str_sum.substring(0, str_sum.indexOf('.') + index + 1));
                    }
                } else if (str_sum.charAt(str_sum.indexOf('.') + 1) == '9'
                        && str_sum.length() == str_sum.indexOf('.') + 2) {
                            BigDecimal temp = new BigDecimal(bigDecimal_sum.intValue());
                            bigDecimal_sum = temp.add(BigDecimal.ONE);
                }

                System.out.println(bigDecimal_sum);
            }
        }
        str.close();
    }
}
