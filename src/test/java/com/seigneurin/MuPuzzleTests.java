package com.seigneurin;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class MuPuzzleTests {

    private MuPuzzle muPuzzle = new MuPuzzle();

    @Test
    public void testStep1() {
        String res = muPuzzle.applyRule("MI", 1);
        assertThat(res).isEqualTo("MIU");
    }

    @Test
    public void testStep2() {
        String res = muPuzzle.applyRule("MIU", 2);
        assertThat(res).isEqualTo("MIUIU");
    }

    @Test
    public void testStep3() {
        String res = muPuzzle.applyRule("MUIIIU", 3);
        assertThat(res).isEqualTo("MUUU");
        res = muPuzzle.applyRule("MIIII", 3);
        assertThat(res).isEqualTo("MUI");
    }

    @Test
    public void testStep4() {
        String res = muPuzzle.applyRule("MUUU", 4);
        assertThat(res).isEqualTo("MU");
        res = muPuzzle.applyRule("MUUUU", 4);
        assertThat(res).isEqualTo("M");
    }
}
