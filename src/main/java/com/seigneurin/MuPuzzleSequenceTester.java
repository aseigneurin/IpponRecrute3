package com.seigneurin;

import org.springframework.util.StringUtils;

public class MuPuzzleSequenceTester {

    static final String TARGET = "MUIIU";
    static final int MAX_DEPTH = 10;
    static MuPuzzle muPuzzle = new MuPuzzle();
    static Integer[] sequence = new Integer[MAX_DEPTH];

    public static void main(String[] args) {
        apply("MI", 0);
    }

    public static void apply(String str, int depth) {
        if (depth == MAX_DEPTH)
            return;

        // test all the four rules, one by one
        for (int i = 1; i <= 4; i++) {
            sequence[depth] = i;

            // apply the rule
            String res = muPuzzle.applyRule(str, i);

            // quick exit if the operation is not changing the input
            if (res.equals(str)) {
                sequence[depth] = null;
                continue;
            }

            // debug
            // System.out.println(StringUtils.arrayToCommaDelimitedString(sequence) + " => " + res);

            if (res.equals(TARGET)) {
                // success: print results and stop here
                System.out.println("Valid sequence! " + toString(sequence));
            } else {
                // recurse
                apply(res, depth + 1);
            }

            sequence[depth] = null;
        }
    }

    private static String toString(Integer[] sequence) {
        int length = 0;
        for (int i = 0; i < sequence.length && sequence[i] != null; i++)
            length++;
        return "=" + length + "  -->  " + StringUtils.arrayToCommaDelimitedString(sequence);
    }
}
