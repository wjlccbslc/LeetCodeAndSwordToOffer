package SwordToOfferSolution._16_Power;

/*
 * 数值的整数次方
 *
 * 题目描述：
 * 实现函数 double Power(double base, int exponent)，求 base 的 exponent 次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 * 思路：
 * 1. 当底数是 0 且指数为负数的时候，就返回 0；
 * 2. 当指数为负数的时候，可以先对指数求绝对值，然后再将计算出的结果取倒数。
 */
public class Solution {

    private static double power(double base, int exponent) {
        if (base == 0.0 && exponent < 0) {
            return 0.0;
        }

        int absExponent = exponent;
        if (exponent < 0) absExponent = -exponent;
        double res = powerCore(base, absExponent);
        // 指数为负数时，应求其倒数
        if (exponent < 0) {
            res = 1.0 / res;
        }
        return res;
    }

    private static double powerCore(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double res = powerCore(base, exponent >> 1);
        res *= res;
        if ((exponent & 1) == 1) {
            return res *= base;
        }
        return res;
    }

    public static void main(String[] args) {
        double res = power(2, 5);
        System.out.println(res);
    }
}
