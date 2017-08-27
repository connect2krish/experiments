package net.krishlogic.euler;

import java.math.BigDecimal;

/*
    a<b<c
    a^2 + b^2 = c^2
    a+b+c = 1000

    a*b*c = ?

    Ans:
    A = 375,  B = 200
    31875000
 */
public class Problem9 {

    public static void main(String args[]) {
        int a = 1, b=1, c=1;

        for (int i=1; i < 500; i++) {
            a = i * i; //a^2
            for (int j=1; j<=i;j++) {
                b = j * j; //b^2
                c = a + b; //c^2

                if (i + j + Math.sqrt(c) == 1000) {
                    BigDecimal bigDecimal = new BigDecimal(i * j * Math.sqrt(c));
                    System.out.println(bigDecimal.toPlainString());

                    System.out.println(i + " " + j);

                    break;
                }
            }
        }
    }

}
