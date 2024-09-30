package be.digitalycity.java;

import be.digitalycity.java.exception.*;

public final class Math {


    /**
     * Method used to add two positif number
     * @param a int |a > 0
     * @param b int | a > 0
     * @throws NonPositiveNumberException | a || b <= 0
     * @return a + b
     */

    public static int add(int a, int  b) throws NonPositiveNumberException {
        if (a <= 0) throw new NonPositiveNumberException("first number nmust be gt 0");
        if (b <= 0) throw new NonPositiveNumberException("first number nmust be gt 0");

        return a + b;
    }
}
