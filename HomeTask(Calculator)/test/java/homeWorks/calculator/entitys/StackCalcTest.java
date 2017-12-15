package homeWorks.calculator.entitys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackCalcTest {
    StackCalc sc;

    @Before
    public void setUp() throws Exception {
        sc = new StackCalc();
    }

    @After
    public void tearDown() throws Exception {
        sc = null;
    }

    @Test
    public void process() throws Exception {
        //1.0
        double exp = sc.process("cos(0) + sin(0)");

        assertTrue(exp > 0.99 && exp < 1.1);
    }

}