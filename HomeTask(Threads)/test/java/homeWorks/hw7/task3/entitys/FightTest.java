package homeWorks.hw7.task3.entitys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FightTest {
    Arena arena;
    List<Monk> team;
    @Before
    public void setUp() throws Exception {
        team = Arrays.asList(new Monk("M1", 100), new Monk("M2", 80));
        arena = new Arena(team);
    }

    @After
    public void tearDown() throws Exception {
        team = null;
        arena = null;
    }

    @Test
    public void run() throws Exception {
        Fight fight = new Fight(arena, team);
        fight.run();

        assertTrue(arena.winners.size() == 1);

        Monk exp = team.get(0);
        Monk act = fight.arena.winners.get(0);
        assertEquals(exp, act);

        assertTrue(act.getName().equals("M1"));
        assertTrue(act.getPower() == 100);
    }


}