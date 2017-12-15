package homeWorks.calculator.domain;

import homeWorks.calculator.entitys.StackCalc;

import java.util.EmptyStackException;

/**
 * @author Jesus Raichuk
 */
public class Main {
    public static void main(String[] args) {
        StackCalc sc = new StackCalc();
        System.out.println(StackCalc.process("cos(0) + sin(1)"));
    }
}
