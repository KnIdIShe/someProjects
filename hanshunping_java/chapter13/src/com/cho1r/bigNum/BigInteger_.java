package com.cho1r.bigNum;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Author cho1r
 * 2021-11-29 029 06:14 下午
 */
public class BigInteger_ {
    public static void main(String[] args) {
//        BigInteger bigInteger = new BigInteger("123332132132132131232131");
//        BigInteger bigInteger2 = new BigInteger("12");
//        BigInteger add = bigInteger.add(bigInteger2);
//        System.out.println(add);

        BigDecimal bigDecimal = new BigDecimal("12321.2323213");
        BigDecimal bigDecimal1 = new BigDecimal("1.2");
        System.out.println(bigDecimal.divide(bigDecimal1, RoundingMode.HALF_UP));// 四舍五入
    }
}
