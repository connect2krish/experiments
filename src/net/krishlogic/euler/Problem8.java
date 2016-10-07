package net.krishlogic.euler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

//ans:
/*
    prod: 23514624000 -- > num:5984669866755
*/

public class Problem8 {

    static double productFinal =1;
    static String numStr = "";
    static List<Double> prods = new ArrayList();

    public static void main(String args[]) {

        String numbers = "" +
                "73167176531330624919225119674426574742355349194934" +
                "96983520312774506326239578318016984801869478851843" +
                "85861560789112949495459501737958331952853208805511" +
                "12540698747158523863050715693290963295227443043557" +
                "66896648950445244523161731856403098711121722383113" +
                "62229893423380308135336276614282806444486645238749" +
                "30358907296290491560440772390713810515859307960866" +
                "70172427121883998797908792274921901699720888093776" +
                "65727333001053367881220235421809751254540594752243" +
                "52584907711670556013604839586446706324415722155397" +
                "53697817977846174064955149290862569321978468622482" +
                "83972241375657056057490261407972968652414535100474" +
                "82166370484403199890008895243450658541227588666881" +
                "16427171479924442928230863465674813919123162824586" +
                "17866458359124566529476545682848912883142607690042" +
                "24219022671055626321111109370544217506941658960408" +
                "07198403850962455444362981230987879927244284909188" +
                "84580156166097919133875499200524063689912560717606" +
                "05886116467109405077541002256983155200055935729725" +
                "71636269561882670428252483600823257530420752963450";

        BigInteger bigInteger = new BigInteger(numbers);
        boolean flag = true;
        BigInteger remainder;
        BigInteger theNumber;

        Vector vector = new Vector(13);
        int count = 0;

        while(flag) {
            count++;

            try {
                theNumber = bigInteger.divide(new BigInteger("10"));
                remainder = bigInteger.remainder(new BigInteger("10"));

                if (theNumber.doubleValue() <= 10) {
                    System.out.println(count);
                    break;
                }
            } catch(ArithmeticException are) {
                break;
            }

            bigInteger = theNumber;

            vector.add(remainder.doubleValue());

            if (vector.size() == 13) {
                calculate(vector);
                vector.remove(0);
            }
        }

        System.out.println(new BigDecimal(productFinal).toPlainString() + " " + numStr);

        prods.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) (o2.doubleValue() - o1.doubleValue());
            }
        });
        System.out.println(new BigDecimal(productFinal).toString());
    }


    private static void calculate(Vector<Double> vector) {
        double product = 1;
        String nums = "";
        double val =1;

        for (int i=0; i<vector.size(); i++) {
            val = vector.get(i).intValue();
            product = product * val;
            nums = nums + val;
        }

        prods.add(product);

        if (product > productFinal) {
            productFinal = product;
            numStr = nums;
        }
    }
}
