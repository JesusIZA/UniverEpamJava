package homeWorks.hw7.task3.entitys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArenaTest {
    List t;
    Arena a;
    @Before
    public void setUp() throws Exception {
        t = Arrays.asList(new Monk("M1", 100), new Monk("M2", 80), new Monk("M3", 90));
        a = new Arena(t);

    }

    @After
    public void tearDown() throws Exception {
        t = null;
        a = null;
    }

    @Test
    public void getOneTeamForFight() throws Exception {
        assertTrue(a.getOneTeamForFight(0).size() == 2);

        List exp = new ArrayList();
        exp.add(t.get(0));
        exp.add(t.get(1));

        List act = a.getOneTeamForFight(0);

        assertEquals(exp , act);

    }

}